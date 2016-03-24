package br.eti.gadelha.ejb.controle.dao.em;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import br.eti.gadelha.ejb.controle.interfaces.local.DAOLocalFerramenta;
import br.eti.gadelha.ejb.controle.modelo.oque.Ferramenta;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 05/12/2015
 * @see www.gadelha.eti.br
 **/

@Stateful
@LocalBean
public class DAOEMFerramenta implements DAOLocalFerramenta{
	
	@PersistenceContext(unitName = "controlePU")
	EntityManager em;

	public DAOEMFerramenta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean alterar(Ferramenta objeto) {
		try{
			if(em.find(Ferramenta.class, objeto.getId()) == null){
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
	public Ferramenta consultar(Ferramenta objeto) {
		try{
			return em.find(Ferramenta.class, objeto.getId());
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean excluir(Ferramenta objeto) {
		try{
			objeto = em.find(Ferramenta.class, objeto.getId());
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
	public boolean inserir(Ferramenta objeto) {
		try{
			if(em.find(Ferramenta.class, objeto.getId()) == null){
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
	public List<Ferramenta> listar() {
		try{
			CriteriaQuery criterio = em.getCriteriaBuilder().createQuery();
			criterio.select(criterio.from(Ferramenta.class));
			return (List<Ferramenta>) em.createQuery(criterio).getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}