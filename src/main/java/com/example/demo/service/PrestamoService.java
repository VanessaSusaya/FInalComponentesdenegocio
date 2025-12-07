package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.LibroRepository;
import com.example.demo.repository.PrestamoRepository;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private LibroRepository libroRepository;

    @Transactional
    public Prestamo registrarPrestamo(Long usuarioId, Long libroId, int dias) {
        Usuario u = usuarioRepository.findById(usuarioId).orElseThrow(() -> new IllegalArgumentException("Usuario no existe"));
        Libro l = libroRepository.findById(libroId).orElseThrow(() -> new IllegalArgumentException("Libro no existe"));

        if (l.getEjemplaresDisponibles() == null || l.getEjemplaresDisponibles() <= 0) {
            throw new IllegalStateException("No hay ejemplares disponibles");
        }
        l.setEjemplaresDisponibles(l.getEjemplaresDisponibles() - 1);
        libroRepository.save(l);

        Prestamo p = new Prestamo();
        p.setUsuario(u);
        p.setLibro(l);
        p.setFechaPrestamo(LocalDateTime.now());
        p.setFechaDevolucionPrevista(LocalDateTime.now().plusDays(dias));
        p.setEstado(EstadoPrestamo.PRESTADO);
        return prestamoRepository.save(p);
    }

    @Transactional
    public Prestamo registrarDevolucion(Long prestamoId) {
        Prestamo p = prestamoRepository.findById(prestamoId).orElseThrow(() -> new IllegalArgumentException("Préstamo no existe"));
        if (p.getEstado() == EstadoPrestamo.DEVUELTO) {
            throw new IllegalStateException("Préstamo ya devuelto");
        }
        p.setFechaDevolucionReal(LocalDateTime.now());
        if (p.getFechaDevolucionPrevista() != null && p.getFechaDevolucionReal().isAfter(p.getFechaDevolucionPrevista())) {
            p.setEstado(EstadoPrestamo.ATRASADO);
        } else {
            p.setEstado(EstadoPrestamo.DEVUELTO);
        }

        Libro l = p.getLibro();
        l.setEjemplaresDisponibles(l.getEjemplaresDisponibles() + 1);
        libroRepository.save(l);
        return prestamoRepository.save(p);
    }

    public List<Prestamo> historialUsuario(Long usuarioId) {
        return prestamoRepository.findByUsuarioId(usuarioId);
    }
}
