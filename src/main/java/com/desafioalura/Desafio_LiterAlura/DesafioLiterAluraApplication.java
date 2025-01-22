package com.desafioalura.Desafio_LiterAlura;

import com.desafioalura.Desafio_LiterAlura.principal.Principal;
import com.desafioalura.Desafio_LiterAlura.repository.AutorRepository;
import com.desafioalura.Desafio_LiterAlura.repository.LibrosRepository;
import com.desafioalura.Desafio_LiterAlura.service.ConsumoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioLiterAluraApplication implements CommandLineRunner
{
	@Autowired
	LibrosRepository repositorio;

	@Autowired
	AutorRepository autorRepositorio;

	@Autowired
	ConsumoAPI consumoAPI;

	public static void main(String[] args)
	{
		SpringApplication.run(DesafioLiterAluraApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception
	{
		Principal principal = new Principal(repositorio, autorRepositorio, consumoAPI);
		principal.mostrarMenu();
	}
}
