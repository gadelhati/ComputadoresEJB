package br.eti.gadelha.ejb.controle.dao.em;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import br.eti.gadelha.ejb.controle.interfaces.local.DAOLocalRecurso;
import br.eti.gadelha.ejb.controle.modelo.oque.Recurso;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 27/08/2015
 * @see www.gadelha.eti.br
 **/

@Stateful
@LocalBean
public class DAOEMRecurso implements DAOLocalRecurso{
	
	@PersistenceContext(unitName = "controlePU")
	EntityManager em;

	public DAOEMRecurso() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean alterar(Recurso objeto) {
		try{
			if(em.find(Recurso.class, objeto.getId()) == null){
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
	public Recurso consultar(Recurso objeto) {
		try{
			return em.find(Recurso.class, objeto.getId());
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean excluir(Recurso objeto) {
		try{
			objeto = em.find(Recurso.class, objeto.getId());
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
	public boolean inserir(Recurso objeto) {
		try{
			if(em.find(Recurso.class, objeto.getId()) == null){
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
	public List<Recurso> listar() {
		try{
			CriteriaQuery criterio = em.getCriteriaBuilder().createQuery();
			criterio.select(criterio.from(Recurso.class));
			return (List<Recurso>) em.createQuery(criterio).getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}