package br.eti.gadelha.ejb.controle.interfaces.local;

import java.util.List;

import javax.ejb.Local;

import br.eti.gadelha.ejb.controle.modelo.oque.Grupo;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 06/03/2016
 * @see www.gadelha.eti.br
 **/

@Local
public interface DAOLocalGrupo {
	public abstract boolean alterar(Grupo objeto);
	public abstract Grupo consultar(Grupo objeto);
	public abstract boolean excluir(Grupo objeto);
	public abstract boolean inserir(Grupo objeto);
	public abstract List<Grupo> listar();
}