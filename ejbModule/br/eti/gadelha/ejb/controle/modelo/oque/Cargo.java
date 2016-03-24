package br.eti.gadelha.ejb.controle.modelo.oque;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.eti.gadelha.ejb.controle.modelo.como.Funcao;

@Entity
@Table(name="cargo")
@Inheritance(strategy=InheritanceType.JOINED)
public class Cargo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id @Column(length=16, nullable = false, unique = true)
	private long id;
	@Column(length=45, nullable = false)
	private String nome;
	@Temporal(TemporalType.DATE)
	private Date horasDia;
	@Column
	private int influencia;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Funcao> funcoes;
	
	public Cargo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cargo(long id, String nome, Date horasDia, int influencia, List<Funcao> funcoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.horasDia = horasDia;
		this.influencia = influencia;
		this.funcoes = funcoes;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		if (funcoes == null) {
			if (other.funcoes != null)
				return false;
		} else if (!funcoes.equals(other.funcoes))
			return false;
		if (horasDia == null) {
			if (other.horasDia != null)
				return false;
		} else if (!horasDia.equals(other.horasDia))
			return false;
		if (id != other.id)
			return false;
		if (influencia != other.influencia)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	public Funcao getFuncao(int funcao) {
		return funcoes.get(funcao);
	}
	public List<Funcao> getFuncoes() {
		return funcoes;
	}
	public Date getHorasDia() {
		return horasDia;
	}
	public long getId() {
		return id;
	}
	public int getInfluencia() {
		return influencia;
	}
	public String getNome() {
		return nome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcoes == null) ? 0 : funcoes.hashCode());
		result = prime * result + ((horasDia == null) ? 0 : horasDia.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + influencia;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	public void setfuncao(Funcao funcao) {
		this.funcoes.add(funcao);
	}
	public void setFuncoes(List<Funcao> funcoes) {
		this.funcoes = funcoes;
	}
	public void setHorasDia(Date horasDia) {
		this.horasDia = horasDia;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setInfluencia(int influencia) {
		this.influencia = influencia;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Cargo [id=" + id + ", nome=" + nome + ", horasDia=" + horasDia + ", influencia=" + influencia
				+ ", funcoes=" + funcoes + "]";
	}
}