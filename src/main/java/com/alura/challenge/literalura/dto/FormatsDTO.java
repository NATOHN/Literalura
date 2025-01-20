package com.alura.challenge.literalura.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FormatsDTO {
    @JsonProperty("text/html")
    private String enlaceHtml;

    // Otros formatos pueden ser añadidos aquí si son necesarios

    public String getEnlaceHtml() {
        return enlaceHtml;
    }

    public void setEnlaceHtml(String enlaceHtml) {
        this.enlaceHtml = enlaceHtml;
    }

    public String getEpub() {
        return "";
    }

    public String getHtml() {
        return "";
    }

    public String getTxt() {
        return "";
    }
}
