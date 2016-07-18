package exemplo.ejb.interfaces;

import javax.ejb.Remote;

@Remote
public interface HelloWorldRemote { 
    public String olaMundo();
}
