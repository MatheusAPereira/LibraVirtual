package interfaces;

import java.sql.SQLException;
import java.util.List;

import entities.Livro;

public interface ILivroRepository {
	void salvar(Livro livro) throws SQLException;
    Livro buscarPorID(Long id) throws SQLException;
    List<Livro> listarLivros() throws SQLException;
    List<Livro> listarPorGenero(String genero) throws SQLException;
    List<Livro> listarPorGeneroNome(String genero, String[] termos) throws SQLException;
    List<Livro> listarPorNome(String[] termos) throws SQLException;
    void alterar(Livro livro) throws SQLException;
    void excluirPorID(Long id) throws SQLException;
}
