package aliens;

import javax.swing.ImageIcon;

import telas.TelaJogo;

public class Alien8 extends Alien {

	public Alien8(int numeroAleatorio){
		numeroIcone = numeroAleatorio;
		posicaoMapa = 17;
		vidaAlien = 2;
		pontos = 20;
		nome = "Walking lowered Stalker";
		efeitoSonoroAbatido = "/musics/Xenomorph-Sounds-Like-An-Elephant.wav";
		setBounds(TelaJogo.posicaoXAleatorio(), 600, 766, 210);
		setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensMovingSprites/AlienMoving" + numeroAleatorio + ".gif")));
	}
	
}