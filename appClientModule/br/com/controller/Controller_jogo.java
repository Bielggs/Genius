package br.com.controller;

import java.io.Console;
import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

import br.com.model.Partida;


public class Controller_jogo {
	
	Random rand =  new Random();
	Partida partida = new Partida();
	
	private Partida partida_1;

	//private String [] sequencia_computador = null ;
	
	
	
	
	public void Escolher_nivel(int nivel) {
		
		switch (nivel) {
		case 1:
			partida_1 = new Partida(0,0,25);
	//		sequencia_computador = new String [25];
			break;
		case 2:
			partida_1 = new Partida(0,0,50);
			//sequencia_computador = new String [50];
			break;
		case 3:
			partida_1 = new Partida(0,0,100);
			//sequencia_computador = new String [100];
			break;
			
		default:
			break;
		}
		
	}
	
	

	public void Adicionar_numero_array_Novo( ) {
		partida_1.getSequencia_computador()[partida_1.getTamanho_Array()]= rand.nextInt(4) + "";
		for (int i = 0; i < partida_1.getSequencia_computador().length; i++) {
			String string = partida_1.getSequencia_computador()[i];
			if(string!= null) {
				System.out.println("P: ["+i +"] "+string);
			}
		}
	}

	
	
	
	public int Jogada2(String jogada) {
		
		
		for (int i = 0; i < partida_1.getSequencia_computador().length; i++) {
			String string = partida_1.getSequencia_computador()[i];
			if(string!= null) {
				System.out.println("P: ["+i +"] "+string);
			}
		}
		
		//Verifica se a sequencia do computador na posição da jogada é igual ao botão clicado
		if(partida_1.getSequencia_computador()[partida_1.getContador_jogadas()].equals(jogada)) {
			
			System.out.println("O contador de jogadas esta em: [" + partida_1.getContador_jogadas() + "] e o contador do array esta em : [" + partida_1.getTamanho_Array()+"]");
			
			System.out.println("O numero do array e [" + partida_1.getSequencia_computador()[partida_1.getContador_jogadas()] + "] e o numero digitado foi [" + jogada+"]");
			
			
			//verifica se o contador é do tamanho do array
			if(partida_1.getContador_jogadas() == partida_1.getTamanho_Array()) {
				
				//adiciona mais um no tamanho do array do computador
				partida_1.setTamanho_Array(partida_1.getTamanho_Array() +1 );	
				
				//ele deposita um numero a mais na sequencia
				partida_1.getSequencia_computador()[partida_1.getTamanho_Array()]= rand.nextInt(4) + "";
				
				
				
				System.out.println("O novo numero sorteado foi ["+partida_1.getSequencia_computador()[partida_1.getTamanho_Array()]+"]" );
				
				//zera o contador de jogadas para iniciar uma nova rodada
				partida_1.setContador_jogadas(0);	
				
				return 2;
				
			}else {
				
				//contador recebe mais um para a proxima jogada
				partida_1.setContador_jogadas(partida_1.getContador_jogadas() +1 );	
				return 1;
			}
			
			
			
		}else {
			
			JOptionPane.showMessageDialog(null,  "Deu ruim");
			return 3;
			
		}
		

		// 1 - para próxima jogada
		// 2 - para iniciar nova rodada
		// 3 - para fechar a tela
		
	}
	

	
	
	
	public void Jogada(String jogada) {
		
	
		//Verifica se a sequencia do computador na posição da jogada é igual ao botão clicado
		if(partida_1.getSequencia_computador()[partida_1.getContador_jogadas()].equals(jogada)) {
			
			System.out.println("O contador de jogadas esta em: [" + partida_1.getContador_jogadas() + "] e o contador do array esta em : [" + partida_1.getTamanho_Array()+"]");
			
			System.out.println("O numero do array e [" + partida_1.getSequencia_computador()[partida_1.getContador_jogadas()] + "] e o numero digitado foi [" + jogada+"]");
			
			
			//verifica se o contador é do tamanho do array
			if(partida_1.getContador_jogadas() == partida_1.getTamanho_Array()) {
				
				//adiciona mais um no tamanho do array do computador
				partida_1.setTamanho_Array(partida_1.getTamanho_Array() +1 );	
				
				//ele deposita um numero a mais na sequencia
				partida_1.getSequencia_computador()[partida_1.getTamanho_Array()]= rand.nextInt(4) + "";
				
				
				
				System.out.println("O novo numero sorteado foi ["+partida_1.getSequencia_computador()[partida_1.getTamanho_Array()]+"]" );
				
				//zera o contador de jogadas para iniciar uma nova rodada
				partida_1.setContador_jogadas(0);	
				
				
				
			}else {
				
				//contador recebe mais um para a proxima jogada
				partida_1.setContador_jogadas(partida_1.getContador_jogadas() +1 );	
			}
			
			
			
		}else {
			
			JOptionPane.showMessageDialog(null,  "Deu ruim");
			
			
		}
		for (int i = 0; i < partida_1.getSequencia_computador().length; i++) {
			String string = partida_1.getSequencia_computador()[i];
			if(string!= null) {
				System.out.println("P: ["+i +"] "+string);
			}
			
		}
		
	}

	
	public void Reciclar () {
		
		partida_1.setContador_jogadas(0);
		partida_1.setTamanho_Array(0);
		partida_1.setSequencia_computador(new String [25]);

	}



