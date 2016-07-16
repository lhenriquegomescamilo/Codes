package br.edu.mk.droagaria.dao;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.mk.drogaria.dao.DataAccessObject;
import br.edu.mk.drogaria.domain.Funcionario;
import br.edu.mk.drogaria.domain.ItemVenda;
import br.edu.mk.drogaria.domain.Produto;

public class ItemVendaDataAccessObjectTest {

	@Test
	@Ignore
	public void save() {

		ItemVenda itemVenda = new ItemVenda();

		itemVenda.setFuncionario(new DataAccessObject<>(Funcionario.class).search(57L));
		itemVenda.setProduto(new DataAccessObject<>(Produto.class).search(263L));
		itemVenda.setQuantidade(new Short("58"));
		itemVenda.setValorParcial(new BigDecimal(300D));

		new DataAccessObject<>(ItemVenda.class).save(itemVenda);
	}

	@Test
	@Ignore
	public void update() {
		ItemVenda itemVenda = new ItemVenda();

		itemVenda.setPrimaryKey(314L);
		itemVenda.setFuncionario(new DataAccessObject<>(Funcionario.class).search(57L));
		itemVenda.setProduto(new DataAccessObject<>(Produto.class).search(263L));
		itemVenda.setQuantidade(new Short("58"));
		itemVenda.setValorParcial(new BigDecimal(99999D));

		new DataAccessObject<>(ItemVenda.class).update(itemVenda);
	}

	@Test
	@Ignore
	public void findAll(){
		new DataAccessObject<>(ItemVenda.class)
		.findAll()
		.stream()
		.forEach(item -> System.out.println(item));
	}
	
	@Test
	@Ignore
	public void find(){
		System.out.println(new DataAccessObject<>(ItemVenda.class).search(314L));
	}
	
	@Test
	@Ignore
	public void delete(){
		new DataAccessObject<>(ItemVenda.class).delete(314L);
		System.out.println(new DataAccessObject<>(ItemVenda.class).search(314L));
	}
	
}
