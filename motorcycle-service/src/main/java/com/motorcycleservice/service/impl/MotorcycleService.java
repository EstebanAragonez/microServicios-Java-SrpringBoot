package com.motorcycleservice.service.impl;

import com.motorcycleservice.entity.Motorcycle;
import com.motorcycleservice.repository.MotorcycleRepository;
import com.motorcycleservice.service.IMotorcycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotorcycleService implements IMotorcycleService {

    private final MotorcycleRepository motorcycleRepository;

    @Override
    public List<Motorcycle> getAll() throws Exception {
        try {
            return motorcycleRepository.findAll();
        }catch (Exception e) {
            throw new Exception(e);
        }

    }
    @Override
    public Motorcycle getMotorcycleById(int id) throws Exception {
        try {
            return motorcycleRepository.findById(id).orElse(null);
        }catch (Exception e){
            throw new Exception(e);
        }
    }
    @Override
    public Motorcycle save(Motorcycle motorcycle) throws Exception {
        try {
            Motorcycle nuevoMotorcycle = motorcycleRepository.save(motorcycle);
            return nuevoMotorcycle;
        }catch (Exception e){
            throw new Exception(e);
        }
    }
    @Override
    public List<Motorcycle> byUsuarioId(int usuarioId) throws Exception {
        try {
            return motorcycleRepository.findByUsuarioId(usuarioId);
        }catch (Exception e){
            throw new Exception(e);
        }
    }

}
