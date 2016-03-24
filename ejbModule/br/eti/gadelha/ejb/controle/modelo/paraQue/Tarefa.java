package br.eti.gadelha.ejb.controle.modelo.paraQue;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.eti.gadelha.ejb.controle.modelo.quando.Iteracao;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 14/10/2015
 * @see www.gadelha.eti.br
 **/

//FALTANDO SMART

@Entity
@Table(name="tarefa")
@Inheritance(strategy=InheritanceType.JOINED)
public class Tarefa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id @Column(length=16, nullable = false, unique = true)
	private long id;
	@Temporal(TemporalType.DATE)
	private Date inicio;
	@Temporal(TemporalType.DATE)
	private Date fim;
	@Column(length=16, nullable = false)
	private long dificuldade;
	@Column(length=16, nullable = false)
	private long qtdDeAnexos;
	@Column(length=16, nullable = false)
	private long qtdDeRecados;
	@Column(length=45, nullable = false)
	private String titulo;
	@Column(length=45, nullable = false)
	private String objetivo;//PROPÓSITO
	@Column(length=45, nullable = false)
	private String atividade;//PASSO A PASSO, ESTADO
	@Column(length=45, nullable = false)
	private String envio;//ENVIADO, RECEBIDO, LIDO
	@ManyToOne(cascade=CascadeType.ALL)
	private Historia historia;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Requisito> requisitos;
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)//ou @ManyToMany
	private Iteracao iteracoes;
	
	public Tarefa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tarefa(long id, Date inicio, Date fim, long dificuldade, long qtdDeAnexos, long qtdDeRecados, String titulo,
			String objetivo, String atividade, String envio, Historia historia, List<Requisito> requisitos,
			Iteracao iteracoes) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
		this.dificuldade = dificuldade;
		this.qtdDeAnexos = qtdDeAnexos;
		this.qtdDeRecados = qtdDeRecados;
		this.titulo = titulo;
		this.objetivo = objetivo;
		this.atividade = atividade;
		this.envio = envio;
		this.historia = historia;
		this.requisitos = requisitos;
		this.iteracoes = iteracoes;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		if (atividade == null) {
			if (other.atividade != null)
				return false;
		} else if (!atividade.equals(other.atividade))
			return false;
		if (dificuldade != other.dificuldade)
			return false;
		if (envio == null) {
			if (other.envio != null)
				return false;
		} else if (!envio.equals(other.envio))
			return false;
		if (fim == null) {
			if (other.fim != null)
				return false;
		} else if (!fim.equals(other.fim))
			return false;
		if (historia == null) {
			if (other.historia != null)
				return false;
		} else if (!historia.equals(other.historia))
			return false;
		if (id != other.id)
			return false;
		if (inicio == null) {
			if (other.inicio != null)
				return false;
		} else if (!inicio.equals(other.inicio))
			return false;
		if (iteracoes == null) {
			if (other.iteracoes != null)
				return false;
		} else if (!iteracoes.equals(other.iteracoes))
			return false;
		if (objetivo == null) {
			if (other.objetivo != null)
				return false;
		} else if (!objetivo.equals(other.objetivo))
			return false;
		if (qtdDeAnexos != other.qtdDeAnexos)
			return false;
		if (qtdDeRecados != other.qtdDeRecados)
			return false;
		if (requisitos == null) {
			if (other.requisitos != null)
				return false;
		} else if (!requisitos.equals(other.requisitos))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	public String getAtividade() {
		return atividade;
	}
	public long getDificuldade() {
		return dificuldade;
	}
	public String getEnvio() {
		return envio;
	}
	public Date getFim() {
		return fim;
	}
	public Historia getHistoria() {
		return historia;
	}
	public long getId() {
		return id;
	}
	public Date getInicio() {
		return inicio;
	}
	public Iteracao getIteracoes() {
		return iteracoes;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public long getQtdDeAnexos() {
		return qtdDeAnexos;
	}
	public long getQtdDeRecados() {
		return qtdDeRecados;
	}
	public Requisito getRequisito(int indice) {
		return requisitos.get(indice);
	}
	public List<Requisito> getRequisitos() {
		return requisitos;
	}
	public String getTitulo() {
		return titulo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atividade == null) ? 0 : atividade.hashCode());
		result = prime * result + (int) (dificuldade ^ (dificuldade >>> 32));
		result = prime * result + ((envio == null) ? 0 : envio.hashCode());
		result = prime * result + ((fim == null) ? 0 : fim.hashCode());
		result = prime * result + ((historia == null) ? 0 : historia.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
		result = prime * result + ((iteracoes == null) ? 0 : iteracoes.hashCode());
		result = prime * result + ((objetivo == null) ? 0 : objetivo.hashCode());
		result = prime * result + (int) (qtdDeAnexos ^ (qtdDeAnexos >>> 32));
		result = prime * result + (int) (qtdDeRecados ^ (qtdDeRecados >>> 32));
		result = prime * result + ((requisitos == null) ? 0 : requisitos.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	public void setDificuldade(long dificuldade) {
		this.dificuldade = dificuldade;
	}
	public void setEnvio(String envio) {
		this.envio = envio;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	public void setHistoria(Historia historia) {
		this.historia = historia;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public void setIteracoes(Iteracao iteracoes) {
		this.iteracoes = iteracoes;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public void setQtdDeAnexos(long qtdDeAnexos) {
		this.qtdDeAnexos = qtdDeAnexos;
	}
	public void setQtdDeRecados(long qtdDeRecados) {
		this.qtdDeRecados = qtdDeRecados;
	}
	public void setRequisito(Requisito requisito) {
		this.requisitos.add(requisito);
	}
	public void setRequisitos(List<Requisito> requisitos) {
		this.requisitos = requisitos;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", inicio=" + inicio + ", fim=" + fim + ", dificuldade=" + dificuldade
				+ ", qtdDeAnexos=" + qtdDeAnexos + ", qtdDeRecados=" + qtdDeRecados + ", titulo=" + titulo
				+ ", objetivo=" + objetivo + ", atividade=" + atividade + ", envio=" + envio + ", historia=" + historia
				+ ", requisitos=" + requisitos + ", iteracoes=" + iteracoes + "]";
	}
}