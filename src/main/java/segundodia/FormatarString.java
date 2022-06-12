package segundodia;

public class FormatarString {


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

}
