package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="livro")
public class Livro {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Lob
		private String imgCapa;
		private String ISBN;
		private String titulo;
		private String sinopse;
		private int numPag;
		private String idioma;
		private String editora;
		private Date dataPubli;
		private String autor;
		private String genero;
		private String classificacao;
		private int numAval;
		private Double notaMedia;
		
		public Livro() {
		}
		
		public Livro (Long id, String capa, String ISBN, String nome, String sinopse, int numpag,
				String idioma, String editora, Date dataPubli, String autor, String genero, 
				String classificacao, Double notaMedia, int numAval) {
					
				this.autor = autor;
				this.classificacao = classificacao;
				this.dataPubli = dataPubli;
				this.editora = editora;
				this.genero = genero;
				this.id = id;
				this.idioma = idioma;
				this.imgCapa = capa;
				this.ISBN = ISBN;
				this.titulo = nome;
				this.numPag = numpag;
				this.sinopse = sinopse;
				this.numAval = numAval;
				this.notaMedia = notaMedia;
		}
		
		public int getNumAval() {
			return numAval;
		}

		public void setNumAval(int numAval) {
			this.numAval = numAval;
		}

		public Double getNotaMedia() {
			return notaMedia;
		}

		public void setNotaMedia(Double notaMedia) {
			this.notaMedia = notaMedia;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setImgCapa(String capa) {
			this.imgCapa = capa;
		}

		public void setISBN(String iSBN) {
			ISBN = iSBN;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public void setSinopse(String sinopse) {
			this.sinopse = sinopse;
		}

		public void setNumpag(int numpag) {
			this.numPag = numpag;
		}

		public void setIdioma(String idioma) {
			this.idioma = idioma;
		}

		public void setEditora(String editora) {
			this.editora = editora;
		}

		public void setDataPubli(Date dataPubli) {
			this.dataPubli = dataPubli;
		}

		public void setAutor(String autor) {
			this.autor = autor;
		}

		public void setGenero(String genero) {
			this.genero = genero;
		}

		public void setClassificacao(String classificacao) {
			this.classificacao = classificacao;
		}

		public Long getId() {
			return this.id;
		}
		
		public String getImgCapa() {
			return this.imgCapa;
		}
		
		public String getISBN() {
			return this.ISBN;
		}
		
		public String getTitulo() {
			return this.titulo;
		}
		
		public String getSinopse() {
			return this.sinopse;
		}
		
		public int getNumpag() {
			return this.numPag;
		}
		
		public String getIdioma() {
			return this.idioma;
		}
		
		public String getEditora() {
			return this.editora;
		}
		
		public Date getDataPubli() {
			return this.dataPubli;
		}
		
		public String getAutor() {
			return this.autor;
		}
		
		public String getGenero() {
			return this.genero;
		}
		
		public String getClassificacao() {
			return this.classificacao;
		}
		
}
