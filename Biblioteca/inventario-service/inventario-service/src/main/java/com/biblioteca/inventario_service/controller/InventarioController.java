package com.biblioteca.inventario_service.controller;

import com.biblioteca.inventario_service.dto.InventarioRequest;
import com.biblioteca.inventario_service.model.Inventario;
import com.biblioteca.inventario_service.service.InventarioService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public ResponseEntity<List<Inventario>> listar() {
        log.info("Listando registros de inventario");

        return ResponseEntity.ok(inventarioService.listarInventario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> buscar(@PathVariable Long id) {
        log.info("Buscando inventario con ID: {}", id);
        return ResponseEntity.ok(inventarioService.buscarInventario(id));
    }

    @PostMapping
    public ResponseEntity<Inventario> guardar(@Valid @RequestBody InventarioRequest request) {
        log.info("Registrando nuevo inventario");
        return ResponseEntity.ok(inventarioService.guardarInventario(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        log.info("Eliminando inventario con ID: {}", id);
        inventarioService.eliminarInventario(id);
        return ResponseEntity.ok("Inventario eliminado");
    }
}