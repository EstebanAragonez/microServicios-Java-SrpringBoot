package com.usuarioservice.service.impl;

import com.usuarioservice.entity.Usuario;
import com.usuarioservice.model.Car;
import com.usuarioservice.model.Motorcycle;
import com.usuarioservice.repository.UsuarioRepository;
import com.usuarioservice.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final RestTemplate restTemplate;
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAll() throws Exception {
        try {
            return usuarioRepository.findAll();
        }catch (Exception e) {
            throw new Exception(e);
        }
    }
    @Override
    public Usuario getUsuarioById(int id) throws Exception {
        try {
            return usuarioRepository.findById(id).orElse(null);
        }catch (Exception e) {
            throw new Exception(e);
        }
    }
    @Override
    public Usuario save(Usuario usuario) throws Exception {
        try {
            Usuario nuevoUsuario = usuarioRepository.save(usuario);
            return nuevoUsuario;
        }catch (Exception e) {
            throw new Exception(e);
        }
    }
    @Override
    public List<Car> getCars(int usuarioId) throws Exception {
        List<Car> cars = restTemplate.getForObject("http://localhost:8002/car/usuario/"+ usuarioId, List.class);
        return cars;
    }

    @Override
    public List<Motorcycle> getMotorcycles(int usuarioId) throws Exception {
        List<Motorcycle> motorcycles = restTemplate.getForObject("http://localhost:8003/motorcycle/usuario/"+ usuarioId, List.class);
        return motorcycles;
    }


}
