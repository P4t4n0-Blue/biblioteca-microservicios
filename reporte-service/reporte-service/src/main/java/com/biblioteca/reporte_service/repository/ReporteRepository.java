package com.biblioteca.reporte_service.repository;

import com.biblioteca.reporte_service.model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReporteRepository extends JpaRepository<Reporte, Long> {
}
