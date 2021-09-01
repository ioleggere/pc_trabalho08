package threads;
import static tela.Telacorrida.rc1;
import static tela.Telacorrida.rc2;
import static tela.Telacorrida.rc3;
import static tela.Telacorrida.rc4;
import static tela.Telacorrida.rc5;
import static tela.Telacorrida.rc6;
import static tela.Telacorrida.rc7;
import static tela.Telacorrida.rc8;
import static tela.Telacorrida.rc9;
import static tela.Telacorrida.rc10;
import static tela.Telacorrida.rc11;
import static tela.Telacorrida.rc12;
import static tela.Telacorrida.rc13;
import static tela.Telacorrida.rc14;
import static tela.Telacorrida.rc15;
import static tela.Telacorrida.rc16;
import static tela.Telacorrida.rc17;
import static tela.Telacorrida.rc18;
import static tela.Telacorrida.rc19;
import static tela.Telacorrida.rc20;
import javax.swing.JLabel;
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: Euler da Silva Lima
Matricula: 201911534
Inicio...: 07 de junho de 2021
Alteracao: 18 de junho de 2021
Nome.....: Carro.java
Funcao...: Classe Carro, sendo as threads dos carros, onde podemos verificar suas RC, e fazer sua movimentacao
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Carro extends Thread {

  //Labels das direcoes
  private JLabel dir;
  private JLabel ba;
  private JLabel esq;
  private JLabel ci;

  //Posicoes de cada carro
  private int xi, yi, x11, y11, x22, y22, x33, y33, rxx, ryy;

  //Label atual
  private JLabel labelcarro;

  //Direcoes para controlar a troca de labels
  boolean indodireita, indoesquerda, indocima, indobaixo;

  //Sentido do carro (SA, H)
  String sent;

  //Cor do carro
  String c;

  //Velocidade
  int velocidade = 10;
  public void run(){
    while(true){  
        try{   
          //Verificamos o sentido do carro para rodar em ordem sua direcao
          if(this.sent.equals("h")){
          while(this.indodireita){
          this.andardireita();
          } // Fim do while
          while(this.indobaixo){
            this.andarbaixo();
          } // Fim do while
          while(this.indoesquerda){
          this.andaresquerda();
          } // Fim do while
          while(this.indocima){
          this.andarecima();
          } // Fim do while
        }else if(this.sent.equals("ah")){
          while(this.indoesquerda){
            this.andaresquerdaah();
          } // Fim do while
          while(this.indobaixo){
            this.andarbaixoah();
          } // Fim do while
          while(this.indodireita){
            this.andardireitaah();
          } // Fim do while
          while(this.indocima){
            this.andarecimaah();
          }
        } // Fim do ifelse
      }catch (Exception e){
      } //Fim do trycatch
    } // Fim do while
  } //Fim do run()

  /********************************************************************* 
  * Metodo: andardireita.
  * Funcao: Move a label do carro para direita e muda o sentido quando chega em um determinado ponto
  * Parametros: nenhum.
  * Retorno: void.
  ********************************************************************* */
  private void andardireita() throws InterruptedException{
    this.labelcarro.setIcon(dir.getIcon());
    while(this.labelcarro.getX() < this.x11){
      this.testaRC();
      sleep(this.velocidade);
      this.labelcarro.setBounds(this.labelcarro.getX() + 1, this.labelcarro.getY(), 60,40);
    } //Fim do while
    this.indodireita = false;
    this.indobaixo = true;
  } //Fim do andardireita()

  /********************************************************************* 
  * Metodo: andarbaixo.
  * Funcao: Move a label do carro para baixo e muda o sentido quando chega em um determinado ponto
  * Parametros: nenhum.
  * Retorno: void.
  ********************************************************************* */

  private void andarbaixo() throws InterruptedException{
    this.labelcarro.setIcon(ba.getIcon());
    while(this.labelcarro.getY() < this.y22){
      this.testaRC();
      sleep(this.velocidade);      
      this.labelcarro.setBounds(this.labelcarro.getX(), this.labelcarro.getY() + 1, 40,60);
    } //Fim do while
    this.indobaixo = false;
    this.indoesquerda = true;
  } //Fim do andarbaixo()

  /********************************************************************* 
  * Metodo: andaresquerda.
  * Funcao: Move a label do carro para esquerda e muda o sentido quando chega em um determinado ponto
  * Parametros: nenhum.
  * Retorno: void.
  ********************************************************************* */

  private void andaresquerda() throws InterruptedException{
    this.labelcarro.setIcon(esq.getIcon());
    while(this.labelcarro.getX() > this.x33){
      this.testaRC();
      sleep(this.velocidade);
      this.labelcarro.setBounds(this.labelcarro.getX() - 1, this.labelcarro.getY(), 60,40);
    } //Fim do while
    this.indoesquerda = false;
    this.indocima = true;
  } //Fim do andaresquerda()

  /********************************************************************* 
  * Metodo: andarcima.
  * Funcao: Move a label do carro para cima e muda o sentido quando chega em um determinado ponto
  * Parametros: nenhum.
  * Retorno: void.
  ********************************************************************* */

  private void andarecima() throws InterruptedException{
    this.labelcarro.setIcon(ci.getIcon());
    while(this.labelcarro.getY() > this.yi){
      this.testaRC();
      sleep(this.velocidade);
      this.labelcarro.setBounds(this.labelcarro.getX(), this.labelcarro.getY() - 1, 40,60);
    } //Fim do while
    this.indocima = false;
    this.indodireita = true;
  } //Fim do andarcima()

  /********************************************************************* 
  * Metodo: andaresquerdaah.
  * Funcao: Move a label do carro para esquerda no sentido anti horario e muda o sentido quando chega em um determinado ponto
  * Parametros: nenhum.
  * Retorno: void.
  ********************************************************************* */

  private void andaresquerdaah() throws InterruptedException{
    this.labelcarro.setIcon(esq.getIcon());
    while(this.labelcarro.getX() > this.x11){
      this.testaRC();
      sleep(this.velocidade);
      this.labelcarro.setBounds(this.labelcarro.getX() - 1, this.labelcarro.getY(), 60,40);
    } //Fim do while
    this.indoesquerda = false;
    this.indobaixo = true;
  } //Fim do andaresquerdaah()

  /********************************************************************* 
  * Metodo: andarbaixoah.
  * Funcao: Move a label do carro para baixo no sentido anti horario e muda o sentido quando chega em um determinado ponto
  * Parametros: nenhum.
  * Retorno: void.
  ********************************************************************* */

  private void andarbaixoah() throws InterruptedException{
    this.labelcarro.setIcon(ba.getIcon());
    while(this.labelcarro.getY() < this.y22){
      this.testaRC();
      sleep(this.velocidade);
      this.labelcarro.setBounds(this.labelcarro.getX(), this.labelcarro.getY() + 1, 40,60);
    } //Fim do while
    this.indobaixo = false;
    this.indodireita = true;
  } //Fim do andarbaixoah()

  /********************************************************************* 
  * Metodo: andardireitaah.
  * Funcao: Move a label do carro para direita no sentido anti horario e muda o sentido quando chega em um determinado ponto
  * Parametros: nenhum.
  * Retorno: void.
  ********************************************************************* */

  private void andardireitaah() throws InterruptedException{
    this.labelcarro.setIcon(dir.getIcon());
    while(this.labelcarro.getX() < this.x33){
      this.testaRC();
      sleep(this.velocidade);
      this.labelcarro.setBounds(this.labelcarro.getX() + 1, this.labelcarro.getY(), 60,40);
    } //Fim do while
    this.indodireita = false;
    this.indocima = true;
  } //Fim do andardireitaah()

  /********************************************************************* 
  * Metodo: andarcima.
  * Funcao: Move a label do carro para cima no sentido anti horario e muda o sentido quando chega em um determinado ponto
  * Parametros: nenhum.
  * Retorno: void.
  ********************************************************************* */

  private void andarecimaah() throws InterruptedException{
    this.labelcarro.setIcon(ci.getIcon());
    while(this.labelcarro.getY() > this.yi){
      this.testaRC();
      sleep(this.velocidade);
      this.labelcarro.setBounds(this.labelcarro.getX(), this.labelcarro.getY() - 1, 40,60);
    } //Fim do while
    this.indocima = false;
    this.indoesquerda = true;
  } //Fim do andarcimaah()

  //Contrutor do carro
  public Carro(int xinicial, int yinicial, int x1,int y1,int x2,int y2,int x3,int y3, JLabel direita, JLabel baixo, JLabel esquerda, JLabel cima, int rx, int ry, String sentido, String cor){
    this.xi = xinicial;
    this.yi = yinicial;
    this.x11 = x1;
    this.y11 = y1;
    this.x22 = x2;
    this.y22 = y2;
    this.x33 = x3;
    this.y33 = y3;
    this.dir = direita;
    this.ba = baixo;
    this.esq = esquerda;
    this.ci = cima;
    this.rxx = rx;
    this.ryy = ry;
    this.sent = sentido;
    this.c = cor;
  } //Fim do contrutor Carro()

  /********************************************************************* 
  * Metodo: setConfig.
  * Funcao: Define o sentido e o ponto inicial do carro, configurando tambem sua label e etc.
  * Parametros: nenhum.
  * Retorno: void.
  ********************************************************************* */
  public void setConfig(){
    if(this.sent.equals("h")){
      this.indodireita = true;
      this.labelcarro = new JLabel(dir.getIcon());
      this.labelcarro.setBounds(xi,yi, rxx, ryy);
    }else if(this.sent.equals("ah")){
      this.indoesquerda = true;
      this.labelcarro = new JLabel(esq.getIcon());
      this.labelcarro.setBounds(xi,yi, rxx, ryy);
    } //Fim do ifelse
  } //Fim do setConfig()

  /********************************************************************* 
  * Metodo: testaRC()
  * Funcao: Metodo para verificar, a cada pixel, se o carro precisa requerir a um semaphore ou nao de acordo com sua cor
  * Parametros: nenhum.
  * Retorno: void.
  ********************************************************************* */
  private void testaRC() throws InterruptedException{
    if(this.c.equals("cinza")){
      this.checaRC1cinza();
      this.checaRC2cinza();
      this.checaRC3cinza();
      this.checaRC19cinza();
      this.checaRC4cinza();
      this.checaRC5cinza();
      this.checaRC6cinza();
    }else if(this.c.equals("azul")){
      this.checaRC1azul();
      this.checaRC7azul();
      this.checaRC12azul();
      this.checaRC16azul();
      this.checaRC20azul();
    }else if(this.c.equals("marrom")){
      this.checaRC2marrom();
      this.checaRC7marrom();
      this.checaRC8marrom();
      this.checaRC9marrom();
    }else if(this.c.equals("rosa")){
      this.checaRC3rosa();
      this.checaRC19rosa();
      this.checaRC8rosa();
      this.checaRC10rosa();
      this.checaRC11rosa();
    }else if(this.c.equals("vermelho")){
      this.checaRC4vermelho();
      this.checaRC11vermelho();
      this.checaRC13vermelho();
      this.checaRC18vermelho();
    }else if(this.c.equals("verde")){
      this.checaRC5verde();
      this.checaRC14verde();
      this.checaRC17verde();
      this.checaRC18verde();
    }else if(this.c.equals("amarelo")){
      this.checaRC6amarelo();
      this.checaRC14amarelo();
      this.checaRC15amarelo();
      this.checaRC16amarelo();
      this.checaRC20amarelo();
    }else if(this.c.equals("preto")){
      this.checaRC9preto();
      this.checaRC10preto();
      this.checaRC12preto();
      this.checaRC13preto();
      this.checaRC15preto();
      this.checaRC17preto();
      this.checaRC20preto();
    } //Fim do ifelse
  } //Fim do testaRC()

  public JLabel getLabelcarro() {
    return this.labelcarro;
  }
  public void setLabelcarro(JLabel labelcarro) {
    this.labelcarro = labelcarro;
  }
 

  //Abaixo temos uma sequencia de metodos que verifica o acquire e release de casa RC, parte muito importante
  public void checaRC1cinza() throws InterruptedException{
    if(this.labelcarro.getX() == 0 && this.labelcarro.getY() == 415){
      rc1.acquire();
    }else if(this.labelcarro.getX() == 0 && this.labelcarro.getY() == 130){
      rc1.release();
    } //Fim do ifelse
  } //Fim do checaRC1cinza()

  public void checaRC1azul() throws InterruptedException{
    if(this.labelcarro.getX() == 50 && this.labelcarro.getY() == 180){
      rc1.acquire();
    }else if(this.labelcarro.getX() == 50 && this.labelcarro.getY() == 375){
      rc1.release();
    } //Fim do ifelse
  } //Fim do checaRC1azul()
  

  public void checaRC2cinza() throws InterruptedException{
    if(this.labelcarro.getX() == 100 && this.labelcarro.getY() == 0){
      rc2.acquire();
    }else if(this.labelcarro.getX() == 450 && this.labelcarro.getY() == 0){
      rc2.release();
    } //Fim do ifelse
  } //Fim do checaRC2cinza()

  public void checaRC2marrom() throws InterruptedException{
    if(this.labelcarro.getX() == 100 && this.labelcarro.getY() == 64){
      rc2.acquire();
    }else if(this.labelcarro.getX() == 370 && this.labelcarro.getY() == 60){
      rc2.release();
    } //Fim do ifelse
  } //Fim do checaRC2marrom()

  public void checaRC3cinza() throws InterruptedException{
    if(this.labelcarro.getX() == 330 && this.labelcarro.getY() == 0){
      rc3.acquire();
    }else if(this.labelcarro.getX() == 710 && this.labelcarro.getY() == 0){
      rc3.release();
    } //Fim do ifelse
  } //Fim do checaRC3cinza()

  public void checaRC3rosa() throws InterruptedException{
    if(this.labelcarro.getX() == 620 && this.labelcarro.getY() == 60){
      rc3.acquire();
    }else if(this.labelcarro.getX() == 360 && this.labelcarro.getY() == 70){
      rc3.release();
    } //Fim do ifelse
  } //Fim do checaRC3rosa()

  public void checaRC4cinza() throws InterruptedException{
    if(this.labelcarro.getX() == 760 && this.labelcarro.getY() == 160){
      rc4.acquire();
    }else if(this.labelcarro.getX() == 760 && this.labelcarro.getY() == 420){
      rc4.release();
    } //Fim do ifelse
  } //Fim do checaRC4cinza()

  public void checaRC4vermelho() throws InterruptedException{
    if(this.labelcarro.getX() == 750 && this.labelcarro.getY() == 180){
      rc4.acquire();
    }else if(this.labelcarro.getX() == 750 && this.labelcarro.getY() == 375){
      rc4.release();
    } //Fim do ifelse
  } //Fim do checaRC4vermelho()

  public void checaRC5cinza() throws InterruptedException{
    if(this.labelcarro.getX() == 750 && this.labelcarro.getY() == 560){
      rc5.acquire();
    }else if(this.labelcarro.getX() == 310 && this.labelcarro.getY() == 560){
      rc5.release();
    } //Fim do ifelse
  } //Fim do checaRC5cinza()

  public void checaRC5verde() throws InterruptedException{
    if(this.labelcarro.getX() == 650 && this.labelcarro.getY() == 500){
      rc5.acquire();
    }else if(this.labelcarro.getX() == 380 && this.labelcarro.getY() == 500){
      rc5.release();
    } //Fim do ifelse
  } //Fim do checaRC5verde()

  public void checaRC6cinza() throws InterruptedException{
    if(this.labelcarro.getX() == 420 && this.labelcarro.getY() == 560){
      rc6.acquire();
    }else if(this.labelcarro.getX() == 38 && this.labelcarro.getY() == 560){
      rc6.release();
    } //Fim do ifelse
  } //Fim do checaRC6cinza()

  public void checaRC6amarelo() throws InterruptedException{
    if(this.labelcarro.getX() == 100 && this.labelcarro.getY() == 500){
      rc6.acquire();
    }else if(this.labelcarro.getX() == 375 && this.labelcarro.getY() == 500){
      rc6.release();
    } //Fim do ifelse
  } //Fim do checaRC6amarelo()

  public void checaRC7azul() throws InterruptedException{
    if(this.labelcarro.getX() == 260 && this.labelcarro.getY() == 240){
      rc7.acquire();
    }else if(this.labelcarro.getX() == 60 && this.labelcarro.getY() == 180){
      rc7.release();
    } //Fim do ifelse
  } //Fim do checaRC7azul()

  public void checaRC7marrom() throws InterruptedException{
    if(this.labelcarro.getX() == 320 && this.labelcarro.getY() == 180){
      rc7.acquire();
    }else if(this.labelcarro.getX() == 100 && this.labelcarro.getY() == 140){
      rc7.release();
    } //Fim do ifelse
  } //Fim do checaRC7marrom()

  public void checaRC8marrom() throws InterruptedException{
    if(this.labelcarro.getX() == 322 && this.labelcarro.getY() == 0){
      rc8.acquire();
    }else if(this.labelcarro.getX() == 340 && this.labelcarro.getY() == 180){
      rc8.release();
    } //Fim do ifelse
  } //Fim do checaRC8marrom()

  public void checaRC8rosa() throws InterruptedException{
    if(this.labelcarro.getX() == 420 && this.labelcarro.getY() == 0){
      rc8.acquire();
    }else if(this.labelcarro.getX() == 440 && this.labelcarro.getY() == 180){
      rc8.release();
    } //Fim do ifelse
  } //Fim do checaRC8rosa()

  public void checaRC9preto() throws InterruptedException{
    if(this.labelcarro.getX() == 430 && this.labelcarro.getY() == 180){
      rc9.acquire();
    }else if(this.labelcarro.getX() == 260 && this.labelcarro.getY() == 255){
      rc9.release();
    } //Fim do ifelse
  } //Fim do checaRC9rosa()

  public void checaRC9marrom() throws InterruptedException{
    if(this.labelcarro.getX() == 370 && this.labelcarro.getY() == 150){
      rc9.acquire();
    }else if(this.labelcarro.getX() == 240 && this.labelcarro.getY() == 180){
      rc9.release();
    } //Fim do ifelse
  } //Fim do checaRC9marrom()

  public void checaRC10preto() throws InterruptedException{
    if(this.labelcarro.getX() == 520 && this.labelcarro.getY() == 240){
      rc10.acquire();
    }else if(this.labelcarro.getX() == 330 && this.labelcarro.getY() == 180){
      rc10.release();
    } //Fim do ifelse
  } //Fim do checaRC10preto()

  public void checaRC10rosa() throws InterruptedException{
    if(this.labelcarro.getX() == 360 && this.labelcarro.getY() == 120){
      rc10.acquire();
    }else if(this.labelcarro.getX() == 600 && this.labelcarro.getY() == 180){
      rc10.release();
    } //Fim do ifelse
  } //Fim do checaRC10rosa()

  public void checaRC11rosa() throws InterruptedException{
    if(this.labelcarro.getX() == 500 && this.labelcarro.getY() == 180){
      rc11.acquire();
    }else if(this.labelcarro.getX() == 620 && this.labelcarro.getY() == 140){
      rc11.release();
    } //Fim do ifelse
  } //Fim do checaRC11rosa()

  public void checaRC11vermelho() throws InterruptedException{
    if(this.labelcarro.getX() == 520 && this.labelcarro.getY() == 220){
      rc11.acquire();
    }else if(this.labelcarro.getX() == 700 && this.labelcarro.getY() == 180){
      rc11.release();
    } //Fim do ifelse
  } //Fim do checaRC11vermelho()

  public void checaRC12preto() throws InterruptedException{
    if(this.labelcarro.getX() == 310 && this.labelcarro.getY() == 180){
      rc12.acquire();
    }else if(this.labelcarro.getX() == 310 && this.labelcarro.getY() == 375){
      rc12.release();
    } //Fim do ifelse
  } //Fim do checaRC12preto()

  public void checaRC12azul() throws InterruptedException{
    if(this.labelcarro.getX() == 210 && this.labelcarro.getY() == 375){
      rc12.acquire();
    }else if(this.labelcarro.getX() == 240 && this.labelcarro.getY() == 180){
      rc12.release();
    } //Fim do ifelse
  } //Fim do checaRC12azul()

  public void checaRC13preto() throws InterruptedException{
    if(this.labelcarro.getX() == 520 && this.labelcarro.getY() == 375){
      rc13.acquire();
    }else if(this.labelcarro.getX() == 520 && this.labelcarro.getY() == 180){
      rc13.release();
    } //Fim do ifelse
  } //Fim do checaRC13preto()

  public void checaRC13vermelho() throws InterruptedException{
    if(this.labelcarro.getX() == 550 && this.labelcarro.getY() == 375){
      rc13.acquire();
    }else if(this.labelcarro.getX() == 550 && this.labelcarro.getY() == 180){
      rc13.release();
    } //Fim do ifelse
  } //Fim do checaRC13vermelho()

  public void checaRC14amarelo() throws InterruptedException{
    if(this.labelcarro.getX() == 320 && this.labelcarro.getY() == 560){
      rc14.acquire();
    }else if(this.labelcarro.getX() == 360 && this.labelcarro.getY() == 375){
      rc14.release();
    } //Fim do ifelse
  } //Fim do checaRC14amarelo()

  public void checaRC14verde() throws InterruptedException{
    if(this.labelcarro.getX() == 430 && this.labelcarro.getY() == 560){
      rc14.acquire();
    }else if(this.labelcarro.getX() == 430 && this.labelcarro.getY() == 375){
      rc14.release();
    } //Fim do ifelse
  } //Fim do checaRC14verde()

  public void checaRC15amarelo() throws InterruptedException{
    if(this.labelcarro.getX() == 375 && this.labelcarro.getY() == 440){
      rc15.acquire();
    }else if(this.labelcarro.getX() == 215 && this.labelcarro.getY() == 375){
      rc15.release();
    } //Fim do ifelse
  } //Fim do checaRC15amarelo()

  public void checaRC15preto() throws InterruptedException{
    if(this.labelcarro.getX() == 260 && this.labelcarro.getY() == 300){ // 420, 375
      rc15.acquire();
    }else if(this.labelcarro.getX() == 420 && this.labelcarro.getY() == 375){
      rc15.release();
    } //Fim do ifelse
  } //Fim do checaRC15preto()

  public void checaRC16amarelo() throws InterruptedException{
    if(this.labelcarro.getX() == 320 && this.labelcarro.getY() == 375){
      rc16.acquire();
    }else if(this.labelcarro.getX() == 100 && this.labelcarro.getY() == 430){
      rc16.release();
    } //Fim do ifelse
  } //Fim do checaRC16amarelo()

  public void checaRC16azul() throws InterruptedException{
    if(this.labelcarro.getX() == 70 && this.labelcarro.getY() == 375){
      rc16.acquire();
    }else if(this.labelcarro.getX() == 260 && this.labelcarro.getY() == 345){
      rc16.release();
    } //Fim do ifelse
  } //Fim do checaRC16azul()

  public void checaRC17verde() throws InterruptedException{
    if(this.labelcarro.getX() == 380 && this.labelcarro.getY() == 425){
      rc17.acquire();
    }else if(this.labelcarro.getX() == 580 && this.labelcarro.getY() == 375){
      rc17.release();
    } //Fim do ifelse
  } //Fim do checaRC17verde()

  public void checaRC17preto() throws InterruptedException{
    if(this.labelcarro.getX() == 340 && this.labelcarro.getY() == 375){
      rc17.acquire();
    }else if(this.labelcarro.getX() == 520 && this.labelcarro.getY() == 350){
      rc17.release();
    } //Fim do ifelse
  } //Fim do checaRC17preto()

  public void checaRC18verde() throws InterruptedException{
    if(this.labelcarro.getX() == 470 && this.labelcarro.getY() == 375){
      rc18.acquire();
    }else if(this.labelcarro.getX() == 650 && this.labelcarro.getY() == 430){
      rc18.release();
    } //Fim do ifelse
  } //Fim do checaRC18verde()

  public void checaRC18vermelho() throws InterruptedException{
    if(this.labelcarro.getX() == 730 && this.labelcarro.getY() == 375){
      rc18.acquire();
    }else if(this.labelcarro.getX() == 520 && this.labelcarro.getY() == 320){
      rc18.release();
    } //Fim do ifelse
  } //Fim do checaRC18vermelho()

  public void checaRC19rosa() throws InterruptedException{
    if(this.labelcarro.getX() == 440 && this.labelcarro.getY() == 0){
      rc19.acquire();
    }else if(this.labelcarro.getX() == 360 && this.labelcarro.getY() == 70){
      rc19.release();
    } //Fim do ifelse
  } //Fim do checaRC19rosa()

  public void checaRC19cinza() throws InterruptedException{
    if(this.labelcarro.getX() == 330 && this.labelcarro.getY() == 0){
      rc19.acquire();
    }else if(this.labelcarro.getX() == 400 && this.labelcarro.getY() == 0){
      rc19.release();
    } //Fim do ifelse
  } //Fim do checaRC19cinza()

  public void checaRC20azul() throws InterruptedException{
    if(this.labelcarro.getX() == 65 && this.labelcarro.getY() == 375){
      rc20.acquire();
    }else if(this.labelcarro.getX() == 240 && this.labelcarro.getY() == 180){
      rc20.release();
    } //Fim do ifelse
  } //Fim do checaRC20azul()

  public void checaRC20preto() throws InterruptedException{
    if(this.labelcarro.getX() == 330 && this.labelcarro.getY() == 180){
      rc20.acquire();
    }else if(this.labelcarro.getX() == 445 && this.labelcarro.getY() == 375){
      rc20.release();
    } //Fim do ifelse
  } //Fim do checaRC20preto()

  public void checaRC20amarelo() throws InterruptedException{
    if(this.labelcarro.getX() == 375 && this.labelcarro.getY() == 431){
      rc20.acquire();
    }else if(this.labelcarro.getX() == 100 && this.labelcarro.getY() == 440){
      rc20.release();
    } //Fim do ifelse
  } //Fim do checaRC20amarelo()

  public int getVelocidade() {
    return velocidade;
  } //Fim do getVelocidade()

  public void setVelocidade(int velocidade) {
    this.velocidade = velocidade;
  } //Fim do setVelocidade
} //Fim da classe Carro