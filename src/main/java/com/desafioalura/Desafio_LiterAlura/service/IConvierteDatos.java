package com.desafioalura.Desafio_LiterAlura.service;

public interface IConvierteDatos
{
    <T> T obtenerDatos(String json, Class<T> clase);
}
