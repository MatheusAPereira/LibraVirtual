
import java.sql.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Livro;
import entities.Moderador;
import entities.Usuario;
import util.JPAUtil;

public class Main {

	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Livro livro = new Livro();
		livro.setTitulo("Com amor, simon");
		livro.setAutor("Autora desconhecida");
		livro.setGenero("romance");
		
//		Moderador mod = new Moderador();
//		mod.setNome("Ivo Vicente");
//		mod.setEmail("ivo@mail.com");
//		mod.setSenha("senha321");
		
//		Usuario us = new Usuario();
//		us.setNome("Maria");
//		us.setEmail("maria@mail.com");
//		us.setDataNascimento(Date.valueOf("2002-02-01"));
//		us.setLinkImagemPerfil("localhost:8080/LibraVirtual/img/usuario/0948857.jpg");
//		us.setSenha("senha123");
		
//		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
//        String dataFormatada = formatador.format(us.getDataNascimento());
		
		em.persist(livro);
		et.commit();

	}

}
