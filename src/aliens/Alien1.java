package aliens;

import javax.swing.ImageIcon;

import telas.TelaJogo;

public class Alien1 extends Alien {

	public Alien1(int numeroAleatorio){
		posicaoMapa = 18;
		vidaAlien = 2;
		pontos = 20;
		nome = "Stalker";
		efeitoSonoroAbatido = "/musics/Xenomorph-Sounds-Like-An-Elephant.wav";
		setBounds(TelaJogo.posicaoXAleatorio(), 400, 412, 345);
		setIcon(new ImageIcon(TelaJogo.class.getResource("/images/aliensSprites/Alien" + numeroAleatorio + ".gif")));
	}
	
}
