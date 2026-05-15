package com.biblioteca.reserva_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Long usuarioId;

    @NotNull
    @Column(nullable = false)
    private Long libroId;

    @NotNull(message = "La fecha de reserva es obligatoria")
    @Column(nullable = false)
    private LocalDate fechaReserva;
}
