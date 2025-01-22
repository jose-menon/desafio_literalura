package com.desafioalura.Desafio_LiterAlura.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Map;

@Service
public class ConsumoAPI
{
    private final RestTemplate restTemplate;

    public ConsumoAPI()
    {
        this.restTemplate = new RestTemplate();
    }

    public Map<String, Object> buscarLibroPorTitulo(String titulo)
    {
        String url = "https://gutendex.com/books/" + titulo;
        return restTemplate.getForObject(url, Map.class);
    }
}
