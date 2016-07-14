package br.edu.mk.drogaria.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.mk.drogaria.util.HibernateUtil;

public class DataAccessObject <T>{

	public void salvar(T objeto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.save(objeto);
			transacao.commit();
			
		}catch(RuntimeException exception){
			if(transacao != null)
				transacao.rollback();
			
			System.err.println("Erro ao salvar objeto: " + exception.getMessage());
			
			throw exception;
		}finally{
			sessao.close();
		}
	}
	
}
