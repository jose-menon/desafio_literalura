package com.desafioalura.Desafio_LiterAlura.principal;

import com.desafioalura.Desafio_LiterAlura.entity.Autor;
import com.desafioalura.Desafio_LiterAlura.entity.Libro;
import com.desafioalura.Desafio_LiterAlura.repository.AutorRepository;
import com.desafioalura.Desafio_LiterAlura.repository.LibrosRepository;
import com.desafioalura.Desafio_LiterAlura.service.ConsumoAPI;
import com.desafioalura.Desafio_LiterAlura.service.ConvierteDatos;

import java.util.List;
import java.util.Scanner;

public class Principal
{
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibrosRepository repositorioLibros;
    private AutorRepository autorRepositorio;
    private ConsumoAPI consumoAPI;
    Scanner teclado = new Scanner(System.in);

    public Principal(LibrosRepository reposotorio, AutorRepository autorRepositorio, ConsumoAPI consumo)
    {
        this.repositorioLibros = reposotorio;
        this.autorRepositorio = autorRepositorio;
        this.consumoAPI = consumo;
    }
    public void mostrarMenu()
    {
        var opcion = -1;

        while (opcion != 6)
        {
            var menu = """
                    1. Buscar libro por título
                    2. Listar libros registrados
                    3. Listar autores registrados
                    4. Listar autores vivos en un año específico
                    5. Listar libros por idioma
                    6. Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion)
            {
                case 1:
                    System.out.print("Introduce el título del libro: ");
                    String titulo = teclado.nextLine();
                    buscarLibroPorTitulo(titulo);
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    System.out.print("Introduce el año: ");
                    int año = teclado.nextInt();
                    listarAutoresVivos(año);
                    break;
                case 5:
                    System.out.print("Introduce el idioma: ");
                    String idioma = teclado.nextLine();
                    listarLibrosPorIdioma(idioma);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

    }

    private void listarLibrosPorIdioma(String idioma)
    {
        List<Libro> librosPorIdioma = repositorioLibros.findByIdioma(idioma);
        librosPorIdioma.forEach(libro -> System.out.println(libro.getTitulo()));
    }

    private void listarAutoresVivos(int año)
    {
        List<Autor> autoresVivos = autorRepositorio.findByVivo(true);
        autoresVivos.forEach(autor -> System.out.println(autor.getNombre()));
    }

    private void listarAutoresRegistrados()
    {
        List<Autor> autores = autorRepositorio.findAll();
        autores.forEach(autor -> System.out.println(autor.getNombre()));
    }

    private void listarLibrosRegistrados()
    {
        List<Libro> libros = repositorioLibros.findAll();
        libros.forEach(libro -> System.out.println(libro.getTitulo()));
    }

    private void buscarLibroPorTitulo(String titulo)
    {
        List<Libro> librosPorTitulo = repositorioLibros.findByTituloContaining(titulo);
        librosPorTitulo.forEach(libro -> System.out.println(libro.getTitulo()));
    }
}






