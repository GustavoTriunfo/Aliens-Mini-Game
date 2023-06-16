package useCase;

import java.util.concurrent.TimeUnit;

import telas.TelaJogo;

public class AmmoThread {
    private boolean running;
    private long interval;
    private int maxMunicaoPorOnda;
    private int municaoCriada;

    public AmmoThread(long interval) {
        this.interval = interval;
       // this.maxAliensPerWave = maxAliensPerWave;
        this.municaoCriada = 0;
        this.running = true;
    }

    public void stopThread() {
        this.running = false;
    }

    public void run() {
        while (running) {
            if (municaoCriada < maxMunicaoPorOnda) {
            	   TelaJogo.criarMunicao();
            	   municaoCriada++;
            }else {
            	stopThread();
            }
            
            try {
                TimeUnit.SECONDS.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