	public Partida getPartida_1() {
		return partida_1;
	}



	public void setPartida_1(Partida partida_1) {
		this.partida_1 = partida_1;
	}
	
	
	/*

	public void Adicionar_numero_array( ) {
		getSequencia_computador()[partida.getTamanho_Array()]= rand.nextInt(4) + "";
		
		for (int i = 0; i < getSequencia_computador().length; i++) {
			String string = getSequencia_computador()[i];
			if(string!= null) {
				System.out.println("P: ["+i +"] "+string);
			}
			
		}
	}
	
	
	public void Jogada_1(String jogada) {
		
		
		System.out.println("O contador de jogadas esta em: [" + partida.getContador_jogadas() + "] e o contador do array esta em : [" + partida.getTamanho_Array()+"]");
		
		System.out.println("O numero do array e [" + getSequencia_computador()[partida.getContador_jogadas()] + "] e o numero digitado foi [" + jogada+"]");
		
		
		//Verifica se a sequencia do computador na posição da jogada é igual ao botão clicado
		if(getSequencia_computador()[partida.getContador_jogadas()].equals(jogada)) {
			

			
			//verifica se o contador é do tamanho do array
			if(partida.getContador_jogadas() == partida.getTamanho_Array()) {
				
				
				partida.setTamanho_Array(partida.getTamanho_Array() +1 );	
				
				getSequencia_computador()[partida.getTamanho_Array()]= rand.nextInt(4) + "";
				
				System.out.println("O novo numero sorteado foi ["+getSequencia_computador()[partida.getTamanho_Array()]+"]" );
				partida.setContador_jogadas(0);	
				
			}else {
				
				//contador recebe mais um para a proxima jogada
				partida.setContador_jogadas(partida.getContador_jogadas() +1 );	
			}
			
			
			
		}else {
			
			partida.setContador_jogadas(0);
			partida.setTamanho_Array(0);
			setSequencia_computador(new String [25]);
		}
		for (int i = 0; i < getSequencia_computador().length; i++) {
			String string = getSequencia_computador()[i];
			if(string!= null) {
				System.out.println("P: ["+i +"] "+string);
			}
			
		}
		
	}
	
	
	public void Solicitar_dica() {

	}
	
	public void Exibir_sequencia() {

	}
	
	
	public String[] getSequencia_computador() {
		return sequencia_computador;
	}



	public void setSequencia_computador(String[] sequencia_computador) {
		this.sequencia_computador = sequencia_computador;
	}
	*/
	
	

}
