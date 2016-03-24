package br.eti.gadelha.ejb.controle.modelo.quando;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 14/10/2015
 * @see www.gadelha.eti.br
 **/

//ITERAÇÃO ou SPRINT

@Entity
@Table(name="iteracao")
public class Iteracao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id @Column(length=16, nullable = false, unique = true)
	private long id;
	@Temporal(TemporalType.DATE)
	private Date inicio;
	@Temporal(TemporalType.DATE)
	private Date fim;
	@Column(length=16, nullable = false)
	private long minimo;
	@Column(length=16, nullable = false)
	private long maximo;
	
	public Iteracao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Iteracao(long id, Date inicio, Date fim, long minimo, long maximo) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
		this.minimo = minimo;
		this.maximo = maximo;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Iteracao other = (Iteracao) obj;
		if (fim == null) {
			if (other.fim != null)
				return false;
		} else if (!fim.equals(other.fim))
			return false;
		if (id != other.id)
			return false;
		if (inicio == null) {
			if (other.inicio != null)
				return false;
		} else if (!inicio.equals(other.inicio))
			return false;
		if (maximo != other.maximo)
			return false;
		if (minimo != other.minimo)
			return false;
		return true;
	}
	public Date getFim() {
		return fim;
	}
	public long getId() {
		return id;
	}
	public Date getInicio() {
		return inicio;
	}
	public long getMaximo() {
		return maximo;
	}
	public long getMinimo() {
		return minimo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fim == null) ? 0 : fim.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
		result = prime * result + (int) (maximo ^ (maximo >>> 32));
		result = prime * result + (int) (minimo ^ (minimo >>> 32));
		return result;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public void setMaximo(long maximo) {
		this.maximo = maximo;
	}
	public void setMinimo(long minimo) {
		this.minimo = minimo;
	}
	@Override
	public String toString() {
		return "Iteracao [id=" + id + ", inicio=" + inicio + ", fim=" + fim + ", minimo=" + minimo + ", maximo="
				+ maximo + "]";
	}
}