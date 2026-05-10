package com.biblioteca.libro_service.repository;

import com.biblioteca.libro_service.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LibroRepository extends JpaRepository<Libro, Long> {
}
