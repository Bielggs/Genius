package br.com.model;


public class Partida{
	
	
	private int tamanho_Array = 0;
	private int contador_jogadas = 0;
	private int tamanho_para_o_array = 0;
	private String [] sequencia_computador;
	
	
	
	
	
	
	public Partida() {
	}
		
	
	
	public Partida(int tamanho_Array, int contador_jogadas, int tamanho_para_o_array ) {
		this.tamanho_Array = tamanho_Array;
		this.contador_jogadas = contador_jogadas;
		this.sequencia_computador = new String [tamanho_para_o_array];
	}
	
	public int getContador_jogadas() {
		return contador_jogadas;
	}
	public void setContador_jogadas(int Contador_jogadas) {
		contador_jogadas = Contador_jogadas;
	}
	public int getTamanho_Array() {
		return tamanho_Array;
	}
	public void setTamanho_Array(int Tamanho_Array) {
		tamanho_Array = Tamanho_Array;
	}

	public String[] getSequencia_computador() {
		return sequencia_computador;
	}

	public void setSequencia_computador(String[] sequencia_computador) {
		this.sequencia_computador = sequencia_computador;
	}

	public int getTamanho_para_o_array() {
		return tamanho_para_o_array;
	}

	public void setTamanho_para_o_array(int tamanho_para_o_array) {
		this.tamanho_para_o_array = tamanho_para_o_array;
	}
	
	
	

}
