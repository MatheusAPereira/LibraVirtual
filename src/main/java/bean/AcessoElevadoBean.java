package bean;

import java.io.IOException;
import java.util.Optional;

import service.AdmService;
import service.ModService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Adm;
import entities.Moderador;



@WebServlet("/entrarElevado")
public class AcessoElevadoBean extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nivel = req.getParameter("nivel_acesso");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		if(nivel.equals("Administrador")) {
			AdmService admService = new AdmService();

			Optional<Adm> adm = Optional.empty();

			try {
				adm = admService.buscarPorEmailSenha(email, senha);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (adm.isPresent()) {
				HttpSession session = req.getSession();
				session.setAttribute("user_id", adm.get().getId());
				session.setAttribute("user_name", adm.get().getNome());
				session.setAttribute("user_type", "administrador");
				resp.sendRedirect("/LibraVirtual");
				return;
			} else {
				resp.sendRedirect("AcessoElevadoForm.jsp?erro=1");
				return;
			}
			
		} else {
			
			ModService modService = new ModService();

			Optional<Moderador> mod = Optional.empty();

			try {
				mod = modService.buscarPorEmailSenha(email, senha);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (mod.isPresent()) {
				HttpSession session = req.getSession();
				session.setAttribute("user_id", mod.get().getId());
				session.setAttribute("user_name", mod.get().getNome());
				session.setAttribute("user_type", "moderador");
				resp.sendRedirect("/LibraVirtual");
				return;
			} else {
				resp.sendRedirect("AcessoElevadoForm.jsp?erro=1");
				return;
			}
		}
		
	}

}
