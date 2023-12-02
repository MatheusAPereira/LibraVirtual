package repository;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entities.Avaliacao;
import interfaces.IAvaliacaoRepositorio;
import util.JPAUtil;
import util.TransacaoUtil;

public class AvaliacaoRepository implements IAvaliacaoRepositorio{

	@Override
	public void salvar(Avaliacao avaliacao) throws SQLException {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(avaliacao);
		et.commit();
	}

	@Override
	public Avaliacao buscarPorLivroUsuario(Long idLivro, Long idUsuario) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Avaliacao avaliacao;
		List<Avaliacao> avaliacaoTeste;

		try {
			transaction.begin();
			
			Query query = manager.createQuery("FROM Avaliacao WHERE idLivro_id = :id_livro"
					+ " and idUsuario = :id_usuario", Avaliacao.class);
			
			query.setParameter("id_livro", idLivro);
			query.setParameter("id_usuario", idUsuario);
			
			avaliacaoTeste = query.getResultList();

			if(avaliacaoTeste.isEmpty()){
			    return null;
			} else {
				avaliacao = avaliacaoTeste.get(0);
			    return avaliacao;
			}

			} catch (Exception e) {
				throw new SQLException(e);
				} finally {
					if (transaction.isActive()) {
						transaction.rollback();
					}
			manager.close();
		}

	}
	
}
