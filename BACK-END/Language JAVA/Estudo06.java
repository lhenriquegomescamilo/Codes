package estrutura.janelas;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public final class FrameEuclides extends JFrame {
    public static final class Euclides{
        private Integer resto;
        private List<Integer> listaRestos = new ArrayList<>();
        private List<Integer> listaDivisor = new ArrayList<>();
        private List<Integer> listaDividendo = new ArrayList<>();
        private List<Integer> listaResultado = new ArrayList<>();

        public final Integer divisaoEuclides(Integer dividendo, Integer divisor) throws Exception{
            this.resto = 1;

            while(this.resto != 0){
                this.resto = dividendo % divisor;    
                this.listaRestos.add(this.resto);
                this.listaDivisor.add(divisor);
                this.listaDividendo.add(dividendo);
                this.listaResultado.add(dividendo/divisor);
                dividendo = divisor;
                divisor = this.resto;
            }
            return dividendo;
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
    }
    
    private static final JLabel num1 = new JLabel("X: "), num2 = new JLabel("Y: "), resultado = new JLabel("Resultado MDC: ");
    private static final JTextField tNum1 = new JTextField(), tNum2 = new JTextField();
    private static final JButton calcular = new JButton("Calcular"), limpar = new JButton("Limpar");
    
    public FrameEuclides(){
        initJanela();
        initComponentes();
        initEventos();
    }
    
    private void initJanela(){
        setTitle("Calcular Euclides");
        setLayout(new GridLayout(4, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(250, 100);
        setResizable(false);
        setVisible(true);
    }
    private void initComponentes(){
        add(num1);
        add(tNum1);
        add(num2);
        add(tNum2);
        add(resultado);
        add(new JLabel(""));
        add(calcular);
        add(limpar);
    }
    
    private void initEventos(){
        limpar.addActionListener(action -> limpar());
        calcular.addActionListener(action -> calcularEuclides());  
    }
    
    private void limpar(){
        tNum1.setText(null);
        tNum2.setText(null);
        resultado.setText("Resultado MDC: ");
    }
    
    private void calcularEuclides(){
        try{
            if((!tNum2.getText().trim().equalsIgnoreCase(null)) && (Integer.parseInt(tNum2.getText().trim())) != 0){
                Integer result = new Euclides().divisaoEuclides((Integer.parseInt(tNum1.getText().trim())), (Integer.parseInt(tNum2.getText().trim())));
                resultado.setText("Resultado MDC: " + result);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Campos incorretos");
            }
            
        }catch(NumberFormatException error){
            JOptionPane.showMessageDialog(rootPane, "Digite números: " + error.getMessage());
        }catch(Exception error){
            JOptionPane.showMessageDialog(rootPane, "Erro na operação: " + error.getMessage());
        }
    }
    
    public static void main(String[] args){
        new FrameEuclides();
    }
}
