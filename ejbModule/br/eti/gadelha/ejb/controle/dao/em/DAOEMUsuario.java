package br.eti.gadelha.ejb.controle.dao.em;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import br.eti.gadelha.ejb.controle.interfaces.local.DAOLocalUsuario;
import br.eti.gadelha.ejb.controle.modelo.oque.quem.Usuario;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 27/08/2015
 * @see www.gadelha.eti.br
 **/

@Stateful
@LocalBean
public class DAOEMUsuario implements DAOLocalUsuario{
	
	@PersistenceContext(unitName = "controlePU")
	EntityManager em;

	public DAOEMUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean alterar(Usuario objeto) {
		try{
			if(em.find(Usuario.class, objeto.getId()) == null){
				return false;
			}else{
				em.merge(objeto);
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Usuario consultar(Usuario objeto) {
		try{
			return em.find(Usuario.class, objeto.getId());
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean excluir(Usuario objeto) {
		try{
			objeto = em.find(Usuario.class, objeto.getId());
			if(objeto == null){
				return false;
			}else{
				
				em.remove(objeto);
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean inserir(Usuario objeto) {
		try{
			if(em.find(Usuario.class, objeto.getId()) == null){
				em.persist(objeto);
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Usuario> listar() {
		try{
			CriteriaQuery criterio = em.getCriteriaBuilder().createQuery();
			criterio.select(criterio.from(Usuario.class));
			return (List<Usuario>) em.createQuery(criterio).getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}