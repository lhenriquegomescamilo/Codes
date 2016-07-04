package br.com.system.test;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import br.com.system.dao.GenericDAO;
import br.com.system.disabled.ManufacturerDAO;
import br.com.system.domain.Product;

public class ProductDAOTest {

	@Test
	@Ignore
	public void saveTest(){
		GenericDAO<Product, Long> dao = new GenericDAO<>(Product.class);
		dao.save(new Product("PRODUTO A", new BigDecimal(20.00D), 01, new ManufacturerDAO().search(26L)));
		dao.save(new Product("PRODUTO B", new BigDecimal(40.00D), 99, new ManufacturerDAO().search(26L)));
		dao.save(new Product("PRODUTO B", new BigDecimal(40.00D), 99, new ManufacturerDAO().search(32L)));
		
		dao.findAll().stream().forEach(product -> System.out.println(product));
	}
	
	@Test
	@Ignore
	public void updateTest(){
		GenericDAO<Product, Long> dao = new GenericDAO<>();
		Product product = new Product();
		product.setCode(35L);
		product.setAmount(35);
		product.setDescription("PRODUTO A/C");
		product.setPrice(new BigDecimal(99D));
		product.setManufacturer(new ManufacturerDAO().search(32L));
		
		dao.update(product);
	}
	
	@Test
	@Ignore
	public void deleteIdentifier(){
		GenericDAO<Product, Long> dao = new GenericDAO<>(Product.class);
		dao.delete(35L);
	}
	
	@Test
	@Ignore
	public void deleteProduct(){
		GenericDAO<Product, Long> dao = new GenericDAO<>(Product.class);
		Product product = new Product();
		product.setCode(34L);
		product.setAmount(1);
		product.setPrice(new BigDecimal(20.00D));
		product.setDescription("PRODUTO A");
		product.setManufacturer(new ManufacturerDAO().search(26L));
		dao.delete(product);
	}
	
	@Test
	@Ignore
	public void searchProduct(){
		GenericDAO<Product, Long> dao = new GenericDAO<>(Product.class);
		System.out.println(dao.search(37L));
	}
	
	@Test
	@Ignore
	public void findAll(){
		GenericDAO<Product, Long> dao = new GenericDAO<>(Product.class);
		dao.findAll().stream().forEach(product -> System.out.println(product));
	}
}
