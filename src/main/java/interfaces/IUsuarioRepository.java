package interfaces;

import java.sql.SQLException;
import java.util.Optional;

import entities.Usuario;

public interface IUsuarioRepository {
	void salvar(Usuario usuario) throws SQLException;
    Optional<Usuario> buscarPorEmailSenha(String email, String senha) throws SQLException;
    Optional<Usuario> buscarPorID(Long id) throws SQLException;
    void alterar(Usuario usuario) throws SQLException;
    void excluirPorId(Long id) throws SQLException;
}
