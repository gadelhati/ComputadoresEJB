package br.eti.gadelha.ejb.controle.interfaces.local;

import java.util.List;

import javax.ejb.Local;

import br.eti.gadelha.ejb.controle.modelo.oque.Ferramenta;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 05/12/2015
 * @see www.gadelha.eti.br
 **/

@Local
public interface DAOLocalFerramenta {
	public abstract boolean alterar(Ferramenta objeto);
	public abstract Ferramenta consultar(Ferramenta objeto);
	public abstract boolean excluir(Ferramenta objeto);
	public abstract boolean inserir(Ferramenta objeto);
	public abstract List<Ferramenta> listar();
}