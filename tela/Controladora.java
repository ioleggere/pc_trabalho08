package tela;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: Euler da Silva Lima
Matricula: 201911534
Inicio...: 06 de junho de 2021
Alteracao: 18 de junho de 2021
Nome.....: Controladora.java
Funcao...: Classe Controladora, onde a cena de inicio acontece, e iniciamos a tela de inicio.
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Controladora {
  //Frames e labels
  private JFrame janela = new JFrame("Transito autonomo, desafio em Tokyo");
  private JLabel cenaum = new JLabel();
  private JLabel cenadois = new JLabel();
  private JLabel cenatres = new JLabel();
  private JLabel cenaquatro = new JLabel();
  private JLabel cenacinco = new JLabel();
  private JLabel cenaseis = new JLabel();
  private JLabel cenasete = new JLabel();
  private JLabel cenaoito = new JLabel();

  //Botao e array de cenas
  private JButton avancar = new JButton("Avancar");
  private List<JLabel> cenas = new ArrayList<JLabel>();

  //Fonte
  String family = "Impact";
  int style = Font.PLAIN;
  int size = 13;
  Font f = new Font(family, style, size);
  public Controladora(){

    //Colocando as imagens nas labels
    cenaum = new JLabel(new ImageIcon(getClass().getResource("/img/um.png")));
    cenadois = new JLabel(new ImageIcon(getClass().getResource("/img/dois.png")));
    cenatres = new JLabel(new ImageIcon(getClass().getResource("/img/tres.png")));
    cenaquatro = new JLabel(new ImageIcon(getClass().getResource("/img/quatro.png")));
    cenacinco = new JLabel(new ImageIcon(getClass().getResource("/img/cinco.png")));
    cenaseis = new JLabel(new ImageIcon(getClass().getResource("/img/seis.png")));
    cenasete = new JLabel(new ImageIcon(getClass().getResource("/img/sete.png")));    
    cenaoito = new JLabel(new ImageIcon(getClass().getResource("/img/oito.png")));
    
    //Configurando a janela
    janela.setSize(800,600);
    janela.setResizable(false);
    janela.setLocationRelativeTo(null);
    janela.setVisible(true);
    janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
    janela.getContentPane().setLayout(null);

    //Confugurando as cenas e o botao
    cenaum.setSize(800, 600);
    cenadois.setSize(800, 600);
    cenatres.setSize(800, 600);
    cenaquatro.setSize(800, 600);
    cenacinco.setSize(800, 600);
    cenaseis.setSize(800, 600);
    cenasete.setSize(800, 600);   
    cenaoito.setSize(800, 600);
    avancar.setBounds(700, 10, 80, 30);
    avancar.setFont(f);

    //Adicionando as cenas no array
    cenas.add(cenadois);
    cenas.add(cenatres);
    cenas.add(cenaquatro);
    cenas.add(cenacinco);
    cenas.add(cenaseis);
    cenas.add(cenasete);
    cenas.add(cenaoito);
    cenaum.add(avancar);
    janela.add(cenaum);

    //ActionListener do botao, que passa as cenas do array e, ao terminar, inicia a proxima janela
    avancar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        try{
          cenaum.setIcon(cenas.get(0).getIcon());
          cenaum.repaint();
          cenas.remove(0);
        }catch(IndexOutOfBoundsException a){
          janela.dispose();
          new Telainicial();
        } //Fim do try catch
      } //Fim do actionPerformed
    }); //Fim do ActionListener
  } //Fim do contrutor Controladora()
} //Fim da classe Controladora