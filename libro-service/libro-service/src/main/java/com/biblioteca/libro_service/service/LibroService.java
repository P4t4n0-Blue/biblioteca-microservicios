package com.biblioteca.libro_service.service;

import com.biblioteca.libro_service.model.Libro;
import com.biblioteca.libro_service.repository.LibroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private static final Logger log = LoggerFactory.getLogger(LibroService.class);

    @Autowired
    private LibroRepository libroRepository;

    // LISTAR
    public List<Libro> listarLibros(){
        log.info("Listando libros");

        return libroRepository.findAll();
    }

    // GUARDAR
    public Libro guardarLibro(Libro libro){
        log.info("Guardando libro");

        return libroRepository.save(libro);
    }

    // BUSCAR
    public Libro buscarLibroPorId(Long id){
        log.info("Buscando libro con ID: {}", id);

        return libroRepository.findById(id).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    // ELIMINAR
    public void eliminarLibro(Long id){
        log.info("Eliminando libro con ID: {}", id);
        libroRepository.deleteById(id);
    }
}