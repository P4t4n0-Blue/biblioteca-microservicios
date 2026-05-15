package com.biblioteca.reserva_service.controller;

import com.biblioteca.reserva_service.model.Reserva;
import com.biblioteca.reserva_service.service.ReservaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    // GET
    @GetMapping
    public ResponseEntity<List<Reserva>> listarReservas(){
        return ResponseEntity.ok(reservaService.listarReservas());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarReserva(@PathVariable Long id){
        return ResponseEntity.ok(reservaService.buscarReserva(id));
    }

    // POST
    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@Valid @RequestBody Reserva reserva) {
        log.info("Iniciando proceso de reserva, Usuario ID: {}, Libro ID: {}",
                reserva.getUsuarioId(), reserva.getLibroId());

        Reserva nuevaReserva = reservaService.guardarReserva(reserva);

        log.info("Reserva finalizada correctamente con ID: {}", nuevaReserva.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaReserva);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarReserva(@PathVariable Long id){
        reservaService.eliminarReserva(id);
        return ResponseEntity.ok("Reserva eliminada");
    }
}