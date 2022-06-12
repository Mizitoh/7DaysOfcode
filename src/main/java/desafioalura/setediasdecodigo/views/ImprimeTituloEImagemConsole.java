package desafioalura.setediasdecodigo.views;

import java.util.List;

import  desafioalura.setediasdecodigo.models.Filme;
import segundodia.ListaParseia;

public class ImprimeTituloEImagemConsole {

	public static void main(String[] args) throws Exception {
		
		ListaParseia lista = new ListaParseia();
		String listagem = lista.parseString();
		
		List<Filme> filmes = lista.getTodosOsDados(listagem);

		filmes.forEach(filme -> System.out.println(filme.toString()));
	}

}
