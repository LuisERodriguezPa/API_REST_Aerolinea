package com.generation.AerolineaAPI.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.generation.AerolineaAPI.model.ClaseAsiento;

import java.time.LocalDateTime;

public class ReservaRequestDTO {
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaReserva;
    private ClaseAsiento clase;
    private Long pasajeroId;
    private Long vueloId;

    public ReservaRequestDTO() {
    }

    public LocalDateTime getFecha() {
        return fechaReserva;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fechaReserva = fecha;
    }

    public ClaseAsiento getClase() {
        return clase;
    }

    public void setClase(ClaseAsiento clase) {
        this.clase = clase;
    }

    public Long getPasajeroId() {
        return pasajeroId;
    }

    public void setPasajeroId(Long pasajeroId) {
        this.pasajeroId = pasajeroId;
    }

    public Long getVueloId() {
        return vueloId;
    }

    public void setVueloId(Long vueloId) {
        this.vueloId = vueloId;
    }
}
