package br.eti.gadelha.ejb.controle.modelo.oque.quem;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.eti.gadelha.ejb.controle.modelo.como.Funcao;
import br.eti.gadelha.ejb.controle.modelo.oque.Cargo;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 27/08/2015
 * @see www.gadelha.eti.br
 **/

@Entity
@Table(name="usuario")
@PrimaryKeyJoinColumn(name = "id")
public class Usuario extends Cargo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Column(length=16)
	private String apelido;
	@Column(length=16, nullable = false, unique = true)
	private String email;
	@Column(length=16, nullable = false)
	private String senha;
	@Column(length=16, nullable = false)
	private String nivelDeAcesso;//CLIENTE, ADMINISTRADOR, GESTOR, GERENTE, OPERADOR(local e geral), VOLUNTÁRIO
	@Temporal(TemporalType.DATE)
	private Date cadastro;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(long id, String nome, Date horasDia, int influencia, List<Funcao> funcoes) {
		super(id, nome, horasDia, influencia, funcoes);
		// TODO Auto-generated constructor stub
	}
	public Usuario(String apelido, String email, String senha, String nivelDeAcesso, Date cadastro) {
		super();
		this.apelido = apelido;
		this.email = email;
		this.senha = senha;
		this.nivelDeAcesso = nivelDeAcesso;
		this.cadastro = cadastro;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (apelido == null) {
			if (other.apelido != null)
				return false;
		} else if (!apelido.equals(other.apelido))
			return false;
		if (cadastro == null) {
			if (other.cadastro != null)
				return false;
		} else if (!cadastro.equals(other.cadastro))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nivelDeAcesso == null) {
			if (other.nivelDeAcesso != null)
				return false;
		} else if (!nivelDeAcesso.equals(other.nivelDeAcesso))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
	public String getApelido() {
		return apelido;
	}
	public Date getCadastro() {
		return cadastro;
	}
	public String getEmail() {
		return email;
	}
	public String getNivelDeAcesso() {
		return nivelDeAcesso;
	}
	public String getSenha() {
		return senha;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		result = prime * result + ((cadastro == null) ? 0 : cadastro.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nivelDeAcesso == null) ? 0 : nivelDeAcesso.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNivelDeAcesso(String nivelDeAcesso) {
		this.nivelDeAcesso = nivelDeAcesso;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "Usuario [apelido=" + apelido + ", email=" + email + ", senha=" + senha + ", nivelDeAcesso="
				+ nivelDeAcesso + ", cadastro=" + cadastro + "]";
	}
}