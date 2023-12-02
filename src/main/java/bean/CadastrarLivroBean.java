package bean;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Date;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import entities.Livro;
import service.LivroService;

@WebServlet("/cadastrarLivro")
public class CadastrarLivroBean extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		if(session == null || session.getAttribute("user_type") == null) {
			resp.sendRedirect("/LibraVirtual");
			return;
		} else if (session.getAttribute("user_type").equals("comum")) {
			resp.sendRedirect("/LibraVirtual");
			return;
		}
		
		String img = req.getParameter("imagem");
		String ISBN = req.getParameter("isbn");
		String titulo = req.getParameter("titulo");
		String sinopse = req.getParameter("sinopse");
		String numPag = req.getParameter("num_paginas");
		String idioma = req.getParameter("idioma");
		String editora = req.getParameter("editora");
		String dataPub = req.getParameter("data_publicacao");
		String autor = req.getParameter("autor");
		String genero = req.getParameter("genero");
		String classificacao = req.getParameter("classificacao");
		
		Livro livro = new Livro();
		
		livro.setImgCapa(img);
		livro.setISBN(ISBN);
		livro.setTitulo(titulo);
		livro.setSinopse(sinopse);
		livro.setNumpag(Integer.parseInt(numPag));
		livro.setIdioma(idioma);
		livro.setEditora(editora);
		livro.setDataPubli(Date.valueOf(dataPub));
		livro.setAutor(autor);
		livro.setGenero(genero);
		livro.setClassificacao(classificacao);
		
		LivroService service = new LivroService();
		
		try {
			service.Salvar(livro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("/LibraVirtual");
	}
	
}
