package br.com.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.controller.Controller_jogo;
import br.com.model.Button_Game;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Genius extends JFrame {

	private JPanel contentPane;
	private int id;

	Controller_jogo controlador;

	Button_Game[] botoes;
	Button_Game botao_0 = new Button_Game("Botao 0", 0);
	Button_Game botao_1 = new Button_Game("Botao 1", 1);
	Button_Game botao_2 = new Button_Game("Botao 2", 2);
	Button_Game botao_3 = new Button_Game("Botao 3", 3);
	Button_Game botao_iniciar = new Button_Game("Iniciar", 4);
	
	JLabel lblAviso = new JLabel("New label");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Genius frame = new Genius();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Genius() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		botoes = new Button_Game[4];
		botoes[botao_0.getIndex()] = botao_0;
		botoes[botao_1.getIndex()] = botao_1;
		botoes[botao_2.getIndex()] = botao_2;
		botoes[botao_3.getIndex()] = botao_3;

		botao_0.setBackground(Color.RED);
		botao_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jogada(botao_0, botao_0.getBackground(), teste2(controlador.Jogada2("0")));
			}
		});
		botao_0.setBounds(21, 61, 142, 48);
		contentPane.add(botao_0);

		botao_1.setBackground(Color.GREEN);
		botao_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jogada(botao_1, botao_1.getBackground(), teste2(controlador.Jogada2("1")));
			}
		});

		botao_1.setBounds(217, 61, 142, 48);
		contentPane.add(botao_1);

		botao_2.setBackground(Color.BLUE);
		botao_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jogada(botao_2, botao_2.getBackground(), teste2(controlador.Jogada2("2")));
			}
		});
		botao_2.setBounds(21, 222, 142, 48);
		contentPane.add(botao_2);

		botao_3.setBackground(Color.YELLOW);
		botao_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jogada(botao_3, botao_3.getBackground(), teste2(controlador.Jogada2("3")));
			}
		});
		botao_3.setBounds(217, 222, 142, 48);
		contentPane.add(botao_3);
		botao_iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.Adicionar_numero_array_Novo();
				Demonstrar_Nova_Sequencia();
			}
		});

		botao_iniciar.setBackground(Color.CYAN);
		botao_iniciar.setBounds(123, 148, 142, 48);
		contentPane.add(botao_iniciar);
		

		lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setBounds(61, 298, 298, 48);
		contentPane.add(lblAviso);

	}

	public void Demonstrar_Nova_Sequencia() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				String[] array_aux;
				array_aux = controlador.getPartida_1().getSequencia_computador();
				try {
					Thread.sleep(controlador.getPartida_1().getESPERA_FOR());
					lblAviso.setText("Carregando nova sequencia!");
					Thread.sleep(controlador.getPartida_1().getESPERA_FOR());
					for (int i = 0; i < array_aux.length; i++) {
						Thread.sleep(controlador.getPartida_1().getESPERA_FOR());
						if (array_aux[i] == null) {
							break;
						} else {
							Piscar_botoes(botoes[Integer.parseInt(array_aux[i])]);
						}
					}
					Thread.sleep(controlador.getPartida_1().getESPERA_FOR());
					lblAviso.setText("Sua vez de jogar :D");
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		}).start();

	}

	public int teste2(int numero) {
		int i = 0;
		/*
		 * 1 - para próxima Jogada 2 - para iniciar nova rodada 3 - para fechar a tela
		 */
		switch (numero) {
		case 1:

			i = 0;
			break;
		case 2:
			// solicitar o array de numeros
			Demonstrar_Nova_Sequencia();
			i = 1;
			break;
		case 3: 
			new Menu().show();
			Genius.this.dispose();
			i = 2;
			break;
		default:
			break;
		}

		return i;

	}

	public void Jogada(Button_Game e, Color c, int i) {

		if (i != 2) {
			try {
				Thread.currentThread();
				e.setBackground(Color.WHITE);
				Thread.sleep(controlador.getPartida_1().getPISCAR_BRANCO());
				Tocar_musica(e.getNome());
				e.setBackground(c);
			} catch (InterruptedException | UnsupportedAudioFileException | IOException | LineUnavailableException P) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, P.getMessage());
			}
		}

	}

	public void Piscar_botoes(Button_Game e) {

		Color c = e.getBackground();

		try {
			Thread.currentThread();
			e.setBackground(Color.WHITE);
			Thread.sleep(controlador.getPartida_1().getPISCAR_BRANCO());
			Tocar_musica(e.getNome());
			e.setBackground(c);
			// controlador.Tocar_Musica("Botao 0");
			// Thread.sleep(controlador.getPartida_1().getPISCAR_COR());

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException P) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, P.getMessage());
		}

	}
	
	public void Tocar_musica(String nome) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		AudioInputStream sound = AudioSystem
				.getAudioInputStream(Controller_jogo.class.getResourceAsStream(nome + ".wav"));
		DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
		Clip clip = (Clip) AudioSystem.getLine(info);
		clip.open(sound);
		clip.start();
	}
	
	public void Recebe_Controller(Controller_jogo controler, int id) {
		this.controlador = controler;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
