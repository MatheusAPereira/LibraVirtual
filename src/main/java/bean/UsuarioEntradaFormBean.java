package bean;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Usuario;
import service.UsuarioService;

@WebServlet("/entrar")
public class UsuarioEntradaFormBean extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		UsuarioService service = new UsuarioService();

		Optional<Usuario> usuario = Optional.empty();
		
		try {
			usuario = service.buscarPorEmailSenha(email, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (usuario.isPresent()) {
			HttpSession session = req.getSession();
			session.setAttribute("user_id", usuario.get().getId());
			session.setAttribute("user_name", usuario.get().getNome());
			session.setAttribute("user_type", "comum");
			resp.sendRedirect("/LibraVirtual");
			return;
		} else {
			resp.sendRedirect("UsuarioEntradaForm.jsp?erro=1");
			return;
		}
	}
}
