package com.example.demo.dto;

public class PrestamoDTO {

    private Long usuarioId;
    private Long libroId;
    private Integer dias;

    public PrestamoDTO() {
    }

    public PrestamoDTO(Long usuarioId, Long libroId, Integer dias) {
        this.usuarioId = usuarioId;
        this.libroId = libroId;
        this.dias = dias;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }
}
