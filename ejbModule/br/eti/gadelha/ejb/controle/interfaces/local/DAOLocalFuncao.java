package br.eti.gadelha.ejb.controle.interfaces.local;

import java.util.List;

import javax.ejb.Local;

import br.eti.gadelha.ejb.controle.modelo.como.Funcao;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 04/03/2016
 * @see www.gadelha.eti.br
 **/

@Local
public interface DAOLocalFuncao {
	public abstract boolean alterar(Funcao objeto);
	public abstract Funcao consultar(Funcao objeto);
	public abstract boolean excluir(Funcao objeto);
	public abstract boolean inserir(Funcao objeto);
	public abstract List<Funcao> listar();
}