package aliens;

import javax.swing.ImageIcon;

import telas.TelaJogo;

public class AlienGrayRoyalGuard extends Alien{
	public AlienGrayRoyalGuard(){
		posicaoMapa = 21;
		vidaAlien = 20;
		pontos = 800;
		nome = "Razor Claw";
		efeitoSonoroAbatido = "/musics/aln_death_scream_23.wav";
		setBounds(-150, 290, 727, 400);
		setIcon(new ImageIcon(TelaJogo.class.getResource("/royalGuards/RoyalGuard2.gif")));
	}
}
