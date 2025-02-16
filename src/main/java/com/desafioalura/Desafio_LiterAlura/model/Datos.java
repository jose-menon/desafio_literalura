package com.desafioalura.Desafio_LiterAlura.model;

import com.desafioalura.Desafio_LiterAlura.model.DatosLibros;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record Datos(
        @JsonAlias("results") List<DatosLibros> libros
) {
}

