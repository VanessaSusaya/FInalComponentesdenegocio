package com.example.demo.controller;

import com.example.demo.entity.Libro;
import com.example.demo.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> listar() {
        return ResponseEntity.ok(libroService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> detalle(@PathVariable Long id) {
        return libroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Libro> crear(@RequestBody Libro libro) {
        Libro creado = libroService.crear(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar(@PathVariable Long id, @RequestBody Libro datos) {
        return ResponseEntity.ok(libroService.actualizar(id, datos));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        libroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
