package br.com.view;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.controller.Controller_jogo;

public class nivel_facil extends JFrame {

	private JPanel contentPane;

	Controller_jogo controlador;

	boolean ativar_sequencia_nova = false;

	// String [] sequencia_computador = new String[partida.getContador_jogadas() +1
	// ];
	int PISCAR_BRANCO = 800;
	int PISCAR_COR = 1800;
	int ESPERA_FOR = 90;

	JButton btnNewButton_1 = new JButton("1");
	JButton btnNewButton_3 = new JButton("3");
	JButton btnNewButton_2 = new JButton("2");
	JButton btnNewButton_iniciar = new JButton("Iniciar");
	JButton btnNewButton = new JButton("0");
	private final JButton btnNewButton_4 = new JButton("New button");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nivel_facil frame = new nivel_facil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public nivel_facil() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// controlador.Jogada("0");

				teste2(controlador.Jogada2("0"));

			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(158, 100, 152, 77);
		contentPane.add(btnNewButton);

		btnNewButton_iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.Adicionar_numero_array_Novo();
				
				 try {
			           URL url = nivel_facil.class.getResource("/Projeto Genius/appClientModule/br.com.model/band.wav");
			           String nome = url.getPath();
			            AudioInputStream sound = AudioSystem.getAudioInputStream(url);
			            DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
			            Clip clip = (Clip) AudioSystem.getLine(info);
			            clip.open(sound);
			            clip.start();
			        } catch (Exception h) {
			         //   JOptionPane.showMessageDialog(this, e);
			        }
					
				
			}
		});
		btnNewButton_iniciar.setBackground(Color.WHITE);
		btnNewButton_iniciar.setBounds(329, 188, 152, 77);
		contentPane.add(btnNewButton_iniciar);

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// controlador.Jogada("2");
				teste2(controlador.Jogada2("2"));
			}
		});
		btnNewButton_2.setBackground(Color.BLUE);
		btnNewButton_2.setBounds(158, 272, 152, 77);
		contentPane.add(btnNewButton_2);

		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// controlador.Jogada("3");
				teste2(controlador.Jogada2("3"));
			}
		});
		btnNewButton_3.setBackground(Color.YELLOW);
		btnNewButton_3.setBounds(498, 272, 152, 77);
		contentPane.add(btnNewButton_3);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// controlador.Jogada("1");
				teste2(controlador.Jogada2("1"));
			}
		});
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setBounds(498, 100, 152, 77);
		contentPane.add(btnNewButton_1);

		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Teste();
			}
		});
		btnNewButton_4.setBounds(392, 36, 89, 23);
		contentPane.add(btnNewButton_4);

	}
	/*
	 * 
	 * public void Exibir_Nova_Sequencia(boolean teste) {
	 * 
	 * for (int i = 0; i <= controlador.Sequencia_do_array().length; i++) {
	 * 
	 * if(controlador.Sequencia_do_array()[i].equals("0")) {
	 * 
	 * try { Thread.currentThread(); btnNewButton.setBackground(Color.WHITE);
	 * Thread.sleep(10000); btnNewButton.setBackground(Color.BLUE);
	 * Thread.sleep(3000); btnNewButton.setBackground(Color.GREEN);
	 * Thread.sleep(10000); btnNewButton.setBackground(Color.GREEN);
	 * 
	 * 
	 * } catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 */

	public void Teste() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					btnNewButton.setEnabled(false);
					;
					Thread.currentThread();
					Thread.sleep(PISCAR_BRANCO);
					btnNewButton.setBackground(Color.WHITE);
					Thread.sleep(2000);
					btnNewButton.setBackground(Color.GREEN);
					Thread.sleep(1000);
					btnNewButton.setBackground(Color.RED);
					btnNewButton.setEnabled(true);
					;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

	}

	public void Recebe_Controller(Controller_jogo controler) {

		this.controlador = controler;
	}

	public void teste2(int numero) {

		// 1 - para próxima jogada
		// 2 - para iniciar nova rodada
		// 3 - para fechar a tela

		switch (numero) {
		case 1:

			break;
		case 2:

			// solicitar o array de numeros
			String[] array_aux;
			array_aux = controlador.getPartida_1().getSequencia_computador();

			for (int i = 0; i < array_aux.length; i++) {
				String string = array_aux[i];
				if (string != null) {
					System.out.println("P: [" + i + "] " + string);
				}

			}

			for (int i = 0; i < array_aux.length; i++) {

				try {
					Thread.sleep(ESPERA_FOR);

					if (array_aux[i] != null) {
						botoes(array_aux[i]);
					}

				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			break;
		case 3:

			Menu menu = new Menu();
			menu.show();
			nivel_facil.this.dispose();
			break;
		default:
			break;
		}

	}

	public void botoes(String numero) {	
		if (numero.equals("0")) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {

					//	btnNewButton.setEnabled(false);
						Thread.currentThread();
						Thread.sleep(PISCAR_BRANCO);
						btnNewButton.setBackground(Color.WHITE);
						Tocar_Musica(this.getClass().getResourceAsStream("band-re.wav")+"");
						Thread.sleep(PISCAR_COR);
						btnNewButton.setBackground(Color.RED);
						//btnNewButton.setEnabled(true);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
			// btnNewButton 0
			// btnNewButton_2 2
			// btnNewButton_3 3
			// btnNewButton_1 1

		} else if (numero.equals("1")) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {

					//	btnNewButton_1.setEnabled(false);
						Thread.currentThread();
						Thread.sleep(PISCAR_BRANCO);
						btnNewButton_1.setBackground(Color.WHITE);
						Tocar_Musica("C:\\Users\\bielg\\Desktop\\band-la.wav");
						Thread.sleep(PISCAR_COR);
						btnNewButton_1.setBackground(Color.GREEN);
					//	btnNewButton_1.setEnabled(true);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		} else if (numero.equals("2")) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {

					//	btnNewButton_2.setEnabled(false);
						Thread.currentThread();
						Thread.sleep(PISCAR_BRANCO);
						btnNewButton_2.setBackground(Color.WHITE);
						Thread.sleep(PISCAR_COR);
						btnNewButton_2.setBackground(Color.BLUE);
					//	btnNewButton_2.setEnabled(true);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();

		} else if (numero.equals("3")) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {

					//	btnNewButton_3.setEnabled(false);
						Thread.currentThread();
						Thread.sleep(PISCAR_BRANCO);
						btnNewButton_3.setBackground(Color.WHITE);
						Thread.sleep(PISCAR_COR);
						btnNewButton_3.setBackground(Color.YELLOW);
					//	btnNewButton_3.setEnabled(true);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();

		}

	}
	
	
	
	public void Tocar_Musica(String caminho) {
		
		//"C:\\Users\\bielg\\Desktop\\band-la.wav"
        try {
            File soundFile = new File(caminho);
            AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);
            DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(sound);
            clip.start();
        } catch (Exception h) {
         //   JOptionPane.showMessageDialog(this, e);
        }
		
	}

}
