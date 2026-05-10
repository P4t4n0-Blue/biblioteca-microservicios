package com.biblioteca.reporte_service.controller;

import com.biblioteca.reporte_service.model.Reporte;
import com.biblioteca.reporte_service.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    // GET
    @GetMapping
    public ResponseEntity<List<Reporte>> listarReportes(){
        return ResponseEntity.ok(reporteService.listarReportes());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Reporte> buscarReporte(@PathVariable Long id){
        return ResponseEntity.ok(reporteService.buscarReporte(id));
    }

    // POST
    @PostMapping
    public ResponseEntity<Reporte> guardarReporte(@RequestBody Reporte reporte){
        return ResponseEntity.ok(reporteService.guardarReporte(reporte));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarReporte(@PathVariable Long id){
        reporteService.eliminarReporte(id);
        return ResponseEntity.ok("Reporte eliminado");
    }
}