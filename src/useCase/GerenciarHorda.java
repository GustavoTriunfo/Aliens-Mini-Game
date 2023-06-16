package useCase;

import javax.swing.JButton;
import javax.swing.JLabel;

import telas.TelaJogo;

public class GerenciarHorda {
	private JLabel ondaAtual = new JLabel();
	private JLabel QtdAliens = new JLabel();
	private int numeroOnda = 0;
	private int qtdAliensAbatidos = 0;
	private int aliensAdicionar = 0;
	
	public GerenciarHorda(JLabel tempo, JButton start, JLabel onda, JLabel aliens) {
		ondaAtual = onda;
		QtdAliens = aliens;
		qtdAliensAbatidos = 0;
	}
	public void iniciarHorda() {
		numeroOnda++;
		ondaAtual.setText(Integer.toString(numeroOnda));
		//TelaJogo.iniciarVerificacaoAlienZero();
		QtdAliens.setText(Integer.toString(qtdAliensAbatidos));
	}
	
	public void setQtdAliensPorOnda(int aliensOnda) {
		qtdAliensAbatidos = aliensOnda;
	}
	public int getQtdAliensPorOnda() {
		return qtdAliensAbatidos;
	}
	public void adicionarMaisAliens() {
		aliensAdicionar += 3;
	}
}
