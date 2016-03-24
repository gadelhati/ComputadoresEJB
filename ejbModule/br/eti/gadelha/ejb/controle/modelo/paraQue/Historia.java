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

//PRODUCT BACKLOG ITENS: conjunto de tarefas

@Entity
@Table(name="historia")
public class Historia implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id @Column(length=16, nullable = false, unique = true)
	private long id;
	@Column(length=16, nullable = false)
	private long prioridade;
	@ManyToOne(cascade=CascadeType.ALL)
	private Projeto projeto;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Tarefa> tarefas;
	
	public Historia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Historia(long id, long prioridade, Projeto projeto, List<Tarefa> tarefas) {
		super();
		this.id = id;
		this.prioridade = prioridade;
		this.projeto = projeto;
		this.tarefas = tarefas;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Historia other = (Historia) obj;
		if (id != other.id)
			return false;
		if (prioridade != other.prioridade)
			return false;
		if (projeto == null) {
			if (other.projeto != null)
				return false;
		} else if (!projeto.equals(other.projeto))
			return false;
		if (tarefas == null) {
			if (other.tarefas != null)
				return false;
		} else if (!tarefas.equals(other.tarefas))
			return false;
		return true;
	}
	public long getId() {
		return id;
	}
	public long getPrioridade() {
		return prioridade;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public Tarefa getTarefa(int indice) {
		return tarefas.get(indice);
	}
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (prioridade ^ (prioridade >>> 32));
		result = prime * result + ((projeto == null) ? 0 : projeto.hashCode());
		result = prime * result + ((tarefas == null) ? 0 : tarefas.hashCode());
		return result;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setPrioridade(long prioridade) {
		this.prioridade = prioridade;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	public void setTarefa(Tarefa tarefa) {
		this.tarefas.add(tarefa);
	}
	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	@Override
	public String toString() {
		return "Historia [id=" + id + ", prioridade=" + prioridade + ", projeto=" + projeto + ", tarefas=" + tarefas
				+ "]";
	}
}