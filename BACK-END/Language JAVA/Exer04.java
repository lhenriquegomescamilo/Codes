package aplicacao;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public final class Aplicacao extends JFrame {
    private Integer num1, num2;
    private static final JLabel labelNum1 = new JLabel("Primeiro número: "), labelNum2 = new JLabel("Segunda número: ");
    private static final JButton ok = new JButton("OK"), limpar = new JButton("Limpar");
    private static JTextField textNum1 = new JTextField(), textNum2 = new JTextField();
    
    public Aplicacao(){
        initFrame();
        initComp();
        initEvent();
    }
    
    private void initFrame(){
        setTitle("Verifica o maior número");
        setSize(300, 250);
        setLayout(new GridLayout(3, 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void initComp(){
        add(labelNum1);
        add(textNum1);
        add(labelNum2);
        add(textNum2);
        add(ok);
        add(limpar);
    }

    private void limpar(){
        textNum1.setText(null);
        textNum2.setText(null);
    }
    
    private void initEvent(){
        ok.addActionListener(e -> ok());
        limpar.addActionListener(e -> limpar());
    }
    
    private void ok(){
        Integer num_1 = Integer.parseInt(textNum1.getText().trim()), num_2 = Integer.parseInt(textNum2.getText().trim());
        
        try{
            if(num_1 > num_2)
                JOptionPane.showMessageDialog(rootPane, "Número: " + num_1 + " é maior que " + num_2);
            else if(num_2 > num_1)
                JOptionPane.showMessageDialog(rootPane, "Número: " + num_2 + " é maior que " + num_1);
            else
                JOptionPane.showMessageDialog(rootPane, "Os dois são iguais");

            limpar();
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Aplicacao Parou -> " + e.getMessage());
        }
    }
    
    
    
    public static void main(String[] args){
        new Aplicacao();
    }
}
