package com.biblioteca.inventario_service.controller;

import com.biblioteca.inventario_service.model.Inventario;
import com.biblioteca.inventario_service.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    // GET
    @GetMapping
    public ResponseEntity<List<Inventario>> listar(){
        return ResponseEntity.ok(inventarioService.listarInventario());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Inventario> buscar(@PathVariable Long id){
        return ResponseEntity.ok(inventarioService.buscarInventario(id));
    }

    // POST
    @PostMapping
    public ResponseEntity<Inventario> guardar(@RequestBody Inventario inventario){
        return ResponseEntity.ok(inventarioService.guardarInventario(inventario));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){inventarioService.eliminarInventario(id);
        return ResponseEntity.ok("Inventario eliminado");
    }
}