package com.biblioteca.inventario_service.service;

import com.biblioteca.inventario_service.model.Inventario;
import com.biblioteca.inventario_service.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    // LISTAR
    public List<Inventario> listarInventario(){
        return inventarioRepository.findAll();
    }

    // GUARDAR
    public Inventario guardarInventario(Inventario inventario){
        return inventarioRepository.save(inventario);
    }

    // BUSCAR
    public Inventario buscarInventario(Long id){
        return inventarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
    }

    // ELIMINAR
    public void eliminarInventario(Long id){
        inventarioRepository.deleteById(id);
    }
}