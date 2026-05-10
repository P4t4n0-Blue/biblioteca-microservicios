package com.biblioteca.prestamo_service.controller;

import com.biblioteca.prestamo_service.model.Prestamo;
import com.biblioteca.prestamo_service.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public ResponseEntity<List<Prestamo>> listar(){
        return ResponseEntity.ok(prestamoService.listarPrestamos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> buscar(@PathVariable Long id){
        return ResponseEntity.ok(prestamoService.buscarPrestamo(id));
    }

    @PostMapping
    public ResponseEntity<Prestamo> guardar(@RequestBody Prestamo prestamo){
        return ResponseEntity.ok(prestamoService.guardarPrestamo(prestamo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        prestamoService.eliminarPrestamo(id);
        return ResponseEntity.ok("Prestamo eliminado");
    }
}