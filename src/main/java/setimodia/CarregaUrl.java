package setimodia;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import segundodia.CaptaJsonAPI;

public class CarregaUrl {
	
	private int posicaoLinha = 0;
	
	public CarregaUrl(int posicaoLinha) {
		this.posicaoLinha = posicaoLinha;
	}

	public int getPosicaoLinha() {
		return posicaoLinha;
	}

	public String parseString() {	
		List<String> linhaUrl = new ArrayList<>();
		String linha;
		try {
		FileInputStream ler = new FileInputStream("url.txt");
		InputStreamReader converte = new InputStreamReader(ler);
		BufferedReader armazena = new BufferedReader(converte);
		linha = armazena.readLine();
		while (linha != null && !linha.isEmpty()) {
			linhaUrl.add(linha);
			linha = armazena.readLine();
		}
		String url = linhaUrl.get(getPosicaoLinha());
		String string = new CaptaJsonAPI(url).getBody();
		armazena.close();
		return string;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
