package br.eti.gadelha.ejb.controle.interfaces.local;

import java.util.List;

import javax.ejb.Local;

import br.eti.gadelha.ejb.controle.modelo.oque.Cargo;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 27/08/2015
 * @see www.gadelha.eti.br
 **/

@Local
public interface DAOLocalCargo {
	public abstract boolean alterar(Cargo objeto);
	public abstract Cargo consultar(Cargo objeto);
	public abstract boolean excluir(Cargo objeto);
	public abstract boolean inserir(Cargo objeto);
	public abstract List<Cargo> listar();
}