package repository;

import java.sql.SQLException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.mindrot.jbcrypt.BCrypt;

import entities.Adm;
import entities.Usuario;
import interfaces.IAdmRepository;
import interfaces.IUsuarioRepository;
import util.JPAUtil;
import util.TransacaoUtil;

public class AdmRepository implements IAdmRepository {

	@Override
	public void salvar(Adm adm) throws SQLException {
		TransacaoUtil.executarTransacao(maneger -> maneger.persist(adm));
	}
	
	@Override
	public Optional<Adm> buscarPorEmailSenha(String email, String senha) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Adm adm = null;

		try {
			transaction.begin();
			System.out.println("Email: "+email);
			System.out.println("Senha: "+senha);
			adm = manager.createQuery("FROM Adm WHERE email = :email", Adm.class)
					.setParameter("email", email).getSingleResult();

			if (adm != null && BCrypt.checkpw(senha, adm.getSenha())) {
				transaction.commit();
			} else {
				adm = null;
			}
			} catch (Exception e) {
				throw new SQLException(e);
				} finally {
					if (transaction.isActive()) {
						transaction.rollback();
					}
			manager.close();
		}

		return Optional.ofNullable(adm);
	}

//	@Override
//	public Optional<Amd> buscarPorID(int id) throws SQLException {
//		EntityManager manager = JPAUtil.getEntityManager();
//		EntityTransaction transaction = manager.getTransaction();
//
//		Adm adm = null;
//
//		try {
//			transaction.begin();
//			adm = manager.createQuery("FROM adm WHERE id = :id", Adm.class)
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
//		return Optional.ofNullable(adm);
//	}
//
//	@Override
//	public void alterar(Amd adm) throws SQLException {
//		TransacaoUtil.executarTransacao(maneger -> maneger.merge(usuario));
//	}
//
//	@Override
//	public void excluirPorId(int id) throws SQLException {
//		TransacaoUtil.executarTransacao(maneger -> {
//			Adm adm = maneger.find(Adm.class, id);
//			maneger.remove(adm);
//		});
//	}

}
