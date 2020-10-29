package br.com.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import br.com.model.Usuario;

public class Controller_usuario {
	
	private String caminho_txt = "/appClientModule/br/com/controller/Usuarios.txt";
	private int id;
 

	public int Salvar(String nome, String senha) {		
		int definicao = 0;
			if(Verificar_Nome(nome) == true){
				
			}else {
				Usuario user = new Usuario();
				user.setId(Proximo_id());
				user.setNome(nome);
				user.setSenha(senha);
				user.setPontuacao(0);
				
				try {
					String path = new File(new File(".").getCanonicalPath() + this.caminho_txt).getCanonicalPath();
					FileWriter fileWriter = new FileWriter(path, true);
					PrintWriter printWriter = new PrintWriter(fileWriter);
					// Utilizamos o método print() para escrever na
					// mesma linha e um ponto e vírgula no final.
					// O println forçará a troca de linha
					// para o próximo user.
					String preparar_salvar = user.getId() + ";" + user.getNome() + ";" + user.getSenha() + ";"+ user.getPontuacao();
					printWriter.print(preparar_salvar + "\n");

					printWriter.flush();
					printWriter.close();
					definicao = 1;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
			return definicao;
	}
	
	
	

	public ArrayList<Usuario> Ler_arquivo() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try (BufferedReader leitor_arquivo = new BufferedReader(
				new FileReader(new File(".").getCanonicalPath() + this.caminho_txt))) {
			String line = leitor_arquivo.readLine();
			while (line != null) {
					String[] aux = line.split(";");
					Usuario u = new Usuario(aux[0], aux[1], aux[2], aux[3]);
					lista.add(u);
				line = leitor_arquivo.readLine();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return lista;
	}
	
	public boolean Verificar_Nome(String nome) {
		ArrayList<Usuario> lista = Ler_arquivo();
		Usuario usuario = lista.stream().filter(user -> user.getNome().equals(nome)).findFirst().orElse(null);
		return usuario != null;
		}
	
	public int Proximo_id(){
        List<String> linhas = null;
		try {
			linhas = Files.readAllLines(Paths.get(new File(".").getCanonicalPath() + this.caminho_txt));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(linhas != null) {
			return linhas.size() + 1;
			
		}else {
			return 0;
		}
	}
	
	public int Verificar_Login(String nome, String senha) {
		int test = 0;
		ArrayList<Usuario> lista = Ler_arquivo();
		Usuario usuario = lista.stream().filter(user -> user.getNome().equals(nome) && user.getSenha().equals(senha)).findFirst().orElse(null);
		if(usuario != null) {
			test = usuario.getId();
		}else {
			test = 0;
		}
			return test;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void Atualizar(int id, int potuacao) {
		 Path path;
	        List<String> linhas;
	        
	        ArrayList<Usuario> lista = Ler_arquivo();
	        for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getId()==id){
					try {
						path = Paths.get(new File(".").getCanonicalPath() + this.caminho_txt);
						linhas = Files.readAllLines(path);
						if(potuacao > lista.get(i).getPontuacao()) {
							String novoConteudo = lista.get(i).getId() + ";" + lista.get(i).getNome() + ";" + lista.get(i).getSenha() + ";"+ potuacao;
						        linhas.remove(i);
						        linhas.add(i, novoConteudo);
						        if(path != null && linhas !=null) {
							        Files.write(path, linhas);					        	
						        }
						}
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 
					 break;
				}else {
					
				}
			}
	        
	        
	        
			
	}
	
	
	public ArrayList<Usuario> ranque () {
		
		ArrayList<Usuario> lista_usuarios  = Ler_arquivo(); 
		
		for (int a = 0; a < lista_usuarios.size(); a++) {
			for (int b = 0; b <= a; b++) {
				if(lista_usuarios.get(a).getPontuacao() > lista_usuarios.get(b).getPontuacao() ) {
					
					Usuario u = lista_usuarios.get(a);
					
					lista_usuarios.remove(a);
					lista_usuarios.add(a, lista_usuarios.get(b));
					
					lista_usuarios.remove(b);
					lista_usuarios.add(b,u);
				
					
				}else if (lista_usuarios.get(a).getPontuacao() == lista_usuarios.get(b).getPontuacao()){
					
				}
			}
		}
		return lista_usuarios;
		
		
	}

}
