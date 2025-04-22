package br.com.DesafioComApi.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaOmdb {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Inicializa o scanner
        Scanner scanner = new Scanner(System.in);
        String busca = "";
        String apiKey = "";
        List<Titulo> titulos = new ArrayList<>();

        // Cria uma instância do Gson para manipulação de JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //Solicita a API Key
        System.out.println("Digite sua API Key do OMDb:");
        apiKey = scanner.nextLine();

        //Loop para busca do filme, até que o usuário digite "sair"
        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite um filme para busca (ou 'sair' para encerrar):");
            busca = scanner.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            //Url da requisição para a API OMDB
            String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=" + apiKey;

            try {
                //Cria um cliente HTTP e faz a requisição
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                //Obtém a resposta JSON da API
                String json = response.body();
                System.out.println(json);

                //Cria o objeto título a partir de TituloOmdb
                TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(tituloOmdb);

                Titulo titulo = new Titulo(
                        tituloOmdb.Title(),
                        tituloOmdb.Year(),
                        tituloOmdb.Runtime(),
                        tituloOmdb.Genre(),
                        tituloOmdb.Director(),
                        tituloOmdb.Plot()
                );
                System.out.println("Título convertido");
                System.out.println(titulo);

                //adiciona o objeto a lista
                titulos.add(titulo);
            } catch (Exception e) {
                //Trata exceções e imprime uma mensagem de erro
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }

        //Usando try-with-resources para garantir que o FileWriter seja fechado corretamente
        try (FileWriter escrita = new FileWriter("Filmes.json")) {
            escrita.write(gson.toJson(titulos));
            System.out.println("O programa finalizou corretamente!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
        }

        scanner.close();
    }
}