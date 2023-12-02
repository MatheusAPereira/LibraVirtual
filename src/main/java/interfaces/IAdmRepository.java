package interfaces;

import java.sql.SQLException;
//import java.util.List;
import java.util.Optional;

import entities.Adm;

public interface IAdmRepository {
	void salvar(Adm adm) throws SQLException;
    Optional<Adm> buscarPorEmailSenha(String email, String senha) throws SQLException;
}
