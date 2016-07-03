package br.com.sistema.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sistema.domain.Funcionario;
import br.com.sistema.util.HibernateUtil;

/**
 * 
 * @author Maikon
 *
 */

public class FuncionarioDAO {
	
	/**
	 * Método para salvar um funcionario.
	 * 
	 * @param funcionario
	 * @return void
	 */
	
	public void salvar(final Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(funcionario);
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
	 * Método para remover um funcionario pelo ID.
	 * 
	 * @param id
	 * @return void
	 */
	public void removerPeloId(final Long id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(sessao.load(Funcionario.class, id));
			transacao.commit();
		}catch(Exception exception){
			if(transacao != null)
				transacao.rollback();
			
			System.err.println("Falha ao salvar funcionario: ");
		}finally{
			sessao.close();
		}
	}
	
	
	/**
	 * Método para remover um funcionario.
	 * 
	 * @param funcionario
	 * @return void
	 */
	public void removerFuncionario(final Funcionario funcionario){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(funcionario);
			transacao.commit();
		}catch(Exception exception){
			if(transacao != null)
				transacao.rollback();
			
			System.err.println("Falha ao remover funcionario: " + exception.getMessage());
		}finally{
			sessao.close();
		}
	}
	
	/**
	 * Método para buscar funcionario pelo ID.
	 * 
	 * @param id
	 * @return Funcionario
	 */
	
	public Funcionario buscarPeloID(final Long id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Funcionario funcionario = null;
		
		try{
			funcionario = sessao.find(Funcionario.class, id);
		}catch(Exception exception){
			throw exception;
		}finally{
			sessao.close();
		}
		
		return funcionario;
	}
	

	/**
	 * Método para buscar todos os funcionarios.
	 * 
	 * @param void
	 * @return List<Funcionario>
	 */
	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarTodos(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Funcionario> funcionarios = null;
		
		try{
			funcionarios = sessao.createQuery("SELECT funcionario FROM Funcionario funcionario").getResultList();
		}catch(Exception exception){
			throw exception;
		}finally{
			sessao.close();
		}
		
		return funcionarios;
	}
	
	/**
	 * Método para atualizar funcionario
	 * 
	 * @param funcionario
	 * @return void
	 */
	public void atualizarFuncionario(final Funcionario funcionario){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(funcionario);
			transacao.commit();
		}catch(Exception exception){
			if(transacao != null)
				transacao.rollback();
			
			System.err.println("Falha ao atualizar funcionario: " + exception.getMessage());
		}finally{
			sessao.close();
		}
	}
}
