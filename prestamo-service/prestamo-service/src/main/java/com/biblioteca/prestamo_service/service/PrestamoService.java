package com.biblioteca.prestamo_service.service;

import com.biblioteca.prestamo_service.client.UsuarioClient;
import com.biblioteca.prestamo_service.client.LibroClient;
import com.biblioteca.prestamo_service.model.Prestamo;
import com.biblioteca.prestamo_service.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private LibroClient libroClient;

    // LISTAR
    public List<Prestamo> listarPrestamos(){
        return prestamoRepository.findAll();
    }

    // GUARDAR
    public Prestamo guardarPrestamo(Prestamo prestamo){
        usuarioClient.validarUsuario(prestamo.getUsuarioId());
        libroClient.validarLibro(prestamo.getLibroId());
        prestamo.setEstado("ACTIVO");

        return prestamoRepository.save(prestamo);
    }

    // BUSCAR
    public Prestamo buscarPrestamo(Long id){
        return prestamoRepository.findById(id).orElseThrow(() -> new RuntimeException("Prestamo no encontrado"));
    }

    // ELIMINAR
    public void eliminarPrestamo(Long id){
        prestamoRepository.deleteById(id);
    }
}