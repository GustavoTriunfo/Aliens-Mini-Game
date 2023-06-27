package aliens;

import javax.swing.JLabel;

public abstract class Alien extends JLabel {
    // Adicione os métodos e atributos comuns a todos os aliens aqui
    // Por exemplo, métodos para definir a posição, a imagem, etc.
	protected int numeroIcone = 0;
	protected int vidaAlien = 1;
	protected int pontos = 1;
	protected String nome = null;
	protected static int posicaoMapa;
	protected String efeitoSonoroAbatido = null;
	protected int direcao;
	
	public boolean alienAbatido() {
		if(vidaAlien <= 0) {
			return true;
		}
		return false;
	}
	public int getAlienVida() {
		return vidaAlien;
	}
	
	public String getAlienNome() {
		return nome;
	}
	public int getPontos() {
		return pontos;
	}
	public void danoAlienVida() {
		vidaAlien--;
	}
	public int getPosicaoMapa() {
		return posicaoMapa;
	}
	public void setPosicaoMapa() {
		 posicaoMapa++;
	}
	public int getNumeroIcone() {
		return numeroIcone;
	}
	public int getDirecao() {
		return direcao;
	}
	public void setDirecao(int valor) {
		direcao = valor;
	}
	
	public String getEfeitoSonoroAbatido() {
		return efeitoSonoroAbatido;
	}
	
}