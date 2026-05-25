package com.generation.AerolineaAPI.controller;

import com.generation.AerolineaAPI.model.Vuelo;
import com.generation.AerolineaAPI.service.VueloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Tag(name = "Vuelos", description = "Gestión de vuelos de la aerolínea")
@RestController
@RequestMapping("/vuelos")
public class VueloController {

    private final VueloService vueloService;
    @Autowired
    public VueloController(VueloService vueloService){
        this.vueloService = vueloService;
    }

    @Operation(summary = "Listar todos los vuelos")
    @GetMapping
    public ResponseEntity<List<Vuelo>> obtenerTodos(){
        return ResponseEntity.ok(vueloService.findAll());
    }

    @Operation(summary = "Buscar vuelo por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> obtenerPorId(@PathVariable Long id){
        Vuelo vuelo = vueloService.findById(id);
        if(vuelo == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(vuelo);
    }

    @PostMapping
    public ResponseEntity<Vuelo> crear(@Valid @RequestBody Vuelo vuelo) {
        return ResponseEntity.status(CREATED).body(vueloService.save(vuelo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> actualizar(@PathVariable Long id, @Valid @RequestBody Vuelo datos) {
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
