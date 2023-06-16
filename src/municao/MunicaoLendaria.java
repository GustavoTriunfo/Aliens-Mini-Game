package municao;

import java.util.Random;

import javax.swing.ImageIcon;

import telas.TelaJogo;

public class MunicaoLendaria extends Municao{
	Random rand = new Random();
	public MunicaoLendaria() {
		int municao = rand.nextInt(16,19);
		qtdAmmo = municao;
		tipo = "lendario";
		posicaoMapa = 21;
		setBounds(TelaJogo.posicaoXAleatorio(), 600, 150, 80);
		setIcon(new ImageIcon(TelaJogo.class.getResource("/imagesAmmo/ammo1Lendaria.png")));
	}
}
