package com.example.demo.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PrestamoDTO {
    private Long usuarioId;
    private Long libroId;
    private Integer dias; // duracion prestamo
}
