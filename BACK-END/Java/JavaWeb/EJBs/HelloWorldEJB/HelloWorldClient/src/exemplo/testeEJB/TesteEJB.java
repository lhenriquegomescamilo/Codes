/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.testeEJB;

import exemplo.ejb.interfaces.HelloWorldRemote;
import javax.naming.InitialContext;

/**
 *
 * @author Maikon
 */
public class TesteEJB {
    public static void main(String[] args) throws Exception{
        InitialContext contexto = new InitialContext();
        HelloWorldRemote ejb = (HelloWorldRemote)contexto.lookup("exemplo.ejb.interfaces.HelloWorldRemote");
        
        System.out.println(ejb.olaMundo());
    }
}
