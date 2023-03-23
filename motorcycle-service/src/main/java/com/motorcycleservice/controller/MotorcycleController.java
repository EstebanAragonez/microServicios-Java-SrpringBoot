package com.motorcycleservice.controller;

import com.motorcycleservice.entity.Motorcycle;
import com.motorcycleservice.service.impl.MotorcycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorcycle")
@RequiredArgsConstructor
public class MotorcycleController {

    private  final MotorcycleService motorcycleService;

    @GetMapping
    public ResponseEntity<List<Motorcycle>> listarMotorcycles()throws Exception {
        List<Motorcycle> motorcycles = motorcycleService.getAll();
        if (motorcycles == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motorcycles);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Motorcycle> obtenerMotorcycle(@PathVariable("id")int id)throws Exception {
        Motorcycle motorcycle = motorcycleService.getMotorcycleById(id);
        if (motorcycle == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motorcycle);
    }
    @PostMapping
    public ResponseEntity<Motorcycle> guardarMotorcycle(@RequestBody Motorcycle motorcycle) throws Exception {
        Motorcycle nuevoMotorcycle = motorcycleService.save(motorcycle);
        return ResponseEntity.ok(nuevoMotorcycle);
    }
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Motorcycle>>listarMotorcyclesPorUsuarioId(@PathVariable("usuarioId")int id)throws Exception{
        List<Motorcycle> motorcycles = motorcycleService.byUsuarioId(id);
        if (motorcycles.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motorcycles);
    }




}
