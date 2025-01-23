package com.desafioalura.Desafio_LiterAlura.entity;

import com.desafioalura.Desafio_LiterAlura.model.Datos;
import com.desafioalura.Desafio_LiterAlura.model.DatosLibros;
import jakarta.persistence.*;

import java.util.OptionalDouble;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String idioma;
    private Double numeroDescargas;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Libro(DatosLibros datosLibros)
    {
        this.titulo = datosLibros.titulo();
        this.autor = (datosLibros.autor() instanceof Autor) ? (Autor) datosLibros.autor() : null;
        this.idioma = String.valueOf(datosLibros.idiomas());
        this.numeroDescargas = (datosLibros.numeroDescargas() != null) ? datosLibros.numeroDescargas() : 0.0;
    }
    public Libro() {
    }

    public Libro(Datos datos) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Double getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Double numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }
}
