package segundodia;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class CaptaJsonAPI {
	
	private String linha;

	public CaptaJsonAPI(String linha) {
		this.linha = linha;
	}

	public String getLinha() {
		return linha;
	}

		public String getBody() {
			try {
				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(getLinha())).GET().build();
				HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
				response.body();

				return response.body();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Erro ao captar Json do IMDB" + e);
				return null;
			}
	}
}
