package useCase;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import aliens.Alien;
import telas.TelaJogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AlienDeathAnimationTask {
    private Alien alien;
    private boolean iconeTrocou = false;
    private boolean iconeTrocou2 = false;
    private boolean iconeTrocou3 = false;
    private Timer timer;
    private Random rand = new Random();
    private JLabel missionComplete;
    private JLabel contagemOnda;
    
    public AlienDeathAnimationTask(Alien alien,JLabel missionComplete, JLabel contagemOnda) {
        this.alien = alien;
        this.missionComplete = missionComplete;
        this.contagemOnda = contagemOnda;
    }

    public void startAnimation(int intervaloEmMilissegundos) {
        // Crie um timer com o intervalo desejado
        timer = new Timer(intervaloEmMilissegundos, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (iconeTrocou) {
                    alien.setVisible(false);
                    timer.setRepeats(false);
                    timer.stop();
                } else {
                	
                    int numeroSorteado = rand.nextInt(1,4);
                    iconeTrocou = true;
                    
              		 if(alien.getSize().height == 280 && alien.getY() == 0) {
              			  alien.setBounds(alien.getX(), alien.getY(), 350, 350);
              		       alien.setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensKilled/acidBlood0.gif")));
              		}
              		else if(alien.getSize().height == 280) {
              			  alien.setBounds(alien.getX(), alien.getY(), 350, 350);
              		       alien.setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensKilled/acidBlood" + numeroSorteado + ".gif")));
              		}
              		else if(alien.getSize().height == 345) {
              			  alien.setBounds(alien.getX(), alien.getY(), 350, 350);
              		       alien.setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensKilled/acidBlood" + numeroSorteado + ".gif")));
              		}
              		else if(alien.getSize().height == 210) {
            			  alien.setBounds(alien.getX(), alien.getY(), 350, 350);
            		       alien.setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensKilled/acidBlood" + numeroSorteado + ".gif")));
            		}
              		else if(alien.getSize().height == 300) {
           			  alien.setBounds(alien.getX(), alien.getY(), 380, 380);
           		       alien.setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensKilled/acidBlood380.gif")));
           		}
              		else if(alien.getSize().height == 380) {
             			  alien.setBounds(alien.getX(), alien.getY(), 380, 380);
             		       alien.setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensKilled/acidBlood380.gif")));
             		}
                	
                    
                    // Defina o tempo de espera após a troca de ícone
                    int tempoEsperaEmMilissegundos = 350; // Tempo desejado em milissegundos

                    // Crie um novo timer para o tempo de espera
                    Timer esperaTimer = new Timer(tempoEsperaEmMilissegundos, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
 
                            alien.setVisible(false); // Defina a visibilidade como false após o tempo de espera
                        }
                    });

                    esperaTimer.setRepeats(false);
                    esperaTimer.start();
                }
            }
        });

        // Inicie o timer
        timer.setRepeats(false);
        timer.start();
    }
    
    public void animationRazorClaw() {
        if (iconeTrocou2) {
            alien.setVisible(false);
        } else {
            iconeTrocou2 = true;
            alien.setBounds(alien.getX(), alien.getY() - 40, 500, 393);
            missionComplete.setVisible(true);
            int direcao = alien.getDirecao();
            if (direcao == 2) {
                alien.setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensBosses/RazorClawDying01.png")));
            } else {
                alien.setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensBosses/RazorClawDying03.png")));
            }
            int tempoEsperaEmMilissegundos = 2000; // Tempo desejado em milissegundos

            // Crie um novo timer para o tempo de espera
            Timer esperaTimer = new Timer(tempoEsperaEmMilissegundos, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    alien.setBounds(alien.getX(), alien.getY() + 200, 550, 173);
                    if (direcao == 2) {
                        alien.setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensBosses/RazorClawDying02.png")));
                    } else {
                        alien.setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensBosses/RazorClawDying04.png")));
                    }

                    // Defina o tempo de espera após a segunda alteração do ícone
                    int tempoEsperaEmMilissegundos2 = 10000; // Tempo desejado em milissegundos

                    // Crie um novo timer para o tempo de espera antes de ocultar o alien
                    Timer esperaTimer2 = new Timer(tempoEsperaEmMilissegundos2, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	alien.setBounds(alien.getX(), alien.getY() -170, 380, 380);
                        	alien.setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensKilled/acidBlood380.gif")));

                            // Defina o tempo de espera antes de ocultar o alien
                            int tempoEsperaEmMilissegundos3 = 350; // Tempo desejado em milissegundos

                            // Crie um novo timer para o tempo de espera antes de ocultar o alien
                            Timer esperaTimer3 = new Timer(tempoEsperaEmMilissegundos3, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    alien.setVisible(false);
                                    missionComplete.setVisible(false);
                                    int numero = Integer.parseInt(contagemOnda.getText());
                            		numero++;
                            		String novoNumero = Integer.toString(numero);
                            		contagemOnda.setText(novoNumero);
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
    
    public void animationGoldenRoyalGuard() {
        if (iconeTrocou3) {
            alien.setVisible(false);
        } else {
        	iconeTrocou3 = true;
            alien.setBounds(alien.getX(), alien.getY() - 40, 500, 393);
            missionComplete.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/defeatTheRoyalGuards.png")));
            missionComplete.setVisible(true);
            int direcao = alien.getDirecao();
            if (direcao == 2) {
                alien.setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensBosses/RazorClawDying01.png")));
            } else {
                alien.setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensBosses/RazorClawDying03.png")));
            }
            int tempoEsperaEmMilissegundos = 2000; // Tempo desejado em milissegundos

            // Crie um novo timer para o tempo de espera
            Timer esperaTimer = new Timer(tempoEsperaEmMilissegundos, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    alien.setBounds(alien.getX(), alien.getY() + 200, 550, 173);
                    if (direcao == 2) {
                        alien.setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensBosses/RazorClawDying02.png")));
                    } else {
                        alien.setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensBosses/RazorClawDying04.png")));
                    }

                    // Defina o tempo de espera após a segunda alteração do ícone
                    int tempoEsperaEmMilissegundos2 = 10000; // Tempo desejado em milissegundos

                    // Crie um novo timer para o tempo de espera antes de ocultar o alien
                    Timer esperaTimer2 = new Timer(tempoEsperaEmMilissegundos2, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	alien.setBounds(alien.getX(), alien.getY() -170, 380, 380);
                        	alien.setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensKilled/acidBlood380.gif")));

                            // Defina o tempo de espera antes de ocultar o alien
                            int tempoEsperaEmMilissegundos3 = 350; // Tempo desejado em milissegundos

                            // Crie um novo timer para o tempo de espera antes de ocultar o alien
                            Timer esperaTimer3 = new Timer(tempoEsperaEmMilissegundos3, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    alien.setVisible(false);
                                    missionComplete.setVisible(false);
                                    int numero = Integer.parseInt(contagemOnda.getText());
                            		numero++;
                            		String novoNumero = Integer.toString(numero);
                            		contagemOnda.setText(novoNumero);
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



    }
    


