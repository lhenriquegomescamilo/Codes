package br.edu.mk.droagaria.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.mk.drogaria.dao.DataAccessObject;
import br.edu.mk.drogaria.domain.Estado;

public class EstadoDataAccessObjectTest {
	
	@Test
	@Ignore
	public void save(){
		
		Estado estado = new Estado();
		estado.setNome("DISTRITO FEDERAL");
		estado.setSigla("DF");
		
		for(int i = 0; i < 25; i++)
			new DataAccessObject<Estado, Long>(Estado.class).save(estado);
	}
	
	@Test
	@Ignore
	public void update(){
		new DataAccessObject<Estado, Long>(Estado.class).update(new Estado(206L, "RJ", "RIO DE JANEIRO"));
	}
	
	@Test
	@Ignore
	public void findAll(){
		new DataAccessObject<Estado, Long>(Estado.class).findAll().stream().forEach(estado -> System.out.println(estado));
	}
	
	@Test
	@Ignore
	public void search(){
		System.out.println(new DataAccessObject<Estado, Long>(Estado.class).search(206L));
	}
	
	@Test
	@Ignore
	public void delete(){
		new DataAccessObject<Estado, Long>(Estado.class).delete(204L);
		System.out.println(new DataAccessObject<Estado, Long>(Estado.class).search(204L));
	}
	
	@Test
	@Ignore
	public void deleteObject(){
		new DataAccessObject<Estado, Long>(Estado.class).delete(new Estado(205L, "DF", "DISTRITO FEDERAL"));
	}
	
}
