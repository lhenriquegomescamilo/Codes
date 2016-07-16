package br.edu.mk.droagaria.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.mk.drogaria.dao.DataAccessObject;
import br.edu.mk.drogaria.domain.Pessoa;
import br.edu.mk.drogaria.domain.Usuario;

public class UsuarioAccessDataObjectTest {
	
	@Test
	@Ignore
	public void save(){
		
		Usuario usuario = new Usuario();
		
		usuario.setAtivo(false);
		usuario.setSenha("123456");
		usuario.setTipo('F');
		usuario.setPessoa(new DataAccessObject<Pessoa, Long>(Pessoa.class).search(52L));
		
		new DataAccessObject<Usuario, Long>().save(usuario);
	}
	
	
	@Test
	@Ignore
	public void update(){
		Usuario usuario = new Usuario();
		
		usuario.setPrimaryKey(55L);
		usuario.setAtivo(true);
		usuario.setSenha("17879");
		usuario.setTipo('G');
		usuario.setPessoa(new DataAccessObject<Pessoa, Long>(Pessoa.class).search(52L));
		
		new DataAccessObject<Usuario, Long>(Usuario.class).update(usuario);
	}
	
	@Test
	@Ignore
	public void findAll(){
		new DataAccessObject<Usuario, Long>(Usuario.class).findAll().stream().forEach(user -> System.out.println(user));
	}
	
	@Test
	@Ignore
	public void search(){
		System.out.println(new DataAccessObject<>(Usuario.class).search(55L));
	}
	
	@Test
	@Ignore
	public void delete(){
		new DataAccessObject<>(Usuario.class).delete(55L);
		System.out.println(new DataAccessObject<>(Usuario.class).search(55L));
	}
}
