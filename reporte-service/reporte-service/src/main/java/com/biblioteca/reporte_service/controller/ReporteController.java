package com.biblioteca.reporte_service.controller;

import com.biblioteca.reporte_service.model.Reporte;
import com.biblioteca.reporte_service.service.ReporteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        log.info("Solicitando lista completa de reportes");
        List<Reporte> reportes = reporteService.listarReportes();
        log.info("Se han recuperado {} reportes", reportes.size());
        return ResponseEntity.ok(reportes);
    }

    // GET
    @GetMapping("/{id}")
    public ResponseEntity<Reporte> buscarReporte(@PathVariable Long id) {
        log.info("Buscando reporte con ID: {}", id);
        Reporte reporte = reporteService.buscarReporte(id);

        if (reporte == null) {
            log.warn("No se encontró el reporte con ID: {}", id);
            return ResponseEntity.notFound().build();
        }
        log.info("Reporte con ID {} encontrado exitosamente", id);
        return ResponseEntity.ok(reporte);
    }

    // POST
    @PostMapping
    public ResponseEntity<Reporte> guardarReporte(@Valid @RequestBody Reporte reporte){
        return ResponseEntity.ok(reporteService.guardarReporte(reporte));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarReporte(@PathVariable Long id){
        reporteService.eliminarReporte(id);
        return ResponseEntity.ok("Reporte eliminado");
    }
}