package aliens;

import javax.swing.ImageIcon;

import telas.TelaJogo;

public class AlienRazorClaw extends Alien{
	public AlienRazorClaw(){
		posicaoMapa = 21;
		vidaAlien = 15;
		pontos = 800;
		nome = "Razor Claw";
		efeitoSonoroAbatido = "aln_death_scream_23.wav";
		setBounds(-650, 400, 694, 300);
		setIcon(new ImageIcon(TelaJogo.class.getResource("/aliensBosses/RazorClaw2.gif")));
	}
}
