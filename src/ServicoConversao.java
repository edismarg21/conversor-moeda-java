import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicoConversao {

    private static final String API_KEY = "SUA_CHAVE_AQUI";

    public double converter(String base, String destino, double valor) throws Exception {

        String endereco =  "https://v6.exchangerate-api.com/v6/bd876b1c84c572cd1e56e9d2/latest/" + base;


        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        RespostaAPI resposta =
                gson.fromJson(response.body(), RespostaAPI.class);

        if (resposta == null || resposta.getConversion_rates() == null) {
            throw new RuntimeException("Erro ao obter dados da API.");
        }

        Double taxaBase = resposta.getConversion_rates().get(base);
        Double taxaDestino = resposta.getConversion_rates().get(destino);

        if (taxaBase == null || taxaDestino == null) {
            throw new RuntimeException("Moeda não encontrada na API.");
        }

        double valorEmUSD = valor / taxaBase;

        return valorEmUSD * taxaDestino;
    }
}