package com.biblioteca.categoria_service.service;

import com.biblioteca.categoria_service.model.Categoria;
import com.biblioteca.categoria_service.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    //LISTAR
    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }

    //GUARDAR
    public Categoria guardarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    //BUSCAR
    public Categoria buscarCategoria(Long id){
        return categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }

    //ELIMINAR
    public void eliminarCategoria(Long id){
        categoriaRepository.deleteById(id);
    }
}
