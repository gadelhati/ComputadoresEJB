package br.eti.gadelha.ejb.controle.dao.em;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import br.eti.gadelha.ejb.controle.interfaces.local.DAOLocalCargo;
import br.eti.gadelha.ejb.controle.modelo.oque.Cargo;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 05/12/2015
 * @see www.gadelha.eti.br
 **/

@Stateful
@LocalBean
public class DAOEMCargo implements DAOLocalCargo{
	
	@PersistenceContext(unitName = "controlePU")
	EntityManager em;

	public DAOEMCargo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean alterar(Cargo objeto) {
		try{
			if(em.find(Cargo.class, objeto.getId()) == null){
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
	public Cargo consultar(Cargo objeto) {
		try{
			return em.find(Cargo.class, objeto.getId());
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean excluir(Cargo objeto) {
		try{
			objeto = em.find(Cargo.class, objeto.getId());
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
	public boolean inserir(Cargo objeto) {
		try{
			if(em.find(Cargo.class, objeto.getId()) == null){
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
	public List<Cargo> listar() {
		try{
			CriteriaQuery criterio = em.getCriteriaBuilder().createQuery();
			criterio.select(criterio.from(Cargo.class));
			return (List<Cargo>) em.createQuery(criterio).getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}