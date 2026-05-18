package com.biblioteca.reserva_service.controller;

import com.biblioteca.reserva_service.dto.ReservaDTO;
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
    public ResponseEntity<List<Reserva>> listarReservas() {
        log.info("Controller: Solicitando lista de todas las reservas");
        return ResponseEntity.ok(reservaService.listarReservas());
    }
    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarReserva(@PathVariable Long id) {
        log.info("Controller: Buscando reserva con ID: {}", id);
        return ResponseEntity.ok(reservaService.buscarReserva(id));
    }

    // POST
    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@Valid @RequestBody ReservaDTO reservaDTO) {
        log.info("Controller: Iniciando creación de reserva para Usuario ID: {}", reservaDTO.getUsuarioId());
        Reserva nueva = reservaService.guardarReserva(reservaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarReserva(@PathVariable Long id) {
        log.warn("Controller: Petición para eliminar reserva ID: {}", id);
        reservaService.eliminarReserva(id);
        return ResponseEntity.ok("Reserva eliminada con éxito");
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> actualizarReserva(@PathVariable Long id, @Valid @RequestBody ReservaDTO reservaDTO) {
        log.info("Controller: Petición para actualizar reserva con ID: {}", id);
        Reserva actualizada = reservaService.actualizarReserva(id, reservaDTO);
        return ResponseEntity.ok(actualizada);
    }
}