package com.alura.challenge.literalura.service;

import com.alura.challenge.literalura.dto.LibroDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class GutendexService {
    private static final String BASE_URL = "https://gutendex.com/books/";
    private final HttpClient client;

    public GutendexService() {
        this.client = HttpClient.newHttpClient();
    }

    public List<LibroDTO> buscarLibros(String titulo) {
        String url = BASE_URL + "?search=" + titulo.replace(" ", "%20");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("🔍 JSON recibido: " + response.body()); // Log para depuración
            return convertirJsonALista(response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al conectar con Gutendex API", e);
        }
    }

    private List<LibroDTO> convertirJsonALista(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Leer el JSON completo
            JsonNode root = objectMapper.readTree(json);
            // Extraer el nodo "results"
            JsonNode results = root.get("results");
            // Convertir "results" en una lista de objetos LibroDTO
            return objectMapper.readerForListOf(LibroDTO.class).readValue(results);
        } catch (IOException e) {
            throw new RuntimeException("Error al procesar el JSON", e);
        }
    }
}
