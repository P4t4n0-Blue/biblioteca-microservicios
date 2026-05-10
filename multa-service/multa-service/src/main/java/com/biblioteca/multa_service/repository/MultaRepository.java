package com.biblioteca.multa_service.repository;

import com.biblioteca.multa_service.model.Multa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultaRepository extends JpaRepository<Multa, Long> {
}
