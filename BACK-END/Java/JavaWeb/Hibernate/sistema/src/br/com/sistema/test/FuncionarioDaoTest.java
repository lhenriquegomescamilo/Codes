package br.com.sistema.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sistema.dao.FuncionarioDAO;
import br.com.sistema.domain.Funcionario;

public class FuncionarioDaoTest {
	
	@Test
	@Ignore
	public void salvarFuncionarioTest(){
		FuncionarioDAO dao = new FuncionarioDAO();
		
		dao.salvar(new Funcionario("Maikon", "573.102.224-06", "99360225", "Estudante"));
	}
	
	@Test
	@Ignore
	public void atualizarFuncionarioTest(){
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = new Funcionario();
		
		funcionario.setCodigo(24L);
		funcionario.setCpf("835.854.120-17");
		funcionario.setFuncao("Geografo");
		funcionario.setNome("Frederico");
		funcionario.setSenha("123456789");
		
		dao.atualizarFuncionario(funcionario);
	}
	
	@Test
	@Ignore
	public void removerFuncionarioPeloID(){
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.removerPeloId(6L);
	}
	
	@Test
	@Ignore
	public void removerFuncionario(){
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.buscarPeloID(24L);
		
		dao.removerFuncionario(funcionario);
	}
	
	@Test
	@Ignore
	public void buscarPeloID(){
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.buscarPeloID(7L);
		
		System.out.println(funcionario);
	}
	
	@Test
	@Ignore
	public void buscarTodos(){
		new FuncionarioDAO().buscarTodos().stream().forEach(f -> System.out.println(f));
	}
}
