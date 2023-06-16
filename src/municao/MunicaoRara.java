package municao;

import java.util.Random;

import javax.swing.ImageIcon;

import telas.TelaJogo;

public class MunicaoRara extends Municao{
	Random rand = new Random();
	public MunicaoRara() {
		int municao = rand.nextInt(8,10);
		qtdAmmo = municao;
		tipo = "raro";
		posicaoMapa = 19;
		setBounds(TelaJogo.posicaoXAleatorio(), 600, 150, 80);
		setIcon(new ImageIcon(TelaJogo.class.getResource("/imagesAmmo/ammo1Rara.png")));
	}
}
