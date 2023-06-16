package estruturasDeDados;


import aliens.Alien;

public class IntNoAlien {
	private Alien alien;
	  int valor;
	  IntNoAlien prox;

	 
	   public IntNoAlien(int ValorNo, Alien alienRecebido){
		   alien = alienRecebido;
	       valor = ValorNo;
	       prox = null;
	   }
	   
	   public int getValor() {
		   return valor;
	   }
	   public int getAlienPontos() {
		   return alien.getPontos();
	   }
	   public IntNoAlien getProx() {
		   return prox;
	   }
	   public String getNomeAlien() {
		   return alien.getAlienNome();
	   }
}
