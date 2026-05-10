package com.biblioteca.reserva_service.controller;

import com.biblioteca.reserva_service.model.Reserva;
import com.biblioteca.reserva_service.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Reserva> guardarReserva(@RequestBody Reserva reserva){
        return ResponseEntity.ok(reservaService.guardarReserva(reserva));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarReserva(@PathVariable Long id){
        reservaService.eliminarReserva(id);
        return ResponseEntity.ok("Reserva eliminada");
    }
}