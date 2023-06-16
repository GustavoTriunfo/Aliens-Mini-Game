package estruturasDeDados;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import aliens.Alien;

public class ListaEncadeadaAlien {
	  IntNoAlien primeiro, ultimo;
	    int numero_nos=0;
	    
	    public ListaEncadeadaAlien(){
	        primeiro = ultimo = null;   
	    }
	   public void insereNo_fim (IntNoAlien novoNo, JLabel alien){
		novoNo.prox = null;
	        if (primeiro == null)
	            primeiro = novoNo;
		if (ultimo != null)
	            ultimo.prox = novoNo;
	        ultimo = novoNo;
		numero_nos++;
	    }
	   public void insereNo_inicio (int valorNo, Alien alien){
		   IntNoAlien novoNo = new IntNoAlien(valorNo, alien);
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
	        IntNoAlien temp_no = primeiro;
	    	while (temp_no != null)
	        {   tamanho++;
	            temp_no = temp_no.prox;
		}
	        return tamanho;
	    }
	    public void insereNo_posicao(IntNoAlien novoNo, int posicao, JLabel alien){
		IntNoAlien temp_no = primeiro;
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


	   public IntNoAlien buscaNo (int buscaValor){
	        int i = 0;
	        IntNoAlien temp_no = primeiro;
	        while (temp_no != null)
	        {
	            if (temp_no.valor == buscaValor)
	            {
	              //  JOptionPane.showMessageDialog(null, "No " + temp_no.valor + " posição " + i);
	                return temp_no;	
	            }
	            i++;
	            temp_no = temp_no.prox;
	        }
	        return null;
	    }
	    public void excluiNo (int valor, JLabel alien){
	    	IntNoAlien temp_no = primeiro;
	    	IntNoAlien anterior_no=null;
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
		   IntNoAlien temp_no = primeiro;
	        int i = 0;
	        while (temp_no != null)
	        {
	            System.out.println("Saida - Nome: " + temp_no.getNomeAlien() + " Pontos: " + temp_no.getAlienPontos() + " Posição " + i);
	                            temp_no = temp_no.prox;
	            i++;
	        }
	    }
	   public IntNoAlien getPrimeiro() {
		   return primeiro;
	   }
	   public IntNoAlien getUltimo() {
		   return ultimo;
	   }
//	   public String getNumeroNoConvertido() {
//		  String numeroNoTexto = Integer.toString(numeroNo);
//		   return numeroNoTexto;
//	   }
	   
	   public ArrayList<Integer> converteListaEncadeadaEmArrayList() {
		   ArrayList<Integer> listaEncadeadaConvertidaEmArrayList = new ArrayList<>();
		   IntNoAlien temp_no = primeiro;
		   while (temp_no != null)
	       {
			   listaEncadeadaConvertidaEmArrayList.add(temp_no.valor);
		   temp_no = temp_no.prox;
	       }
		   return listaEncadeadaConvertidaEmArrayList;
	   }
}
