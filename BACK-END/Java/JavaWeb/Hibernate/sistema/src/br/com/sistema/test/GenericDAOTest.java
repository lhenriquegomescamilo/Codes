package br.com.sistema.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sistema.domain.Fabricante;
import br.com.sistema.domain.Funcionario;
import br.com.sistema.generico.GenericDAO;

public class GenericDAOTest {
	
	@Test
	public void saveTest(){
		GenericDAO<Fabricante, Long> dao = new GenericDAO<>(Fabricante.class);
		dao.save(new Fabricante("EMPRESA GOOGLE"));
		dao.save(new Fabricante("EMPRESA CENTRAL T.I"));
		
		new GenericDAO<>(Fabricante.class).findAll().stream().forEach(f -> System.out.println(f));
	}
	
	@Test
	@Ignore
	public void finAllTest(){
		new GenericDAO<>(Funcionario.class).findAll().stream().forEach(f -> System.out.println(f));
	}
}
