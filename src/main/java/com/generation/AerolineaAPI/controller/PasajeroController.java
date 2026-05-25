package com.generation.AerolineaAPI.controller;

import com.generation.AerolineaAPI.model.Pasajero;
import com.generation.AerolineaAPI.model.Pasajero;
import com.generation.AerolineaAPI.service.PasajeroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/pasajeros")
public class PasajeroController {

    private final PasajeroService pasajeroService;

    @Autowired
    public PasajeroController(PasajeroService pasajeroService) {
        this.pasajeroService = pasajeroService;
    }

    @GetMapping
    public ResponseEntity<List<Pasajero>> obtenerTodos(){
        return ResponseEntity.ok(pasajeroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pasajero> obtenerPorId(@PathVariable Long id){
        Pasajero pasajero  = pasajeroService.findById(id);
        if(pasajero == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pasajero);
    }

    @PostMapping
    public ResponseEntity<Pasajero> crear(@Valid @RequestBody Pasajero pasajero) {
        return ResponseEntity.status(CREATED).body(pasajeroService.save(pasajero));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pasajero> actualizar(@PathVariable Long id, @Valid @RequestBody Pasajero datos) {
        Pasajero actualizado = pasajeroService.update(id, datos);
        if(actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pasajeroService.delete(id);
        return ResponseEntity.noContent().build();
    }


//    @GetMapping
//    public List<Pasajero> obtenerTodos() {
//        return pasajeroService.findAll();
//    }
//    @GetMapping("/{id}")
//    public Pasajero obtenerPorId(@PathVariable Long id){
//        return pasajeroService.findById(id);
//    }
//    @PostMapping
//    public Pasajero crear(@RequestBody Pasajero pasajero) {
//        return pasajeroService.save(pasajero);
//    }
//    @PutMapping("/{id}")
//    public Pasajero actualizar(@PathVariable Long id, @RequestBody Pasajero datos) {
//        return pasajeroService.update(id, datos);
//    }
//    @DeleteMapping("/{id}")
//    public void eliminar(@PathVariable Long id) {
//        pasajeroService.delete(id);
//    }

}
