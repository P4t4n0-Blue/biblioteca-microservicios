package com.biblioteca.multa_service.service;

import com.biblioteca.multa_service.model.Multa;
import com.biblioteca.multa_service.repository.MultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultaService {

    @Autowired
    private MultaRepository multaRepository;

    // LISTAR
    public List<Multa> listarMultas(){
        return multaRepository.findAll();
    }

    // GUARDAR
    public Multa guardarMulta(Multa multa){
        return multaRepository.save(multa);
    }

    // BUSCAR
    public Multa buscarMulta(Long id){
        return multaRepository.findById(id).orElseThrow(() -> new RuntimeException("Multa no encontrada"));
    }

    // ELIMINAR
    public void eliminarMulta(Long id){

        multaRepository.deleteById(id);
    }
}