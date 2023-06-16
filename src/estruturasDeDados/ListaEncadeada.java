package estruturasDeDados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class ListaEncadeada {
    IntNoSimples primeiro, ultimo;
    int numero_nos=0;
    
    public ListaEncadeada(){
        primeiro = ultimo = null;   
    }
   public void insereNo_fim (IntNoSimples novoNo){
	novoNo.prox = null;
        if (primeiro == null)
            primeiro = novoNo;
	if (ultimo != null)
            ultimo.prox = novoNo;
        ultimo = novoNo;
	numero_nos++;
    }
   public void insereNo_inicio (IntNoSimples novoNo){
        novoNo.prox = primeiro;
	if(primeiro == null && ultimo==null) //Só tem um elemento na lista
        {
            ultimo = novoNo;
	}
	primeiro = novoNo;
        numero_nos++;
    }
   public int ContarNos(){
	int tamanho = 0;
        IntNoSimples temp_no = primeiro;
    	while (temp_no != null)
        {   tamanho++;
            temp_no = temp_no.prox;
	}
        return tamanho;
    }
    public void insereNo_posicao(IntNoSimples novoNo, int posicao){
	IntNoSimples temp_no = primeiro;
	int numero_nos = ContarNos();
	int pos_aux;
	if(posicao == 0)
	{
            novoNo.prox = primeiro;
            if(primeiro == ultimo)
            {
                ultimo = novoNo;
            }
            primeiro = novoNo;
        }
        else
	{
            if (posicao <= numero_nos)
            {   
		pos_aux = 1;
		while(temp_no != null && posicao > pos_aux)
		{
                    temp_no = temp_no.prox;
                    pos_aux ++;
                }
                novoNo.prox = temp_no.prox;
                temp_no.prox = novoNo;
            }
            else
            {
                if(posicao > numero_nos)
		{
                    ultimo.prox = novoNo;
                    ultimo = novoNo;
		}
            }	 
        }
    }


   public IntNoSimples buscaNo (int buscaValor){
        int i = 0;
        IntNoSimples temp_no = primeiro;
        while (temp_no != null)
        {
            if (temp_no.valor == buscaValor)
            {
                JOptionPane.showMessageDialog(null, "No " + temp_no.valor + " posição " + i);
                return temp_no;	
            }
            i++;
            temp_no = temp_no.prox;
        }
        return null;
    }
    public void excluiNo (int valor){
        IntNoSimples temp_no = primeiro;
        IntNoSimples anterior_no=null;
        while (temp_no != null && temp_no.valor != valor){
            anterior_no = temp_no;
            temp_no = temp_no.prox;
        }
        if (temp_no == primeiro){
            if (temp_no.prox !=null)
                primeiro = temp_no.prox;
            else
                primeiro = null;
        }
        else{
            anterior_no.prox =temp_no.prox;
        }
        
        if (ultimo == temp_no)
            ultimo = anterior_no;
    }
   public void exibeLista(){
        IntNoSimples temp_no = primeiro;
        int i = 0;
        while (temp_no != null)
        {
            System.out.println("Saida - Valor" + temp_no.valor + " posição " + i);
                            temp_no = temp_no.prox;
            i++;
        }
    }
   public IntNoSimples getPrimeiro() {
	   return primeiro;
   }
   public IntNoSimples getUltimo() {
	   return ultimo;
   }
   
   public ArrayList<Integer> converteListaEncadeadaEmArrayList() {
	   ArrayList<Integer> listaEncadeadaConvertidaEmArrayList = new ArrayList<>();
	   IntNoSimples temp_no = primeiro;
	   while (temp_no != null)
       {
		   listaEncadeadaConvertidaEmArrayList.add(temp_no.valor);
	   temp_no = temp_no.prox;
       }
	   return listaEncadeadaConvertidaEmArrayList;
   }
}
