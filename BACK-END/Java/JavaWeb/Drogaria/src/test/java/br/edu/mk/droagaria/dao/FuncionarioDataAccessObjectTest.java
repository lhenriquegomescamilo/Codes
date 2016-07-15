package br.edu.mk.droagaria.dao;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.mk.drogaria.dao.DataAccessObject;
import br.edu.mk.drogaria.domain.Funcionario;
import br.edu.mk.drogaria.domain.Pessoa;

public class FuncionarioDataAccessObjectTest {

	@Test
	@Ignore
	public void save() {

		Funcionario funcionario = new Funcionario();

		funcionario.setCarteiraTrabalho("15151515");
		funcionario.setDataAdmissao(new Date());
		funcionario.setPessoa(new DataAccessObject<Pessoa, Long>(Pessoa.class).search(54L));

		new DataAccessObject<Funcionario, Long>(Funcionario.class).save(funcionario);
	}

	@Test
	@Ignore
	public void update() {
		Funcionario funcionario = new Funcionario();
		
		funcionario.setPrimaryKey(57L);
		funcionario.setCarteiraTrabalho("1616161616");
		funcionario.setDataAdmissao(new Date());
		funcionario.setPessoa(new DataAccessObject<Pessoa, Long>(Pessoa.class).search(54L));

		new DataAccessObject<Funcionario, Long>(Funcionario.class).update(funcionario);
	}
	
	@Test
	@Ignore
	public void findAll(){
		new DataAccessObject<Funcionario, Long>(Funcionario.class)
		.findAll()
		.stream()
		.forEach(funcionario -> System.out.println(funcionario));
	}
	
	@Test
	@Ignore
	public void find(){
		System.out.println(new DataAccessObject<>(Funcionario.class).search(57L));
	}
	
	@Test
	@Ignore
	public void delete(){
		new DataAccessObject<>(Funcionario.class).delete(58L);
	}

}
