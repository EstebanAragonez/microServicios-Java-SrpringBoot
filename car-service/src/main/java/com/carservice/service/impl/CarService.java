package com.carservice.service.impl;

import com.carservice.entity.Car;
import com.carservice.repository.CarRepository;
import com.carservice.service.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService implements ICarService {

    private final CarRepository carRepository;

    @Override
    public List<Car> getAll() throws Exception {
        try {
            return carRepository.findAll();
        }catch (Exception e) {
            throw new Exception(e);
        }
    }
    @Override
    public Car getCarById(int id) throws Exception {
        try {
            return carRepository.findById(id).orElse(null);
        }catch (Exception e) {
            throw new Exception(e);
        }
    }
    @Override
    public Car save(Car car) throws Exception {
        try {
            Car nuevoCar = carRepository.save(car);
            return nuevoCar;
        }catch (Exception e) {
            throw new Exception(e);
        }
    }
    @Override
    public List<Car> byUsuarioId(int usuarioId) throws Exception {
        try {
            return carRepository.findByUsuarioId(usuarioId);
        }catch (Exception e) {
            throw new Exception(e);
        }
    }
}
