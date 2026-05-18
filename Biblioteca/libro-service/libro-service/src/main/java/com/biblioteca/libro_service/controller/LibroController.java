package com.biblioteca.libro_service.controller;

import com.biblioteca.libro_service.dto.LibroRequest;
import com.biblioteca.libro_service.model.Libro;
import com.biblioteca.libro_service.service.LibroService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/libros")
public class LibroController {
    // Inyección del servicio de libros para manejar la lógica de negocio
    @Autowired
    private LibroService libroService;
    // GET - Listar todos
    @GetMapping
    public ResponseEntity<List<Libro>> listarLibros() {
        log.info("Controller: Solicitud para listar todos los libros");
        return ResponseEntity.ok(libroService.listarLibros());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscarLibro(@PathVariable Long id) {
        log.info("Controller: Buscando libro con ID: {}", id);
        return ResponseEntity.ok(libroService.buscarLibroPorId(id));
    }

    // POST - Crear
    @PostMapping
    public ResponseEntity<Libro> guardarLibro(@Valid @RequestBody LibroRequest dto) {
        log.info("Controller: Solicitud para crear libro: {}", dto.getTitulo());
        Libro nuevo = libroService.guardarLibro(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    // PUT - Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id,
                                                  @Valid @RequestBody LibroRequest dto) {
        log.info("Controller: Solicitud para actualizar libro con ID: {}", id);
        return ResponseEntity.ok(libroService.actualizarLibro(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLibro(@PathVariable Long id) {
        log.warn("Controller: Eliminando libro con ID: {}", id);
        libroService.eliminarLibro(id);
        return ResponseEntity.ok("Libro eliminado correctamente");
    }
}
