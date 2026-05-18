package com.biblioteca.reporte_service.controller;

import com.biblioteca.reporte_service.dto.ReporteDTO;
import com.biblioteca.reporte_service.model.Reporte;
import com.biblioteca.reporte_service.service.ReporteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    // GET
    @GetMapping
    public ResponseEntity<List<Reporte>> listarReportes() {
        log.info("Controller: Solicitud para listar reportes");
        return ResponseEntity.ok(reporteService.listarReportes());
    }

    // GET
    @GetMapping("/{id}")
    public ResponseEntity<Reporte> obtenerReporte(@PathVariable Long id) {
        log.info("Controller: Buscando reporte ID: {}", id);
        return ResponseEntity.ok(reporteService.buscarReporte(id));
    }

    // POST
    @PostMapping
    public ResponseEntity<Reporte> crearReporte(@Valid @RequestBody ReporteDTO reporteDTO) {
        log.info("Controller: Recibida solicitud para crear reporte tipo: {}", reporteDTO.getTipo());
        Reporte nuevo = reporteService.guardarReporte(reporteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarReporte(@PathVariable Long id) {
        log.warn("Controller: Solicitud para eliminar reporte ID: {}", id);
        reporteService.eliminarReporte(id);
        return ResponseEntity.ok("Reporte eliminado con éxito");
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<Reporte> actualizarReporte(@PathVariable Long id, @Valid @RequestBody ReporteDTO reporteDTO) {
        log.info("Controller: Solicitud de actualización para reporte ID: {}", id);
        return ResponseEntity.ok(reporteService.actualizarReporte(id, reporteDTO));
    }
}