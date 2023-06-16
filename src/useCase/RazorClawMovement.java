package useCase;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import aliens.Alien;
import estruturasDeDados.Pilha;
import telas.TelaJogo;

public class RazorClawMovement extends Thread{
	private Alien alienLabel;
	private JLabel barra, contagemNumeroOnda;
	private Pilha pilha;
	private static int perigoRazor = 0;
	private static int velocidadeRazor = 4;
private boolean chegouNaDireita = false;
    public RazorClawMovement(Alien alienLabel, JLabel barraPerigo, Pilha pilha,JLabel contagemOnda) {
        this.alienLabel = alienLabel;
        barra = barraPerigo;
        this.pilha = pilha;
        contagemNumeroOnda = contagemOnda;
    }


    @Override
    public void run() {
        while (alienLabel.getAlienVida() != 0) {
            // Atualize a posição do JLabel aqui
        	if(alienLabel.getAlienVida() <= 7) {
        		velocidadeRazor = 6;
        	}
        	if(alienLabel.getX() < 1700 && chegouNaDireita == false) {
        	RazorEsquerda();
        }else {
        	
        	RazorDireita();
        }
        	
        	try {
                Thread.sleep(7); // Aguarde um pequeno intervalo de tempo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(alienLabel.getAlienVida() <= 0) {
        	EfeitosSonorosEMusicas.efeitoSonoroRazorClawParar();
        	EfeitosSonorosEMusicas.pararMusicaBoss();
        	EfeitosSonorosEMusicas.efeitoSonoroBossDerrotado();
    		int numero = Integer.parseInt(contagemNumeroOnda.getText());
    		numero++;
    		String novoNumero = Integer.toString(numero);
    		contagemNumeroOnda.setText(novoNumero);
    		
    		barra.setBounds(109, 33, pilha.desempilharBoss(perigoRazor), 39);
    	}
    }
    public void RazorEsquerda(){

    	 int currentX = alienLabel.getX();
         int newXDireita = currentX + velocidadeRazor; // Exemplo: move 4 unidade para a direita
         alienLabel.setLocation(newXDireita, alienLabel.getY());
         if(alienLabel.getLocation().x >= 1600) {
         	alienLabel.setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensBosses/RazorClaw1.gif")));
         	chegouNaDireita = true;
         	perigoRazor += 10;
         	barra.setBounds(109, 33, pilha.empilharBoss(10), 39);
         }
 	
     try {
         Thread.sleep(1); // Aguarde um pequeno intervalo de tempo
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
     }
    public void RazorDireita(){

		int currentX = alienLabel.getX();
        int newXEsquerda = currentX - velocidadeRazor; // Exemplo: move 4 unidade para a esquerda
        alienLabel.setLocation(newXEsquerda, alienLabel.getY());
        if(alienLabel.getLocation().x <= 1000) {
        	
        }
        if(alienLabel.getLocation().x <= -750) {
        	alienLabel.setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensBosses/RazorClaw2.gif")));
        	chegouNaDireita = false;
        	perigoRazor += 10;
        	barra.setBounds(109, 33, pilha.empilharBoss(10), 39);
        }
	
    
    }

}
