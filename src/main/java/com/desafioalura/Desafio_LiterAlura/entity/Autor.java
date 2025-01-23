package com.desafioalura.Desafio_LiterAlura.entity;

import com.desafioalura.Desafio_LiterAlura.entity.Libro;
import com.desafioalura.Desafio_LiterAlura.model.DatosAutor;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private boolean vivo;
    private LocalDate fechaNacimiento;
    private LocalDate fechaFallecimiento;
    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    public Autor(){}

    public Autor(DatosAutor datosAutor)
    {
        this.nombre = datosAutor.nombre();
        this.fechaNacimiento = LocalDate.parse(datosAutor.fechaNacimiento());
        this.fechaFallecimiento = LocalDate.parse(datosAutor.fechaFallecimiento());
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(LocalDate fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}

