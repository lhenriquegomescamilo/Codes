
package exemplo.ejb.impl;

import exemplo.ejb.interfaces.HelloWorldRemote;
import javax.ejb.Stateless;

@Stateless
public class HelloWorldBean implements HelloWorldRemote{
    
    @Override
    public String olaMundo(){
        return "Olá Mundo com EJB!";
    }
}
