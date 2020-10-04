package br.com.controller;

import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JOptionPane;

import br.com.model.Partida;


public class Controller_jogo {
	
	Random rand =  new Random();
	
	private Partida partida_1;

	
	
	public void Escolher_nivel(int nivel) {
		
		switch (nivel) {
		case 1:
			partida_1 = new Partida(0,0,25, 400, 500, 500);			
			break;
		case 2:
			partida_1 = new Partida(0,0,50, 300, 400, 400);
			
			break;
		case 3:
			partida_1 = new Partida(0,0,100, 200, 300, 380);
			break;
		case 4:
			partida_1 = new Partida(0,0,100, 100, 100, 100);
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

	

	
	public int Jogada_botoes(String jogada) {		
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
			try {
	            AudioInputStream sound = AudioSystem.getAudioInputStream(Controller_jogo.class.getResourceAsStream("Errou.wav"));
	            DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
	            Clip clip = (Clip) AudioSystem.getLine(info);
	            clip.open(sound);
	            clip.start();
	        } catch (Exception i) {
	            JOptionPane.showMessageDialog(null, i.getMessage());
	        }
			
			JOptionPane.showMessageDialog(null,  "Deu ruim");
			return 3;
			
		}
		/*  1 - para próxima jogada
		 	2 - para iniciar nova rodada
		 	3 - para fechar a tela
		*/
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
			try {
	            AudioInputStream sound = AudioSystem.getAudioInputStream(Controller_jogo.class.getResourceAsStream("Errou.wav"));
	            DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
	            Clip clip = (Clip) AudioSystem.getLine(info);
	            clip.open(sound);
	            clip.start();
	        } catch (Exception i) {
	            JOptionPane.showMessageDialog(null, i.getMessage());
	        }
			
			JOptionPane.showMessageDialog(null,  "Deu ruim");
			return 3;
			
		}
		/*  1 - para próxima jogada
		 	2 - para iniciar nova rodada
		 	3 - para fechar a tela
		*/
	}
	
	public void Tocar_Musica(String nome) {
		try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(Controller_jogo.class.getResourceAsStream(nome+".wav"));
            DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(sound);
            clip.start();
        } catch (Exception i) {
            JOptionPane.showMessageDialog(null, i.getMessage());
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
	

}
