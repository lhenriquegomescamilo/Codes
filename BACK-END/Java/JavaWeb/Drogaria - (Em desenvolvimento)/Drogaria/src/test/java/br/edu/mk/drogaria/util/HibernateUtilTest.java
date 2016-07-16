package br.edu.mk.drogaria.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {

	@Test
	public void SessionFactoryTest(){
		try{
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			sessao.close();
		}catch(Exception e){
			System.err.println("Erro no teste SessionFactory: " + e.getMessage());
		}
	}
	
}
