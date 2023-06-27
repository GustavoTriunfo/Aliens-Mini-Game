package aliens;

import javax.swing.ImageIcon;

import telas.TelaJogo;

public class Alien9 extends Alien {
	
	public Alien9(int numeroAleatorio){
		numeroIcone = numeroAleatorio;
		posicaoMapa = 19;
		vidaAlien = 3;
		pontos = 30;
		nome = "Walking Smasher";
		efeitoSonoroAbatido = "/musics/Xenomorph-Sounds-Like-An-Elephant.wav";
		setBounds(TelaJogo.posicaoXAleatorio(), 400, 604, 300);
		setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensMovingSprites/AlienMoving" + numeroAleatorio + ".gif")));
	}

}
