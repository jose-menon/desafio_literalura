package com.desafioalura.Desafio_LiterAlura.repository;

import com.desafioalura.Desafio_LiterAlura.entity.Autor;
import com.desafioalura.Desafio_LiterAlura.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibrosRepository extends JpaRepository<Libro, Long>
{
    List<Libro> findByTituloContaining(String titulo);
    List<Libro> findByIdioma(String idioma);
}
