package br.com.sistema.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sistema.domain.Manufacturer;
import br.com.sistema.domain.Employee;
import br.com.sistema.generico.GenericDAO;

public class GenericDAOTest {
	
	@Test
	@Ignore
	public void saveTest(){
		GenericDAO<Manufacturer, Long> dao = new GenericDAO<>(Manufacturer.class);
		dao.save(new Manufacturer("EMPRESA GOOGLE"));
		dao.save(new Manufacturer("EMPRESA CENTRAL T.I"));
		
		new GenericDAO<>(Manufacturer.class).findAll().stream().forEach(f -> System.out.println(f));
	}
	
	@Test
	@Ignore
	public void updateTest(){
		GenericDAO<Manufacturer, Long> dao = new GenericDAO<>(Manufacturer.class);
		Manufacturer fabricante = new Manufacturer();
		fabricante.setCode(4L);
		fabricante.setDescription("GOOGLE");
		
		dao.update(fabricante);
		
		new GenericDAO<>(Manufacturer.class).findAll().stream().forEach(f -> System.out.println(f));
	}
	
	@Test
	@Ignore
	public void searchTest(){
		GenericDAO<Manufacturer, Long> dao = new GenericDAO<>(Manufacturer.class);
		System.out.println(dao.search(4L));
	}
	
	@Test
	@Ignore
	public void finAllTest(){
		new GenericDAO<>(Employee.class).findAll().stream().forEach(f -> System.out.println(f));
		new GenericDAO<>(Manufacturer.class).findAll().stream().forEach(f -> System.out.println(f));
	}
	
	@Test
	@Ignore
	public void deleteIdentifier(){
		GenericDAO<Manufacturer, Long> dao = new GenericDAO<>(Manufacturer.class);
		dao.delete(4L);
		
		new GenericDAO<>(Manufacturer.class).findAll().stream().forEach(f -> System.out.println(f));
	}
	
	@Test
	@Ignore
	public void deleteObject(){
		GenericDAO<Manufacturer, Long> dao = new GenericDAO<>(Manufacturer.class);
		dao.delete(new Manufacturer(28L, "EMPRESA CENTRAL T.I"));
		
		new GenericDAO<>(Manufacturer.class).findAll().stream().forEach(f -> System.out.println(f));
	}
}
