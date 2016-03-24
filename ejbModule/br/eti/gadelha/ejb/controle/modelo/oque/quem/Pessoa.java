package br.eti.gadelha.ejb.controle.modelo.oque.quem;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 27/08/2015
 * @see www.gadelha.eti.br
 **/

//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="pessoa")
@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name = "tipo")
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id @Column(length=16, nullable = false, unique = true)
	private long id;
	@Temporal(TemporalType.DATE)
	private Date nascimento;
	@Column(length=45, nullable = false)
	private String nome;
	
	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pessoa(long id, Date nascimento, String nome) {
		super();
		this.id = id;
		this.nascimento = nascimento;
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
		Pessoa other = (Pessoa) obj;
		if (id != other.id)
			return false;
		if (nascimento == null) {
			if (other.nascimento != null)
				return false;
		} else if (!nascimento.equals(other.nascimento))
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
	public Date getNascimento() {
		return nascimento;
	}
	public String getNome() {
		return nome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nascimento == null) ? 0 : nascimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nascimento=" + nascimento + ", nome=" + nome + "]";
	}
}