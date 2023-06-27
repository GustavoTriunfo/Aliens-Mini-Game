package telas;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aliens.Alien;
import aliens.Alien1;
import aliens.Alien2;
import aliens.Alien3;
import aliens.Alien4;
import aliens.Alien5;
import aliens.Alien6;
import aliens.Alien7;
import aliens.Alien8;
import aliens.Alien9;
import aliens.AlienGoldenRoyalGuard;
import aliens.AlienGrayRoyalGuard;
import aliens.AlienRazorClaw;
import estruturasDeDados.Fila;
import estruturasDeDados.IntNoAlien;
import estruturasDeDados.IntNoSimples;
import estruturasDeDados.ListaEncadeadaAlien;
import estruturasDeDados.Pilha;
import municao.Municao;
import municao.MunicaoLendaria;
import municao.MunicaoNormal;
import municao.MunicaoRara;
import useCase.AlienAnimation;
import useCase.AlienDeathAnimationTask;
import useCase.AlienFastMovementThread;
import useCase.AlienMovementThread;
import useCase.AlienThread;
import useCase.EfeitosSonorosEMusicas;
import useCase.GerenciarHorda;
import useCase.RazorClawMovement;
import useCase.Stopwatch;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class TelaJogo extends JFrame {

	private static JLabel fundoEntradaPredio = new JLabel("");
	private static JLabel MissionComplete = new JLabel("");
	private static int contagemPontos = 0;
	 private static JLabel pontos = new JLabel("0");
	private static String musicaAtual = null;
	private static int numeroMin = 6;
	private static int ondaAlteraTempoMunicao = 4;
	private static int numeroMax = 9;
	  private static Lock lock = new ReentrantLock();
	private static Alien alienAnda;
	private static Alien alienBoss;
	private static JLabel alienQueAnda = new JLabel();
	private static Alien alienAndaRapido;
	private static int moverX = 100;
	private static JFrame frameFecharJanela = new JFrame();
	private static int tamanhoPerigo = 50;
	private static JLabel perigo = new JLabel("");
	private static Municao municao = null;
    private static int aliensMortosNaOnda = 0;
    private volatile static boolean isRunningVerificaAlien = true;
    private volatile static boolean isRunningAlienAnda = true;
    private volatile static boolean isRunningMunicao = true;
	private volatile static boolean isRunningMusica = true;
	private volatile static boolean isRunningAlienRapido = true;
	private static int numeroPorOnda = 5;
	private static JLabel fundoCidade = new JLabel("");
	private static JLabel fundoMetro = new JLabel("");
	private static JLabel miraArma = new JLabel("");
    private static Alien alien = null;
	private static JLabel sangueDisparo = new JLabel("");
	private static JLabel alien1 = new JLabel("");
	private static int municaoCarga = 99;
	private static int contagemAliens = 0;
	private static int contagemOnda = 1;
	private int BarraPerigo = 0;
	private static JLabel numeroMunicao = new JLabel(Integer.toString(municaoCarga));
	private static JLabel numeroAliens = new JLabel(Integer.toString(contagemAliens));
	
	private static boolean musica1 = false, musica2 = false, musica3 = false, musicaBoss = false, musica4 = false, musica5 = false;
	private static JButton startButton = new JButton("Start");
	private static JLabel fundo = new JLabel("");
	private static JPanel contentPane;
	private static Pilha pilha = new Pilha(800);
	private static Fila fila = new Fila(5);
	private static Random rand = new Random();
	private static JLabel tempo = new JLabel("");
	private final JLabel botaoReset = new JLabel("");
	private static JLabel contagemNumeroOnda = new JLabel(Integer.toString(contagemOnda));
    private static ListaEncadeadaAlien listaEncadeada = new ListaEncadeadaAlien();
	private static GerenciarHorda horda = new GerenciarHorda(tempo,startButton,contagemNumeroOnda,numeroAliens);
    private static  AlienThread alienThread = new AlienThread(5,200);
   
	private Stopwatch stopwatch = new Stopwatch(tempo,startButton,horda,alien1, alienThread );
	//private static EfeitosSonorosEMusicas efeitosSonorosEMusicas = new EfeitosSonorosEMusicas();
	private static ListaEncadeadaAlien listaEncadeadaAlien = new ListaEncadeadaAlien();
	
	private static JLabel municao5 = new JLabel("");
	private static JLabel municao4 = new JLabel("");
	private static JLabel municao3 = new JLabel("");
	private static JLabel municao2 = new JLabel("");
	private static JLabel municao1 = new JLabel("");
	
	
	private static JLabel alien2 = new JLabel("");
	private static JLabel alien3 = new JLabel("");
	private JLabel alien4 = new JLabel("");
	private JLabel alien5 = new JLabel("");
	private JLabel alien6 = new JLabel("");
	
	private final JLabel alienHordeLogo = new JLabel("");

	private final JLabel lblHordaOnda = new JLabel("Horda Onda");
	

	static MouseMotionListener mouseMotionListener = new MouseMotionAdapter() {
		  @Override
		    public void mouseMoved(MouseEvent e) {
		        Point mousePosition = e.getLocationOnScreen();
		        int x = mousePosition.x - fundo.getLocationOnScreen().x - 30;
		        int y = mousePosition.y - fundo.getLocationOnScreen().y - 30;
		        miraArma.setBounds(x, y, 67, 67);
		    }

	    @Override
	    public void mouseDragged(MouseEvent e) {
	    }
	};

	static MouseListener mouseListener = new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
	    	if(!fila.vazia()) {
	    	calcularDisparo();
	    	   alien = (Alien) e.getSource();
	    	alien.danoAlienVida();
	    	EfeitosSonorosEMusicas.efeitoSonoroTiro();
	        if (alien.getAlienVida() == 0) {
	        	
	        	
	        	contagemPontos += alien.getPontos();
	        	pontos.setText(Integer.toString(contagemPontos));

	            tamanhoPerigo -= 100;
	            listaEncadeada.insereNo_inicio(alien.getPontos(), alien);
	            perigo.setBounds(109, 33,  pilha.desempilhar(), 39);
	            EfeitosSonorosEMusicas.efeitoSonoroAlienAbatido(alien.getEfeitoSonoroAbatido());
	            contagemAliens = Integer.parseInt(numeroAliens.getText());
	            contagemAliens++;
	            numeroAliens.setText(Integer.toString(contagemAliens));
	            aliensMortosNaOnda++;
	         // Código para quando o alien morrer
	            AlienDeathAnimationTask alienDied = new AlienDeathAnimationTask(alien,MissionComplete,contagemNumeroOnda);
	            if(alien.getAlienNome().equals("Razor Claw")) {
	            	alienDied.animationRazorClaw();
	            }else {
	      
	            alienDied.startAnimation(50); 
	            }
	        }
	    }else {
	    	EfeitosSonorosEMusicas.efeitoSonoroPenteVazio();
	    }
	    }
	};
	
	static MouseListener mouseListenerAmmo = new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
	    	municao = (Municao) e.getSource();
	    	municaoCarga += municao.getQuantidade();
	    	numeroMunicao.setText(Integer.toString(municaoCarga));    
	    	municao.setVisible(false);
	    	EfeitosSonorosEMusicas.efeitoSonoroPegouMunicao();
	    }
	};

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJogo frame = new TelaJogo();
					frame.setVisible(true);
					frameFecharJanela = frame;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaJogo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaJogo.class.getResource("/images/HordeLogo.png")));
		contagemPontos += Integer.parseInt(pontos.getText());
		fila.enfileirar(1);
		fila.enfileirar(2);
		fila.enfileirar(3);
		fila.enfileirar(4);
		fila.enfileirar(5);
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 960);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		fundo.setHorizontalAlignment(SwingConstants.RIGHT);
	
		fundo.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				  miraArma.setBounds(e.getX() -30, e.getY() -30, 67, 67);
				
			}
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		
		sangueDisparo.setVisible(false);
		
		
		fundo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!fila.vazia()) {
				disparar();
				EfeitosSonorosEMusicas.efeitoSonoroTiro();
				}
