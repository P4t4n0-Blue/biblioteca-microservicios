package com.biblioteca.autenticacion_service.controller;

import com.biblioteca.autenticacion_service.model.Autenticacion;
import com.biblioteca.autenticacion_service.service.AutenticacionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    @Autowired
    private AutenticacionService autenticacionService;

    @GetMapping
    public ResponseEntity<List<Autenticacion>> listarUsuarios() {
        log.info("Listando usuarios autenticados");
        return ResponseEntity.ok(autenticacionService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autenticacion> buscarUsuario(@PathVariable Long id) {
        log.info("Buscando usuario con ID: {}", id);
        return ResponseEntity.ok(autenticacionService.buscarUsuario(id));
    }

    @PostMapping
    public ResponseEntity<Autenticacion> guardarUsuario(@RequestBody Autenticacion autenticacion) {
        log.info("Registrando usuario: {}", autenticacion.getNombreUsuario());
        return ResponseEntity.ok(autenticacionService.guardarUsuario(autenticacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        log.info("Eliminando usuario con ID: {}", id);
        autenticacionService.eliminarUsuario(id);
        return ResponseEntity.ok("Usuario eliminado");
    }
}