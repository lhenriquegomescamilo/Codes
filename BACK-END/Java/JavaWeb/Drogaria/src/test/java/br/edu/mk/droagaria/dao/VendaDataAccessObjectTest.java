package br.edu.mk.droagaria.dao;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.mk.drogaria.dao.DataAccessObject;
import br.edu.mk.drogaria.domain.Cliente;
import br.edu.mk.drogaria.domain.Funcionario;
import br.edu.mk.drogaria.domain.Venda;

public class VendaDataAccessObjectTest {

	@Test
	@Ignore
	public void save() {
		Venda venda = new Venda();

		venda.setHorario(new Date());
		venda.setCliente(new DataAccessObject<>(Cliente.class).search(58L));
		venda.setFuncionario(new DataAccessObject<>(Funcionario.class).search(57L));
		venda.setValorTotal(new BigDecimal(500D));

		new DataAccessObject<>(Venda.class).save(venda);
	}

	@Test
	@Ignore
	public void update() {
		Venda venda = new Venda();
		
		venda.setPrimaryKey(311L);
		venda.setHorario(new Date());
		venda.setCliente(new DataAccessObject<>(Cliente.class).search(58L));
		venda.setFuncionario(new DataAccessObject<>(Funcionario.class).search(57L));
		venda.setValorTotal(new BigDecimal(6000D));

		new DataAccessObject<>(Venda.class).update(venda);
	}
	
	@Test
	@Ignore
	public void findAll(){
		new DataAccessObject<>(Venda.class)
		.findAll()
		.stream()
		.forEach(venda -> System.out.println(venda));
	}

	@Test
	@Ignore
	public void find(){
		System.out.println(new DataAccessObject<>(Venda.class).search(312L));
	}
	
	@Test
	@Ignore
	public void delete(){
		new DataAccessObject<>(Venda.class).delete(312L);
		System.out.println(new DataAccessObject<>(Venda.class).search(312L));
	}
	
}
