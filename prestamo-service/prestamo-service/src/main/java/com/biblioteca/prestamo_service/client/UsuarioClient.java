package com.biblioteca.prestamo_service.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UsuarioClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public void validarUsuario(Long id){
        String url = "http://localhost:8082/usuarios/" + id;

        try {
            restTemplate.getForObject(url, String.class);
        } catch (Exception e){
            throw new RuntimeException("Usuario no encontrado");
        }
    }
}