
package gestaoDeposito.DAO;

import gestaoDeposito.modelo.Produtos;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;


public class ProdutosDAO {
    private EntityManager em = getEntityManager();
    
    private EntityManager getEntityManager(){
        return Persistence.createEntityManagerFactory("GestaoDepositoPU").createEntityManager();
    }
    
    public void salvar(Produtos produto){   
        try{
            em.getTransaction().begin();
            
            if(produto.getId() == null)
                em.persist(produto);
            else
                em.merge(produto);
            
            em.getTransaction().commit();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problema ao salvar: " + e.getMessage());
        }finally{
            em.close();
        }
    }
    
    public Produtos buscar(Long id){
        Produtos produto = null;
        
        try{
            produto = em.find(Produtos.class, id);
            em.flush();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problema ao buscar: " + e.getMessage());
        }finally{
            em.close();
        }
        
        return produto;
    }
    
    public void remover(Long id){
        try{
            em.getTransaction().begin();
            em.remove(em.find(Produtos.class, id));
            em.getTransaction().commit();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problema ao remover: " + e.getMessage());
        }finally{
            em.close();
        }
    }
    
}
