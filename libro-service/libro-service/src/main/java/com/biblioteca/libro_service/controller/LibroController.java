package com.biblioteca.libro_service.controller;

import com.biblioteca.libro_service.model.Libro;
import com.biblioteca.libro_service.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    // GET
    @GetMapping
    public ResponseEntity<List<Libro>> listarLibros(){
        return ResponseEntity.ok(libroService.listarLibros());
    }

    // GET
    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscarLibro(@PathVariable Long id){
        return ResponseEntity.ok(libroService.buscarLibroPorId(id));
    }

    // POST
    @PostMapping
    public ResponseEntity<Libro> guardarLibro(@RequestBody Libro libro){
        return ResponseEntity.ok(libroService.guardarLibro(libro));
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libroActualizado){

        Libro libro = libroService.buscarLibroPorId(id);

        libro.setTitulo(libroActualizado.getTitulo());
        libro.setAutor(libroActualizado.getAutor());
        libro.setDisponible(libroActualizado.isDisponible());

        return ResponseEntity.ok(libroService.guardarLibro(libro));
    }

    // DELETE -> ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLibro(@PathVariable Long id){
        libroService.eliminarLibro(id);
        return ResponseEntity.ok("Libro eliminado correctamente");
    }
}