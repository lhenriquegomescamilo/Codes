package br.edu.mk.droagaria.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.mk.drogaria.dao.DataAccessObject;
import br.edu.mk.drogaria.domain.Cidade;
import br.edu.mk.drogaria.domain.Pessoa;

public class PessoaDataAccessObjectTest {

	@Test
	@Ignore
	public void save() {

		Pessoa pessoa = new Pessoa();

		pessoa.setBairro("SUL");
		pessoa.setCelular("99998888");
		pessoa.setCep("72322017");
		pessoa.setCidade(new DataAccessObject<Cidade, Long>(Cidade.class).search(27L));
		pessoa.setComplemento("CS");
		pessoa.setCpf("99988878866");
		pessoa.setEmail("teste@gmail.com");
		pessoa.setNome("Nome");
		pessoa.setNumero(new Short("10"));
		pessoa.setRg("23");
		pessoa.setRua("AGOSTINHO");
		pessoa.setTelefone("55557777");

		new DataAccessObject<Pessoa, Long>(Pessoa.class).save(pessoa);
	}
	
	@Test
	@Ignore
	public void update(){
		Pessoa pessoa = new Pessoa();
		
		pessoa.setPrimaryKey(333L);
		pessoa.setBairro("SUL");
		pessoa.setCelular("99998888");
		pessoa.setCep("72322017");
		pessoa.setCidade(new DataAccessObject<Cidade, Long>(Cidade.class).search(234L));
		pessoa.setComplemento("CS");
		pessoa.setCpf("99988877766");
		pessoa.setEmail("maikon@gmail.com");
		pessoa.setNome("Maikon");
		pessoa.setNumero(new Short("10"));
		pessoa.setRg("23");
		pessoa.setRua("AGOSTINHO");
		pessoa.setTelefone("66667777");

		new DataAccessObject<Pessoa, Long>(Pessoa.class).update(pessoa);
	}
	
	@Test
	@Ignore
	public void findAll(){
		new DataAccessObject<Pessoa, Long>(Pessoa.class).findAll().stream().forEach(pessoa -> System.out.println(pessoa));
	}
	
	@Test
	@Ignore
	public void find(){
		System.out.print(new DataAccessObject<Pessoa, Long>(Pessoa.class).search(333L));
	}
	
	@Test
	@Ignore
	public void delete(){
		new DataAccessObject<Pessoa, Long>(Pessoa.class).delete(333L);
	}
	

}
