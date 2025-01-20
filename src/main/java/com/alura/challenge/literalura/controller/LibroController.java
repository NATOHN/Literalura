package com.alura.challenge.literalura.controller;

import com.alura.challenge.literalura.model.Libro;
import com.alura.challenge.literalura.service.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // Endpoint para buscar y guardar libros por título
    @GetMapping("/{titulo}")
    public ResponseEntity<String> buscarYGuardarLibros(@PathVariable String titulo) {
        libroService.buscarYGuardarLibros(titulo);
        return ResponseEntity.ok("Búsqueda y almacenamiento completados para: " + titulo);
    }

    // Endpoint para listar todos los libros almacenados
    @GetMapping
    public ResponseEntity<List<Libro>> listarLibros() {
        List<Libro> libros = libroService.listarLibros();
        if (libros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(libros);
    }
}