//				if(miraArma.getLocation().x == 3) {
//				sangueDisparo.setVisible(true);
//				sangueDisparo.setBounds(e.getX() -120, e.getY() -130, 241, 170);
//				}
			else {
				EfeitosSonorosEMusicas.efeitoSonoroPenteVazio();
			}
			}
		});
						
						JLabel botaoRecarregar = new JLabel("");
						botaoRecarregar.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/reloadButton.png")));
						botaoRecarregar.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								if(!fila.cheia() && municaoCarga > 0) {
								recarregar();
								EfeitosSonorosEMusicas.efeitoSonoroRecarregou();
								}
							}
							@Override
							public void mouseEntered(MouseEvent e) {
								botaoRecarregar.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/reloadButton.png")));
							}
							@Override
							public void mouseExited(MouseEvent e) {
								botaoRecarregar.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/reloadButton.png")));
							}
							@Override
							public void mousePressed(MouseEvent e) {
								botaoRecarregar.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/reloadButton.png")));
							}
							@Override
							public void mouseReleased(MouseEvent e) {
								botaoRecarregar.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/reloadButton.png")));
							}
						});
						pontos.setForeground(Color.WHITE);
						pontos.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 50));
						pontos.setBounds(109, 99, 308, 91);
						
						contentPane.add(pontos);
						
						JLabel ammo = new JLabel("");
						ammo.setBounds(453, 617, 150, 80);
						contentPane.add(ammo);
						
						
						
						startButton.setBounds(991, 33, 220, 51);
						startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						startButton.setForeground(Color.BLACK);
						startButton.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 34));
						startButton.setBounds(1012, 33, 199, 51);
						contentPane.add(startButton);

						tempo.setForeground(Color.WHITE);
						tempo.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 45));

						tempo.setBounds(109, 201, 228, 91);
						
						contentPane.add(tempo);
						contagemNumeroOnda.setForeground(Color.WHITE);
						contagemNumeroOnda.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 50));
						contagemNumeroOnda.setBounds(932, 748, 134, 91);
						
						contentPane.add(contagemNumeroOnda);
						lblHordaOnda.setForeground(Color.WHITE);
						lblHordaOnda.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 45));
						lblHordaOnda.setBounds(540, 750, 526, 91);
						
						contentPane.add(lblHordaOnda);
						numeroAliens.setHorizontalAlignment(SwingConstants.RIGHT);
						numeroAliens.setForeground(new Color(255, 0, 0));
						numeroAliens.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 50));
						numeroAliens.setBounds(1208, 33, 180, 91);
						
						contentPane.add(numeroAliens);
						alienHordeLogo.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/HordeLogo.png")));
						alienHordeLogo.setBounds(1389, 10, 115, 115);
						
						contentPane.add(alienHordeLogo);
						botaoRecarregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						botaoRecarregar.setBounds(1108, 732, 120, 120);
						contentPane.add(botaoRecarregar);
						
						
						numeroMunicao.setForeground(Color.WHITE);
						numeroMunicao.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 50));
						numeroMunicao.setBounds(1238, 748, 165, 91);
						contentPane.add(numeroMunicao);
						
						
						municao5.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/balaDisparo.png")));
						municao5.setBounds(368, 720, 71, 132);
						contentPane.add(municao5);
						
						
						municao4.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/balaDisparo.png")));
						municao4.setBounds(299, 720, 71, 132);
						contentPane.add(municao4);
						
					
						municao3.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/balaDisparo.png")));
						municao3.setBounds(231, 720, 71, 132);
						contentPane.add(municao3);
						
					
						municao2.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/balaDisparo.png")));
						municao2.setBounds(161, 720, 71, 132);
						contentPane.add(municao2);
						
					
						municao1.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/balaDisparo.png")));
						municao1.setBounds(92, 720, 71, 132);
						contentPane.add(municao1);
						
						JLabel caveira = new JLabel("");
						caveira.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/caveiraMorte.png")));
						caveira.setBounds(605, 10, 80, 73);
						contentPane.add(caveira);
					
					
						miraArma.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/miraArmaRed.png")));
						miraArma.setBounds(902, 400, 67, 67);
						contentPane.add(miraArma);
				
				
				perigo.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/barraDePerigo.png")));
				perigo.setBounds(109, 33, 50, 39);
				contentPane.add(perigo);
		sangueDisparo.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/blood1Tiro (2).gif")));
		sangueDisparo.setBounds(1010, 363, 241, 170);
		contentPane.add(sangueDisparo);
		
		alien4.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/aliensSprites/alienRoyal1 (1).gif")));
		alien4.setBounds(898, 358, 676, 380);
		alien4.setVisible(false);
		contentPane.add(alien4);
		
	
		alien3.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/aliensSprites/Alien11.gif")));
		alien3.setBounds(783, 328, 534, 380);
		alien3.setVisible(false);
		contentPane.add(alien3);
		alien6.setHorizontalAlignment(SwingConstants.RIGHT);
	
		alien6.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/aliensSprites/Alien3.gif")));
		alien6.setBounds(435, 417, 428, 280);
		alien6.setVisible(false);
		contentPane.add(alien6);
		contentPane.add(alien5);
		
		
		fundoMetro.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/fundoCenarioMetro (2).gif")));
		fundoMetro.setVisible(false);
		
		
		fundoCidade.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/fundoCenarioCidade (1).gif")));
		fundoCidade.setVisible(false);
		

		MissionComplete.setVisible(false);
		MissionComplete.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/missionComplete.png")));
		MissionComplete.setBounds(445, 35, 1003, 687);
		contentPane.add(MissionComplete);
		

		fundoEntradaPredio.setVisible(false);
		fundoEntradaPredio.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/fundoCenarioEntradaPredio.gif")));
		fundoEntradaPredio.setBounds(-146, 36, 1920, 1090);
		contentPane.add(fundoEntradaPredio);
		fundoCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		fundoCidade.setBounds(36, -314, 1982, 1121);
		contentPane.add(fundoCidade);
		fundoMetro.setHorizontalAlignment(SwingConstants.RIGHT);
		fundoMetro.setBounds(36, -47, 1920, 960);
		contentPane.add(fundoMetro);
		//contentPane.add(alien2);
		
	
		fundo.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/fundoCenarioClaro.png")));
		fundo.setBounds(0, 0, 1920, 960);
		contentPane.add(fundo);

	}
	
	public static void disparar() {
		fila.desenfileirar();
		int opcao =  fila.getTotal();
		switch(opcao) {
		case 0: municao1.setVisible(false);
		break;
		case 1: municao2.setVisible(false);
			break;
		case 2: municao3.setVisible(false);
		break;
		case 3: municao4.setVisible(false);
		break;
		case 4: municao5.setVisible(false);
		break;
		}
	}
	
	public void recarregar() {
		//for(int i = 0; i <= municaoCarga; i++) {
		fila.enfileirar(5);
		municaoCarga--;
		
		int opcao =  fila.getTotal();
		switch(opcao) {
		case 1: municao1.setVisible(true);
			break;
		case 2: municao2.setVisible(true);
		break;
		case 3: municao3.setVisible(true);
		break;
		case 4: municao4.setVisible(true);
		break;
		case 5: municao5.setVisible(true);
		break;
		}
		//}
		numeroMunicao.setText(Integer.toString(municaoCarga));
	}
	
	public static  void criarAlienQueAnda() {
		int nivelOnda = 0;
	    if (Integer.parseInt(contagemNumeroOnda.getText()) <= 10) {
        nivelOnda = 9;
    } else if (Integer.parseInt(contagemNumeroOnda.getText()) > 10 && Integer.parseInt(contagemNumeroOnda.getText()) < 15) {
        nivelOnda = 15;
    }
	    int alienSorteado = rand.nextInt(1, nivelOnda);

			if(alienSorteado < 9) {
				alienAnda = new Alien4(alienSorteado);
			}
			else if(alienSorteado == 9 || alienSorteado == 10) {
	    	alienAnda = new Alien7(alienSorteado);
			}
			else if(alienSorteado == 11 || alienSorteado == 12) {
			alienAnda = new Alien8(alienSorteado);
			}
			else if(alienSorteado == 13 || alienSorteado == 14) {
				alienAnda = new Alien9(alienSorteado);
				}
	    	if(alienAnda.getNumeroIcone() % 2 == 1 && alienAnda.getAlienNome().equals("Moving Warrior")) {
	    		alienAnda.setLocation(1400, 400);
	    	}
	    	AlienMovementThread movementThread = new AlienMovementThread(alienAnda, alienAnda.getNumeroIcone());
	    	 movementThread.start();

	
	   
   	
	    if (alienAnda != null) {
	    	alienAnda.addMouseMotionListener(mouseMotionListener);
	    alienAnda.addMouseListener(mouseListener);
	    alienAnda.setVisible(true);
	    tamanhoPerigo += 100;
	    perigo.setBounds(109, 33, pilha.empilhar(alienAnda), 39);

	    alienAnda.setEnabled(true);
	    alienAnda.setFocusable(true);
	    contentPane.add(alienAnda);
	    contentPane.revalidate();
	    contentPane.repaint();
	    contentPane.setComponentZOrder(alienAnda, alienAnda.getPosicaoMapa());
	    contentPane.repaint();
	    }
	    

	    
	}
	
