package br.eti.gadelha.ejb.controle.modelo.paraQue;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 14/10/2015
 * @see www.gadelha.eti.br
 **/

@Entity
@Table(name="programa")
public class Programa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id @Column(length=16, nullable = false, unique = true)
	private long id;
	@Column(length=45, nullable = false)
	private String categoria;//SAÚDE, EDUCAÇÃO, ALIMENTAÇÃO, TRABALHO, MORADIA... MASLOW
	
	public Programa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Programa(long id, String categoria) {
		super();
		this.id = id;
		this.categoria = categoria;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Programa other = (Programa) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	public String getCategoria() {
		return categoria;
	}
	public long getId() {
		return id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Programa [id=" + id + ", categoria=" + categoria + "]";
	}
}