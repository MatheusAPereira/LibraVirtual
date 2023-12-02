package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="denuncia")
public class Denuncia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private int idComentario;
    private int idUsuario;
    private Date data;
    private String motivoDenuncia;
    private boolean avaliado;
    private boolean procede;
    

    public Denuncia() {
    	
    }
    
    public Denuncia (Long id, int idComentario, int idUsuario, Date data, String motivoDenuncia,
            boolean avaliado, boolean procede) {
        this.id = id;
        this.data = data;
        this.idComentario = idComentario;
        this.avaliado = avaliado;
        this.idUsuario = idUsuario;
        this.motivoDenuncia = motivoDenuncia;
        this.procede = procede;
    }
        
    public void setId(Long id) {
		this.id = id;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setMotivoDenuncia(String motivoDenuncia) {
		this.motivoDenuncia = motivoDenuncia;
	}

	public void setAvaliado(boolean avaliado) {
		this.avaliado = avaliado;
	}

	public void setProcede(boolean procede) {
		this.procede = procede;
	}

	public Long getId() {
		return id;
	}

	public int getIdComentario() {
        return this.idComentario;
    }
    
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public boolean getAvaliado() {
        return this.avaliado;
    }
    
    public String getMotivoDenuncia() {
        return this.motivoDenuncia;
    }
    
    public Date getData() {
        return this.data;
    }
    
    public boolean getProcede() {
        return this.procede;
    }

}