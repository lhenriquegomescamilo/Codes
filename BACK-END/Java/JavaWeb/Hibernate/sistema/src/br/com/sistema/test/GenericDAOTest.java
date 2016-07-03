package br.com.sistema.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sistema.domain.Fabricante;
import br.com.sistema.domain.Funcionario;
import br.com.sistema.generico.GenericDAO;

public class GenericDAOTest {
	
	
	
	@Test
	@Ignore
	public void saveTest(){
		GenericDAO<Fabricante, Long> dao = new GenericDAO<>(Fabricante.class);
		dao.save(new Fabricante("EMPRESA GOOGLE"));
		dao.save(new Fabricante("EMPRESA CENTRAL T.I"));
		
		new GenericDAO<>(Fabricante.class).findAll().stream().forEach(f -> System.out.println(f));
	}
	
	@Test
	@Ignore
	public void updateTest(){
		GenericDAO<Fabricante, Long> dao = new GenericDAO<>(Fabricante.class);
		Fabricante fabricante = new Fabricante();
		fabricante.setCodigo(4L);
		fabricante.setDescricao("GOOGLE");
		
		dao.update(fabricante);
		
		new GenericDAO<>(Fabricante.class).findAll().stream().forEach(f -> System.out.println(f));
	}
	
	@Test
	@Ignore
	public void searchTest(){
		GenericDAO<Fabricante, Long> dao = new GenericDAO<>(Fabricante.class);
		System.out.println(dao.search(4L));
	}
	
	@Test
	@Ignore
	public void finAllTest(){
		new GenericDAO<>(Funcionario.class).findAll().stream().forEach(f -> System.out.println(f));
		new GenericDAO<>(Fabricante.class).findAll().stream().forEach(f -> System.out.println(f));
	}
	
	@Test
	@Ignore
	public void deleteIdentifier(){
		GenericDAO<Fabricante, Long> dao = new GenericDAO<>(Fabricante.class);
		dao.delete(4L);
		
		new GenericDAO<>(Fabricante.class).findAll().stream().forEach(f -> System.out.println(f));
	}
	
	@Test
	@Ignore
	public void deleteObject(){
		GenericDAO<Fabricante, Long> dao = new GenericDAO<>(Fabricante.class);
		dao.delete(new Fabricante(28L, "EMPRESA CENTRAL T.I"));
		
		new GenericDAO<>(Fabricante.class).findAll().stream().forEach(f -> System.out.println(f));
	}
}
