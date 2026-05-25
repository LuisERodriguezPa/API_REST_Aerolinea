package com.generation.AerolineaAPI.service;

import com.generation.AerolineaAPI.model.Pasajero;
import com.generation.AerolineaAPI.model.Vuelo;
import com.generation.AerolineaAPI.repository.PasajeroRepository;
import com.generation.AerolineaAPI.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasajeroService {

    private final PasajeroRepository pasajeroRepository;

    @Autowired
    public PasajeroService(PasajeroRepository pasajeroRepository){
        this.pasajeroRepository = pasajeroRepository;
    }

    public List<Pasajero> findAll(){
        return pasajeroRepository.findAll();
    }

    public Pasajero save(Pasajero pasajero){
        return pasajeroRepository.save(pasajero);
    }

    public Pasajero findById(Long id){
        return pasajeroRepository.findById(id).orElse(null);
    }
    public Pasajero update(Long id, Pasajero datos){
        Pasajero existente = pasajeroRepository.findById(id).orElse(null);
        if (existente == null) return null;
        existente.setNombre(datos.getNombre());
        existente.setApellido(datos.getApellido());
        existente.setDocumento(datos.getDocumento());
        existente.setDocumento(datos.getEmail());
        return pasajeroRepository.save(existente);
    }
    public void delete(Long id){
        pasajeroRepository.deleteById(id);
    }
}
