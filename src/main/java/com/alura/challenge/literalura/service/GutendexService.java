package com.alura.challenge.literalura.service;

import com.alura.challenge.literalura.dto.LibroDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class GutendexService {
    private static final String BASE_URL = "https://gutendex.com/books/";
    private final HttpClient client;
    private final ObjectMapper objectMapper;

    public GutendexService() {
        this.client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public List<LibroDTO> buscarLibros(String titulo) {
        String url = BASE_URL + "?search=" + titulo.replace(" ", "%20");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return convertirJsonALista(response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al conectar con Gutendex API", e);
        }
    }

    private List<LibroDTO> convertirJsonALista(String json) {
        try {
            JsonNode rootNode = objectMapper.readTree(json);
            JsonNode resultsNode = rootNode.get("results");

            if (resultsNode == null || !resultsNode.isArray()) {
                return new ArrayList<>();
            }

            List<LibroDTO> libros = new ArrayList<>();
            for (JsonNode libroNode : resultsNode) {
                LibroDTO libro = objectMapper.treeToValue(libroNode, LibroDTO.class);
                libros.add(libro);
            }
            return libros;
        } catch (IOException e) {
            throw new RuntimeException("Error al convertir JSON a objetos Java", e);
        }
    }
}
