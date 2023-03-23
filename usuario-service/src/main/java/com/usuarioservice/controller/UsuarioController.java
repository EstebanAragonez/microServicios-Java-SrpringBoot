package com.usuarioservice.controller;

import com.usuarioservice.entity.Usuario;
import com.usuarioservice.model.Car;
import com.usuarioservice.model.Motorcycle;
import com.usuarioservice.service.impl.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() throws Exception {
        List<Usuario> usuarios = usuarioService.getAll();
        if(usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarios(@PathVariable("id")int id) throws Exception {
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }
    @PostMapping
    public ResponseEntity<Usuario> guardUsuario(@RequestBody Usuario usuario) throws Exception {
        Usuario nuevoUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }
    @GetMapping("/cars/{usuarioId}")
    public ResponseEntity<List<Car>> listarCars(@PathVariable("usuarioId") int id) throws Exception {
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        List<Car> cars =  usuarioService.getCars(id);
        return ResponseEntity.ok(cars);
    }
    @GetMapping("/motorcycle/{usuarioId}")
    public ResponseEntity<List<Motorcycle>> listarMotorcycles(@PathVariable("usuarioId") int id) throws Exception {
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        List<Motorcycle> motorcycles =  usuarioService.getMotorcycles(id);
        return ResponseEntity.ok(motorcycles);
    }




}
