package com.biblioteca.autor_service.controller;

import com.biblioteca.autor_service.dto.AutorRequest;
import com.biblioteca.autor_service.model.Autor;
import com.biblioteca.autor_service.service.AutorService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;
    // GET - Listar todos
    @GetMapping
    public ResponseEntity<List<Autor>> listarAutores() {
        log.info("Controller: Solicitud para listar todos los autores");
        return ResponseEntity.ok(autorService.listarAutores());
    }
    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarAutor(@PathVariable Long id) {
        log.info("Controller: Buscando autor con ID: {}", id);
        return ResponseEntity.ok(autorService.buscarAutor(id));
    }
    // POST - Crear
    @PostMapping
    public ResponseEntity<Autor> guardarAutor(@Valid @RequestBody AutorRequest dto) {
        log.info("Controller: Solicitud para crear autor: {}", dto.getNombre());
        Autor nuevo = autorService.guardarAutor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
    // PUT - Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutor(@PathVariable Long id,
                                                  @Valid @RequestBody AutorRequest dto) {
        log.info("Controller: Solicitud para actualizar autor con ID: {}", id);
        return ResponseEntity.ok(autorService.actualizarAutor(id, dto));
    }
    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAutor(@PathVariable Long id) {
        log.warn("Controller: Eliminando autor con ID: {}", id);
        autorService.eliminarAutor(id);
        return ResponseEntity.ok("Autor eliminado correctamente");
    }
}
