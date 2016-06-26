
package mk.sistema.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import mk.sistema.modelo.Pessoa;


public class PessoaDAO {
    private EntityManager getEntityManager(){
        return Persistence.createEntityManagerFactory("SistemaPU").createEntityManager();
    }
    
    public void salvar(Pessoa p){
        EntityManager em = getEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problema ao salvar: " + e.getMessage());
        }finally{
            em.close();
        }
    }
    
    public Pessoa buscar(Long id){
        EntityManager em = getEntityManager();
        Pessoa p = null;
        try{
            em.getTransaction().begin();
            p = em.find(Pessoa.class, id);
            em.getTransaction().commit();

        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, "Problema a buscar: " + e.getMessage());
        }finally{
            em.close();
        }
        
        return p;
    }
    
}
