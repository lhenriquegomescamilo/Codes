package br.edu.mk.droagaria.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.mk.drogaria.dao.DataAccessObject;
import br.edu.mk.drogaria.domain.Fabricante;

public class FabricanteDataAccessObjectTest {
	
	@Test
	@Ignore
	public void save(){
		
		for(int i = 0; i < 200; i++)
			new DataAccessObject<Fabricante, Long>(Fabricante.class).save(new Fabricante("FABRICANTE " + i));
	}
	
	@Test
	@Ignore
	public void update(){
		new DataAccessObject<Fabricante, Long>(Fabricante.class).update(new Fabricante(38L, "EMPRESA A"));
	}
	
	@Test
	@Ignore
	public void findAll(){
		new DataAccessObject<Fabricante, Long>(Fabricante.class).findAll().stream().forEach(f -> System.out.println(f));
	}
	
	@Test
	@Ignore
	public void search(){
		System.out.println(new DataAccessObject<Fabricante, Long>(Fabricante.class).search(50L));
	}
	
	@Test
	@Ignore
	public void delete(){
		new DataAccessObject<Fabricante, Long>(Fabricante.class).delete(49L);
		System.out.println(new DataAccessObject<Fabricante, Long>(Fabricante.class).search(49L));
	}
	
	@Test
	@Ignore
	public void deleteObject(){
		new DataAccessObject<Fabricante, Long>(Fabricante.class).delete(new Fabricante(31L, "EMPRESA 30"));
	}
	
	
}
