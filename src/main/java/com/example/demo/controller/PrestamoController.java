package com.example.demo.controller;

import com.example.demo.dto.PrestamoDTO;
import com.example.demo.entity.Prestamo;
import com.example.demo.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Prestamo> registrar(@RequestBody PrestamoDTO dto) {
        Prestamo p = prestamoService.registrarPrestamo(dto.getUsuarioId(), dto.getLibroId(), dto.getDias() != null ? dto.getDias() : 14);
        return ResponseEntity.status(HttpStatus.CREATED).body(p);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
    @PostMapping("/{id}/devolver")
    public ResponseEntity<Prestamo> devolver(@PathVariable Long id) {
        return ResponseEntity.ok(prestamoService.registrarDevolucion(id));
    }

    // USUARIO puede ver su propio historial (se debe chequear en la capa de seguridad/servicio)
    @PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Prestamo>> historial(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(prestamoService.historialUsuario(usuarioId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Prestamo>> listarTodos() {
        return ResponseEntity.ok(prestamoService.historialUsuario(null)); // fallback (implementación alternativa)
    }
}
