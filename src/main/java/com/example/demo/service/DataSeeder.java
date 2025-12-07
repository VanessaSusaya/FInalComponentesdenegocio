package com.example.demo.service;

import com.example.demo.entity.ERole;
import com.example.demo.entity.Rol;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.RolRepository;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (rolRepository.count() == 0) {
            rolRepository.save(new Rol(null, ERole.ROLE_ADMIN));
            rolRepository.save(new Rol(null, ERole.ROLE_USUARIO));
        }

        if (!usuarioRepository.existsByEmail("admin@uni.edu")) {
            Usuario admin = new Usuario();
            admin.setEmail("admin@uni.edu");
            admin.setPassword(passwordEncoder.encode("Admin123!"));
            admin.setNombre("Admin");
            Set<Rol> roles = new HashSet<>();
            rolRepository.findByNombre(ERole.ROLE_ADMIN).ifPresent(roles::add);
            rolRepository.findByNombre(ERole.ROLE_USUARIO).ifPresent(roles::add);
            admin.setRoles(roles);
            usuarioRepository.save(admin);
        }
    }
}
