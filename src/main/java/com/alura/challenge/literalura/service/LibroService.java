package com.alura.challenge.literalura.service;

import com.alura.challenge.literalura.dto.LibroDTO;
import com.alura.challenge.literalura.model.Libro;
import com.alura.challenge.literalura.repositorio.LibroRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {
    private final GutendexService gutendexService;
    private final LibroRepositorio libroRepository;

    public LibroService(GutendexService gutendexService, LibroRepositorio libroRepository) {
        this.gutendexService = gutendexService;
        this.libroRepository = libroRepository;
    }

    public void buscarYGuardarLibros(String titulo) {
        // Buscar libros en la API de Gutendex
        List<LibroDTO> librosEncontrados = gutendexService.buscarLibros(titulo);

        if (librosEncontrados.isEmpty()) {
            System.out.println("❌ No se encontraron libros con el título: " + titulo);
            return;
        }

        // Filtrar libros que ya están en la base de datos
        List<Libro> librosNuevos = librosEncontrados.stream()
                .filter(dto -> !libroRepository.existsByTitulo(dto.getTitulo())) // Evitar duplicados
                .map(dto -> new Libro(
                        null,
                        dto.getTitulo(),
                        dto.getCantidadDescargas(),
                        dto.getIdiomas(),
                        dto.getAutores().stream()
                                .map(autor -> autor.getNombre())
                                .collect(Collectors.toList()),
                        dto.getLinkDescarga()
                ))
                .collect(Collectors.toList());

        if (librosNuevos.isEmpty()) {
            System.out.println("✅ Todos los libros ya están guardados en la base de datos.");
        } else {
            // Guardar los nuevos libros en la base de datos
            libroRepository.saveAll(librosNuevos);
            System.out.println("📚 Se han añadido nuevos libros a la base de datos.");
        }
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }
}
