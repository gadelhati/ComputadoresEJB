package br.eti.gadelha.ejb.controle.interfaces.local;

import java.util.List;

import javax.ejb.Local;

import br.eti.gadelha.ejb.controle.modelo.oque.quem.Usuario;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 27/08/2015
 * @see www.gadelha.eti.br
 **/

@Local
public interface DAOLocalUsuario {
	public abstract boolean alterar(Usuario objeto);
	public abstract Usuario consultar(Usuario objeto);
	public abstract boolean excluir(Usuario objeto);
	public abstract boolean inserir(Usuario objeto);
	public abstract List<Usuario> listar();
}