public static void criarAlienQueAndaRapido() {
		
	    int alienSorteado = rand.nextInt(1, 4);

//	  if(alienSorteado >= 9 && alienSorteado <= 16) {
	
	    alienAndaRapido = new Alien5(alienSorteado);

	    	if(alienAndaRapido.getNumeroIcone() % 2 == 1) {
	    		alienAndaRapido.setLocation(1400, 0);
	    	}
	    	AlienFastMovementThread fastMovementThread = new AlienFastMovementThread(alienAndaRapido, alienAndaRapido.getNumeroIcone());
	    	 fastMovementThread.start();
	    	//}
	
	   
   	
	    if (alienAndaRapido != null) {
	    	alienAndaRapido.addMouseMotionListener(mouseMotionListener);
	    alienAndaRapido.addMouseListener(mouseListener);
	    alienAndaRapido.setVisible(true);
	    //tamanhoPerigo += 100;
	    perigo.setBounds(109, 33, pilha.empilhar(alienAndaRapido), 39);

	    alienAndaRapido.setEnabled(true);
	    alienAndaRapido.setFocusable(true);
	    contentPane.add(alienAndaRapido);
	    contentPane.revalidate();
	    contentPane.repaint();
	    contentPane.setComponentZOrder(alienAndaRapido, alienAndaRapido.getPosicaoMapa());
	    contentPane.repaint();
	    }
	    

	    
	}

	public static void criarAlien() {
		

	    int nivelOnda = 0;
	    if (Integer.parseInt(contagemNumeroOnda.getText()) <= 4) {
	        nivelOnda = 11;
	    } else if (Integer.parseInt(contagemNumeroOnda.getText()) > 4 && Integer.parseInt(contagemNumeroOnda.getText()) <= 10) {
	        nivelOnda = 13;
	    }
	    else if (Integer.parseInt(contagemNumeroOnda.getText()) > 10 && Integer.parseInt(contagemNumeroOnda.getText()) <= 14) {
	        nivelOnda = 15;
	    }
	  
	    int alienSorteado = rand.nextInt(1, nivelOnda);
	    //String numeroAleatorio = Integer.toString(alienSorteado);

	    if (alienSorteado == 9 || alienSorteado == 10) {
	        alien = new Alien1(alienSorteado);
	    } 
	    else if(alienSorteado < 9){
	        alien = new Alien2(alienSorteado);
	    }
	    	
	    else if (alienSorteado == 11 || alienSorteado == 12) {
	            alien = new Alien3(alienSorteado);
	        }
	    else if (alienSorteado == 13 || alienSorteado == 14) {
            alien = new Alien6(alienSorteado);
        }
	   
    	
	    if (alien != null) {
	    alien.addMouseMotionListener(mouseMotionListener);
	    alien.addMouseListener(mouseListener);
	    alien.setVisible(true);
	    tamanhoPerigo += 100;
	    perigo.setBounds(109, 33, pilha.empilhar(alien), 39);
	    alien.setEnabled(true);
	    alien.setFocusable(true);
	    contentPane.add(alien);
	    contentPane.revalidate();
	    contentPane.repaint();
	    contentPane.setComponentZOrder(alien, alien.getPosicaoMapa());
	    contentPane.repaint();
	    }
	    

	}
	    
	
	public static int posicaoXAleatorio() {
		return rand.nextInt(450,900);
	}
	
