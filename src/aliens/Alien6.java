package aliens;

import javax.swing.ImageIcon;

import telas.TelaJogo;

public class Alien6 extends Alien {

	public Alien6(int numeroAleatorio){
		posicaoMapa = 17;
		vidaAlien = 2;
		pontos = 20;
		nome = "Stalker";
		efeitoSonoroAbatido = "/musics/Xenomorph-Sounds-Like-An-Elephant.wav";
		setBounds(TelaJogo.posicaoXAleatorio(), 550, 535, 210);
		setIcon(new ImageIcon(TelaJogo.class.getResource("/images/aliensSprites/Alien" + numeroAleatorio + ".gif")));
	}
	
}