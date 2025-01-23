<<<<<<< HEAD
package com.desafioalura.Desafio_LiterAlura.repository;

import com.desafioalura.Desafio_LiterAlura.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long>
{
    List<Autor> findByVivo(boolean vivo);
    List<Autor> findByFechaNacimientoBeforeAndFechaFallecimientoAfter(LocalDate fechaNacimiento, LocalDate fechaFallecimiento);


    List<Autor> findByFechaNacimientoBefore(LocalDate inicio);
}
=======
package com.desafioalura.Desafio_LiterAlura.repository;

import com.desafioalura.Desafio_LiterAlura.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long>
{
    List<Autor> findByVivo(boolean vivo);

}
>>>>>>> 918d1a98f4c13e76bb18112723cafcf0183d12ab
