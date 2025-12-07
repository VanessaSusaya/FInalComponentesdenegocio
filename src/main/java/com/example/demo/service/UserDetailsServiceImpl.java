package com.example.demo.service;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

        @Autowired
        private UsuarioRepository usuarioRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Usuario u = usuarioRepository.findByEmail(username)
                                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

                return new User(u.getEmail(),
                                u.getPassword(),
                                u.isEnabled(),
                                true, true, true,
                                u.getRoles().stream()
                                                .map(r -> new SimpleGrantedAuthority(r.getNombre().name()))
                                                .collect(Collectors.toList()));
        }
}
