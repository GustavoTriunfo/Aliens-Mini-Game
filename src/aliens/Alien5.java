package aliens;

import javax.swing.ImageIcon;

import telas.TelaJogo;

public class Alien5 extends Alien{
	public Alien5(int numeroAleatorio){
		numeroIcone = numeroAleatorio;
		posicaoMapa = 21;
		vidaAlien = 1;
		pontos = 17;
		nome = "Arachnoid";
		efeitoSonoroAbatido = "Xenomorph-Sounds-Like-An-Elephant.wav";
		setBounds(300, 0, 564, 280);
		setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensFastMoving/AlienFastMoving" + numeroAleatorio + ".gif")));
		
	}
}
