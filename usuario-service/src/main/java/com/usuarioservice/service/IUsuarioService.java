package com.usuarioservice.service;

import com.usuarioservice.entity.Usuario;
import com.usuarioservice.model.Car;
import com.usuarioservice.model.Motorcycle;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> getAll() throws Exception;

    Usuario getUsuarioById(int id) throws Exception;

    Usuario save(Usuario usuario) throws Exception;

    List<Car> getCars(int usuarioId) throws Exception;

    List<Motorcycle> getMotorcycles(int usuarioId) throws Exception;
}
