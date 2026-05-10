package com.biblioteca.prestamo_service.repository;

import com.biblioteca.prestamo_service.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}
