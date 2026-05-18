package com.biblioteca.prestamo_service.controller;

import com.biblioteca.prestamo_service.dto.PrestamoRequest;
import com.biblioteca.prestamo_service.dto.PrestamoResponse;
import com.biblioteca.prestamo_service.service.PrestamoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    // GET - Listar todos
    @GetMapping
    public ResponseEntity<List<PrestamoResponse>> listar() {
        log.info("Controller: Solicitud para listar todos los préstamos");
        return ResponseEntity.ok(prestamoService.listarPrestamos());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<PrestamoResponse> buscar(@PathVariable Long id) {
        log.info("Controller: Buscando préstamo con ID: {}", id);
        return ResponseEntity.ok(prestamoService.buscarPrestamo(id));
    }

    // POST - Crear
    @PostMapping
    public ResponseEntity<PrestamoResponse> guardar(@Valid @RequestBody PrestamoRequest dto) {
        log.info("Controller: Solicitud para crear préstamo - Usuario: {}, Libro: {}",
                dto.getUsuarioId(), dto.getLibroId());
        PrestamoResponse nuevo = prestamoService.guardarPrestamo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    // PUT - Actualizar estado
    @PutMapping("/{id}/estado")
    public ResponseEntity<PrestamoResponse> actualizarEstado(@PathVariable Long id,
                                                              @RequestParam String estado) {
        log.info("Controller: Actualizando estado del préstamo ID: {} a '{}'", id, estado);
        return ResponseEntity.ok(prestamoService.actualizarEstado(id, estado));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        log.warn("Controller: Eliminando préstamo con ID: {}", id);
        prestamoService.eliminarPrestamo(id);
        return ResponseEntity.ok("Préstamo eliminado correctamente");
    }
}
