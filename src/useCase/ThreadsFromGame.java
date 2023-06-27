


	package useCase;

	import java.util.Random;
	import java.util.concurrent.TimeUnit;

	import telas.TelaJogo;
	
	public class ThreadsFromGame {
		
		private boolean isRunningAlienAnda = true;
		//private boolean isRunningMunicao = true;
		private boolean isRunningAlienRapido = true;
		private static Random rand = new Random();
		
		public void criarAliensAndam() {
			criarAliensAndam.start();
			}

		 private Thread criarAliensAndam = new Thread(() -> {
		    while (isRunningAlienAnda == true) {
		    	int numeroAleatorio = rand.nextInt(6,8);
		    	TelaJogo.criarAlienQueAnda();
		        try {
		        	 TimeUnit.SECONDS.sleep(numeroAleatorio);
		            //Thread.sleep(1000); // Aguarda 1 segundo antes de verificar novamente
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    }
		});
		public void pararAliensAndam() {
			isRunningAlienAnda = false;
			}
		
		public void criarAliensAndamRapido() {
			criarAliensAndamRapido.start();
			}

		 private Thread criarAliensAndamRapido = new Thread(() -> {
		    while (isRunningAlienRapido == true) {
		    	int numeroAleatorio = rand.nextInt(11,17);
		    	TelaJogo.criarAlienQueAndaRapido();
		        try {
		        	 TimeUnit.SECONDS.sleep(numeroAleatorio);
		            //Thread.sleep(1000); // Aguarda 1 segundo antes de verificar novamente
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    }
		});
		 
			public void pararAliensAndamRapido() {
				isRunningAlienRapido = false;
				}
			
			
		}




