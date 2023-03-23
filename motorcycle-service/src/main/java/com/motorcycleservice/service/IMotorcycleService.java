package com.motorcycleservice.service;

import com.motorcycleservice.entity.Motorcycle;

import java.util.List;

public interface IMotorcycleService {

    List<Motorcycle> getAll() throws Exception;

    Motorcycle getMotorcycleById(int id) throws Exception;

    Motorcycle save(Motorcycle motorcycle) throws Exception;

    List<Motorcycle> byUsuarioId(int usuarioId)throws Exception;

}
