
package estrutura;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Estrutura extends JFrame{
    
    //Classe para Cadastrar Aluno
    private class Aluno {
        private String nome;
        private Integer matricula;

        Aluno(String nome, Integer matricula) {
            this.nome = nome;
            this.matricula = matricula;
        } 
    }
    

    //Inicializa atributos da classe
    private JLabel LabelNome = new JLabel("Nome: "), LabelMatricula = new JLabel("Matricula: ");

    private JButton ButtonConfirmar = new JButton("Cadastrar"), ButtonPesquisar = new JButton("Pesquisar"), ButtonCancelar  = new JButton("Sair");
    
    private JTextField TextNome = new JTextField(), TextMatricula = new JTextField();
    
    private ArrayList<Aluno> listaAlunos = new ArrayList<>();
    
    //Metodo construtor, Chama a JFrame
    Estrutura(){
       inicializa();
    }
    
    //Chama todos os outros metodos para incializar Frame
    private void inicializa(){
        initComponent(); 
        initEventos();
        addAll();
        initFrame();
    }
    
    //Metodo para configurar a inicializacao da JFrame
    private void initFrame(){
        setTitle("Cadastrando Alunos"); //Configura o titulo da Frame
        setSize(350, 205); //Configura o tamanho do Frame
        setLocationRelativeTo(null); //Configura o Frame para iniciar no meio da Tela
        setDefaultCloseOperation(Estrutura.EXIT_ON_CLOSE); //Determina comando de Fechar Janela
        setLayout(null); //Layout(NULL), por que utilizei setBounds. Mas pode utilizar outros GridLayout, FlowLayout...
        setResizable(false); //Configura para não mudar o tamanho da Janela
        setVisible(true); //Mostra a Janela na tela
    }
    
    //Metodo para configurar localizacao e tamanho do componentes
    private void initComponent(){
        //SetBounds utilizado para determinar onde cada elemento vai ficar no Frame
        LabelNome.setBounds(5, 10, 39, 25); 
        TextNome.setBounds(50, 10, 280, 25);
        LabelMatricula.setBounds(5, 50, 59, 25);
        TextMatricula.setBounds(70, 50, 260, 25);
        ButtonConfirmar.setBounds(5, 130, 100, 25);
        ButtonCancelar.setBounds(235, 130, 100, 25);
    }
    
    private void initEventos(){
        
        //Metodo para cadastrar a informacao
        ButtonConfirmar.addActionListener(e -> {
            try{
                //Verifica se o nome é vazio, se não for pega as informações e adiciona no ArrayList
                if(!(TextNome.getText().trim().equals(""))){
                    listaAlunos.add(new Aluno(TextNome.getText(), Integer.parseInt(TextMatricula.getText())));
                    
                    JOptionPane.showMessageDialog(rootPane, "Você cadastrou: " + TextNome.getText());
                    
                    //Depois de cadastrar as informações zera os campos.
                    TextNome.setText(null); 
                    TextMatricula.setText(null);
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Digite o nome!");
                }
            }catch(NumberFormatException error){
                JOptionPane.showMessageDialog(rootPane, "Digite todos os campos corretamente");
            }catch(Exception error){
                JOptionPane.showMessageDialog(rootPane, "Error inesperado: " + error.getMessage());
            }
        });
        
        //Metodo para evento de sair
        ButtonCancelar.addActionListener(e -> dispose());
    }
    
    //Metodo para adicionar os componentes na JFrame
    private void addAll(){
        //add(Component), adiciona o componente na Frame
        add(LabelNome);
        add(TextNome);
        add(LabelMatricula);
        add(TextMatricula);
        add(ButtonConfirmar);
        add(ButtonPesquisar);
        add(ButtonCancelar);
    }
    
    //Metedo Principal para invocar a classe e iniciar o programa
    public static void main(String[] args) {
        Estrutura edFrame = new Estrutura();
    }
    
}
