package aliens;

import javax.swing.ImageIcon;

import telas.TelaJogo;

public class AlienGoldenRoyalGuard extends Alien{
	public AlienGoldenRoyalGuard(){
		posicaoMapa = 21;
		vidaAlien = 30;
		pontos = 1800;
		nome = "Royal Guard";
		efeitoSonoroAbatido = "/musics/aln_death_scream_23.wav";
		setBounds(850, 280, 712, 400);
		setIcon(new ImageIcon(TelaJogo.class.getResource("/royalGuards/RoyalGuard1.gif")));
	}
}
