package com.carservice.service;

import com.carservice.entity.Car;

import java.util.List;

public interface ICarService {
    List<Car> getAll()throws Exception;

    Car getCarById(int id)throws Exception;

    Car save(Car car)throws Exception;

    List<Car> byUsuarioId(int usuarioId)throws Exception;



}
