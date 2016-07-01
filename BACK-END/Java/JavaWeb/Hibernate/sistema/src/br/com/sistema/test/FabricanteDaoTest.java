package br.com.sistema.test;

import org.junit.Test;

import br.com.sistema.dao.FabricanteDAO;
import br.com.sistema.domain.Fabricante;

public class FabricanteDaoTest {
	@Test
	public void salvarTest(){
		Fabricante fabricante = new Fabricante(), fabricante1 = new Fabricante();
		fabricante.setDescricao("Empresa E");
		fabricante1.setDescricao("Empresa F");
		
		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(fabricante);
		dao.salvar(fabricante1);
	}
}
