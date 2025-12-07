package com.example.demo.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LibroDTO {
    private Long id;
    private String titulo;
    private String autor;
    private Integer totalEjemplares;
    private Integer ejemplaresDisponibles;
    private String categoria;
}
