package br.eti.gadelha.ejb.controle.dao.em;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import br.eti.gadelha.ejb.controle.interfaces.local.DAOLocalFuncao;
import br.eti.gadelha.ejb.controle.modelo.como.Funcao;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 04/03/2016
 * @see www.gadelha.eti.br
 **/

@Stateful
@LocalBean
public class DAOEMFuncao implements DAOLocalFuncao{
	
	@PersistenceContext(unitName = "controlePU")
	EntityManager em;

	public DAOEMFuncao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean alterar(Funcao objeto) {
		try{
			if(em.find(Funcao.class, objeto.getId()) == null){
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
	public Funcao consultar(Funcao objeto) {
		try{
			return em.find(Funcao.class, objeto.getId());
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean excluir(Funcao objeto) {
		try{
			objeto = em.find(Funcao.class, objeto.getId());
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
	public boolean inserir(Funcao objeto) {
		try{
			if(em.find(Funcao.class, objeto.getId()) == null){
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
	public List<Funcao> listar() {
		try{
			CriteriaQuery criterio = em.getCriteriaBuilder().createQuery();
			criterio.select(criterio.from(Funcao.class));
			return (List<Funcao>) em.createQuery(criterio).getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}