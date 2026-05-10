package com.biblioteca.prestamo_service.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LibroClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public void validarLibro(Long id){
        String url = "http://localhost:8081/libros/" + id;

        try {
            restTemplate.getForObject(url, String.class);
        } catch (Exception e){
            throw new RuntimeException("Libro no encontrado");
        }
    }
}