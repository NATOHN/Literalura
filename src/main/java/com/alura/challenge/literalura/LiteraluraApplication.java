package com.alura.challenge.literalura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.alura.challenge.literalura.model.Libro;
import com.alura.challenge.literalura.repositorio.LibroRepositorio;
import com.alura.challenge.literalura.service.LibroService;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication {
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}
}

@Component
class ConsolaApp implements CommandLineRunner {
	private final LibroService libroService;
	private final LibroRepositorio libroRepository;

	public ConsolaApp(LibroService libroService, LibroRepositorio libroRepository) {
		this.libroService = libroService;
		this.libroRepository = libroRepository;
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n📚 Bienvenido a Literalura - Catálogo de Libros 📚");

		while (true) {
			System.out.println("\nOpciones disponibles:");
			System.out.println("1. Buscar y guardar un libro por título");
			System.out.println("2. Listar todos los libros");
			System.out.println("3. Salir");

			System.out.print("\nIngrese una opción: ");
			String opcion = scanner.nextLine();

			switch (opcion) {
				case "1" -> buscarYGuardarLibro(scanner);
				case "2" -> listarLibros();
				case "3" -> {
					System.out.println("👋 Saliendo del programa...");
					scanner.close();
					System.exit(0);
					return;
				}
				default -> System.out.println("❌ Opción no válida. Intente nuevamente.");
			}
		}
	}

	private void buscarYGuardarLibro(Scanner scanner) {
		System.out.print("\n🔎 Ingrese el título del libro a buscar: ");
		String titulo = scanner.nextLine();
		libroService.buscarYGuardarLibros(titulo);
	}

	private void listarLibros() {
		List<Libro> libros = libroRepository.findAll();
		if (libros.isEmpty()) {
			System.out.println("❌ No hay libros guardados en la base de datos.");
		} else {
			System.out.println("\n📚 Lista de libros en la base de datos:");
			for (Libro libro : libros) {
				System.out.println("----------------------------------------");
				System.out.println("📖 Título: " + libro.getTitulo());
				System.out.println("🌍 Idioma: " + libro.getIdioma());
				System.out.println("👨‍💼 Autor(es): " + String.join(", ", libro.getAutores()));
				System.out.println("🔗 Link de descarga: " + libro.getLinkDescarga());
				System.out.println("⬇️ Descargas: " + libro.getNumeroDescargas());
			}
		}
	}
}
