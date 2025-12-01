package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestamos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Fecha del préstamo
    @NotNull
    private LocalDate fechaPrestamo;

    // Fecha en que se devolvió (puede ser null)
    private LocalDate fechaDevolucion;

    // Estado del préstamo: PRESTADO, DEVUELTO
    @Column(nullable = false)
    private String estado;

    // Mucho a uno con Usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Mucho a uno con Libro
    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;
}
