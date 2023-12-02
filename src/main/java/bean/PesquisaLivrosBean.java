package bean;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Livro;
import service.LivroService;

@WebServlet("/pesquisar")
public class PesquisaLivrosBean extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String q = req.getParameter("q");
		String genero = req.getParameter("genero");
		
		LivroService service = new LivroService();
		
		List<Livro> livros = new ArrayList<>();
		
		if (!q.equals("") && genero.equals("")) {
			try {
				livros = service.listarLivrosPorNome(q);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (!q.equals("") && !genero.equals("")) {
			try {
				livros = service.listarLivrosPorGeneroNome(genero, q);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (q.equals("") && !genero.equals("")) {
			try {
				livros = service.listarLivrosPorGenero(genero);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				livros = service.listarLivros();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		req.setAttribute("livros", livros);		
		RequestDispatcher dispatcher = req.getRequestDispatcher("Pesquisa.jsp");
		dispatcher.forward(req, resp);

	}
	
}
