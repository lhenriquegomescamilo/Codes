package br.com.sistema.test;

import org.junit.Test;

import br.com.sistema.util.HibernateUtil;

public class HibernateUtilTest {
	@Test
	public void testeConexaoHibernate(){
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
}
