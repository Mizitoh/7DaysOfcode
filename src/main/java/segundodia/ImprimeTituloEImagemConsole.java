package segundodia;

import java.util.List;

import  desafioalura.setediasdecodigo.models.Filme;

public class ImprimeTituloEImagemConsole {

	public static void main(String[] args) throws Exception {
		
		ListaParseia lista = new ListaParseia();
		String listagem = lista.carregaListagem();
		
		List<Filme> filmes = lista.getTodosOsDados(listagem);

		filmes.forEach(filme -> System.out.println(filme.toString()));
	}

}
