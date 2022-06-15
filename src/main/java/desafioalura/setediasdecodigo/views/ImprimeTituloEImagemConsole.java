package desafioalura.setediasdecodigo.views;

import java.util.List;

import  desafioalura.setediasdecodigo.models.Filme;
import quintoEsextodia.OpcaoAPI;
import segundodia.ListaFilmes;

public class ImprimeTituloEImagemConsole {

	public static void main(String[] args) throws Exception {
		
		List<Filme> filmes = new ListaFilmes().getTodosOsDados(OpcaoAPI.FILMES_250_URL1.parseString());

		filmes.forEach(filme -> System.out.println(filme.toString()));
	}

}
