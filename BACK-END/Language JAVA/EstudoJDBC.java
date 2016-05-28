package estudojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

//Classe de estudo sobre JDBC
public class EstudoJDBC {
    
    //Faz uma fabrica de conexao 
    public class ConnectionFactory{
        
        //Retorna um objeto com a conexao ao BD 
        public Connection getConnection(){
            try{
                return DriverManager.getConnection("jdbc:mysql://localhost", "root", ""); //Faz conexao com DB
            }catch(Exception e){
                throw new RuntimeException(e); //Retorna uma exception 
            }
        }
    }
    
    public static void main(String[] args) {
          //Pega conexao
          Connection con = new ConnectionFactory().getConnection();
    }
}
