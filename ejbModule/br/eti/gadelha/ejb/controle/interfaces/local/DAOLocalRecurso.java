package br.eti.gadelha.ejb.controle.interfaces.local;

import java.util.List;

import javax.ejb.Local;

import br.eti.gadelha.ejb.controle.modelo.oque.Recurso;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 27/08/2015
 * @see www.gadelha.eti.br
 **/

@Local
public interface DAOLocalRecurso {
	public abstract boolean alterar(Recurso objeto);
	public abstract Recurso consultar(Recurso objeto);
	public abstract boolean excluir(Recurso objeto);
	public abstract boolean inserir(Recurso objeto);
	public abstract List<Recurso> listar();
}