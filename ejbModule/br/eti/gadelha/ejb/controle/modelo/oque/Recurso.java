package br.eti.gadelha.ejb.controle.modelo.oque;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 27/08/2015
 * @see www.gadelha.eti.br
 **/

//motherbord, processador, memória

@Entity
@Table(name="recurso")
@PrimaryKeyJoinColumn(name = "id")
public class Recurso extends Ferramenta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Temporal(TemporalType.DATE)
	private Date contratacao;
	@Temporal(TemporalType.DATE)
	private Date aposentadoria;//aposentadoria, encerramento
	@Temporal(TemporalType.DATE)
	private Date depreciacao;
	@Column
	private byte interesse;
	@Column
	private long qtdMin;
	@Column
	private long qtdMax;
	@OneToMany(fetch = FetchType.EAGER)//TODOS QUE TERMINAM COM ...Many SÃO LAZY NÃO EAGER
	private List<Recurso> recursos;//DEPENDENTES
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Cargo> cargos;
	
	public Recurso() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Recurso(long id, Ferramenta ferramenta) {
		super(id, ferramenta);
		// TODO Auto-generated constructor stub
	}
	public Recurso(Date contratacao, Date aposentadoria, Date depreciacao, byte interesse, 
			long qtdMin, long qtdMax, List<Recurso> recursos, List<Cargo> cargos) {
		super();
		this.contratacao = contratacao;
		this.aposentadoria = aposentadoria;
		this.depreciacao = depreciacao;
		this.interesse = interesse;
		this.qtdMin = qtdMin;
		this.qtdMax = qtdMax;
		this.recursos = recursos;
		this.cargos = cargos;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recurso other = (Recurso) obj;
		if (aposentadoria == null) {
			if (other.aposentadoria != null)
				return false;
		} else if (!aposentadoria.equals(other.aposentadoria))
			return false;
		if (cargos == null) {
			if (other.cargos != null)
				return false;
		} else if (!cargos.equals(other.cargos))
			return false;
		if (contratacao == null) {
			if (other.contratacao != null)
				return false;
		} else if (!contratacao.equals(other.contratacao))
			return false;
		if (depreciacao == null) {
			if (other.depreciacao != null)
				return false;
		} else if (!depreciacao.equals(other.depreciacao))
			return false;
		if (interesse != other.interesse)
			return false;
		if (qtdMax != other.qtdMax)
			return false;
		if (qtdMin != other.qtdMin)
			return false;
		if (recursos == null) {
			if (other.recursos != null)
				return false;
		} else if (!recursos.equals(other.recursos))
			return false;
		return true;
	}
	public Date getAposentadoria() {
		return aposentadoria;
	}
	public Cargo getCargo(int cargo) {
		return cargos.get(cargo);
	}
	public List<Cargo> getCargos() {
		return cargos;
	}
	public Date getContratacao() {
		return contratacao;
	}
	public Date getDepreciacao() {
		return depreciacao;
	}
	public byte getInteresse() {
		return interesse;
	}
	public long getQtdMax() {
		return qtdMax;
	}
	public long getQtdMin() {
		return qtdMin;
	}
	public Recurso getRecurso(int recurso) {
		return recursos.get(recurso);
	}
	public List<Recurso> getRecursos() {
		return recursos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((aposentadoria == null) ? 0 : aposentadoria.hashCode());
		result = prime * result + ((cargos == null) ? 0 : cargos.hashCode());
		result = prime * result + ((contratacao == null) ? 0 : contratacao.hashCode());
		result = prime * result + ((depreciacao == null) ? 0 : depreciacao.hashCode());
		result = prime * result + interesse;
		result = prime * result + (int) (qtdMax ^ (qtdMax >>> 32));
		result = prime * result + (int) (qtdMin ^ (qtdMin >>> 32));
		result = prime * result + ((recursos == null) ? 0 : recursos.hashCode());
		return result;
	}
	public void setAposentadoria(Date aposentadoria) {
		this.aposentadoria = aposentadoria;
	}
	public void setCargo(Cargo cargo) {
		this.cargos.add(cargo);
	}
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	public void setContratacao(Date contratacao) {
		this.contratacao = contratacao;
	}
	public void setDepreciacao(Date depreciacao) {
		this.depreciacao = depreciacao;
	}
	public void setInteresse(byte interesse) {
		this.interesse = interesse;
	}
	public void setQtdMax(long qtdMax) {
		this.qtdMax = qtdMax;
	}
	public void setQtdMin(long qtdMin) {
		this.qtdMin = qtdMin;
	}
	public void setRecurso(Recurso recurso) {
		this.recursos.add(recurso);
	}
	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}
	@Override
	public String toString() {
		return "Recurso [contratacao=" + contratacao + ", aposentadoria=" + aposentadoria + ", depreciacao="
				+ depreciacao + ", interesse=" + interesse + ", qtdMin="
				+ qtdMin + ", qtdMax=" + qtdMax + ", recursos=" + recursos + ", cargos=" + cargos + "]";
	}	
}