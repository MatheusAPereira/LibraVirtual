package util;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptUtil {
	
	public static String gerarHashSenha(String senha) throws Exception {
        String salt = BCrypt.gensalt();
        String hashSenha = BCrypt.hashpw(senha, salt);
        return hashSenha;
    }
}
