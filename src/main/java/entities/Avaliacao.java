package entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="avaliacao")
public class Avaliacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @JoinColumn(name = "idLivro_id")
    private Long idLivro;
    private Double nota;
    private String comentario;
    private Date data;
    private boolean spoiler;
    private boolean visivel;
    
    public Avaliacao() {
    	
    }

    public Avaliacao(Long id, Usuario usuario, Long idLivro, Double nota, String comentario, 
            Date data, boolean spoiler, boolean visivel ) {
        
    	this.id = id;
        this.comentario = comentario;
        this.data = data;
        this.usuario = usuario;
        this.idLivro = idLivro;
        this.nota = nota;
        this.spoiler = spoiler;
        this.visivel = visivel;    
    }
    
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public Long getId() {
		return id;
	}

	public Long getIdLivro() {
		return idLivro;
	}

	public Double getNota() {
        return this.nota;
    }
    
    public String getComentario() {
        return this.comentario;
    }
    
    public Date getData() {
        return this.data;
    }
    
    public boolean getSpoiler() {
        return this.spoiler;
    }
    
    public boolean getVisivel() {
        return this.visivel;
    }

	public void setId(Long id) {
		this.id = id;
	}

	public void setLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setSpoiler(boolean spoiler) {
		this.spoiler = spoiler;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	
}