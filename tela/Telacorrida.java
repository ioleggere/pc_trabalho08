package tela;
import java.net.URL;
import java.util.concurrent.Semaphore;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.Font;
import threads.Carro;
import java.applet.Applet;
import java.applet.AudioClip;
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: Euler da Silva Lima
Matricula: 201911534
Inicio...: 07 de junho de 2021
Alteracao: 18 de junho de 2021
Nome.....: Controladora.java
Funcao...: Classe Telacorrida, onde as thrads do carro sao controladas e iniciadas.
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Telacorrida {
  //Frames e etc
  private JFrame telac = new JFrame("Transito autonomo, desafio em Tokyo");
  private JLabel fundo = new JLabel();
  URL url = getClass().getResource("/audio/tokyo.wav");
  AudioClip audio = Applet.newAudioClip(url);


  //Labels do carro
  public static JLabel carrovermelhodireita = new JLabel();
  public static JLabel carrovermelhobaixo = new JLabel();
  public static JLabel carrovermelhoesquerda = new JLabel();
  public static JLabel carrovermelhocima = new JLabel();

  public static JLabel carrocinzadireita = new JLabel();
  public static JLabel carrocinzabaixo = new JLabel();
  public static JLabel carrocinzaesquerda = new JLabel();
  public static JLabel carrocinzacima = new JLabel();

  public static JLabel carromarromdireita = new JLabel();
  public static JLabel carromarrombaixo = new JLabel();
  public static JLabel carromarromesquerda = new JLabel();
  public static JLabel carromarromcima = new JLabel();

  public static JLabel carrorosadireita = new JLabel();
  public static JLabel carrorosabaixo = new JLabel();
  public static JLabel carrorosaesquerda = new JLabel();
  public static JLabel carrorosacima = new JLabel();

  public static JLabel carroazuldireita = new JLabel();
  public static JLabel carroazulbaixo = new JLabel();
  public static JLabel carroazulesquerda = new JLabel();
  public static JLabel carroazulcima = new JLabel();

  public static JLabel carropretodireita = new JLabel();
  public static JLabel carropretobaixo = new JLabel();
  public static JLabel carropretoesquerda = new JLabel();
  public static JLabel carropretocima = new JLabel();

  public static JLabel carroamarelodireita = new JLabel();
  public static JLabel carroamarelobaixo = new JLabel();
  public static JLabel carroamareloesquerda = new JLabel();
  public static JLabel carroamarelocima = new JLabel();

  public static JLabel carroverdedireita = new JLabel();
  public static JLabel carroverdebaixo = new JLabel();
  public static JLabel carroverdeesquerda = new JLabel();
  public static JLabel carroverdecima = new JLabel();

  //Sliders.
  private JSlider velcarro1 = new JSlider(JSlider.HORIZONTAL, 0, 9, 5);
  private JSlider velcarro2 = new JSlider(JSlider.HORIZONTAL, 0, 9, 5);
  private JSlider velcarro3 = new JSlider(JSlider.HORIZONTAL, 0, 9, 5);
  private JSlider velcarro4 = new JSlider(JSlider.HORIZONTAL, 0, 9, 5);
  private JSlider velcarro5 = new JSlider(JSlider.HORIZONTAL, 0, 9, 5);
  private JSlider velcarro6 = new JSlider(JSlider.HORIZONTAL, 0, 9, 5);
  private JSlider velcarro7 = new JSlider(JSlider.HORIZONTAL, 0, 9, 5);
  private JSlider velcarro8 = new JSlider(JSlider.HORIZONTAL, 0, 9, 5);

  //Textos
  private JTextField carro1 = new JTextField("Velocidade quadra cinza: ");
  private JTextField carro2 = new JTextField("Velocidade quadra marrom: ");
  private JTextField carro3 = new JTextField("Velocidade quadra rosa: ");
  private JTextField carro4 = new JTextField("Velocidade quadra azul: ");
  private JTextField carro5 = new JTextField("Velocidade quadra preta: ");
  private JTextField carro6 = new JTextField("Velocidade quadra vermelha: ");
  private JTextField carro7 = new JTextField("Velocidade quadra amarela: ");
  private JTextField carro8 = new JTextField("Velocidade quadra verde: ");

  //Fonte 
  String family = "Impact";
  int style = Font.PLAIN;
  int size = 16;
  Font f = new Font(family, style, size);

  //Semaforos (quando esta com 0, significa q algum dos carros ja inicia na zona critica)
  public static Semaphore rc1 = new Semaphore(0);
  public static Semaphore rc2 = new Semaphore(0);
  public static Semaphore rc3 = new Semaphore(0);
  public static Semaphore rc4 = new Semaphore(1);
  public static Semaphore rc5 = new Semaphore(1);
  public static Semaphore rc6 = new Semaphore(1);
  public static Semaphore rc7 = new Semaphore(1);
  public static Semaphore rc8 = new Semaphore(1);
  public static Semaphore rc9 = new Semaphore(0);
  public static Semaphore rc10 = new Semaphore(1);
  public static Semaphore rc11 = new Semaphore(0);
  public static Semaphore rc12 = new Semaphore(0);
  public static Semaphore rc13 = new Semaphore(1);
  public static Semaphore rc14 = new Semaphore(0);
  public static Semaphore rc15 = new Semaphore(0);
  public static Semaphore rc16 = new Semaphore(1);
  public static Semaphore rc17 = new Semaphore(0);
  public static Semaphore rc18 = new Semaphore(1);
  public static Semaphore rc19 = new Semaphore(1);
  public static Semaphore rc20 = new Semaphore(0);

  public Telacorrida(){    
    //Configurado fundo
    fundo = new JLabel(new ImageIcon(getClass().getResource("/img/fundodrift.png")));

    //Configurando labels dos carros
    carrocinzadireita = new JLabel(new ImageIcon(getClass().getResource("/img/cinzadireita.gif")));
    carrocinzabaixo = new JLabel(new ImageIcon(getClass().getResource("/img/cinzabaixo.gif")));
    carrocinzaesquerda = new JLabel(new ImageIcon(getClass().getResource("/img/cinzaesquerda.gif")));
    carrocinzacima = new JLabel(new ImageIcon(getClass().getResource("/img/cinzacima.gif")));
    carrocinzadireita.setVisible(true);
    carrocinzabaixo.setVisible(true);
    carrocinzaesquerda.setVisible(true);
    carrocinzacima.setVisible(true);

    carromarromdireita = new JLabel(new ImageIcon(getClass().getResource("/img/marromdireita.gif")));
    carromarrombaixo = new JLabel(new ImageIcon(getClass().getResource("/img/marrombaixo.gif")));
    carromarromesquerda = new JLabel(new ImageIcon(getClass().getResource("/img/marromesquerda.gif")));
    carromarromcima = new JLabel(new ImageIcon(getClass().getResource("/img/marromcima.gif")));
    carromarromdireita.setVisible(true);
    carromarrombaixo.setVisible(true);
    carromarromesquerda.setVisible(true);
    carromarromcima.setVisible(true);

    carrorosadireita = new JLabel(new ImageIcon(getClass().getResource("/img/rosadireita.gif")));
    carrorosabaixo = new JLabel(new ImageIcon(getClass().getResource("/img/rosabaixo.gif")));
    carrorosaesquerda = new JLabel(new ImageIcon(getClass().getResource("/img/rosaesquerda.gif")));
    carrorosacima = new JLabel(new ImageIcon(getClass().getResource("/img/rosacima.gif")));
    carrorosadireita.setVisible(true);
    carrorosabaixo.setVisible(true);
    carrorosaesquerda.setVisible(true);
    carrorosacima.setVisible(true);

    carroazuldireita = new JLabel(new ImageIcon(getClass().getResource("/img/azuldireita.gif")));
    carroazulbaixo = new JLabel(new ImageIcon(getClass().getResource("/img/azulbaixo.gif")));
    carroazulesquerda = new JLabel(new ImageIcon(getClass().getResource("/img/azulesquerda.gif")));
    carroazulcima = new JLabel(new ImageIcon(getClass().getResource("/img/azulcima.gif")));
    carroazuldireita.setVisible(true);
    carroazulbaixo.setVisible(true);
    carroazulesquerda.setVisible(true);
    carroazulcima.setVisible(true);

    carropretodireita = new JLabel(new ImageIcon(getClass().getResource("/img/pretodireita.gif")));
    carropretobaixo = new JLabel(new ImageIcon(getClass().getResource("/img/pretobaixo.gif")));
    carropretoesquerda = new JLabel(new ImageIcon(getClass().getResource("/img/pretoesquerda.gif")));
    carropretocima = new JLabel(new ImageIcon(getClass().getResource("/img/pretocima.gif")));
    carropretodireita.setVisible(true);
    carropretobaixo.setVisible(true);
    carropretoesquerda.setVisible(true);
    carropretocima.setVisible(true);

    carrovermelhodireita = new JLabel(new ImageIcon(getClass().getResource("/img/vermelhodireita.gif")));
    carrovermelhobaixo = new JLabel(new ImageIcon(getClass().getResource("/img/vermelhobaixo.gif")));
    carrovermelhoesquerda = new JLabel(new ImageIcon(getClass().getResource("/img/vermelhoesquerda.gif")));
    carrovermelhocima = new JLabel(new ImageIcon(getClass().getResource("/img/vermelhocima.gif")));
    carrovermelhodireita.setVisible(true);
    carrovermelhobaixo.setVisible(true);
    carrovermelhoesquerda.setVisible(true);
    carrovermelhocima.setVisible(true);

    carroamarelodireita = new JLabel(new ImageIcon(getClass().getResource("/img/amarelodireita.gif")));
    carroamarelobaixo = new JLabel(new ImageIcon(getClass().getResource("/img/amarelobaixo.gif")));
    carroamareloesquerda = new JLabel(new ImageIcon(getClass().getResource("/img/amareloesquerda.gif")));
    carroamarelocima = new JLabel(new ImageIcon(getClass().getResource("/img/amarelocima.gif")));
    carroamarelodireita.setVisible(true);
    carroamarelobaixo.setVisible(true);
    carroamareloesquerda.setVisible(true);
    carroamarelocima.setVisible(true);

    carroverdedireita = new JLabel(new ImageIcon(getClass().getResource("/img/verdedireita.gif")));
    carroverdebaixo = new JLabel(new ImageIcon(getClass().getResource("/img/verdebaixo.gif")));
    carroverdeesquerda = new JLabel(new ImageIcon(getClass().getResource("/img/verdeesquerda.gif")));
    carroverdecima = new JLabel(new ImageIcon(getClass().getResource("/img/verdecima.gif")));
    carroverdedireita.setVisible(true);
    carroverdebaixo.setVisible(true);
    carroverdeesquerda.setVisible(true);
    carroverdecima.setVisible(true);

    //Criando as threads dos carros
    Carro carrovermelhao = new Carro(0,0, 760,0, 760, 560, 0, 560, carrocinzadireita, carrocinzabaixo, carrocinzaesquerda, carrocinzacima, 60, 40, "h", "cinza");
    Carro carrovermelhao2 = new Carro(105,0, 370,0, 370, 180, 100, 180, carromarromdireita, carromarrombaixo, carromarromesquerda, carromarromcima, 60, 40, "h", "marrom");
    Carro carrovermelhao3 = new Carro(680,0, 360,0, 360, 180, 620, 180, carrorosadireita, carrorosabaixo, carrorosaesquerda, carrorosacima, 60, 40,"ah", "rosa");
    Carro carrovermelhao4 = new Carro(0,180, 0,180, 0, 375, 260, 375, carroazuldireita, carroazulbaixo, carroazulesquerda, carroazulcima, 60, 40,"ah", "azul");
    Carro carrovermelhao5 = new Carro(260,180, 260,180, 260, 375, 520, 375, carropretodireita, carropretobaixo, carropretoesquerda, carropretocima, 60, 40,"ah", "preto");
    Carro carrovermelhao6 = new Carro(610,180, 770,180, 798, 375, 520, 375, carrovermelhodireita, carrovermelhobaixo, carrovermelhoesquerda, carrovermelhocima, 60, 40,"h", "vermelho");
    Carro carrovermelhao7 = new Carro(340,375, 100,375, 100, 560, 375, 560, carroamarelodireita, carroamarelobaixo, carroamareloesquerda, carroamarelocima, 60, 40,"ah", "amarelo");
    Carro carrovermelhao8 = new Carro(380,375, 650,375, 650, 560, 380, 560, carroverdedireita, carroverdebaixo, carroverdeesquerda, carroverdecima, 60, 40,"h", "verde");
    float[] hsb = Color.RGBtoHSB(50, 58, 90, null);

    //Configurando os textos
    carro1.setFont(f);
    carro2.setFont(f);
    carro3.setFont(f);
    carro4.setFont(f);
    carro5.setFont(f);
    carro6.setFont(f);
    carro7.setFont(f);
    carro8.setFont(f);
    carro1.setEditable(false);
    carro2.setEditable(false);
    carro3.setEditable(false);
    carro4.setEditable(false);
    carro5.setEditable(false);
    carro6.setEditable(false);
    carro7.setEditable(false);
    carro8.setEditable(false);
    carro1.setBounds(850, 10, 200, 30);
    carro2.setBounds(850, 80, 200, 30);
    carro3.setBounds(850, 150, 200, 30);
    carro4.setBounds(850, 220, 200, 30);
    carro5.setBounds(850, 290, 200, 30);
    carro6.setBounds(850, 360, 200, 30);
    carro7.setBounds(850, 430, 200, 30);
    carro8.setBounds(850, 500, 200, 30);
    carro1.setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    carro2.setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    carro3.setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    carro4.setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    carro5.setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    carro6.setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    carro7.setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    carro8.setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    carro1.setForeground(Color.WHITE);
    carro2.setForeground(Color.WHITE);
    carro3.setForeground(Color.WHITE);
    carro4.setForeground(Color.WHITE);
    carro5.setForeground(Color.WHITE);
    carro6.setForeground(Color.WHITE);
    carro7.setForeground(Color.WHITE);
    carro8.setForeground(Color.WHITE);

    //Configurando os Sliders
    velcarro1.setBounds(850, 40, 200, 30);
    velcarro2.setBounds(850, 110, 200, 30);
    velcarro3.setBounds(850, 180, 200, 30);
    velcarro4.setBounds(850, 250, 200, 30);
    velcarro5.setBounds(850, 320, 200, 30);
    velcarro6.setBounds(850, 390, 200, 30);
    velcarro7.setBounds(850, 460, 200, 30);
    velcarro8.setBounds(850, 530, 200, 30);
    velcarro1.setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    velcarro2.setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    velcarro3.setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    velcarro4.setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    velcarro5.setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    velcarro6.setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    velcarro7.setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    velcarro8.setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
   
    //Configurando o fundo
    fundo.setSize(800,600);
    telac.setSize(1100,645);

    //Configurando a tela
    telac.setResizable(false);
    telac.setLocationRelativeTo(null);
    telac.setVisible(true);
    telac.setDefaultCloseOperation(telac.EXIT_ON_CLOSE);
    telac.getContentPane().setLayout(null);
    telac.getContentPane().setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));  

    //Setando as configuracoes dos carros
    carrovermelhao.setConfig();
    carrovermelhao2.setConfig();
    carrovermelhao3.setConfig();
    carrovermelhao4.setConfig();
    carrovermelhao5.setConfig();
    carrovermelhao6.setConfig();
    carrovermelhao7.setConfig();
    carrovermelhao8.setConfig();

    //Adicionando as labels de cada carro na tela
    telac.add(carrovermelhao.getLabelcarro());
    telac.add(carrovermelhao2.getLabelcarro());
    telac.add(carrovermelhao3.getLabelcarro());
    telac.add(carrovermelhao4.getLabelcarro());
    telac.add(carrovermelhao5.getLabelcarro());
    telac.add(carrovermelhao6.getLabelcarro());
    telac.add(carrovermelhao7.getLabelcarro());
    telac.add(carrovermelhao8.getLabelcarro());

    //Adicionando as caixas de texto na tela
    telac.add(carro1);
    telac.add(carro2);
    telac.add(carro3);
    telac.add(carro4);
    telac.add(carro5);
    telac.add(carro6);
    telac.add(carro7);
    telac.add(carro8);

    //Adicionando os sliders na tela
    telac.add(velcarro1);
    telac.add(velcarro2);
    telac.add(velcarro3);
    telac.add(velcarro4);
    telac.add(velcarro5);
    telac.add(velcarro6);
    telac.add(velcarro7);
    telac.add(velcarro8);

    //Iniciando as threads dos carros
    carrovermelhao.start();
    carrovermelhao2.start();
    carrovermelhao3.start();
    carrovermelhao4.start();
    carrovermelhao5.start();
    carrovermelhao6.start();
    carrovermelhao7.start();
    carrovermelhao8.start();
    telac.add(fundo);
    audio.loop();


    //Abaixo temos as configuracoes dos sliders, que basicamente ira setar a velocidade de cada carro de acordo com os valores dos sliders
    velcarro1.addChangeListener(new ChangeListener(){
      @Override
      public void stateChanged(ChangeEvent e) {
        int velocidadecarro1 = 10 - velcarro1.getValue();
        carrovermelhao.setVelocidade(velocidadecarro1);
      } //Fim do stateChanged
    }); //Fim do ChangeListener

    velcarro2.addChangeListener(new ChangeListener(){
      @Override
      public void stateChanged(ChangeEvent e) {
        int velocidadecarro2 = 10 - velcarro2.getValue();
        carrovermelhao2.setVelocidade(velocidadecarro2);
      } //Fim do stateChanged      
    }); //Fim do ChangeListener

    velcarro3.addChangeListener(new ChangeListener(){
      @Override
      public void stateChanged(ChangeEvent e) {
        int velocidadecarro3 = 10 - velcarro3.getValue();
        carrovermelhao3.setVelocidade(velocidadecarro3);
      } //Fim do stateChanged
    }); //Fim do ChangeListener

    velcarro4.addChangeListener(new ChangeListener(){
      @Override
      public void stateChanged(ChangeEvent e) {
        int velocidadecarro4 = 10 - velcarro4.getValue();
        carrovermelhao4.setVelocidade(velocidadecarro4);
      } //Fim do stateChanged
    }); //Fim do ChangeListener

    velcarro5.addChangeListener(new ChangeListener(){
      @Override
      public void stateChanged(ChangeEvent e) {
        int velocidadecarro5 = 10 - velcarro5.getValue();
        carrovermelhao5.setVelocidade(velocidadecarro5);
      } //Fim do stateChanged 
    }); //Fim do ChangeListener

    velcarro6.addChangeListener(new ChangeListener(){
      @Override
      public void stateChanged(ChangeEvent e) {
        int velocidadecarro6 = 10 - velcarro6.getValue();
        carrovermelhao6.setVelocidade(velocidadecarro6);
      } //Fim do stateChanged     
    }); //Fim do ChangeListener

    velcarro7.addChangeListener(new ChangeListener(){
      @Override
      public void stateChanged(ChangeEvent e) {
        int velocidadecarro7 = 10 - velcarro7.getValue();
        carrovermelhao7.setVelocidade(velocidadecarro7);
      } //Fim do stateChanged  
    }); //Fim do ChangeListener

    velcarro8.addChangeListener(new ChangeListener(){
      @Override
      public void stateChanged(ChangeEvent e) {
        int velocidadecarro8 = 10 - velcarro8.getValue();
        carrovermelhao8.setVelocidade(velocidadecarro8);
        System.out.println(velocidadecarro8);
      } //Fim do stateChanged      
    }); //Fim do ChangeListener
  } //Fim do contrutor Telacorrida()
} //Fim da classe Telacorrida