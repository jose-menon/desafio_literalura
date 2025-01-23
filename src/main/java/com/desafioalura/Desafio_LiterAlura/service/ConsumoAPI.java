package com.desafioalura.Desafio_LiterAlura.service;

import org.springframework.stereotype.Service;



import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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


