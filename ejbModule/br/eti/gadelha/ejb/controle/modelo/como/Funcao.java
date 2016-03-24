package br.eti.gadelha.ejb.controle.modelo.como;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 27/08/2015
 * @see www.gadelha.eti.br
 **/

//cozinheiro, nutricionista, médico, doador, recebedor, ferramenta

@Entity
@Table(name="funcao")
public class Funcao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id @Column(length=16, nullable = false, unique = true)
	private long id;
	@Column(length=45, nullable = false)
	private String nome;
	
	public Funcao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Funcao(long id) {
		super();
		this.id = id;
	}
	public Funcao(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcao other = (Funcao) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Funcao [id=" + id + ", nome=" + nome + "]";
	}
}