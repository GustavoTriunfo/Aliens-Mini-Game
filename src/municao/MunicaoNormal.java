package municao;

import java.util.Random;

import javax.swing.ImageIcon;

import telas.TelaJogo;

public class MunicaoNormal extends Municao{
	Random rand = new Random();
	public MunicaoNormal() {
		int municao = rand.nextInt(4,6);
		qtdAmmo = municao;
		tipo = "normal";
		posicaoMapa = 19;
		setBounds(TelaJogo.posicaoXAleatorio(), 600, 150, 80);
		setIcon(new ImageIcon(TelaJogo.class.getResource("/imagesAmmo/ammo1.png")));
	}
}
