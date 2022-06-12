package desafioalura.setediasdecodigo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafioalura.setediasdecodigo.models.Filme;
import segundodia.FormatarString;
import segundodia.ListaParseia;

@RestController
@RequestMapping
public class Controller {
	

	ListaParseia lista = new ListaParseia();
	
	@GetMapping
	public List<Filme> exibeJson() throws Exception {
		List<Filme> filmes = lista.getTodosOsDados(lista.parseString());	
		return filmes;
	}
	
	@GetMapping(path = "/titulo")
	public String exibeTitulo() throws Exception {
		List<Filme> filmes = lista.getTodosOsDados(lista.parseString());
		List<String> nova = new ArrayList<>();
		for (Filme filme : filmes) {
			nova.add(filme.getTitle());
		}

		return FormatarString.formatarTitulo(nova.toString());
	}
	
	@GetMapping(path = "/imagem")
	public String exibeImagem() throws Exception {
		List<Filme> filmes = lista.getTodosOsDados(lista.parseString());
		List<String> nova = new ArrayList<>();
		for (Filme filme : filmes) {
			nova.add(filme.getImage());
		}
						
		return FormatarString.formatarImagem(nova.toString());
		
	}
}
