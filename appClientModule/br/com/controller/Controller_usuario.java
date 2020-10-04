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


	public void Salvar(String nome, String senha) {		
			if(Verificar_Nome(nome) == true){
				
			}else {
				Usuario user = new Usuario();
				user.setId(Proximo_id());
				user.setNome(nome);
				user.setSenha(senha);
				user.setPontuacao(0);
				
				try {
					String raiz = new File(".").getCanonicalPath();
					String path = new File(new File(".").getCanonicalPath() + this.caminho_txt)
							.getCanonicalPath();
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
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	
		// user.getNome().contains(s)

		
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
		boolean test = true;
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNome().equals(nome)){
				 test = true;
				 break;
			}else {
				 test = false;
			}
		}
			return test;
	}
	
	public int Proximo_id() {
        Path path;
        List<String> linhas = null;
		try {
			path = Paths.get(new File(".").getCanonicalPath() + this.caminho_txt);
			linhas = Files.readAllLines(path); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return linhas.size() + 1;
	}
	
	public int Verificar_Login(String nome, String senha) {
		ArrayList<Usuario> lista = Ler_arquivo();
		int test = 0;
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNome().equals(nome) && lista.get(i).getSenha().equals(senha)){
				 test = i;
				 setId(i);
				 break;
			}else {
				 test = 0;
			}
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
						String novoConteudo = lista.get(i).getId() + ";" + lista.get(i).getNome() + ";" + lista.get(i).getSenha() + ";"+ potuacao;
					        linhas.remove(i);
					        linhas.add(i, novoConteudo);
					        Files.write(path, linhas);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 
					 break;
				}else {
					
				}
			}
	        
	        
	        
			
	}
	

}
