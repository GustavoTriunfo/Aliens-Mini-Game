package aliens;

import javax.swing.ImageIcon;

import telas.TelaJogo;

public class Alien3 extends Alien {
	
	public Alien3(int numeroAleatorio){
		posicaoMapa = 19;
		vidaAlien = 3;
		pontos = 30;
		nome = "Smasher";
		efeitoSonoroAbatido = "/musics/Xenomorph-Sounds-Like-An-Elephant.wav";
		setBounds(TelaJogo.posicaoXAleatorio(), 400, 534, 380);
		setIcon(new ImageIcon(TelaJogo.class.getResource("/images/aliensSprites/Alien" + numeroAleatorio + ".gif")));
	}

}
