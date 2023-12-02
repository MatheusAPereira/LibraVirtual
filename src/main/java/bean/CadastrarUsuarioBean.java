package bean;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import entities.Usuario;
import service.UsuarioService;
import util.BCryptUtil;

@WebServlet("/cadastrar")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10, // 10MB
    maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class CadastrarUsuarioBean extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
//		Part imagemPart = req.getPart("imagem");
//        InputStream fileContent = imagemPart.getInputStream();
//        byte[] imageBytes = fileContent.readAllBytes();
		
		String nome = req.getParameter("nome");
		String dataNasc = req.getParameter("dataNascimento");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		try {
			senha = BCryptUtil.gerarHashSenha(senha);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UsuarioService service = new UsuarioService();
		
		Usuario usuario = new Usuario();
		
//		usuario.setImagem(imageBytes);
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setDataNascimento(Date.valueOf(dataNasc));
		usuario.setSenha(senha);
		
		try {
			service.salvarUsuario(usuario);
			HttpSession session = req.getSession();
			session.setAttribute("user_id", usuario.getId());
			session.setAttribute("user_name", usuario.getNome());
			session.setAttribute("user_type", "comum");
			resp.sendRedirect("/LibraVirtual");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
