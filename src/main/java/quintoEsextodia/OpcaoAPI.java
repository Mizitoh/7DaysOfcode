package quintoEsextodia;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import segundodia.CaptaJsonAPI;

public enum OpcaoAPI {

	FILMES_250_URL1 {
		@Override
		public String parseString() {
			try {
				url = new FileInputStream("url.txt");
			InputStreamReader converte = new InputStreamReader(url);
			BufferedReader armazena = new BufferedReader(converte);
			String linha = armazena.readLine();
			String string = new CaptaJsonAPI(linha).getBody();
			return string;
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	},
	FILMES_250_URL2 {
		@Override
		public String parseString() {
			try {
				url = new FileInputStream("url2.txt");
			InputStreamReader converte = new InputStreamReader(url);
			BufferedReader armazena = new BufferedReader(converte);
			String linha = armazena.readLine();
			String string = new CaptaJsonAPI(linha).getBody();
			return string;
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	};

	public abstract String parseString();
	public FileInputStream url = null;
}
