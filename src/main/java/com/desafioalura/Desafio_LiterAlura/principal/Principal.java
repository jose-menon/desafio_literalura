<<<<<<< HEAD
package com.desafioalura.Desafio_LiterAlura.principal;

import com.desafioalura.Desafio_LiterAlura.entity.Autor;
import com.desafioalura.Desafio_LiterAlura.entity.Libro;
import com.desafioalura.Desafio_LiterAlura.model.Datos;
import com.desafioalura.Desafio_LiterAlura.model.DatosLibros;
import com.desafioalura.Desafio_LiterAlura.repository.AutorRepository;
import com.desafioalura.Desafio_LiterAlura.repository.LibrosRepository;
import com.desafioalura.Desafio_LiterAlura.service.ConsumoAPI;
import com.desafioalura.Desafio_LiterAlura.service.ConvierteDatos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal
{
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibrosRepository repositorioLibros;
    private AutorRepository autorRepositorio;
    private ConsumoAPI consumoAPI;
    private List<Libro> libros;
    private List<Autor> autor;
    Scanner teclado = new Scanner(System.in);

    public Principal(LibrosRepository repositorio, AutorRepository autorRepositorio, ConsumoAPI consumo)
    {
        this.repositorioLibros = repositorio;
        this.autorRepositorio = autorRepositorio;
        this.consumoAPI = consumo;
    }
    public void mostrarMenu()
    {
        var opcion = -1;
        while (opcion != 0)
        {
            var menu = """
                    1. Buscar libro por título
                    2. Listar libros registrados
                    3. Listar autores registrados
                    4. Listar autores vivos en un año específico
                    5. Listar libros por idioma
                    0. Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion)
            {
                case 1:
                    buscarLibroPorTitulo();
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
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    private String getTituloLibro()
    {
        System.out.println("ingrese el nombre del libro que desea buscar: ");
        var tituloLibro = teclado.nextLine();
        return tituloLibro;
    }
    private Datos getDatosLibro()
    {
        getTituloLibro();
        var json = consumo.obtenerDatos(URL_BASE + "?search=" + getTituloLibro().replace(" ", "+"));
        System.out.println(json);
        Datos datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        return datosBusqueda;
    }
    private void listarLibrosPorIdioma(String idioma)
    {
        List<Libro> librosPorIdioma = repositorioLibros.findByIdioma(idioma);
        librosPorIdioma.forEach(libro -> System.out.println(libro.getTitulo()));
    }

    private void listarAutoresVivos(int año) {
        LocalDate inicio = LocalDate.of(año, 1, 1);
        LocalDate fin = LocalDate.of(año, 12, 31);

        // Obtener la lista de autores que nacieron antes del inicio del año
        autor = autorRepositorio.findByFechaNacimientoBefore(inicio);
        List<Autor> autoresVivos = new ArrayList<>();

        // Filtrar autores vivos
        for (Autor a : autor) {
            if (a.getFechaFallecimiento() == null || a.getFechaFallecimiento().isAfter(fin)) {
                autoresVivos.add(a);
            }
        }

        // Imprimir los nombres de los autores vivos
        for (Autor autor : autoresVivos) {
            System.out.println(autor.getNombre());
        }
    }

    private void listarAutoresRegistrados()
    {
        autor = autorRepositorio.findAll();
        autor.forEach(autor -> System.out.println(autor.getNombre()));
    }

    private void listarLibrosRegistrados()
    {
        libros = repositorioLibros.findAll();
        libros.forEach(libro -> System.out.println(libro.getTitulo()));
    }

    private void buscarLibroPorTitulo()
    {
        Datos datos = getDatosLibro();
        Optional<DatosLibros> librosBuscados = datos.libros().stream()
                .filter(l -> l.titulo().toUpperCase().contains(getTituloLibro().toUpperCase()))
                .findFirst();

        if(librosBuscados.isPresent())
        {
            DatosLibros datosLibros = librosBuscados.get();
            System.out.println("Libro encontrado: " + datosLibros);
            Libro libro = new Libro(datosLibros);
            repositorioLibros.save(libro);
        }
    }
}






=======
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






>>>>>>> 918d1a98f4c13e76bb18112723cafcf0183d12ab
