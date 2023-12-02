package service;

import java.sql.SQLException;
import java.util.Optional;

import entities.Moderador;
import repository.ModRepository;

public class ModService {
	
	private ModRepository modRepository;

	public ModService() {
		this.modRepository = new ModRepository();
	}
	
	public void salvarUsuario(Moderador mod) throws Exception, SQLException {
		modRepository.salvar(mod);
	}

	public Optional<Moderador> buscarPorEmailSenha(String email, String senha) throws Exception, SQLException {
		return modRepository.buscarPorEmailSenha(email, senha);
	}
	
	
}
