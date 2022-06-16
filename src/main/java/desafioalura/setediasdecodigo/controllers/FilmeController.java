package desafioalura.setediasdecodigo.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import desafioalura.setediasdecodigo.models.Filme;
import quintoEsextodia.OpcaoAPI;
import segundodia.FilmesRepository;
import segundodia.ListaConteudos;

@Controller
@RestController
@RequestMapping
public class FilmeController {
	
		
	@GetMapping
	public ModelAndView getList() throws Exception{
		List<Filme> filmes = new ListaConteudos().getTodosOsDados(OpcaoAPI.FILMES_250_URL1.parseString());	
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("listaDeFilmes", filmes);
				
		return mv;
	}
	
	@GetMapping(path = "/teste")
	public ModelAndView teste() throws Exception{
			
		ModelAndView mv = new ModelAndView("teste");
		mv.addObject("nada", null);
				
		return mv;
	}
	
	@PostMapping("/pesquisarank")
	public ModelAndView pesquisarRank(@ModelAttribute("pesquisarank") String rank) throws Exception{
		System.out.println(rank);
		List<Filme> filmes = new ListaConteudos().getTodosOsDados(OpcaoAPI.FILMES_250_URL2.parseString());
		List<Filme> filme = FilmesRepository.captaPorRank(filmes, rank);
		ModelAndView mv = new ModelAndView("pesquisa");
		mv.addObject("filmes", filme);
		
		return mv;
	}
	
	@PostMapping("/pesquisatitulo")
	public ModelAndView pesquisarTitulo(@ModelAttribute("pesquisatitulo") String titulo) throws Exception{
		System.out.println(titulo);
		List<Filme> filmes = new ListaConteudos().getTodosOsDados(OpcaoAPI.FILMES_250_URL1.parseString());
		List<Filme> filme = FilmesRepository.captaPorTitulo(filmes, titulo);
		ModelAndView mv = new ModelAndView("pesquisa");
		mv.addObject("filmes", filme);
		
		return mv;
	}
		
	@RequestMapping(method = RequestMethod.GET, value = "/arquivo2")
	public ModelAndView getArquivo() throws Exception{
		List<Filme> filmes = new ListaConteudos().getTodosOsDados(OpcaoAPI.FILMES_250_URL2.parseString());	
		Collections.sort(filmes, Comparator.reverseOrder());
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("listaDeFilmes", filmes);
				
		return mv;
	}
	
	@PostMapping("/")
	public String index() {
			return "index";
		}
		
	@GetMapping(path = "/titulo")
	public String exibeTitulo(Model model) throws Exception {
		List<Filme> filmes = new ListaConteudos().getTodosOsDados(OpcaoAPI.FILMES_250_URL2.parseString());
		List<String> nova = new ArrayList<>();
		for (Filme filme : filmes) {
			nova.add(filme.getTitle());
		}
		return FilmesRepository.formatarTitulo(nova.toString());
	}
	
	@GetMapping(path = "/imagem")
	public String exibeImagem() throws Exception {
		List<Filme> filmes = new ListaConteudos().getTodosOsDados(OpcaoAPI.FILMES_250_URL1.parseString());
		List<String> nova = new ArrayList<>();
		for (Filme filme : filmes) {
			nova.add(filme.getImage());
		}
						
		return FilmesRepository.formatarImagem(nova.toString());
		
	}
}
