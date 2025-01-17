package com.alura.challenge.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorDTO {

    @JsonProperty("name")
    private String nombre;

    @JsonProperty("birth_year")
    private Integer anioNacimiento;

    @JsonProperty("death_year")
    private Integer anioMuerte;

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(Integer anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public Integer getAnioMuerte() {
        return anioMuerte;
    }

    public void setAnioMuerte(Integer anioMuerte) {
        this.anioMuerte = anioMuerte;
    }

    @Override
    public String toString() {
        return "AutorDTO{" +
                "nombre='" + nombre + '\'' +
                ", anioNacimiento=" + anioNacimiento +
                ", anioMuerte=" + anioMuerte +
                '}';
    }
}
