package estrutura.modelos;

import java.util.ArrayList;
import java.util.List;

public final class Euclides {
    private Integer resto = 1;
    private List<Integer> listaRestos = new ArrayList<>();
    private List<Integer> listaDivisor = new ArrayList<>();
    private List<Integer> listaDividendo = new ArrayList<>();
    private List<Integer> listaResultado = new ArrayList<>();
    
    public final Integer divisaoEuclides(Integer dividendo, Integer divisor){
        try{
            while(resto != 0){
                resto = dividendo % divisor;    
                listaRestos.add(resto);
                listaDivisor.add(divisor);
                listaDividendo.add(dividendo);
                listaResultado.add(dividendo/divisor);
                dividendo = divisor;
                divisor = resto;
            }
    
        }catch(Exception error){
            System.out.println("Erro na divisao: " + error.getMessage());
        }finally{
            return dividendo;
        }
    }
    
    public final List<Integer> getListaRestos(){
        return this.listaRestos;
    }
    
    public final List<Integer> getListaDivisores(){
        return this.listaDivisor;
    }
    
    public final List<Integer> getListaDividendo(){
        return this.listaDividendo;
    }
    
    public final List<Integer> getListaResultado(){
        return this.listaResultado;
    }
    
    
    
    public final static void main(String[] args){
        Euclides a = new Euclides();
        
        System.out.print("Resultado MDC: " + a.divisaoEuclides(101, 103));
        
        System.out.print("\nDivisores: ");
        for(Integer key : a.getListaDivisores())
            System.out.print(key + " ");
        
        System.out.print("\nDividendos: ");
        for(Integer key : a.getListaDividendo())
            System.out.print(key + " ");
        
        System.out.print("\nResultados: ");
        for(Integer key : a.getListaResultado())
            System.out.print(key + " ");
    }

}
