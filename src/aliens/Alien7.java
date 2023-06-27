package aliens;

import javax.swing.ImageIcon;

import telas.TelaJogo;

public class Alien7 extends Alien {

	public Alien7(int numeroAleatorio){
		numeroIcone = numeroAleatorio;
		posicaoMapa = 19;
		vidaAlien = 2;
		pontos = 20;
		nome = "Walking Stalker";
		efeitoSonoroAbatido = "/musics/Xenomorph-Sounds-Like-An-Elephant.wav";
		setBounds(TelaJogo.posicaoXAleatorio(), 350, 475, 345);
		setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensMovingSprites/AlienMoving" + numeroAleatorio + ".gif")));
	}
	
}