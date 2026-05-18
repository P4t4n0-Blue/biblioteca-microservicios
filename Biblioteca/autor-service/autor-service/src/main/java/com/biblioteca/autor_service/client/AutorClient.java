package com.biblioteca.autor_service.client;

import com.biblioteca.autor_service.dto.AutorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.NoSuchElementException;

/**
 * Cliente HTTP para consumir datos del propio autor-service.
 */
@Component
@Slf4j
public class AutorClient {

    @Autowired
    private WebClient autorsWebClient;

    /**
     * Obtiene un autor por su ID desde el autor-service.
     *
     * @param autorId Long - ID del autor a consultar
     * @return AutorResponse con datos del autor
     * @throws NoSuchElementException si el autor no existe (HTTP 404)
     */
    public AutorResponse getAutorById(Long autorId) {
        log.info("Client: Consultando autor con ID: {}", autorId);
        try {
            return autorsWebClient.get()
                    .uri("/autores/{id}", autorId)
                    .retrieve()
                    .bodyToMono(AutorResponse.class)
                    .block();
        } catch (WebClientResponseException ex) {
            log.error("Client: Error al obtener autor con ID {}: {}", autorId, ex.getMessage());
            switch (ex.getStatusCode().value()) {
                case 404 -> throw new NoSuchElementException("Autor no encontrado con ID: " + autorId);
                default -> throw new RuntimeException("Error al comunicarse con autor-service para ID: " + autorId, ex);
            }
        }
    }
}
