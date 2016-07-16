package br.edu.mk.droagaria.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.mk.drogaria.dao.DataAccessObject;
import br.edu.mk.drogaria.domain.Cidade;
import br.edu.mk.drogaria.domain.Estado;

public class CidadeDataAccessObjectTest {
	
	@Test
	@Ignore
	public void save(){
		for(int i = 0; i < 25; i++)
			new DataAccessObject<Cidade, Long>(Cidade.class).save(new Cidade("CIDADE", new DataAccessObject<Estado, Long>(Estado.class).search(1L)));
	}
	
	@Test
	@Ignore
	public void update(){
		new DataAccessObject<Cidade, Long>(Cidade.class).update(new Cidade(229L, "LAPA", new DataAccessObject<Estado, Long>(Estado.class).search(206L)));
	}
	
	@Test
	@Ignore
	public void findAll(){
		new DataAccessObject<Cidade, Long>(Cidade.class).findAll().stream().forEach(Cidade -> System.out.println(Cidade));
	}
	
	@Test
	@Ignore
	public void search(){
		System.out.println(new DataAccessObject<Cidade, Long>(Cidade.class).search(235L));
	}
	
	@Test
	@Ignore
	public void delete(){
		new DataAccessObject<Cidade, Long>(Cidade.class).delete(235L);
		System.out.println(new DataAccessObject<Cidade, Long>(Cidade.class).search(235L));
	}
	
	@Test
	@Ignore
	public void deleteObject(){
		new DataAccessObject<Cidade, Long>(Cidade.class).delete(new Cidade(255L, "CIDADE", new DataAccessObject<Estado, Long>(Estado.class).search(206L)));
	}
	
	
}
