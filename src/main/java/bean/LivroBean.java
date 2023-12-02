package bean;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Avaliacao;
import entities.Livro;
import service.AvaliacaoService;
import service.LivroService;

@WebServlet("/Livro")
public class LivroBean extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idLivro = req.getParameter("id");
		
		Livro livro = new Livro();
		
		LivroService service = new LivroService();
		
		HttpSession session = req.getSession();
		
		if (idLivro != null && idLivro != "") {
			try {
				livro =  service.buscarPorId(Long.decode(idLivro));
				session.setAttribute("livro", livro);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (session != null && session.getAttribute("user_type") != null && session.getAttribute("user_type").equals("comum")) {
			AvaliacaoService serviceAvaliacao = new AvaliacaoService();
			Avaliacao avaliacao;
			try {
				avaliacao = serviceAvaliacao
						.buscarPorLivroUsuario(Long.valueOf(idLivro),
								Long.valueOf(String.valueOf(session.getAttribute("user_id"))));
				session.setAttribute("avaliacao", avaliacao);
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("Livro.jsp?id="+idLivro);
		dispatcher.forward(req, resp);
	}
}
