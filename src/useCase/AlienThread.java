package useCase;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import telas.TelaJogo;



public class AlienThread extends Thread {
    private boolean running;
    private long interval;
    private int maxAliensPerWave;
    private int aliensCreated;
    private Random random = new Random(); 
    
    public AlienThread(long interval, int maxAliensPerWave) {
        this.interval = interval;
        this.maxAliensPerWave = maxAliensPerWave;
        this.aliensCreated = 0;
        this.running = true;
    }

    public void stopThread() {
        this.running = false;
    }

    @Override
    public void run() {
        while (running) {
            if (aliensCreated < maxAliensPerWave) {
            	   TelaJogo.criarAlien();
                aliensCreated++;
            }
            else {
            	stopThread();
            }
            
            interval = random.nextInt(2,5);
            try {
                TimeUnit.SECONDS.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

