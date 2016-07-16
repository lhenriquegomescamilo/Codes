package br.edu.mk.droagaria.dao;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.mk.drogaria.dao.DataAccessObject;
import br.edu.mk.drogaria.domain.Fabricante;
import br.edu.mk.drogaria.domain.Produto;

public class ProdutoDataAccessObjectTest {
	
	@Test
	@Ignore
	public void save(){
		
		for(int i = 0; i < 50; i++){
			Produto produto = new Produto();
			produto.setDescricao("PRODUTO " + i);
			produto.setPreco(new BigDecimal(20D));
			produto.setQuantidade(new Short(String.valueOf(i)));
			produto.setFabricante(new DataAccessObject<Fabricante, Long>(Fabricante.class).search(246L));
			new DataAccessObject<Produto, Long>(Produto.class).save(produto);
		}
	}
	
	@Test
	@Ignore
	public void update(){
		Produto produto = new Produto();
		
		produto.setPrimaryKey(279L);
		produto.setFabricante(new DataAccessObject<Fabricante, Long>(Fabricante.class).search(38L));
		produto.setPreco(new BigDecimal(50D));
		produto.setDescricao("PRODUTO X");
		produto.setQuantidade(new Short("25"));
		
		new DataAccessObject<>(Produto.class).update(produto);
	}
	
	@Test
	@Ignore
	public void findAll(){
		new DataAccessObject<Produto, Long>(Produto.class).findAll().stream().forEach(produto -> System.out.println(produto));
	}
	
	@Test
	@Ignore
	public void search(){
		System.out.println(new DataAccessObject<>(Produto.class).search(279L));
	}
	
	@Test
	@Ignore
	public void deleteObject(){
		Produto produto = new Produto();
		produto.setPrimaryKey(310L);
		produto.setDescricao("PRODUTO 31");
		produto.setFabricante(new DataAccessObject<Fabricante, Long>(Fabricante.class).search(38L));
		produto.setQuantidade(new Short("31"));
		produto.setPreco(new BigDecimal(20D));
		
		new DataAccessObject<Produto, Long>(Produto.class).delete(produto);
		
		System.out.println(new DataAccessObject<>(Produto.class).search(310L));
	}
	
	@Test
	@Ignore
	public void delete(){
		new DataAccessObject<Produto, Long>(Produto.class).delete(311L);
		System.out.println(new DataAccessObject<>(Produto.class).search(311L));
	}
}
