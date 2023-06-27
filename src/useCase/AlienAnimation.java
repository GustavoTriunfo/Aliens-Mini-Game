package useCase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import aliens.Alien;
import aliens.AlienGoldenRoyalGuard;
import aliens.AlienGrayRoyalGuard;
import telas.TelaJogo;

public class AlienAnimation extends Thread{
	  private Alien alien;
	  private boolean animacao1 = false;
	    private boolean iconeTrocou = false;
	    private boolean iconeTrocou2 = false;
	    private boolean iconeTrocou3 = false;
	    private Timer timer;
	    private Random rand = new Random();
	    private JLabel missionComplete;
	    private Alien royal1;
	    private Alien royal2;
	    private JPanel contentPane;
	    private AlienThread alienThread = new AlienThread(5,200);
	    private boolean isRunningAlienAnda, isRunningAlienRapido, isRunningMunicao;
	    
	    public AlienAnimation(JLabel missionComplete, JPanel contentPane, boolean isRunningAlienAnda, boolean isRunningAlienRapido, boolean isRunningMunicao) {
	        this.missionComplete = missionComplete;
	        this.contentPane = contentPane;
	        this.isRunningAlienAnda = isRunningAlienAnda;
	        this.isRunningAlienRapido = isRunningAlienRapido;
	        this.isRunningMunicao = isRunningMunicao;
	    }
	    
	    public void animationRoyalsIntro() {
	    	missionComplete.setBounds(350, -150, 1003, 687);
	    	missionComplete.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/defeatTheRoyalGuards.png")));
	    	missionComplete.setVisible(true);
	    	royal1 = new AlienGoldenRoyalGuard();
	    	royal2 = new AlienGrayRoyalGuard();
	    	animationRoyalGuards();        
	    }
	    
	    public void animationRoyalGuards() {
	        if (iconeTrocou) {
	            royal1.setVisible(false);
	            royal2.setVisible(false);
	        } else {
	        	iconeTrocou = true;
	        	
	        	    royal1.setVisible(true);
	        	    contentPane.add(royal1);
		    	    contentPane.revalidate();
		    	    contentPane.repaint();
		    	    contentPane.setComponentZOrder(royal1, royal1.getPosicaoMapa());
	        	
		    	    royal2.setVisible(true);
		    	    contentPane.add(royal2);
		    	    contentPane.revalidate();
		    	    contentPane.repaint();
		    	    contentPane.setComponentZOrder(royal2, royal2.getPosicaoMapa());
		    	    
		    	    Thread thread = new Thread(this, "AnimationThread"); // Cria uma nova thread
		    	    EfeitosSonorosEMusicas.efeitoSonoroRoyalWalking1();
		    	    run();
	         
	            
	            int tempoEsperaEmMilissegundos = 1500; // Tempo desejado em milissegundos

	            // Crie um novo timer para o tempo de espera
	            Timer esperaTimer = new Timer(tempoEsperaEmMilissegundos, new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	royal1.setBounds(850, 280, 454, 410);
	                    royal1.setIcon(new ImageIcon(TelaJogo.class.getResource("/royalGuards/RoyalGuard1Looking1.png")));
	                    royal2.setBounds(400, 280, 446, 380);
	                    royal2.setIcon(new ImageIcon(TelaJogo.class.getResource("/royalGuards/RoyalGuard2Looking2.png")));
	                    EfeitosSonorosEMusicas.efeitoSonoroRoyalsIntro();
	                    // Defina o tempo de espera após a segunda alteração do ícone
	                    int tempoEsperaEmMilissegundos2 = 1500; // Tempo desejado em milissegundos

	                    // Crie um novo timer para o tempo de espera antes de ocultar o alien
	                    Timer esperaTimer2 = new Timer(tempoEsperaEmMilissegundos2, new ActionListener() {
	                        @Override
	                        public void actionPerformed(ActionEvent e) {
	                        	
	                        	royal1.setBounds(550, 280, 764, 420);
	    	                    royal1.setIcon(new ImageIcon(TelaJogo.class.getResource("/royalGuards/RoyalGuard1Walking2.gif")));
	    	                    royal2.setBounds(250, 280, 727, 400);
	    	                    royal2.setIcon(new ImageIcon(TelaJogo.class.getResource("/royalGuards/RoyalGuard2.gif")));
	    	                    EfeitosSonorosEMusicas.efeitoSonoroRoyalWalking1();
	    	                    EfeitosSonorosEMusicas.efeitoSonoroRoyalWalking2();
	    	                    thread.start();
	                            // Defina o tempo de espera antes de ocultar o alien
	                            int tempoEsperaEmMilissegundos3 = 3000; // Tempo desejado em milissegundos

	                            // Crie um novo timer para o tempo de espera antes de ocultar o alien
	                            Timer esperaTimer3 = new Timer(tempoEsperaEmMilissegundos3, new ActionListener() {
	                                @Override
	                                public void actionPerformed(ActionEvent e) {
	                                    royal1.setVisible(false);
	                                    royal2.setVisible(false);
	                                    missionComplete.setVisible(false);
	                                    EfeitosSonorosEMusicas.efeitoSonoroRoyalWalkingParar1();
	                                    EfeitosSonorosEMusicas.efeitoSonoroRoyalWalkingParar2();
	                                    alienThread.start();
	                                    isRunningAlienAnda = true;
	                                    isRunningAlienRapido = true;
	                                    isRunningMunicao = true;
	                                    ThreadsFromGame threadsFromGame = new ThreadsFromGame();
	                                    threadsFromGame.criarAliensAndam();
	                                    threadsFromGame.criarAliensAndamRapido();
	                                    
//	                                    Thread alienThreadAndamRapido = new Thread(TelaJogo::criarAliensAndamRapido); // Crie uma nova instância da thread
//	                                    alienThreadAndamRapido.start();
	                                }
	                            });
	                            esperaTimer3.setRepeats(false);
	                            esperaTimer3.start();
	                        }
	                    });
	                    esperaTimer2.setRepeats(false);
	                    esperaTimer2.start();
	                }
	            });

