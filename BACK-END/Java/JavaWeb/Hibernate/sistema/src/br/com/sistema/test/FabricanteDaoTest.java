package br.com.sistema.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sistema.dao.FabricanteDAO;
import br.com.sistema.domain.Fabricante;

public class FabricanteDaoTest {
	
	@Test
	@Ignore
	public void salvarTest(){
		Fabricante fabricante = new Fabricante(), fabricante1 = new Fabricante();
		fabricante.setDescricao("Empresa E");
		fabricante1.setDescricao("Empresa F");
		
		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(fabricante);
		dao.salvar(fabricante1);
	}
	
	@Test
	@Ignore
	public void removerFabricantePeloIDTest(){
		FabricanteDAO dao = new FabricanteDAO();
		dao.removerFabricantePeloID(3L);
	}
	
	@Test
	@Ignore
	public void buscarPeloIDTest(){
		FabricanteDAO dao = new FabricanteDAO();
		System.out.println("\n" + dao.buscarPeloID(3L));;
	}
	
	@Test
	@Ignore
	public void buscarTodosTest(){	
		new FabricanteDAO().buscarTodos().stream().forEach(f -> System.out.println(f));
	}
}
