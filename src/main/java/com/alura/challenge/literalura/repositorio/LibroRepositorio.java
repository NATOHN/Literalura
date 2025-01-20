package com.alura.challenge.literalura.repositorio;

import com.alura.challenge.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {

    // Buscar libro por título exacto
    Optional<Libro> findByTitulo(String titulo);

    // Verificar existencia por título exacto
    boolean existsByTitulo(String titulo);

    // Buscar libros cuyo título contiene un patrón (búsqueda parcial)
    List<Libro> findByTituloContainingIgnoreCase(String titulo);
}