	            esperaTimer.setRepeats(false);
	            esperaTimer.start();
	        }
}
	    
	    @Override
	    public void run() {
	    	
	    	if(animacao1 == false) {
	    		animacao1 = true;
	        while (royal2.getX() != 180) {
	            // Atualize a posição do JLabel aqui
	        	 int currentX = royal2.getX();
	             int newXDireita = currentX + 2; // Exemplo: move 4 unidade para a direita
	             royal2.setLocation(newXDireita, royal2.getY());
	        	
	        	
	        	try {
	                Thread.sleep(10); // Aguarde um pequeno intervalo de tempo
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        EfeitosSonorosEMusicas.efeitoSonoroRoyalWalkingParar1();
	        royal2.setBounds(400, 280, 446, 380);
            royal2.setIcon(new ImageIcon(TelaJogo.class.getResource("/royalGuards/RoyalGuard2Looking2.png")));
	    	}
	    	
	    	 if (Thread.currentThread().getName().equals("AnimationThread")) {
	    	
	    		 while (royal2.getX() != 1650) {
	 	            // Atualize a posição do JLabel aqui
	 	        	 int currentX1 = royal1.getX();
	 	             int newXDireita1 = currentX1 + 8; // Exemplo: move 4 unidade para a direita
	 	             royal1.setLocation(newXDireita1, royal1.getY());
	 	             
	 	            int currentX2 = royal2.getX();
	 	             int newXDireita2 = currentX2 + 7; // Exemplo: move 4 unidade para a direita
	 	             royal2.setLocation(newXDireita2, royal2.getY());
	 	        	
	 	        	
	 	        	try {
	 	                Thread.sleep(10); // Aguarde um pequeno intervalo de tempo
	 	            } catch (InterruptedException e) {
	 	                e.printStackTrace();
	 	            }
	 	        }
	    		 
	    	
	    	 
	    	 }
	    }
	    
	    
}
