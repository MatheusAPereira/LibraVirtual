//package model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//public class Pessoa {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.TABLE)
//	private int id;
//	private String nome;
//    private String email;
//    private String senha;
//    
//    public Pessoa() {
//    }
//    
//    public Pessoa(String nome, String email, String senha, int id) {
//        this.email = email;
//        this.nome = nome;
//        this.senha = senha;
//        this.id = id;
//    }
//    
//    public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getNome() {
//        return this.nome;
//        }
//    
//    public String getEmail() {
//        return this.email;
//        }
//    
//    public String getSenha() {
//        return this.senha;
//        }
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}
//
//	@Override
//	public String toString() {
//		return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
//	}
//	
//}
package entities;