public static void calcularDisparo() {
	MouseEvent e = null;
	if(!fila.vazia()) {
		disparar();
		}
		if(miraArma.getLocation().x == 3) {
		sangueDisparo.setVisible(true);
		sangueDisparo.setBounds(e.getX() -120, e.getY() -130, 241, 170);
		}
}

public static void criarMunicao() {
//	 int nivelOnda = 0;
//	    if (Integer.parseInt(contagemNumeroOnda.getText()) <= 4) {
//	        nivelOnda = 10;
//	    } else if (Integer.parseInt(contagemNumeroOnda.getText()) > 4 && Integer.parseInt(contagemNumeroOnda.getText()) <= 8) {
//	        nivelOnda = 12;
//	    }

	    int municaoSorteada = rand.nextInt(1, 66);
	  //  String numeroAleatorio = Integer.toString(municaoSorteada);
	   // if (nivelOnda > 4 && nivelOnda <= 8) {
	        if (municaoSorteada >= 64) {
	            municao = new MunicaoLendaria();
	        }
	   // }
	    else if (municaoSorteada > 48 && municaoSorteada < 64) {
	    	municao = new MunicaoRara();
	    } else {
	    	municao = new MunicaoNormal();
	    }
	   
	   
	    municao.addMouseMotionListener(mouseMotionListener);
	    municao.addMouseListener(mouseListenerAmmo);
	    municao.setVisible(true);

	    municao.setEnabled(true);
	    municao.setFocusable(true);
	    contentPane.add(municao);
	    contentPane.revalidate();
	    contentPane.repaint();
	    contentPane.setComponentZOrder(municao, municao.getPosicaoMapa());
	    contentPane.repaint();
}
public static void iniciarVerificacaoAlienOnda() {
		threadVerificaAliens.start();
	}

