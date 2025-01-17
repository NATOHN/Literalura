package com.alura.challenge.literalura.service;

import com.alura.challenge.literalura.dto.LibroDTO;
import com.alura.challenge.literalura.model.Libro;
import com.alura.challenge.literalura.repositorio.LibroRepositorio;
import com.alura.challenge.literalura.repositorio.LibroRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        Optional<Libro> libroExistente = libroRepository.findByTitulo(titulo);

        if (libroExistente.isPresent()) {
            System.out.println("\n✅ El libro ya existe en la base de datos: " + titulo);
            return;
        }

        List<LibroDTO> librosEncontrados = gutendexService.buscarLibros(titulo);

        if (librosEncontrados.isEmpty()) {
            System.out.println("❌ No se encontraron libros con el título: " + titulo);
            return;
        }

        List<Libro> libros = librosEncontrados.stream()
                .map(dto -> new Libro(null, dto.getTitulo(), dto.getAnioPublicacion(),
                        dto.getIdiomas(), dto.getAutores(), dto.getLinkDescarga()))
                .collect(Collectors.toList());

        libroRepository.saveAll(libros);
        System.out.println("📚 Libros guardados en la base de datos.");
    }
}
