package com.biblioteca.multa_service.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.multa_service.dto.MultaRequest;
import com.biblioteca.multa_service.dto.MultaResponse;
import com.biblioteca.multa_service.service.MultaService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/multas")
@Slf4j
public class MultaController {
    @Autowired
    private MultaService multaService;
    //GET-Listar todas
    @GetMapping
    public ResponseEntity<List<MultaResponse>> listarMultas() {
            log.info("Solicitud para listar todas las multas");
            List<MultaResponse> multas = multaService.listarMultas();
            log.info("Se encontraron {} multas", multas.size());
        return ResponseEntity.ok(multas);
    }
    //GET BY ID- buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<MultaResponse> buscarMulta(@PathVariable Long id) {
            log.info("Solicitud para buscar multa con ID: {}", id);
            MultaResponse multa = multaService.buscarMulta(id);
            log.info("Multa encontrada con ID: {}", multa.getId());
        return ResponseEntity.ok(multa);
    }
    //POST-Crear
    @PostMapping
    public ResponseEntity<MultaResponse> guardarMulta(@Valid @RequestBody MultaRequest request) {
            log.info("Solicitud para crear nueva multa para usuario ID: {}", request.getUsuarioId());
            MultaResponse nuevaMulta = multaService.guardarMulta(request);
            log.info("Multa creada exitosamente con ID: {}", nuevaMulta.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMulta);
    }
    // PUT-Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<MultaResponse> actualizarMulta(
            @PathVariable Long id,
            @Valid @RequestBody MultaRequest request) {
            log.info("Solicitud para actualizar multa con ID: {}", id);
        return ResponseEntity.ok(multaService.actualizarMulta(id,request));
    }
    //DELETE-Borrar 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMulta(@PathVariable Long id) {
            log.info("Solicitud para eliminar multa con ID: {}", id);
            multaService.eliminarMulta(id);
            log.info("Multa con ID {} eliminada exitosamente", id);
        return ResponseEntity.noContent().build();
    }
}