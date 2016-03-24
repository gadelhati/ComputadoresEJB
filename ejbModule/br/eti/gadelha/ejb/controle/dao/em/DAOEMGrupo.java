package br.eti.gadelha.ejb.controle.dao.em;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import br.eti.gadelha.ejb.controle.interfaces.local.DAOLocalGrupo;
import br.eti.gadelha.ejb.controle.modelo.oque.Grupo;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 06/03/2016
 * @see www.gadelha.eti.br
 **/

@Stateful
@LocalBean
public class DAOEMGrupo implements DAOLocalGrupo{
	
	@PersistenceContext(unitName = "controlePU")
	EntityManager em;

	public DAOEMGrupo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean alterar(Grupo objeto) {
		try{
			if(em.find(Grupo.class, objeto.getId()) == null){
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
	public Grupo consultar(Grupo objeto) {
		try{
			return em.find(Grupo.class, objeto.getId());
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean excluir(Grupo objeto) {
		try{
			objeto = em.find(Grupo.class, objeto.getId());
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
	public boolean inserir(Grupo objeto) {
		try{
			if(em.find(Grupo.class, objeto.getId()) == null){
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
	public List<Grupo> listar() {
		try{
			CriteriaQuery criterio = em.getCriteriaBuilder().createQuery();
			criterio.select(criterio.from(Grupo.class));
			return (List<Grupo>) em.createQuery(criterio).getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}