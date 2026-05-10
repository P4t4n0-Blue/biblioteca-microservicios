package com.biblioteca.autor_service.repository;

import com.biblioteca.autor_service.model.Autor;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
