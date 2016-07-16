package br.com.system.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.system.disabled.ManufacturerDAO;
import br.com.system.domain.Manufacturer;

public class ManufacturerDaoTest {
	
	@Test
	@Ignore
	public void saveTest(){
		Manufacturer manufacturer = new Manufacturer(), manufacturer1 = new Manufacturer();
		manufacturer.setDescription("Empresa E");
		manufacturer.setDescription("Empresa F");
		
		ManufacturerDAO dao = new ManufacturerDAO();
		dao.save(manufacturer);
		dao.save(manufacturer1);
	}
	
	@Test
	@Ignore
	public void deleteIdentifierTest(){
		ManufacturerDAO dao = new ManufacturerDAO();
		dao.delete(3L);
	}
	
	@Test
	@Ignore
	public void deleteManufacturerTest(){
		ManufacturerDAO dao = new ManufacturerDAO();
		dao.delete(new Manufacturer(30L, "EMPRESA CENTRAL T.I"));
	}
	
	@Test
	@Ignore
	public void searchTest(){
		ManufacturerDAO dao = new ManufacturerDAO();
		System.out.println("\n" + dao.search(3L));
	}
	
	@Test
	@Ignore
	public void findAllTest(){	
		new ManufacturerDAO().findAll().stream().forEach(f -> System.out.println(f));
	}
	
	@Test
	@Ignore
	public void updateTest(){
		ManufacturerDAO dao = new ManufacturerDAO();
		
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setCode(3L);
		manufacturer.setDescription("EMPRESA A");
		
		dao.update(manufacturer);
	}
}
