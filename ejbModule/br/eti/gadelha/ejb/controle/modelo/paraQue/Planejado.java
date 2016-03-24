package br.eti.gadelha.ejb.controle.modelo.paraQue;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 14/10/2015
 * @see www.gadelha.eti.br
 **/

@Entity
@Table(name="planejado")
@PrimaryKeyJoinColumn(name = "id")
public class Planejado extends Tarefa implements Serializable {
	private static final long serialVersionUID = 1L;
	
}