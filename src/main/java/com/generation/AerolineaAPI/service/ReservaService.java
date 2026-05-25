package com.generation.AerolineaAPI.service;

import com.generation.AerolineaAPI.dto.ReservaRequestDTO;
import com.generation.AerolineaAPI.dto.ReservaResponseDTO;
import com.generation.AerolineaAPI.model.Pasajero;
import com.generation.AerolineaAPI.model.Reserva;
import com.generation.AerolineaAPI.model.Vuelo;
import com.generation.AerolineaAPI.repository.PasajeroRepository;
import com.generation.AerolineaAPI.repository.ReservaRepository;
import com.generation.AerolineaAPI.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private  final PasajeroRepository pasajeroRepository;
    private final VueloRepository vueloRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository, PasajeroRepository pasajeroRepository, VueloRepository vueloRepository) {
        this.reservaRepository = reservaRepository;
        this.pasajeroRepository = pasajeroRepository;
        this.vueloRepository = vueloRepository;
    }
    public List<ReservaResponseDTO> findAll(){
        return reservaRepository.findAll()
                .stream()
                .map(ReservaResponseDTO::desde)
                .collect(Collectors.toList());

    }
    public ReservaResponseDTO findById(Long id){
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        if(reserva == null) return null;
        return ReservaResponseDTO.desde(reserva);
    }

    public ReservaResponseDTO save(ReservaRequestDTO dto){
        Pasajero pasajero = pasajeroRepository.findById(dto.getPasajeroId()).orElse(null);
        Vuelo vuelo = vueloRepository.findById(dto.getVueloId()).orElse(null);
        Reserva reserva = new Reserva(dto.getFecha(), dto.getClase(), pasajero,vuelo);
        return ReservaResponseDTO.desde(reservaRepository.save(reserva));
    }

    public ReservaResponseDTO update(Long id, ReservaRequestDTO dto){
        Reserva existe = reservaRepository.findById(id).orElse(null);
        if(existe==null) return null;
        Pasajero pasajero = pasajeroRepository.findById(dto.getPasajeroId()).orElse(null);
        Vuelo vuelo = vueloRepository.findById(dto.getVueloId()).orElse(null);
        existe.setFechaReserva(dto.getFecha());
        existe.setClase(dto.getClase());
        existe.setPasajero(pasajero);
        existe.setVuelo(vuelo);
        return ReservaResponseDTO.desde(reservaRepository.save(existe));
    }
    public void delete(Long id){
        reservaRepository.deleteById(id);
    }
}
