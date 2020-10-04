package br.com.model;

public class Usuario {
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public int getPontuacao() {
		return pontuacao;
	}


	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}


	private int id;
	private String nome;
	private String senha;
	private int pontuacao;
	
	
	
	
	public Usuario(String nome, String senha) {
		this.id = 0;
		this.nome = nome;
		this.senha = senha;
		this.pontuacao = 0;
	}
	public Usuario(String id, String nome, String senha, String pontuacao) {
		this.id = Integer.valueOf(id);
		this.nome = nome;
		this.senha = senha;
		this.pontuacao = Integer.valueOf(pontuacao);
	}
	
	public Usuario() {
		
	}
	
	
}
