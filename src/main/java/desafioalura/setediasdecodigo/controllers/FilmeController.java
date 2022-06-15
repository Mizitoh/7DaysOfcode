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
import quintoEsextodia.OpcaoAPI;
import segundodia.FormatarString;
import segundodia.ListaFilmes;

@Controller
@RestController
@RequestMapping
public class FilmeController {
	
	@GetMapping
	public ModelAndView getList() throws Exception{
		List<Filme> filmes = new ListaFilmes().getTodosOsDados(OpcaoAPI.FILMES_250_URL1.parseString());	
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("listaDeFilmes", filmes);
				
		return mv;
	}
	
	@GetMapping(path = "/arquivo2")
	public ModelAndView getArquivo() throws Exception{
		List<Filme> filmes = new ListaFilmes().getTodosOsDados(OpcaoAPI.FILMES_250_URL2.parseString());	
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("listaDeFilmes", filmes);
				
		return mv;
	}
		
	@GetMapping(path = "/titulo")
	public String exibeTitulo(Model model) throws Exception {
		List<Filme> filmes = new ListaFilmes().getTodosOsDados(OpcaoAPI.FILMES_250_URL2.parseString());
		List<String> nova = new ArrayList<>();
		for (Filme filme : filmes) {
			nova.add(filme.getTitle());
		}

		return FormatarString.formatarTitulo(nova.toString());
	}
	
	@GetMapping(path = "/imagem")
	public String exibeImagem() throws Exception {
		List<Filme> filmes = new ListaFilmes().getTodosOsDados(OpcaoAPI.FILMES_250_URL1.parseString());
		List<String> nova = new ArrayList<>();
		for (Filme filme : filmes) {
			nova.add(filme.getImage());
		}
						
		return FormatarString.formatarImagem(nova.toString());
		
	}
}
