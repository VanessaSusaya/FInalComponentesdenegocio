package com.example.demo.dto;

public class LibroDTO {

    private Long id;
    private String titulo;
    private String autor;
    private Integer totalEjemplares;
    private Integer ejemplaresDisponibles;
    private String categoria;

    public LibroDTO() {
    }

    public LibroDTO(Long id, String titulo, String autor, Integer totalEjemplares,
                    Integer ejemplaresDisponibles, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.totalEjemplares = totalEjemplares;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
        this.categoria = categoria;
    }

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
}
