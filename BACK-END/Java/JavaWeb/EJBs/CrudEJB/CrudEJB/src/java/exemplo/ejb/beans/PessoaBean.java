
package exemplo.ejb.beans;

import exemplo.dao.PessoaDAO;
import exemplo.ejb.interfaces.PessoaRemote;
import exemplo.modelo.Pessoa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PessoaBean implements PessoaRemote{
    
    @PersistenceContext(unitName = "PessoaPU")
    private EntityManager entityManager;
    
    @Override
    public Boolean salvar(Pessoa pessoa){
        return new PessoaDAO(entityManager).salvar(pessoa);  
    }
    
    @Override
    public Pessoa buscar(Long id){
        return new PessoaDAO(entityManager).buscar(id);
    }
    @Override
    public Boolean remover(Long id){
        return new PessoaDAO(entityManager).remover(id);
    }
}
