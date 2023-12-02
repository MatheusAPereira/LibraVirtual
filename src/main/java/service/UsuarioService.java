package service;

import java.sql.SQLException;
import java.util.Optional;

import entities.Usuario;
import repository.UsuarioRepository;

public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;

	public UsuarioService() {
		this.usuarioRepository = new UsuarioRepository();
	}
	
	public void salvarUsuario(Usuario usuario) throws Exception, SQLException {
		usuarioRepository.salvar(usuario);
	}

	public Optional<Usuario> buscarPorEmailSenha(String email, String senha) throws Exception, SQLException {
		return usuarioRepository.buscarPorEmailSenha(email, senha);
	}
	
	public Optional<Usuario> buscarPorId (Long id) throws SQLException{
		return usuarioRepository.buscarPorID(id);
	}
	
}
