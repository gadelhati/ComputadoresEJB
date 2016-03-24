package br.eti.gadelha.ejb.controle.interfaces.local;

import java.util.List;

import javax.ejb.Local;

import br.eti.gadelha.ejb.controle.modelo.oque.quem.PessoaFisica;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 27/08/2015
 * @see www.gadelha.eti.br
 **/

@Local
public interface DAOLocalPessoaFisica {
	public abstract boolean alterar(PessoaFisica objeto);
	public abstract PessoaFisica consultar(PessoaFisica objeto);
	public abstract boolean excluir(PessoaFisica objeto);
	public abstract boolean inserir(PessoaFisica objeto);
	public abstract List<PessoaFisica> listar();
}