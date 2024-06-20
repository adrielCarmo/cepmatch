package controller;

import com.google.gson.Gson;
import model.EnderecoViaCEP;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaEnderecoCEP {
    public EnderecoViaCEP buscaEnderecoCEP(String cep) throws IOException, InterruptedException {
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpRequest req = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(req, HttpResponse.BodyHandlers.ofString());

        return new Gson ().fromJson(response.body(), EnderecoViaCEP.class);
    }
}
