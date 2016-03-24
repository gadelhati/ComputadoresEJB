package br.eti.gadelha.ejb.controle.dao.em;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateless;
//import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.criteria.CriteriaQuery;

//import br.eti.gadelha.ejb.controle.interceptor.TerceiroInterceptador;
import br.eti.gadelha.ejb.controle.interfaces.local.DAOLocalPessoa;
import br.eti.gadelha.ejb.controle.modelo.oque.quem.Pessoa;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 27/08/2015
 * @see www.gadelha.eti.br
 **/

@Stateless//@Stateful(name="DAOEMPessoa", targetNamespace="www.gadelha.eti.br")
@LocalBean//@Remote
//@Interceptors({PrimeiroInterceptador.class, SegundoInterceptador.class})
public class DAOEMPessoa implements DAOLocalPessoa{
	
	@PersistenceContext(unitName = "controlePU")
	EntityManager em;
	
	private static final Logger log = Logger.getLogger(DAOEMPessoa.class.getName());
	@PostConstruct	public void iniciar() 	{	log.info("Construido");	}
	@PreDestroy		public void destruir() 	{	log.info("Destruido");	}
	@PostActivate	public void ativar() 	{	log.info("Ativado");	}
	@PrePassivate	public void desativar() {	log.info("Desativado");	}
	@PostLoad		public void carregar() 	{	log.info("Carregado");	}
	//CRUD
	@PreUpdate		public void alterar() 	{	log.info("Alterar");	}
	@PostUpdate		public void alterado() 	{	log.info("Alterado");	}
	@PreRemove		public void excluir() 	{	log.info("Excluir");	}
	@PostRemove		public void exluido() 	{	log.info("Excluido");	}
	@PrePersist		public void inserir() 	{	log.info("Inserir");	}
	@PostPersist	public void inserido() 	{	log.info("Inserido");	}
	
	public DAOEMPessoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean alterar(Pessoa objeto) {
		try{
			if(em.find(Pessoa.class, objeto.getId()) == null){
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
	public Pessoa consultar(Pessoa objeto) {
		try{
			return em.find(Pessoa.class, objeto.getId());
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean excluir(Pessoa objeto) {
		try{
			objeto = em.find(Pessoa.class, objeto.getId());
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
	//@Interceptors({TerceiroInterceptador.class})
	public boolean inserir(Pessoa objeto) {
		try{
			if(em.find(Pessoa.class, objeto.getId()) == null){
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
	public List<Pessoa> listar() {
		try{
			CriteriaQuery criterio = em.getCriteriaBuilder().createQuery();
			criterio.select(criterio.from(Pessoa.class));
			return (List<Pessoa>) em.createQuery(criterio).getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}