package estruturasDeDados;
/**
 * @author bruno
 */
import javax.swing.JOptionPane;

public class Pilha {
    //Declarando os atributos da classe
    int topo;
    int tamanho;
    Object vetor[];
    
    public Pilha(int tam){
        topo = 50; //Marca que a pilha está vazia
        tamanho = tam;
        vetor = new Object[tam];
    }
    public boolean vazia(){
        if (topo == -1)
            return true;
        else
            return false;
    }
    public boolean cheia(){
        if(topo == tamanho -1)
            return true;
        else
            return false;
    }
    public int empilhar(Object elem){
        if (cheia() == false){
           topo = topo + 100;
            vetor[topo]=elem;
        }
        else{
            JOptionPane.showMessageDialog(null, 
                    "PILHA CHEIA!");
        }
        return topo;
    }
    
    public int empilharBoss(int qnt){
        if (cheia() == false){
           topo = topo + qnt;
            
        }
        else{
            JOptionPane.showMessageDialog(null, 
                    "PILHA CHEIA!");
        }
        return topo;
    }
    
    public Object desempilharObjeto(){
        Object valorDesempilhado;
        if(vazia() == true){
            valorDesempilhado = "Pilha Vazia";
        }
        else{
            valorDesempilhado = vetor[topo]; 
            topo = topo - 100;
        }
        return valorDesempilhado;
    }
    
    public int desempilhar(){
       
        if(vazia() == true){
          System.out.println("pilha vazia");
        }
        else{
         
            topo = topo - 100;
        }
        return topo;
    }
    public int desempilharBoss(int valor){
        
        if(vazia() == true){
          System.out.println("pilha vazia");
        }
        else{
         
            topo = topo - valor;
        }
        return topo;
    }
    
    public void ExibePilha(){
        if(vazia() == true){
            JOptionPane.showMessageDialog(null, 
                    "PILHA VAZIA!");
        }
        else{
            for(int i=topo; i>=0; i--){
                System.out.println("Elemento " 
                        + vetor[i] + " - posição " + i);
            }
        }
    }
}
