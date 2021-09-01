package tela;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.*;
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: Euler da Silva Lima
Matricula: 201911534
Inicio...: 06 de junho de 2021
Alteracao: 18 de junho de 2021
Nome.....: Controladora.java
Funcao...: Classe Telainicial, onde, podemos comecar a rodar as threads da proxima janela.
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Telainicial {
  //Frames, Labels e botoes
  private JFrame tela = new JFrame("Transito autonomo, desafio em Tokyo");
  private JLabel fundo = new JLabel();
  private JButton iniciar = new JButton("Iniciar");

  //Fonte
  String family = "Impact";
  int style = Font.PLAIN;
  int size = 16;
  Font f = new Font(family, style, size);

  //Musica de fundo
  URL url = getClass().getResource("/audio/intro.wav");
  AudioClip audio = Applet.newAudioClip(url);
  public Telainicial(){

    //Configurando o fundo
    fundo = new JLabel(new ImageIcon(getClass().getResource("/img/fundotela.png")));
    fundo.setSize(800,600);

    //Configurando a tela
    tela.setSize(800,600);
    tela.setResizable(false);
    tela.setLocationRelativeTo(null);
    tela.setVisible(true);
    tela.setDefaultCloseOperation(tela.EXIT_ON_CLOSE);
    tela.getContentPane().setLayout(null);

    //Configurando o botao
    iniciar.setFont(f);
    iniciar.setForeground(Color.BLUE);
    iniciar.setBackground(Color.YELLOW);
    iniciar.setBounds(360,280, 120,40);
    
    //Adicionando elementos na tela
    tela.add(fundo);
    tela.add(iniciar);
    audio.loop();    


    //Configurando acao do botao iniciar, que ira chamar a tela q inicia as threads dos carros
    iniciar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        tela.dispose();
        audio.stop();
        new Telacorrida();
      } //Fim do actionPerformed
    }); //Fim do actionListener
  } //Fim do contrutor Telainicial()
}  //Fim da classe Telainicial