package repository;

import java.sql.SQLException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.mindrot.jbcrypt.BCrypt;

import entities.Moderador;
import entities.Usuario;
import interfaces.IModRepository;
import interfaces.IUsuarioRepository;
import util.JPAUtil;
import util.TransacaoUtil;

public class ModRepository implements IModRepository {

	@Override
	public void salvar(Moderador mod) throws SQLException {
		TransacaoUtil.executarTransacao(maneger -> maneger.persist(mod));
	}
	
	@Override
	public Optional<Moderador> buscarPorEmailSenha(String email, String senha) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Moderador mod = null;

		try {
			transaction.begin();
			
			mod = manager.createQuery("FROM Moderador WHERE email = :email", Moderador.class)
					.setParameter("email", email).getSingleResult();
			
			if (mod != null && BCrypt.checkpw(senha, mod.getSenha())) {
				transaction.commit();
			} else {
				mod = null;
			}
			} catch (Exception e) {
				throw new SQLException(e);
				} finally {
					if (transaction.isActive()) {
						transaction.rollback();
					}
			manager.close();
		}

		return Optional.ofNullable(mod);
	}

//	@Override
//	public Optional<Moderador> buscarPorID(int id) throws SQLException {
//		EntityManager manager = JPAUtil.getEntityManager();
//		EntityTransaction transaction = manager.getTransaction();
//
//		Moderador mod = null;
//
//		try {
//			transaction.begin();
//			mod = manager.createQuery("FROM moderador WHERE id = :id", Moderador.class)
//					.setParameter("id", id).getSingleResult();
//			transaction.commit();
//		} catch (Exception e) {
//			throw new SQLException(e);
//		} finally {
//			if (transaction.isActive()) {
//				transaction.rollback();
//			}
//
//			manager.close();
//		}
//
//		return Optional.ofNullable(mod);
//	}
//
//	@Override
//	public void alterar(Moderador mod) throws SQLException {
//		TransacaoUtil.executarTransacao(maneger -> maneger.merge(mod));
//	}
//
//	@Override
//	public void excluirPorId(int id) throws SQLException {
//		TransacaoUtil.executarTransacao(maneger -> {
//			Moderador mod = maneger.find(Moderador.class, id);
//			maneger.remove(mod);
//		});
//	}

}
