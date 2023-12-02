package service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;

import entities.Livro;
import repository.LivroRepository;

public class LivroService {

	private LivroRepository livroRepository;

	public LivroService() {
		this.livroRepository = new LivroRepository();
	}
	
	public void Salvar(Livro livro) throws SQLException {
		livroRepository.salvar(livro);
	}
	
	public Livro buscarPorId(Long id) throws SQLException{
		return livroRepository.buscarPorID(id);
	}
	
	public List<Livro> listarLivros() throws SQLException{
		return livroRepository.listarLivros();
	}
	
	public List<Livro> listarLivrosPorGenero(String genero) throws SQLException{
		return livroRepository.listarPorGenero(genero);
	}
	
	public List<Livro> listarLivrosPorGeneroNome(String genero, String pesquisa) throws SQLException{
		String palavras[] = pesquisa.split(" ");
//		List<String> palavras_sem_artigos = Arrays.stream(palavras)
//                .filter(palavra -> !palavra.equalsIgnoreCase("o") && !palavra.equalsIgnoreCase("a") && !palavra.equalsIgnoreCase("os") && !palavra.equalsIgnoreCase("as"))
//                .collect(Collectors.toList());
//		for (String palavra : palavras_sem_artigos) {
//			
//		}
		return livroRepository.listarPorGeneroNome(genero, palavras);
	}
	
	public List<Livro> listarLivrosPorNome(String pesquisa) throws SQLException{
		String palavras[] = pesquisa.split(" ");
//		List<String> palavras_sem_artigos = Arrays.stream(palavras)
//                .filter(palavra -> !palavra.equalsIgnoreCase("o") && !palavra.equalsIgnoreCase("a") && !palavra.equalsIgnoreCase("os") && !palavra.equalsIgnoreCase("as"))
//                .collect(Collectors.toList());
//		for (String palavra : palavras_sem_artigos) {
//			
//		}
		return livroRepository.listarPorNome(palavras);
	}
}
