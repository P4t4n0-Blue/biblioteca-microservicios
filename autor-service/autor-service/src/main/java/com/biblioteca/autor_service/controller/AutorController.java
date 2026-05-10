package com.biblioteca.autor_service.controller;

import com.biblioteca.autor_service.model.Autor;
import com.biblioteca.autor_service.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    // GET
    @GetMapping
    public ResponseEntity<List<Autor>> listarAutores(){
        return ResponseEntity.ok(autorService.listarAutores());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarAutor(@PathVariable Long id){
        return ResponseEntity.ok(autorService.buscarAutor(id));
    }

    // POST
    @PostMapping
    public ResponseEntity<Autor> guardarAutor(@RequestBody Autor autor){
        return ResponseEntity.ok(autorService.guardarAutor(autor));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAutor(@PathVariable Long id){
        autorService.eliminarAutor(id);
        return ResponseEntity.ok("Autor eliminado");
    }
}