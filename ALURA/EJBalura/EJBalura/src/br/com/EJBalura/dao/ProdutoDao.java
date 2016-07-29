package br.com.EJBalura.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.EJBalura.modelo.Produto;

@Stateless
public class ProdutoDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Produto produto){
		entityManager.persist(produto);
	}
	
	public Produto procurar(Long id){
		return entityManager.find(Produto.class, id);
	}
	
	
}
