package com.alura.challenge.literalura;

import com.alura.challenge.literalura.service.LibroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class LiteraluraApplication implements CommandLineRunner {
	private final LibroService libroService;

	public LiteraluraApplication(LibroService libroService) {
		this.libroService = libroService;
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("\n🔎 Ingrese el título del libro a buscar (o 'salir' para terminar): ");
			String titulo = scanner.nextLine();

			if (titulo.equalsIgnoreCase("salir")) {
				System.out.println("👋 Saliendo del programa...");
				break;
			}

			libroService.buscarYGuardarLibros(titulo);
		}

		scanner.close();
	}
}
