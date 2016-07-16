package br.com.system.test;

import org.junit.Test;

import br.com.system.util.HibernateUtil;

public class HibernateUtilTest {
	@Test
	public void testeConexaoHibernate(){
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
}
