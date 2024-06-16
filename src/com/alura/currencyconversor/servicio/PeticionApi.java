package com.alura.currencyconversor.servicio;

import com.alura.currencyconversor.modelo.ApiRequest;
import com.alura.currencyconversor.modelo.ApiResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class PeticionApi {

    public ApiResponse apiResponse(ApiRequest apiRequest) {
        ApiResponse responseEmpty = new ApiResponse();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String urlRequest = defineUrl(apiRequest.getOrigen(), apiRequest.getDestino(), apiRequest.getValor());
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlRequest))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();


            return gson.fromJson(json, ApiResponse.class);

        } catch (IOException | InterruptedException e) {
            System.err.printf("Error : %s%n", e);
            return responseEmpty;
        }
    }

    private String defineUrl(String origen, String destino, long valor) {
        String urlBase = "https://v6.exchangerate-api.com/v6/";
        String apiKey = "7aec5287fa2e90af38f72b2c";
        return String.format(
                "%s%s/pair/%s/%s/%s",
                urlBase,
                apiKey,
                URLEncoder.encode(origen, StandardCharsets.UTF_8),
                URLEncoder.encode(destino, StandardCharsets.UTF_8),
                URLEncoder.encode(String.valueOf(valor),StandardCharsets.UTF_8)
        );
    }
}
