package estruturaTreino.exer2;

public class Setup {
    
    //Nesse caso irá mostrar da classe em direção as classes filhas. 
    //O valor de X muda somente no final. 
    //Nesse exemplo tanto faz a utilização do "super()" 
    //Qual será a saida disso? 
    //Resposta: A,B,C,40
    
    public static void main(String[] args){
        class A {
        Integer x;
            A(){
                x = 10;
                System.out.println("A");
            }
        }
    
        class B extends A{
            B(){
                super();
                x = 20;
                System.out.println("B");
            }
        }
    
        class C extends B{
            C(){
                super();
                x = 30;
                System.out.println("C");
            }
        }
        
        C c = new C();
        c.x = 40;
        System.out.println(c.x);
    }
}
