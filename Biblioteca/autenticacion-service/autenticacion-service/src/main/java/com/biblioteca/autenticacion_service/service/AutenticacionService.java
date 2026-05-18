package com.biblioteca.autenticacion_service.service;

import com.biblioteca.autenticacion_service.model.Autenticacion;
import com.biblioteca.autenticacion_service.repository.AutenticacionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class AutenticacionService {

    @Autowired
    private AutenticacionRepository autenticacionRepository;

    public List<Autenticacion> listarUsuarios() {
        log.info("Service: Listando todas las autenticaciones");
        return autenticacionRepository.findAll();
    }

    public Autenticacion guardarUsuario(Autenticacion autenticacion) {
        log.info("Service: Guardando autenticacion para usuario ID: {}", autenticacion.getId());
        Autenticacion guardada = autenticacionRepository.save(autenticacion);
        log.info("Service: Autenticacion guardada con ID: {}", guardada.getId());
        return guardada;
    }

    public Autenticacion buscarUsuario(Long id) {
        log.info("Service: Buscando autenticacion con ID: {}", id);
        return autenticacionRepository.findById(id).orElseThrow(() -> {
            log.error("Service: Autenticacion con ID {} no encontrada", id);
            return new RuntimeException("Usuario no encontrado");
        });
    }

    public void eliminarUsuario(Long id) {
        log.warn("Service: Eliminando autenticacion con ID: {}", id);
        autenticacionRepository.deleteById(id);
        log.info("Service: Autenticacion con ID {} eliminada", id);
    }
}