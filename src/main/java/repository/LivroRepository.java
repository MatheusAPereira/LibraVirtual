package repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.catalina.Manager;

import entities.Livro;
import entities.Usuario;
import interfaces.ILivroRepository;
import util.JPAUtil;
import util.TransacaoUtil;

public class LivroRepository implements ILivroRepository{

	@Override
	public void salvar(Livro livro) throws SQLException {
		TransacaoUtil.executarTransacao(maneger -> maneger.persist(livro));
	}

	@Override
	public Livro buscarPorID(Long id) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Livro livro = null;

		try {
			transaction.begin();
			System.out.println("ID: "+id);
			livro = manager.createQuery("FROM Livro WHERE id = :id", Livro.class)
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

		return livro;
	}

	@Override
	public void alterar(Livro livro) throws SQLException {
		TransacaoUtil.executarTransacao(maneger -> maneger.merge(livro));
		
	}

	@Override
	public void excluirPorID(Long id) throws SQLException {
		TransacaoUtil.executarTransacao(maneger -> {
			Livro livro = maneger.find(Livro.class, id);
			maneger.remove(livro);
		});
	}

	@Override
	public List<Livro> listarLivros() throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		List<Livro> livros = null;

		try {
			transaction.begin();
			livros = manager.createQuery("FROM Livro", Livro.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			manager.close();
		}

		return livros;
	}

	@Override
	public List<Livro> listarPorGenero(String genero) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		List<Livro> livros = null;

		try {
			transaction.begin();
			livros = manager.createQuery("FROM Livro WHERE genero = :genero", Livro.class)
					.setParameter("genero", genero).getResultList();
			transaction.commit();
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			manager.close();
		}

		return livros;
	}

	@Override
	public List<Livro> listarPorGeneroNome(String genero, String[] termos) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		List<Livro> livros = null;
		
		String query = "FROM Livro WHERE genero = :genero AND ";
		for (int i = 0; i < termos.length; i++) {
		    if (i > 0) {
		        query += " OR ";
		    }
		    query += "titulo LIKE '%" + termos[i] + "%'";
		}

		try {
			transaction.begin();
			livros = manager.createQuery(query, Livro.class).setParameter("genero", genero).getResultList();
			transaction.commit();
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			manager.close();
		}

		return livros;
	}

	@Override
	public List<Livro> listarPorNome(String[] termos) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		List<Livro> livros = null;
		
		String query = "FROM Livro WHERE ";
		for (int i = 0; i < termos.length; i++) {
		    if (i > 0) {
		        query += " OR ";
		    }
		    query += "titulo LIKE '%" + termos[i] + "%'";
		}

		try {
			transaction.begin();
			livros = manager.createQuery(query, Livro.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			
			manager.close();
		}
		
		System.out.println(livros.isEmpty());

		return livros;
	}

}
