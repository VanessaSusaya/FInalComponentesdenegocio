package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "libro_id")
    private Libro libro;

    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucionPrevista;
    private LocalDateTime fechaDevolucionReal;

    @Enumerated(EnumType.STRING)
    private EstadoPrestamo estado;

    // Constructor vacío
    public Prestamo() {}

    // Constructor con parámetros
    public Prestamo(Long id, Usuario usuario, Libro libro,
                    LocalDateTime fechaPrestamo,
                    LocalDateTime fechaDevolucionPrevista,
                    LocalDateTime fechaDevolucionReal,
                    EstadoPrestamo estado) {
        this.id = id;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
        this.fechaDevolucionReal = fechaDevolucionReal;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public LocalDateTime getFechaPrestamo() {
        return fechaPrestamo;
    }
    public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDateTime getFechaDevolucionPrevista() {
        return fechaDevolucionPrevista;
    }
    public void setFechaDevolucionPrevista(LocalDateTime fechaDevolucionPrevista) {
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
    }

    public LocalDateTime getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }
    public void setFechaDevolucionReal(LocalDateTime fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }

    public EstadoPrestamo getEstado() {
        return estado;
    }
    public void setEstado(EstadoPrestamo estado) {
        this.estado = estado;
    }
}
