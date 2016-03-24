package br.eti.gadelha.ejb.controle.interfaces.local;

import java.util.List;

import javax.ejb.Local;

import br.eti.gadelha.ejb.controle.modelo.oque.quem.Pessoa;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 27/08/2015
 * @see www.gadelha.eti.br
 **/

@Local
public interface DAOLocalPessoa {
	public abstract boolean alterar(Pessoa objeto);
	public abstract Pessoa consultar(Pessoa objeto);
	public abstract boolean excluir(Pessoa objeto);
	public abstract boolean inserir(Pessoa objeto);
	public abstract List<Pessoa> listar();
}