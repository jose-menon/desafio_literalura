package com.desafioalura.Desafio_LiterAlura.service;

import com.desafioalura.Desafio_LiterAlura.entity.Autor;
import com.desafioalura.Desafio_LiterAlura.entity.Libro;
import com.desafioalura.Desafio_LiterAlura.repository.AutorRepository;
import com.desafioalura.Desafio_LiterAlura.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public class BibliotecaService
{
    @Autowired
    private LibrosRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public List<Libro> buscarLibroPorTitulo(String titulo) {
        return libroRepository.findByTituloContaining(titulo);
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public List<Autor> listarAutoresVivos(int año) {
        return autorRepository.findByVivo(true);
    }

    public List<Libro> listarLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }
}
