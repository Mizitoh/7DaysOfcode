package segundodia;

import java.util.List;
import java.util.stream.Collectors;

import desafioalura.setediasdecodigo.models.Filme;

public class FilmesRepository {


	public static String formatarImagem(String string) {
		int ultimo = string.length() - 1;
		String formatacao = string.substring(1, ultimo);
		String[] formatados = formatacao.split(".jpg,");
		String retorno = "";
		for (int i = 0; i < formatados.length; i++) {
			retorno += formatados[i] + ".jpg" + "<br><br>";
		}
		return retorno;
	}

	public static String formatarTitulo(String string) {
		int ultimo = string.length() - 1;
		String formatacao = string.substring(1, ultimo);
		String[] formatados = formatacao.split(",");
		String retorno = "";
		for (int i = 0; i < formatados.length; i++) {
			retorno += formatados[i] + "<br><br>";
		}
		return retorno;
	}
	
	public static List<Filme> captaPorRank(List<Filme> filme, String rank) {
		filme = filme.stream().filter(f -> f.getRank().equals(rank)).collect(Collectors.toList());
		return filme;
	}

	public static List<Filme> captaPorTitulo(List<Filme> filmes, String titulo) {
		filmes = filmes.stream().filter(f -> f.getTitle().contains(titulo)).collect(Collectors.toList());
		filmes.forEach(f->System.out.println(f.getTitle()));
		return filmes;
	}

}
