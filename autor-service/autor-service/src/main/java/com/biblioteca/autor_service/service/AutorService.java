package com.biblioteca.autor_service.service;

import com.biblioteca.autor_service.model.Autor;
import com.biblioteca.autor_service.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    // LISTAR
    public List<Autor> listarAutores(){
        return autorRepository.findAll();
    }

    // GUARDAR
    public Autor guardarAutor(Autor autor){

        return autorRepository.save(autor);
    }

    // BUSCAR
    public Autor buscarAutor(Long id){
        return autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor no encontrado"));
    }

    // ELIMINAR
    public void eliminarAutor(Long id){
        autorRepository.deleteById(id);
    }
}