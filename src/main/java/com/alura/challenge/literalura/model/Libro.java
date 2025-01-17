package com.alura.challenge.literalura.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private int anioPublicacion;

    @ElementCollection
    private List<String> idiomas;

    @ElementCollection
    private List<String> autores;

    private String linkDescarga;
}
