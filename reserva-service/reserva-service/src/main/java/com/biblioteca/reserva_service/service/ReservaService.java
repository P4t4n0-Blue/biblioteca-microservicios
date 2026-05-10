package com.biblioteca.reserva_service.service;

import com.biblioteca.reserva_service.model.Reserva;
import com.biblioteca.reserva_service.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // LISTAR
    public List<Reserva> listarReservas(){
        return reservaRepository.findAll();
    }

    // GUARDAR
    public Reserva guardarReserva(Reserva reserva){
        return reservaRepository.save(reserva);
    }

    // BUSCAR
    public Reserva buscarReserva(Long id){
        return reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    // ELIMINAR
    public void eliminarReserva(Long id){
        reservaRepository.deleteById(id);
    }
}