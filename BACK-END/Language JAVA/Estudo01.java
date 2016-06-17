package estruturaTreino.exer1;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Setup extends JFrame {
    
    //Inicializa variaveis e já cria os objetos
    private JLabel nome = new JLabel("Nome:"), matricula = new JLabel("Matricula:"), nota_a1 = new JLabel("Nota A1:"), nota_a2 = new JLabel("Nota A2:");
    private JTextField tNome = new JTextField(), tMatricula = new JTextField(), tNota_a1 = new JTextField(), tNota_a2 = new JTextField();
    private JButton calcular = new JButton("Calcular"), limpar = new JButton("Limpar");
    
    //Inicializa o programa
    Setup(){
        inicia();
    }
    
    //Chama todas as configuracoes
    private void inicia(){
        iniConfig(); //Configuracoes da Janela
        iniEvent(); //Configuracoes dos Eventos
        iniAddAll(); //Configuracoes dos Componentes
    }
    
    //Configuracao de janela
    private void iniConfig(){
        setTitle("Calculando notas"); //Titulo da Janela
        setSize(520, 320); //Tamanho da Janela
        setLayout(new GridLayout(7, 10)); //Define Layout, nesse caso GridLayout
        setLocationRelativeTo(null); //Deixa o Frame no centro da tela
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Define opcao para fechar 
        setResizable(false); //Nao e possivel aumentar tela
        setVisible(true); //Mostra o Frame na tela
    }
    
    //Configuracao dos eventos
    private void iniEvent(){
        //Evento ao apertar o botao calcular
        calcular.addActionListener(e -> {
            try{
                //Verifica se os campos sao estao vazios/nulos, se nao estiverem entao executa o calculo da media
                if(!(tNota_a1.getText().trim().equalsIgnoreCase("")) && !(tNota_a2.getText().trim().equalsIgnoreCase(""))){
                    Double nota1 = Double.parseDouble(tNota_a1.getText().trim());
                    Double nota2 = Double.parseDouble(tNota_a2.getText().trim());
                    
                    if(((nota1 + nota2)/2) >= 5)
                        JOptionPane.showMessageDialog(rootPane, "Passou");
                    else
                        JOptionPane.showMessageDialog(rootPane, "Reprovou");
                    
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Digite todos os campos");
                }
            }catch(Exception error){
                JOptionPane.showMessageDialog(rootPane, "Error no programa: " + error.getMessage());
            }
        });
        
        //Evento para apertar o botao calcular com o mouse
        calcular.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                try{
                    JOptionPane.showMessageDialog(rootPane, "Você clicou com mouse");
                    if(!(tNota_a1.getText().trim().equalsIgnoreCase("")) && !(tNota_a2.getText().trim().equalsIgnoreCase(""))){
                        Double nota1 = Double.parseDouble(tNota_a1.getText().trim());
                        Double nota2 = Double.parseDouble(tNota_a2.getText().trim());

                        if(((nota1 + nota2)/2) >= 5)
                            JOptionPane.showMessageDialog(rootPane, "Passou");
                        else
                            JOptionPane.showMessageDialog(rootPane, "Reprovou");

                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Digite todos os campos");
                    }
                }catch(Exception error){
                    JOptionPane.showMessageDialog(rootPane, "Error no programa: " + error.getMessage());
                }
            }
        });

        //evento para o botao limpar quando apertado pelo mouse
        limpar.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                limparCampos();
                JOptionPane.showMessageDialog(rootPane, "Você clicou com mouse");
            }
        });
        
        //Evento para o botao limpar
        limpar.addActionListener(e -> limparCampos());

    }
    
    //Configura componentes na tela
    private void iniAddAll(){
        add(nome);
        add(tNome);
        add(matricula);
        add(tMatricula);
        add(nota_a1);
        add(tNota_a1);
        add(nota_a2);
        add(tNota_a2);
        add(calcular);
        add(limpar);
    }
    
    //Metodo para limpar os campos
    private void limparCampos(){
        tNome.setText(null);
        tMatricula.setText(null);
        tNota_a1.setText(null);
        tNota_a2.setText(null);
    }
    
    //Principal para chamar o Frame
    public static void main(String[] args){
        Setup frame = new Setup();
    }
}
