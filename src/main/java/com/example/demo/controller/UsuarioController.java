package com.example.demo.controller;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> detalle(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // actualizar perfil (usuario o admin)
    @PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario u) {
        Usuario existente = usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuario no existe"));
        existente.setNombre(u.getNombre());
        // no actualizamos password aquí por simplicidad
        usuarioRepository.save(existente);
        return ResponseEntity.ok(existente);
    }
}
