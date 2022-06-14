package desafioalura.setediasdecodigo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import desafioalura.setediasdecodigo.models.Filme;
import segundodia.CaptaJsonAPI;
import segundodia.FormatarString;
import segundodia.ListaParseia;

@Controller
@RestController
@RequestMapping
public class FilmeController {
	

	ListaParseia lista = new ListaParseia();
	
	@GetMapping
	public ModelAndView getList() throws Exception{
		List<Filme> filmes = lista.getTodosOsDados(lista.parseString());	
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("listaDeFilmes", filmes);
				
		return mv;
	}
	
	@GetMapping(path = "/json")
	public List<Filme> exibeJson() throws Exception {
		List<Filme> filmes = lista.getTodosOsDados(lista.parseString());	
		return filmes;
	}
	
	@GetMapping(path = "/titulo")
	public String exibeTitulo(Model model) throws Exception {
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
