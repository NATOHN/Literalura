package com.alura.challenge.literalura.repositorio;

import com.alura.challenge.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibroRepositorio extends JpaRepository<Libro, Long> {
    Optional<Libro> findByTitulo(String titulo);
}
