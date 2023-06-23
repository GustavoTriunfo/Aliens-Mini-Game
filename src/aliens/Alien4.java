package aliens;

import javax.swing.ImageIcon;

import telas.TelaJogo;

public class Alien4 extends Alien
{
	
	public Alien4(int numeroAleatorio){
		numeroIcone = numeroAleatorio;
		posicaoMapa = 21;
		vidaAlien = 1;
		pontos = 15;
		nome = "Moving Warrior";
		efeitoSonoroAbatido = "/musics/Xenomorph-Sounds-Like-An-Elephant.wav";
		setBounds(300, 400, 564, 280);
		setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensMovingSprites/AlienMoving" + numeroAleatorio + ".gif")));
		
	}
	

}
