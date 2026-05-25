package com.generation.AerolineaAPI.dto;

import com.generation.AerolineaAPI.model.ClaseAsiento;
import com.generation.AerolineaAPI.model.Reserva;

import java.time.LocalDateTime;

public class ReservaResponseDTO {
    private Long id;
    private LocalDateTime fechaReserva;
    private ClaseAsiento clase;
    private Long pasajeroId;
    private String pasajeroNombre;
    private Long vueloId;
    private String vueloOrigen;
    private String vueloDestino;

    public ReservaResponseDTO() {
    }
    public static ReservaResponseDTO desde(Reserva reserva){
        ReservaResponseDTO dto = new ReservaResponseDTO();
        dto.id = reserva.getId();
        dto.fechaReserva = reserva.getFechaReserva();
        dto.clase = reserva.getClase();
        dto.pasajeroId = reserva.getPasajero().getId();
        dto.pasajeroNombre = reserva.getPasajero().getNombre()+" "+reserva.getPasajero().getApellido();
        dto.vueloId = reserva.getVuelo().getId();
        dto.vueloOrigen = reserva.getVuelo().getOrigen();
        dto.vueloDestino = reserva.getVuelo().getDestino();

        return dto;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public ClaseAsiento getClase() {
        return clase;
    }

    public Long getPasajeroId() {
        return pasajeroId;
    }

    public String getPasajeroNombre() {
        return pasajeroNombre;
    }

    public Long getVueloId() {
        return vueloId;
    }

    public String getVueloOrigen() {
        return vueloOrigen;
    }

    public String getVueloDestino() {
        return vueloDestino;
    }
}
