package com.biblioteca.autenticacion_service.repository;

import com.biblioteca.autenticacion_service.model.Autenticacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutenticacionRepository extends JpaRepository<Autenticacion, Long> {
}
