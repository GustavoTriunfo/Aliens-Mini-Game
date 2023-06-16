package telas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import useCase.EfeitosSonorosEMusicas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaJogoPerdido extends JFrame 
{
	
	private JLabel qtdAliensMortos = new JLabel("");
	private JLabel pontosHighscore = new JLabel("");
	private JLabel tempoTotal = new JLabel("");
	private JPanel contentPane;
	//static TelaJogoPerdido frame = new TelaJogoPerdido();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TelaJogoPerdido(JLabel pontos, JLabel tempo, JLabel aliensMortos) 
	{
		pontosHighscore = pontos;
		tempoTotal.setForeground(Color.WHITE);
		tempoTotal.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 50));
		tempoTotal.setBounds(109, 99, 308, 91);
		pontosHighscore.setText(pontos.getText());
		tempoTotal.setText(tempo.getText());
		qtdAliensMortos.setHorizontalAlignment(SwingConstants.RIGHT);
		qtdAliensMortos.setText(aliensMortos.getText());
		qtdAliensMortos.setForeground(new Color(255, 0, 0));
		qtdAliensMortos.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 50));
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 960);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel botaoRestart = new JLabel("");
		botaoRestart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.exit(0);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				botaoRestart.setIcon(new ImageIcon(TelaJogoPerdido.class.getResource("/images/BotaoRestartEntered.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botaoRestart.setIcon(new ImageIcon(TelaJogoPerdido.class.getResource("/images/BotaoRestart.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				botaoRestart.setIcon(new ImageIcon(TelaJogoPerdido.class.getResource("/images/BotaoRestartPressed.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				botaoRestart.setIcon(new ImageIcon(TelaJogoPerdido.class.getResource("/images/BotaoRestartEntered.png")));
			}
		});
		
		
		qtdAliensMortos.setBounds(1189, 30, 169, 108);
		contentPane.add(qtdAliensMortos);
		
		JLabel logoHorda = new JLabel("");
		logoHorda.setIcon(new ImageIcon(TelaJogoPerdido.class.getResource("/images/HordeLogo.png")));
		logoHorda.setBounds(1372, 23, 115, 115);
		contentPane.add(logoHorda);
		
	
		tempoTotal.setBounds(75, 376, 312, 105);
		contentPane.add(tempoTotal);
		
		
		pontosHighscore.setBounds(75, 242, 486, 105);
		contentPane.add(pontosHighscore);
		botaoRestart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoRestart.setIcon(new ImageIcon(TelaJogoPerdido.class.getResource("/images/BotaoRestart.png")));
		botaoRestart.setBounds(1055, 647, 403, 152);
		contentPane.add(botaoRestart);
		
		JLabel textoDied = new JLabel("");
		textoDied.setIcon(new ImageIcon(TelaJogoPerdido.class.getResource("/images/DiedText (1).png")));
		textoDied.setBounds(10, 95, 509, 105);
		contentPane.add(textoDied);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(TelaJogoPerdido.class.getResource("/images/deathScreen (1).png")));
		fundo.setBounds(-106, -79, 1920, 960);
		contentPane.add(fundo);
		EfeitosSonorosEMusicas.musicaJogoPerdido();
	}

}
