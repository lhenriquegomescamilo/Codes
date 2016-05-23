package estudojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class EstudoJDBC {
    
    public class ConnectionFactory{
        public Connection getConnection(){
            try{
                return DriverManager.getConnection("jdbc:mysql://localhost", "root", "");
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }
    
    public static void main(String[] args) {
          Connection con = new ConnectionFactory().getConnection();
    }
}
