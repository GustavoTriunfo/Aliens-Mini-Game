package municao;

import javax.swing.JLabel;

public abstract class Municao extends JLabel{
	protected int qtdAmmo = 5;
	protected String tipo;
	protected static int posicaoMapa;
	
	public int getPosicaoMapa() {
		return posicaoMapa;
	}
	public void setPosicaoMapa() {
		 posicaoMapa++;
	}
	public int getQuantidade() {
		return qtdAmmo;
	}
}
