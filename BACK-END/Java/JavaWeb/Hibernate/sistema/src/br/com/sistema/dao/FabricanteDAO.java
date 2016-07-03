package br.com.sistema.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sistema.domain.Fabricante;
import br.com.sistema.util.HibernateUtil;

/**
 * Classe para operações de persistência para Fabricante. 
 * 
 * @author Maikon
 *
 */

public class FabricanteDAO {

	/**
	 * Método para salvar um fabricante. 
	 * 
	 * @param fabricante
	 * @return void
	 */
	public void salvar(final Fabricante fabricante) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(fabricante);
			transacao.commit();
		} catch (Exception exception) {
			if (transacao != null)
				transacao.rollback();

			System.err.println("Falha ao salvar fabricante: " + exception.getMessage());
		} finally {
			sessao.close();
		}
	}

	/**
	 * Método para remover um fabricante pelo ID. 
	 * 
	 * @param id
	 * @return void
	 */
	public void removerFabricantePeloID(final Long id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(sessao.load(Fabricante.class, id));
			transacao.commit();
		} catch (Exception exception) {
			if (transacao != null)
				transacao.rollback();

			System.err.println("Falha ao deletar fabricante: " + exception.getMessage());
		} finally {
			sessao.close();
		}
	}

	/**
	 * Método para remover o fabricante.
	 * 
	 * @param fabricante
	 * @return void
	 */
	public void removerFabricante(final Fabricante fabricante) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(fabricante);
			transacao.commit();
		} catch (Exception exception) {
			if (transacao != null)
				transacao.rollback();

			System.err.println("Falha ao deletar fabricante: " + exception.getMessage());
		} finally {
			sessao.close();
		}
	}

	/**
	 * Método para listar todos os fabricantes. 
	 * 
	 * @param void
	 * @return List<Fabricante>
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Fabricante> fabricantes = null;

		try {
			fabricantes = sessao.createQuery("SELECT fabricante FROM Fabricante fabricante").getResultList();
		} catch (Exception exception) {
			throw exception;
		} finally {
			sessao.close();
		}

		return fabricantes;
	}

	
	/**
	 * Método para buscar fabricante pelo ID.
	 * 
	 * @param id
	 * @return fabricante
	 */
	public Fabricante buscarPeloID(final Long id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Fabricante fabricante = null;

		try {
			fabricante = sessao.find(Fabricante.class, id);
		} catch (Exception exception) {
			System.err.println("Falha ao buscar fabricante: " + exception.getMessage());
		} finally {
			sessao.close();
		}

		return fabricante;
	}
	
	/**
	 * Método para atualizar/editar Fabricante 
	 * 
	 * @param fabricante
	 * @return void
	 */
	public void atualizarFabricante(final Fabricante fabricante){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(fabricante);
			transacao.commit();
		}catch(Exception exception){
			if(transacao != null)
				transacao.rollback();
			
			System.err.println("Falha ao atualizar Fabricante: " + exception.getMessage());
		}finally{
			sessao.close();
		}
	}
}
