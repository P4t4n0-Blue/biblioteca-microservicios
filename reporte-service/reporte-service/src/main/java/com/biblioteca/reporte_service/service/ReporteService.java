package com.biblioteca.reporte_service.service;

import com.biblioteca.reporte_service.model.Reporte;
import com.biblioteca.reporte_service.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    // LISTAR
    public List<Reporte> listarReportes(){
        return reporteRepository.findAll();
    }

    // GUARDAR
    public Reporte guardarReporte(Reporte reporte){
        return reporteRepository.save(reporte);
    }

    // BUSCAR
    public Reporte buscarReporte(Long id){
        return reporteRepository.findById(id).orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
    }

    // ELIMINAR
    public void eliminarReporte(Long id){
        reporteRepository.deleteById(id);
    }
}