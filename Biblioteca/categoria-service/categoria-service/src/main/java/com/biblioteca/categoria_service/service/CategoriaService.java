package com.biblioteca.categoria_service.service;

import com.biblioteca.categoria_service.dto.CategoriaRequest;
import com.biblioteca.categoria_service.model.Categoria;
import com.biblioteca.categoria_service.repository.CategoriaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarCategorias() {
        log.info("Service: Listando todas las categorias");
        return categoriaRepository.findAll();
    }

    public Categoria guardarCategoria(CategoriaRequest request) {
        log.info("Service: Guardando nueva categoria: {}", request.getNombre());
        Categoria categoria = new Categoria();
        categoria.setNombre(request.getNombre());
        Categoria guardada = categoriaRepository.save(categoria);
        log.info("Service: Categoria guardada con ID: {}", guardada.getId());
        return guardada;
    }

    public Categoria buscarCategoria(Long id) {
        log.info("Service: Buscando categoria con ID: {}", id);
        return categoriaRepository.findById(id).orElseThrow(() -> {
            log.error("Service: Categoria con ID {} no encontrada", id);
            return new RuntimeException("Categoria no encontrada");
        });
    }

    public void eliminarCategoria(Long id) {
        log.warn("Service: Eliminando categoria con ID: {}", id);
        categoriaRepository.deleteById(id);
        log.info("Service: Categoria con ID {} eliminada", id);
    }
}