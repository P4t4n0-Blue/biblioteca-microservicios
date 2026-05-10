package com.biblioteca.autenticacion_service.controller;

import com.biblioteca.autenticacion_service.model.Autenticacion;
import com.biblioteca.autenticacion_service.service.AutenticacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    @Autowired
    private AutenticacionService autenticacionService;

    // GET
    @GetMapping
    public ResponseEntity<List<Autenticacion>> listarUsuarios(){
        return ResponseEntity.ok(autenticacionService.listarUsuarios());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Autenticacion> buscarUsuario(@PathVariable Long id){
        return ResponseEntity.ok(autenticacionService.buscarUsuario(id));
    }

    // POST
    @PostMapping
    public ResponseEntity<Autenticacion> guardarUsuario(@RequestBody Autenticacion autenticacion){
        return ResponseEntity.ok(autenticacionService.guardarUsuario(autenticacion));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id){
        autenticacionService.eliminarUsuario(id);
        return ResponseEntity.ok("Usuario eliminado");
    }
}