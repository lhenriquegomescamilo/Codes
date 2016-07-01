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
}
