package com.company.Tool;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class HTTPTools {
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public static void post(String adress, String data) throws IOException {
        System.out.println("Données envoyées :");
        System.out.println(data);
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .uri(URI.create("https://cpefiresimulation.azurewebsites.net/send"))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Message retour :");
            System.out.println(response.body());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}