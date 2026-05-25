package com.generation.AerolineaAPI.controller;

import com.generation.AerolineaAPI.model.Vuelo;
import com.generation.AerolineaAPI.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/vuelos")
public class VueloController {
private final VueloService vueloService;

    @Autowired
    public VueloController(VueloService vueloService){
        this.vueloService = vueloService;
    }

    @GetMapping
    public ResponseEntity<List<Vuelo>> obtenerTodos(){
        return ResponseEntity.ok(vueloService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> obtenerPorId(@PathVariable Long id){
        Vuelo vuelo = vueloService.findById(id);
        if(vuelo == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(vuelo);
    }

    @PostMapping
    public ResponseEntity<Vuelo> crear(@RequestBody Vuelo vuelo) {
        return ResponseEntity.status(CREATED).body(vueloService.save(vuelo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> actualizar(@PathVariable Long id, @RequestBody Vuelo datos) {
        Vuelo actualizado = vueloService.update(id, datos);
        if(actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        vueloService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
