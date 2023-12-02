package interfaces;

import java.sql.SQLException;

import entities.Avaliacao;

public interface IAvaliacaoRepositorio {
	void salvar(Avaliacao avaliacao) throws SQLException;
	Avaliacao buscarPorLivroUsuario(Long idLivro, Long idUsuario) throws SQLException;
}
