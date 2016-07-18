package exemplo.dao;

import exemplo.modelo.Pessoa;
import javax.persistence.EntityManager;

public class PessoaDAO {

    private EntityManager entityManager;

    public PessoaDAO(){}
    
    public PessoaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Boolean salvar(Pessoa pessoa) {
        try {
            if(pessoa.getId() != null)
                entityManager.merge(pessoa);
            else
                entityManager.persist(pessoa);
            
            return true; 
            
        } catch (Exception exception) {
            System.err.println("Erro ao salvar pessoa" + exception.getMessage());
            return false;
        }
    }
    
    public Pessoa buscar(Long id){
       return entityManager.find(Pessoa.class, id);
    }
    
    public Boolean remover(Long id){
        try{
            entityManager.remove(this.buscar(id));
            return true;
        }catch(Exception exception){
            return false;
        }
    }
    
    
}
