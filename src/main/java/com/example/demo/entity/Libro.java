package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    @NotNull(message = "El año es obligatorio")
    private Integer anio;

    @NotNull(message = "Total de ejemplares es obligatorio")
    private Integer totalEjemplares;

    private Integer ejemplaresDisponibles;

    private String categoria;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL)
    private List<Prestamo> prestamos;

    // Constructor vacío
    public Libro() {}

    // Constructor con parámetros
    public Libro(Long id, String titulo, String autor, Integer anio,
                Integer totalEjemplares, Integer ejemplaresDisponibles,
                String categoria, List<Prestamo> prestamos) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.totalEjemplares = totalEjemplares;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
        this.categoria = categoria;
        this.prestamos = prestamos;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnio() {
        return anio;
    }
    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getTotalEjemplares() {
        return totalEjemplares;
    }
    public void setTotalEjemplares(Integer totalEjemplares) {
        this.totalEjemplares = totalEjemplares;
    }

    public Integer getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }
    public void setEjemplaresDisponibles(Integer ejemplaresDisponibles) {
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
}
