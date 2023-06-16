package estruturasDeDados;

/**
* @author bruno
*/
public class IntNoSimples {
   int valor;
   IntNoSimples prox;
   public IntNoSimples(int ValorNo){
       valor = ValorNo;
       prox = null;
   }
   
   public int getValor() {
	   return valor;
   }
}