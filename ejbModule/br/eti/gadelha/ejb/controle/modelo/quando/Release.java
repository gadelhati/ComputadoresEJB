package br.eti.gadelha.ejb.controle.modelo.quando;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 14/10/2015
 * @see www.gadelha.eti.br
 **/

@Entity
@Table(name="release")
public class Release implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @Column(length=16, nullable = false, unique = true)
	private long id;
}