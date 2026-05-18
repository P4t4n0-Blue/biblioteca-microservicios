package com.biblioteca.autor_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig {

    @Value("${services.authors.url}")
    private String autorsServiceUrl;

    @Bean
    public WebClient authorsWebClient(){
        return WebClient.builder()
                    .baseUrl(autorsServiceUrl)
                    .defaultHeader("Content-Type", "application/json")
                    .defaultHeader("Accept", "application/json")
                    .build();
    }

}
