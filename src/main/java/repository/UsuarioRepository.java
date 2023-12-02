package repository;

import java.sql.SQLException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.mindrot.jbcrypt.BCrypt;

import entities.Usuario;
import interfaces.IUsuarioRepository;
import util.JPAUtil;
import util.TransacaoUtil;

public class UsuarioRepository implements IUsuarioRepository {

	@Override
	public void salvar(Usuario usuario) throws SQLException {
		TransacaoUtil.executarTransacao(maneger -> maneger.persist(usuario));
	}
	
	@Override
	public Optional<Usuario> buscarPorEmailSenha(String email, String senha) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Usuario usuario = null;

		try {
			transaction.begin();
			usuario = manager.createQuery("FROM usuario WHERE email = :email", Usuario.class)
					.setParameter("email", email).getSingleResult();

			if (usuario != null && BCrypt.checkpw(senha, usuario.getSenha())) {
				transaction.commit();
			} else {
				usuario = null;
			}
			} catch (Exception e) {
				throw new SQLException(e);
				} finally {
					if (transaction.isActive()) {
						transaction.rollback();
					}
			manager.close();
		}

		return Optional.ofNullable(usuario);
	}

	@Override
	public Optional<Usuario> buscarPorID(Long id) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Usuario usuario = null;

		try {
			transaction.begin();
			usuario = manager.createQuery("FROM usuario WHERE id = :id", Usuario.class)
					.setParameter("id", id).getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			manager.close();
		}

		return Optional.ofNullable(usuario);
	}

	@Override
	public void alterar(Usuario usuario) throws SQLException {
		TransacaoUtil.executarTransacao(maneger -> maneger.merge(usuario));
	}

	@Override
	public void excluirPorId(Long id) throws SQLException {
		TransacaoUtil.executarTransacao(maneger -> {
			Usuario usuario = maneger.find(Usuario.class, id);
			maneger.remove(usuario);
		});
	}

}
