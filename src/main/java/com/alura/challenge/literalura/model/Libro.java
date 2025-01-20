package com.alura.challenge.literalura.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255) // Limitar longitud de títulos
    private String titulo;

    @Column(nullable = false, length = 50) // Limitar longitud de idiomas
    private String idioma;

    @Column(nullable = false)
    private Integer numeroDescargas;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "libro_autores", joinColumns = @JoinColumn(name = "libro_id"))
    @Column(name = "autor", length = 255)
    private List<String> autores;


    @Column(name = "link_descarga", length = 2048) // Aumentar la longitud permitida
    private String linkDescarga;


    // Constructor vacío
    public Libro() {
    }

    // Constructor completo
    public Libro(Long id, String titulo, Integer numeroDescargas, List<String> idiomas, List<String> autores, String linkDescarga) {
        this.id = id;
        this.titulo = titulo;
        this.numeroDescargas = numeroDescargas;
        this.autores = autores;
        this.idioma = (idiomas == null || idiomas.isEmpty()) ? "No disponible" : idiomas.get(0);
        this.linkDescarga = linkDescarga;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Integer numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public String getLinkDescarga() {
        return linkDescarga;
    }

    public void setLinkDescarga(String linkDescarga) {
        this.linkDescarga = linkDescarga;
    }
}
