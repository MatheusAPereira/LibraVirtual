package service;

import java.sql.SQLException;

import entities.Avaliacao;
import repository.AvaliacaoRepository;

public class AvaliacaoService {
	
	private AvaliacaoRepository repository;
	
	public AvaliacaoService() {
		repository  = new AvaliacaoRepository();
	}
	
	public void salvar(Avaliacao avaliacao) throws SQLException {
		repository.salvar(avaliacao);
	}
	
	public Avaliacao buscarPorLivroUsuario(Long idLivro, Long idUsuario) throws SQLException {
		return repository.buscarPorLivroUsuario(idLivro, idUsuario);
	}
}
