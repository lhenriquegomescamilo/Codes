package br.com.sistema.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sistema.domain.Fabricante;
import br.com.sistema.util.HibernateUtil;

public class FabricanteDAO {
	
	public void salvar(final Fabricante fabricante){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.save(fabricante);
			transacao.commit();
		}catch(Exception e){
			if(transacao != null)
				transacao.rollback();
			
			System.err.println("Falha ao salvar fabricante: " + e.getMessage());
		}finally{
			sessao.close();
		}
	}
	
	public void remover(final Long id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			//sessao.delete(sessao.find(Fabricante.class, id));
			sessao.delete(sessao.load(Fabricante.class, id));
			transacao.commit();
		}catch(Exception e){
			if(transacao != null)
				transacao.rollback();
			
			System.err.println("Falha ao deletar fabricante: " + e.getMessage());
		}finally{
			sessao.close();
		}
	}
}
