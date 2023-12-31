package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="moderador")
public class Moderador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
    private String email;
    private String senha;
    
    public Moderador () {
    }
	
    public Moderador (int id, String nome, String email, String senha) {
    	this.id = id;
    	this.nome = nome;
    	this.email = email;
    	this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Moderador [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}
    
}

