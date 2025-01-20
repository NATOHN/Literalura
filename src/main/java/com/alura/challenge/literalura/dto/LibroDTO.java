package com.alura.challenge.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LibroDTO {
    @JsonProperty("title")
    private String titulo;

    @JsonProperty("languages")
    private List<String> idiomas;

    @JsonProperty("download_count")
    private int cantidadDescargas;

    @JsonProperty("authors")
    private List<AutorDTO> autores;

    @JsonProperty("formats")
    private FormatsDTO formatos;

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public List<AutorDTO> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorDTO> autores) {
        this.autores = autores;
    }

    public FormatsDTO getFormatos() {
        return formatos;
    }

    public void setFormatos(FormatsDTO formatos) {
        this.formatos = formatos;
    }

    /**
     * Devuelve el enlace de descarga si existe en los formatos.
     * Prioriza el formato EPUB.
     */
    public String getLinkDescarga() {
        if (formatos == null) return "No disponible";

        if (formatos.getEpub() != null) {
            return formatos.getEpub();
        } else if (formatos.getHtml() != null) {
            return formatos.getHtml();
        } else if (formatos.getTxt() != null) {
            return formatos.getTxt();
        } else {
            return "No disponible";
        }
    }
}
