package com.carservice.controller;

import com.carservice.entity.Car;
import com.carservice.service.impl.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> listarCars() throws Exception {
        List<Car> cars = carService.getAll();
        if (cars == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Car> obtenerCar(@PathVariable("id")int id) throws Exception {
        Car car = carService.getCarById(id);
        if (car == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(car);
    }
    @PostMapping
    public ResponseEntity<Car> guardarCar(@RequestBody Car car) throws Exception {
        Car nuevoCar = carService.save(car);
        return ResponseEntity.ok(nuevoCar);
    }
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Car>> listarCarsPorUsuarioId(@PathVariable ("usuarioId") int id )throws Exception {
        List<Car> cars = carService.byUsuarioId(id);
        if (cars.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }
}
