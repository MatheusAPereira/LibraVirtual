package bean;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Avaliacao;
import service.AvaliacaoService;
import service.UsuarioService;

@WebServlet("/salvarAvaliacao")
public class SalvarAvaliacao extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String idUsuario = req.getParameter("id_usuario");
		String idLivro = req.getParameter("id_livro");
		String comentario = req.getParameter("comentario");
		String spoiler = req.getParameter("spoiler");
		String nota = req.getParameter("nota");
		
		AvaliacaoService service = new AvaliacaoService();
		
		UsuarioService usuarioService = new UsuarioService();
		
		Avaliacao avaliacao = new Avaliacao();
		
		try {
			avaliacao.setUsuario(usuarioService.buscarPorId(Long.decode(idUsuario)).get());
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		avaliacao.setSpoiler(spoiler != null ? true : false);
		avaliacao.setNota(Double.valueOf(nota));
		avaliacao.setComentario(comentario);
		avaliacao.setLivro(Long.decode(idLivro));
		avaliacao.setVisivel(true);
		Date date = new Date();
		Long time =  date.getTime();
		date = new Date(time);
		avaliacao.setData(date);
		
		try {
			service.salvar(avaliacao);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("Livro?id="+idLivro);
	}
}
