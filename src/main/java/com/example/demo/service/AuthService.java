package com.example.demo.service;

import com.example.demo.config.JwtUtil;
import com.example.demo.entity.ERole;
import com.example.demo.entity.Rol;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.RolRepository;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    public String login(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        return jwtUtil.generateToken(email);
    }

    public Usuario registerUsuario(Usuario u, boolean isAdmin) {
        if (usuarioRepository.existsByEmail(u.getEmail())) {
            throw new IllegalArgumentException("Email ya registrado");
        }
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        Set<Rol> roles = new HashSet<>();
        Rol roleUser = rolRepository.findByNombre(ERole.ROLE_USUARIO)
                .orElseThrow(() -> new IllegalStateException("Rol USER no existe"));
        roles.add(roleUser);
        if (isAdmin) {
            Rol roleAdmin = rolRepository.findByNombre(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new IllegalStateException("Rol ADMIN no existe"));
            roles.add(roleAdmin);
        }
        u.setRoles(roles);
        return usuarioRepository.save(u);
    }
}

