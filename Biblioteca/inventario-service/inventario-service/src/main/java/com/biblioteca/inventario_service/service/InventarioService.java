package com.biblioteca.inventario_service.service;

import com.biblioteca.inventario_service.dto.InventarioRequest;
import com.biblioteca.inventario_service.model.Inventario;
import com.biblioteca.inventario_service.repository.InventarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> listarInventario() {
        log.info("Service: Listando todo el inventario");
        return inventarioRepository.findAll();
    }

    public Inventario guardarInventario(InventarioRequest request) {
        log.info("Service: Guardando inventario: {}", request.getNombreInventario());
        Inventario inventario = new Inventario();
        inventario.setStock(request.getStock());
        inventario.setNombreInventario(request.getNombreInventario());
        Inventario guardado = inventarioRepository.save(inventario);
        log.info("Service: Inventario guardado con ID: {}", guardado.getId());
        return guardado;
    }

    public Inventario buscarInventario(Long id) {
        log.info("Service: Buscando inventario con ID: {}", id);
        return inventarioRepository.findById(id).orElseThrow(() -> {
            log.error("Service: Inventario con ID {} no encontrado", id);
            return new RuntimeException("Inventario no encontrado");
        });
    }

    public void eliminarInventario(Long id) {
        log.warn("Service: Eliminando inventario con ID: {}", id);
        inventarioRepository.deleteById(id);
        log.info("Service: Inventario con ID {} eliminado", id);
    }
}