package aliens;

import javax.swing.ImageIcon;

import telas.TelaJogo;

public class Alien2 extends Alien {
	
	public Alien2(int numeroAleatorio){
		posicaoMapa = 20;
		vidaAlien = 1;
		pontos = 10;
		nome = "Warrior";
		efeitoSonoroAbatido = "Xenomorph-Sounds-Like-An-Elephant.wav";
		setBounds(TelaJogo.posicaoXAleatorio(), 400, 428, 280);
		setIcon(new ImageIcon(TelaJogo.class.getResource("/images/aliensSprites/Alien" + numeroAleatorio + ".gif")));
	}
}
