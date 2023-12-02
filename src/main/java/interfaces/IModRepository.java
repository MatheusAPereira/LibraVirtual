package interfaces;

import java.sql.SQLException;
//import java.util.List;
import java.util.Optional;

import entities.Moderador;


public interface IModRepository {
	void salvar(Moderador mod) throws SQLException;
    Optional<Moderador> buscarPorEmailSenha(String email, String senha) throws SQLException;
}
