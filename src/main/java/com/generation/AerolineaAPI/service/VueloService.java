package com.generation.AerolineaAPI.service;

import com.generation.AerolineaAPI.model.Vuelo;
import com.generation.AerolineaAPI.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloService {

    private final VueloRepository vueloRepository;

    @Autowired
    public VueloService(VueloRepository vueloRepository){
        this.vueloRepository = vueloRepository;
    }

    public List<Vuelo> findAll(){
        return vueloRepository.findAll();
    }

    public Vuelo save(Vuelo vuelo){
        return vueloRepository.save(vuelo);
    }
    public Vuelo findById(Long id){
        return vueloRepository.findById(id).orElse(null);
    }
    public Vuelo update(Long id, Vuelo datos){
        Vuelo existente = vueloRepository.findById(id).orElse(null);
        if (existente == null) return null;
        existente.setOrigen(datos.getOrigen());
        existente.setDestino(datos.getDestino());
        existente.setFechaHora(datos.getFechaHora());
        existente.setEstado(datos.getEstado());
        return vueloRepository.save(existente);
    }
    public void delete(Long id){
        vueloRepository.deleteById(id);
    }
}
