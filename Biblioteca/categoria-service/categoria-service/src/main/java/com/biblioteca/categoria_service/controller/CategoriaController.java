package com.biblioteca.categoria_service.controller;

import com.biblioteca.categoria_service.dto.CategoriaRequest;
import com.biblioteca.categoria_service.model.Categoria;
import com.biblioteca.categoria_service.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        log.info("Listando todas las categorías");
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoria(@PathVariable Long id) {
        log.info("Buscando categoría con ID: {}", id);
        return ResponseEntity.ok(categoriaService.buscarCategoria(id));
    }

    @PostMapping
    public ResponseEntity<Categoria> guardarCategoria(@Valid @RequestBody CategoriaRequest request) {
        log.info("Registrando categoría: {}", request.getNombre());
        return ResponseEntity.ok(categoriaService.guardarCategoria(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable Long id) {
        log.info("Eliminando categoría con ID: {}", id);
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.ok("Categoria eliminada");
    }
}