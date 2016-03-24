package br.eti.gadelha.ejb.controle.modelo.oque;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 14/10/2015
 * @see www.gadelha.eti.br
 **/

//ESTOQUE, INVENTÁRIO, ALIMENTO(a, b12, c, sódio), REMÉDIO

@Entity
@Table(name="ferramenta")
@Inheritance(strategy=InheritanceType.JOINED)
public class Ferramenta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id @Column(length=16, nullable = false, unique = true)
	private long id;

	@ManyToOne(cascade=CascadeType.ALL)
	private Ferramenta ferramenta;//SERVE À ALGUÉM
	
	public Ferramenta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ferramenta(long id, Ferramenta ferramenta) {
		super();
		this.id = id;
		this.ferramenta = ferramenta;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ferramenta other = (Ferramenta) obj;
		if (ferramenta == null) {
			if (other.ferramenta != null)
				return false;
		} else if (!ferramenta.equals(other.ferramenta))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	public Ferramenta getFerramenta() {
		return ferramenta;
	}
	public long getId() {
		return id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ferramenta == null) ? 0 : ferramenta.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	public void setFerramenta(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Ferramenta [id=" + id + ", ferramenta=" + ferramenta + "]";
	}
}