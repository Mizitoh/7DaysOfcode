package segundodia;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class CaptaJsonAPI {
	
	public String captaJson() throws Exception {

		FileInputStream url = new FileInputStream("url.txt");
		InputStreamReader converte = new InputStreamReader(url);
		@SuppressWarnings("resource")
		BufferedReader armazena = new BufferedReader(converte);

		String linha = armazena.readLine();

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(linha)).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		response.body();

		return response.body();
	}
}
