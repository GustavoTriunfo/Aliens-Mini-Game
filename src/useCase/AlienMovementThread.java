package useCase;

import javax.swing.*;

import telas.TelaJogo;

public class AlienMovementThread extends Thread {
    private JLabel alienLabel;
    private boolean isRunning;
    private int numeroDoIcone = 0;

    public AlienMovementThread(JLabel alienLabel, int numeroIcones) {
        this.alienLabel = alienLabel;
        this.isRunning = true;
        numeroDoIcone = numeroIcones;
    }

    public void stopRunning() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            // Atualize a posição do JLabel aqui
        	if(numeroDoIcone % 2 == 0) {
            int currentX = alienLabel.getX();
            int newXDireita = currentX + 1; // Exemplo: move 1 unidade para a direita
            alienLabel.setLocation(newXDireita, alienLabel.getY());
            if(alienLabel.getLocation().x == 1250) {
            	alienLabel.setVisible(false);
            }
        	}
        	else if(numeroDoIcone % 2 == 1) {
        		int currentX = alienLabel.getX();
                int newXEsquerda = currentX - 1; // Exemplo: move 1 unidade para a esquerda
                alienLabel.setLocation(newXEsquerda, alienLabel.getY());
                if(alienLabel.getLocation().x == 300) {
                	alienLabel.setVisible(false);
                }
        	}
            try {
                Thread.sleep(7); // Aguarde um pequeno intervalo de tempo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}