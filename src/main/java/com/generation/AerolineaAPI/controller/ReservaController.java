package com.generation.AerolineaAPI.controller;

import com.generation.AerolineaAPI.dto.ReservaRequestDTO;
import com.generation.AerolineaAPI.dto.ReservaResponseDTO;
import com.generation.AerolineaAPI.model.Pasajero;
import com.generation.AerolineaAPI.model.Reserva;
import com.generation.AerolineaAPI.model.Reserva;
import com.generation.AerolineaAPI.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;
    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> obtenerTodos(){
        return ResponseEntity.ok(reservaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> obtenerPorId(@PathVariable Long id){
        ReservaResponseDTO reserva = reservaService.findById(id);
        if(reserva == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(reserva);
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> crear(@Valid @RequestBody ReservaRequestDTO dto) {
        return ResponseEntity.status(CREATED).body(reservaService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody ReservaRequestDTO dto) {
        ReservaResponseDTO actualizado = reservaService.update(id, dto);
        if(actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }


//    @GetMapping
//    public List<ReservaResponseDTO> obtenerTodos(){
//        return reservaService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ReservaResponseDTO obtenerPorId(@PathVariable Long id){
//        return reservaService.findById(id);
//    }
//
//    @PostMapping
//    public ReservaResponseDTO crear(@RequestBody ReservaRequestDTO reserva){
//        return reservaService.save(reserva);
//
//    }
//
//    @PutMapping("/{id}")
//    public ReservaResponseDTO actualizar(@PathVariable Long id, @RequestBody ReservaRequestDTO dto){
//        return reservaService.update(id, dto);
//    }
//    @DeleteMapping("/{id}")
//    public void eliminar(@PathVariable Long id ){
//        reservaService.delete(id);
//    }
}
