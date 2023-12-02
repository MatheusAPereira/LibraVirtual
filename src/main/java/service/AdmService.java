package service;

import java.sql.SQLException;
import java.util.Optional;

import entities.Adm;
import entities.Usuario;
import repository.AdmRepository;
import repository.UsuarioRepository;

public class AdmService {
	
	private AdmRepository admRepository;

	public AdmService() {
		this.admRepository = new AdmRepository();
	}
	
	public void salvarUsuario(Adm adm) throws Exception, SQLException {
		admRepository.salvar(adm);
	}

	public Optional<Adm> buscarPorEmailSenha(String email, String senha) throws Exception, SQLException {
		return admRepository.buscarPorEmailSenha(email, senha);
	}
	
}
