package br.edu.mk.droagaria.dao;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.mk.drogaria.dao.DataAccessObject;
import br.edu.mk.drogaria.domain.Cliente;
import br.edu.mk.drogaria.domain.Pessoa;

public class ClienteDataAccessObjectTest {

	@Test
	@Ignore
	public void save() {
		Cliente cliente = new Cliente();

		cliente.setDataCadastro(new Date());
		cliente.setLiberado(false);
		cliente.setPessoa(new DataAccessObject<>(Pessoa.class).search(54L));

		new DataAccessObject<>(Cliente.class).save(cliente);
	}

	@Test
	@Ignore
	public void update() {
		Cliente cliente = new Cliente();
		
		cliente.setPrimaryKey(59L);
		cliente.setDataCadastro(new Date());
		cliente.setLiberado(true);
		cliente.setPessoa(new DataAccessObject<>(Pessoa.class).search(54L));

		new DataAccessObject<>(Cliente.class).update(cliente);
	}
	
	@Test
	@Ignore
	public void findAll(){
		new DataAccessObject<>(Cliente.class)
		.findAll()
		.stream()
		.forEach(cliente -> System.out.println(cliente));
	}
	
	@Test
	@Ignore
	public void find(){
		System.out.println(new DataAccessObject<>(Cliente.class).search(59L));
	}
	
	@Test
	@Ignore
	public void delete(){
		new DataAccessObject<>(Cliente.class).delete(59L);
		System.out.println(new DataAccessObject<>(Cliente.class).search(59L));
	}
	
}
