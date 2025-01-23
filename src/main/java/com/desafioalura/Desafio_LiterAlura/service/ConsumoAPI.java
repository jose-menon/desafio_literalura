<<<<<<< HEAD
package com.desafioalura.Desafio_LiterAlura.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@Service
public class ConsumoAPI
{
    public String obtenerDatos(String url)
    {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest consulta = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> respuesta = null;
        try
        {
            respuesta = cliente
                    .send(consulta, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = respuesta.body();
        return  json;
    }
}
=======
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
>>>>>>> 918d1a98f4c13e76bb18112723cafcf0183d12ab
