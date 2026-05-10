package com.biblioteca.autenticacion_service.service;

import com.biblioteca.autenticacion_service.model.Autenticacion;
import com.biblioteca.autenticacion_service.repository.AutenticacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutenticacionService {

    @Autowired
    private AutenticacionRepository autenticacionRepository;

    // LISTAR
    public List<Autenticacion> listarUsuarios(){
        return autenticacionRepository.findAll();
    }

    // GUARDAR
    public Autenticacion guardarUsuario(Autenticacion autenticacion){
        return autenticacionRepository.save(autenticacion);
    }

    // BUSCAR
    public Autenticacion buscarUsuario(Long id){
        return autenticacionRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // ELIMINAR
    public void eliminarUsuario(Long id){
        autenticacionRepository.deleteById(id);
    }
}