package br.eti.gadelha.ejb.controle.modelo.oque;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 15/10/2015
 * @see www.gadelha.eti.br
 **/

@Entity
@Table(name="grupo")
public class Grupo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id @Column(length=16, nullable = false, unique = true)
	private long id;
	@Temporal(TemporalType.DATE)
	private Date criacao;
	@Temporal(TemporalType.DATE)
	private Date extincao;
	@Column(length=45, nullable = false)
	private String nome;
	@Column(length=45, nullable = false)
	private String cor;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Ferramenta ferramenta;//COMANDA
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Ferramenta> ferramentas;//PC, EQUIPE, RECEITA, DIETA(GRUPO DE FERRAMENTAS)
	
	public Grupo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grupo(long id, Date criacao, Date extincao, String nome, String cor, Ferramenta ferramenta,
			List<Ferramenta> ferramentas) {
		super();
		this.id = id;
		this.criacao = criacao;
		this.extincao = extincao;
		this.nome = nome;
		this.cor = cor;
		this.ferramenta = ferramenta;
		this.ferramentas = ferramentas;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (ferramenta == null) {
			if (other.ferramenta != null)
				return false;
		} else if (!ferramenta.equals(other.ferramenta))
			return false;
		if (ferramentas == null) {
			if (other.ferramentas != null)
				return false;
		} else if (!ferramentas.equals(other.ferramentas))
			return false;
		if (criacao == null) {
			if (other.criacao != null)
				return false;
		} else if (!criacao.equals(other.criacao))
			return false;
		if (id != other.id)
			return false;
		if (extincao == null) {
			if (other.extincao != null)
				return false;
		} else if (!extincao.equals(other.extincao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	public String getCor() {
		return cor;
	}
	public Ferramenta getFerramenta() {
		return ferramenta;
	}
	public Ferramenta getFerramentas(int indice) {
		return ferramentas.get(indice);
	}
	public List<Ferramenta> getFerramentas() {
		return ferramentas;
	}
	public Date getCriacao() {
		return criacao;
	}
	public long getId() {
		return id;
	}
	public Date getExtincao() {
		return extincao;
	}
	public String getNome() {
		return nome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((ferramenta == null) ? 0 : ferramenta.hashCode());
		result = prime * result + ((ferramentas == null) ? 0 : ferramentas.hashCode());
		result = prime * result + ((criacao == null) ? 0 : criacao.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((extincao == null) ? 0 : extincao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public void setFerramenta(Ferramenta ferramenta) {
		ferramentas.add(ferramenta);
	}
	public void setFerramentas(List<Ferramenta> ferramentas) {
		this.ferramentas = ferramentas;
	}
	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setExtincao(Date extincao) {
		this.extincao = extincao;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Grupo [id=" + id + ", criacao=" + criacao + ", extincao=" + extincao + ", nome=" + nome + ", cor=" + cor
				+ ", ferramenta=" + ferramenta + ", ferramentas=" + ferramentas + "]";
	}
}