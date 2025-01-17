package com.alura.challenge.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LibroDTO {

    @JsonProperty("title")
    private String titulo;

    @JsonProperty("authors")
    private List<AutorDTO> autores;

    @JsonProperty("languages")
    private List<String> idiomas;

    @JsonProperty("download_count")
    private int cantidadDescargas;

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<AutorDTO> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorDTO> autores) {
        this.autores = autores;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public int getCantidadDescargas() {
        return cantidadDescargas;
    }

    public void setCantidadDescargas(int cantidadDescargas) {
        this.cantidadDescargas = cantidadDescargas;
    }

    @Override
    public String toString() {
        return "LibroDTO{" +
                "titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", idiomas=" + idiomas +
                ", cantidadDescargas=" + cantidadDescargas +
                '}';
    }
}
