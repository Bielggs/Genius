package br.com.model;

public class Usuario {
	
	int id;
	String nome;
	String senha;
	int pontuacao;
	
	
	
	
	public Usuario(String nome, String senha) {
		this.id = 0;
		this.nome = nome;
		this.senha = senha;
		this.pontuacao = 0;
	}

	
	public Usuario() {
		
	}
}