static Thread threadVerificaAliens = new Thread(() -> {
    while (isRunningVerificaAlien == true) {
    	if(perigo.getWidth() >= 500) {
    		pararMusicas();
    		listaEncadeada.exibeLista();
       		TelaJogoPerdido perdeu = new TelaJogoPerdido(pontos,tempo,numeroAliens);
    		perdeu.setVisible(true);
    		frameFecharJanela.dispose();
    		isRunningVerificaAlien = false;
    		isRunningMunicao = false;
    		isRunningMusica = false;
    		

    		//System.exit(0);
    	}
        if (aliensMortosNaOnda > numeroPorOnda ) {
        	contagemOnda++;
        	aliensMortosNaOnda = 0;
        	numeroPorOnda += 3;
        	String novoNumero = Integer.toString(contagemOnda);
    		contagemNumeroOnda.setText(novoNumero);
  		
            // Ação a ser executada quando não houver mais aliens na tela
            System.out.println("Onda de aliens finalizada");    
            // Você pode adicionar aqui qualquer ação que deseje executar quando a onda de aliens acabar
            
//            break; // Encerra o loop da thread
        }
        
        try {
            Thread.sleep(1000); // Aguarda 1 segundo antes de verificar novamente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
});


public static void iniciarCriacaoMunicao() {
	threadCriaMunicao.start();
	}

static Thread threadCriaMunicao = new Thread(() -> {
    while (isRunningMunicao == true) {
    	 numeroMax = 8;
    	int tempoAleatorio = rand.nextInt(numeroMin,numeroMax);
        if (aliensMortosNaOnda > 2 ) {
        	criarMunicao();
        	int ondaAtual = Integer.parseInt(contagemNumeroOnda.getText());
    		if(ondaAtual == ondaAlteraTempoMunicao) {
    			if(numeroMax != numeroMin) {
    			numeroMax -= 2;
    			}else {
    				numeroMin -= 2;
    			}
    			ondaAlteraTempoMunicao += 3;
    		}
            // Ação a ser executada quando não houver mais aliens na tela
            System.out.println("municao Criada");    
            // Você pode adicionar aqui qualquer ação que deseje executar quando a onda de aliens acabar
            
//            break; // Encerra o loop da thread
        }
        
        try {
        	 TimeUnit.SECONDS.sleep(tempoAleatorio);
            //Thread.sleep(1000); // Aguarda 1 segundo antes de verificar novamente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
});

public static void gerenciarMusicas() {
	gerenciarMusicas.start();
	}

static Thread gerenciarMusicas = new Thread(() -> {
    while (isRunningMusica == true) {
        if (musica1 == false && contagemOnda < 4) {
        	musica1 = true;
        	musicaAtual = "musica1";
        	EfeitosSonorosEMusicas.musicaCena1();
        	

        }
        else if(musica2 == false && contagemOnda > 4 && contagemOnda < 8) {
        	EfeitosSonorosEMusicas.pararMusicaCena1();
        	musica2 = true;
        	musicaAtual = "musica2";
        	EfeitosSonorosEMusicas.musicaCena2();
        	fundo.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/fundoCenarioEscuro.jpg")));
        	criarAliensAndamRapido();
        }
        else if(musica3 == false && contagemOnda >= 7 && contagemOnda <= 8) {
        	EfeitosSonorosEMusicas.pararMusicaCena2();
        	musica3 = true;
        	musicaAtual = "musica3";
        	EfeitosSonorosEMusicas.musicaCena3();
        	fundo.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/fundoCenarioMetro (2).gif")));
         	fundoMetro.setVisible(true);
        }
        else if(musicaBoss == false && contagemOnda == 9) {
        	EfeitosSonorosEMusicas.pararMusicaCena3();
        	EfeitosSonorosEMusicas.musicaBoss();
        	EfeitosSonorosEMusicas.efeitoSonoroRazorClaw();
        	musicaBoss = true;
        	musicaAtual = "musicaBoss";
        	criarAlienBoss1();
        }
        else if(musica4 == false && contagemOnda > 10 && contagemOnda < 14) {
        	musica4 = true;
        	musicaAtual = "musica4";
        	EfeitosSonorosEMusicas.musicaCena4();
        	fundo.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/fundoCenarioClaro.png")));
        	fundoCidade.setVisible(true);
        }
        else if(musica5 == false && contagemOnda > 13 && contagemOnda < 17) {
        	 isRunningAlienAnda = false;
        	 isRunningAlienRapido = false;
        	 alienThread.stopThread();
        	EfeitosSonorosEMusicas.pararMusicaCena4();
        	musica5 = true;
        	musicaAtual = "musica5";
        	EfeitosSonorosEMusicas.musicaCena5();
        	fundoEntradaPredio.setVisible(true);
        	fundoCidade.setVisible(true);
        	fundoCidade.setIcon(new ImageIcon(TelaJogo.class.getResource("/images/fundoCenarioEntradaPredio.gif")));
        	
            AlienAnimation alienAnimation = new AlienAnimation(MissionComplete, contentPane, isRunningAlienAnda, isRunningAlienRapido, isRunningMunicao);
    	    alienAnimation.animationRoyalsIntro();
    	    System.out.println("passou o método");
        }
//        else {
//        	System.out.println("música não foi acionada");
//        }
        
        try {
        	 TimeUnit.SECONDS.sleep(1);
            //Thread.sleep(1000); // Aguarda 1 segundo antes de verificar novamente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
});

public static void pararMusicas() {
	switch(musicaAtual) {
	case "musica1":
		EfeitosSonorosEMusicas.pararMusicaCena1();
		break;
	case "musica2":
		EfeitosSonorosEMusicas.pararMusicaCena2();
		break;
	case "musica3":
		EfeitosSonorosEMusicas.pararMusicaCena3();
		break;
	case "musicaBoss":
		EfeitosSonorosEMusicas.pararMusicaBoss();
		break;
	case "musica4":
		EfeitosSonorosEMusicas.pararMusicaCena4();
		break;
	case "musica5":
		EfeitosSonorosEMusicas.pararMusicaCena5();
		break;
	}
}

public static void criarAliensAndam() {
	criarAliensAndam.start();
	}

static Thread criarAliensAndam = new Thread(() -> {
    while (isRunningAlienAnda == true) {
    	int numeroAleatorio = rand.nextInt(6,8);
    	criarAlienQueAnda();
        try {
        	 TimeUnit.SECONDS.sleep(numeroAleatorio);
            //Thread.sleep(1000); // Aguarda 1 segundo antes de verificar novamente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
});

public static void criarAliensAndamRapido() {
	criarAliensAndamRapido.start();
	}

static Thread criarAliensAndamRapido = new Thread(() -> {
    while (isRunningAlienRapido == true) {
    	int numeroAleatorio = rand.nextInt(11,17);
    	criarAlienQueAndaRapido();
        try {
        	 TimeUnit.SECONDS.sleep(numeroAleatorio);
            //Thread.sleep(1000); // Aguarda 1 segundo antes de verificar novamente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
});


public static void criarAlienBoss1() {
	alienBoss = new AlienRazorClaw();
	
	if (alienBoss != null) {
		alienBoss.addMouseMotionListener(mouseMotionListener);
		alienBoss.addMouseListener(mouseListener);
		alienBoss.setVisible(true);
	    perigo.setBounds(109, 33, pilha.empilhar(alienBoss), 39);
	    alienBoss.setEnabled(true);
	    alienBoss.setFocusable(true);
	    contentPane.add(alienBoss);
	    contentPane.revalidate();
	    contentPane.repaint();
	    contentPane.setComponentZOrder(alienBoss, alienBoss.getPosicaoMapa());
	    contentPane.repaint();
	    RazorClawMovement razorClaw = new RazorClawMovement(alienBoss,perigo,pilha,contagemNumeroOnda);
	    razorClaw.run();
	    }
}
}
