package br.eti.gadelha.ejb.controle.modelo.paraQue;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 14/10/2015
 * @see www.gadelha.eti.br
 **/

//PRODUCT BACKLOG: conjunto de histórias

@Entity
@Table(name="projeto")
public class Projeto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id @Column(length=16, nullable = false, unique = true)
	private long id;
	@Column(length=45, nullable = false)
	private String nome;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Programa programa;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Historia> historias;
	
	public Projeto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Projeto(long id, String nome, Programa programa, List<Historia> historias) {
		super();
		this.id = id;
		this.nome = nome;
		this.programa = programa;
		this.historias = historias;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		if (historias == null) {
			if (other.historias != null)
				return false;
		} else if (!historias.equals(other.historias))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (programa == null) {
			if (other.programa != null)
				return false;
		} else if (!programa.equals(other.programa))
			return false;
		return true;
	}
	public Historia getHistoria(int indice) {
		return historias.get(indice);
	}
	public List<Historia> getHistorias() {
		return historias;
	}
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Programa getPrograma() {
		return programa;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((historias == null) ? 0 : historias.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((programa == null) ? 0 : programa.hashCode());
		return result;
	}
	public void setHistoria(Historia historia) {
		this.historias.add(historia);
	}
	public void setHistorias(List<Historia> historias) {
		this.historias = historias;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	@Override
	public String toString() {
		return "Projeto [id=" + id + ", nome=" + nome + ", programa=" + programa + ", historias=" + historias + "]";
	}
}