package br.com.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.controller.Controller_jogo;
import br.com.view.Menu;

public class Jogo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private int id;


	Controller_jogo controlador;
	boolean ativar_sequencia_nova = false;

	JButton btnNewButton = new JButton("0");
	JButton btnNewButton_1 = new JButton("1");
	JButton btnNewButton_2 = new JButton("2");
	JButton btnNewButton_3 = new JButton("3");
	JButton btnNewButton_iniciar = new JButton("Iniciar");
	JButton[] botoes = { btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3 };

	JLabel lblAviso = new JLabel("");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jogo frame = new Jogo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Jogo() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton.addActionListener(this);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(158, 100, 152, 77);
		contentPane.add(btnNewButton);

		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setBounds(498, 100, 152, 77);
		contentPane.add(btnNewButton_1);

		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBackground(Color.BLUE);
		btnNewButton_2.setBounds(158, 272, 152, 77);
		contentPane.add(btnNewButton_2);

		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setBackground(Color.YELLOW);
		btnNewButton_3.setBounds(498, 272, 152, 77);
		contentPane.add(btnNewButton_3);

		btnNewButton_iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.Adicionar_numero_array_Novo();
				Demonstrar_Nova_Sequencia();
			}
		});
		btnNewButton_iniciar.setBackground(Color.WHITE);
		btnNewButton_iniciar.setBounds(329, 188, 152, 77);
		contentPane.add(btnNewButton_iniciar);

		lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setBounds(239, 373, 298, 48);
		contentPane.add(lblAviso);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < botoes.length; i++) {
			if (e.getSource() == botoes[i]) {
				Jogada(botoes[i], botoes[i].getBackground(), teste2(controlador.Jogada2(String.valueOf(i))));
			}
		}
	}

	public void Recebe_Controller(Controller_jogo controler) {
		this.controlador = controler;
	}

	public void Demonstrar_Nova_Sequencia() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				String[] array_aux;
				array_aux = controlador.getPartida_1().getSequencia_computador();

				/*
				 * array_aux[0] = "0"; array_aux[1] = "1"; array_aux[2] = "3"; array_aux[3] =
				 * "2"; array_aux[4] = "0"; array_aux[5] = "2"; array_aux[6] = "3"; array_aux[7]
				 * = "1"; array_aux[8] = "3"; array_aux[9] = "3"; array_aux[10] = "2";
				 * array_aux[11] = "1"; array_aux[12] = "2"; array_aux[13] = "0"; array_aux[14]
				 * = "0"; array_aux[15] = "0"; array_aux[16] = "0"; array_aux[17] = "0";
				 * array_aux[18] = "0"; array_aux[19] = "0"; array_aux[20] = "0"; array_aux[21]
				 * = "0"; array_aux[22] = "0"; array_aux[23] = "0"; array_aux[24] = "0";
				 */
				try {
					Thread.sleep(1500);
					lblAviso.setText("Carregando nova sequencia!");
					Thread.sleep(1500);
					for (int i = 0; i < array_aux.length; i++) {

						if (array_aux[i] == null) {
							break;
						} else {
							Piscar_botoes(botoes[Integer.parseInt(array_aux[i])]);
						}
						Thread.sleep(controlador.getPartida_1().getESPERA_FOR());

					}
					Thread.sleep(1500);
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
		 * 1 - para próxima jogada 2 - para iniciar nova rodada 3 - para fechar a tela
		 */

		switch (numero) {
		case 1:

			i = 0;
			break;

		case 2:

			// solicitar o array de numeros
			/*
			 * String[] array_aux; array_aux =
			 * controlador.getPartida_1().getSequencia_computador(); for (int i = 0; i <
			 * array_aux.length; i++) { String string = array_aux[i]; if (string != null) {
			 * System.out.println("P: [" + i + "] " + string); } }
			 */

			Demonstrar_Nova_Sequencia();
			i = 1;
			break;
		case 3:
			new Menu().show();
			;
			Jogo.this.dispose();
			i = 2;
			break;
		default:
			break;
		}

		return i;

	}

	public void Piscar_botoes(JButton e) {

		Color c = e.getBackground();

		try {
			Thread.currentThread();
			e.setBackground(Color.WHITE);
			Thread.sleep(controlador.getPartida_1().getPISCAR_BRANCO());
			Tocar_musica(e.getText().toString());
			e.setBackground(c);
			// controlador.Tocar_Musica("Botao 0");
			// Thread.sleep(controlador.getPartida_1().getPISCAR_COR());

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException P) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, P.getMessage());
		}

	}

	public void Jogada(JButton e, Color c, int i) {

		if (i != 2) {
			try {
				Thread.currentThread();
				e.setBackground(Color.WHITE);
				Thread.sleep(controlador.getPartida_1().getPISCAR_BRANCO());
				Tocar_musica(e.getText().toString());
				e.setBackground(c);
			} catch (InterruptedException | UnsupportedAudioFileException | IOException | LineUnavailableException P) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, P.getMessage());
			}
		}

	}

	public void Tocar_musica(String nome) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		AudioInputStream sound = AudioSystem
				.getAudioInputStream(Controller_jogo.class.getResourceAsStream("Botao " + nome + ".wav"));
		DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
		Clip clip = (Clip) AudioSystem.getLine(info);
		clip.open(sound);
		clip.start();
	}

	public void Recebe_Controller(Controller_jogo controler, int id) {
		this.controlador = controler;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
