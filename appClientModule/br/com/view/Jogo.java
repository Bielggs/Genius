package br.com.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.controller.Controller_jogo;
import br.com.controller.Controller_usuario;

public class Jogo extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int id, nivel;

	Controller_jogo controlador;
	Controller_usuario controlador_user = new Controller_usuario();

	boolean ativar_sequencia_nova = false;

	JButton btnNewButton = new JButton("");
	JButton btnNewButton_1 = new JButton("");
	JButton btnNewButton_2 = new JButton("");
	JButton btnNewButton_3 = new JButton("");
	JButton btnNewButton_iniciar = new JButton("");
	JButton[] botoes = { btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3 };

	JLabel lblAviso = new JLabel("");
	private final JLabel lblNewLabel = new JLabel("Acertos");
	private final JLabel lblpontuacao = new JLabel(" ");
	private final JLabel lblNivel = new JLabel("");
	private final JButton btn_repetir = new JButton("");
	private final JLabel lblRepetirSequencia = new JLabel("Repetir");
	private final JLabel lblIniciar = new JLabel("Iniciar");
	private final JButton btn_dica = new JButton("");
	private final JLabel lblDica = new JLabel("Dica");
	private final JButton btn_voltar = new JButton("<-");
	
	



	Font font = new Font("OCR A Extended", Font.BOLD, 20);
	Font font_14 = new Font("OCR A Extended", Font.BOLD, 14);

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
		setBackground(new Color(230, 230, 250));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		Bloquear_Botoes();
		btnNewButton.addActionListener(this);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(168, 41, 90, 233);
		contentPane.add(btnNewButton);

		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setBounds(268, 41, 350, 77);
		contentPane.add(btnNewButton_1);

		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBackground(Color.BLUE);
		btnNewButton_2.setBounds(168, 285, 350, 77);
		contentPane.add(btnNewButton_2);

		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setBackground(Color.YELLOW);
		btnNewButton_3.setBounds(528, 129, 90, 233);
		contentPane.add(btnNewButton_3);
		btnNewButton_iniciar.setFont(font);

		btnNewButton_iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.Adicionar_numero_array_Novo();
				Demonstrar_Nova_Sequencia();
				btnNewButton_iniciar.setEnabled(false);
			}
		});
		btnNewButton_iniciar.setBackground(Color.WHITE);
		// btnNewButton_iniciar.setIcon(new
		// ImageIcon(Controller_jogo.class.getResource("playgame.png")));
		btnNewButton_iniciar.setBounds(362, 148, 50, 30);
		contentPane.add(btnNewButton_iniciar);
		lblAviso.setForeground(new Color(248, 248, 255));

		lblAviso.setFont(font);
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setBounds(202, 373, 372, 32);
		contentPane.add(lblAviso);
		lblNewLabel.setForeground(new Color(248, 248, 255));

		lblNewLabel.setFont(font);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(327, 189, 118, 19);

		contentPane.add(lblNewLabel);
		lblpontuacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblpontuacao.setBackground(new Color(248, 248, 255));
		lblpontuacao.setForeground(new Color(248, 248, 255));
		lblpontuacao.setFont(font);
		lblpontuacao.setBounds(340, 219, 90, 56);

		contentPane.add(lblpontuacao);
		lblNivel.setForeground(Color.WHITE);
		lblNivel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNivel.setBackground(Color.WHITE);
		lblNivel.setFont(new Font("OCR A Extended", Font.BOLD, 21));
		lblNivel.setBounds(168, 0, 450, 40);

		contentPane.add(lblNivel);
		btn_repetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Demonstrar_Nova_Sequencia();
			}
		});
		btn_repetir.setBackground(new Color(255, 255, 0));
		btn_repetir.setBounds(271, 147, 50, 30);

		contentPane.add(btn_repetir);
		lblRepetirSequencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepetirSequencia.setForeground(new Color(248, 248, 255));
		lblRepetirSequencia.setFont(font_14);
		lblRepetirSequencia.setBounds(261, 129, 73, 19);

		contentPane.add(lblRepetirSequencia);
		lblIniciar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciar.setForeground(new Color(248, 248, 255));
		lblIniciar.setFont(font_14);
		lblIniciar.setBounds(350, 129, 73, 19);

		contentPane.add(lblIniciar);
		btn_dica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i = controlador.Dica();
				new Thread(new Runnable() {
					@Override
					public void run() {
						Piscar_botoes(botoes[Integer.valueOf(i)], Integer.valueOf(i));
					}
				}).start();
				btnNewButton_iniciar.setEnabled(false);
			}
		});
		btn_dica.setFont(font);
		btn_dica.setBackground(new Color(0, 0, 205));
		btn_dica.setBounds(457, 148, 50, 30);

		contentPane.add(btn_dica);
		lblDica.setHorizontalAlignment(SwingConstants.CENTER);
		lblDica.setForeground(new Color(248, 248, 255));
		lblDica.setFont(font_14);
		lblDica.setBounds(445, 129, 73, 19);

		contentPane.add(lblDica);
		btn_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.Receber_id(getId());
				menu.setVisible(true);
				Jogo.this.dispose();
			}
		});
		btn_voltar.setFont(font);
		btn_voltar.setBackground(Color.WHITE);
		btn_voltar.setBounds(10, 11, 65, 30);

		contentPane.add(btn_voltar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < botoes.length; i++) {
			if (e.getSource() == botoes[i]) {
				Jogada(botoes[i], botoes[i].getBackground(), opc_jogada(controlador.Jogada(String.valueOf(i))), i);
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
					Bloquear_Botoes();
					Thread.sleep(1500);
					for (int i = 0; i < array_aux.length; i++) {

						if (array_aux[i] == null) {
							break;
						} else {
							Piscar_botoes(botoes[Integer.parseInt(array_aux[i])], Integer.parseInt(array_aux[i]));
						}
						Thread.sleep(controlador.getPartida_1().getESPERA_FOR());

					}
					Thread.sleep(1500);
					lblAviso.setText("Sua vez de jogar :D");
					Desbloquear_Botoes();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}
		}).start();

	}
	

	public int opc_jogada(int numero) {
		int i = 0;
		/*
		 * 1 - para próxima jogada 2 - para iniciar nova rodada 3 - para fechar a tela
		 */
		switch (numero) {
		case 1:
			controlador.getPartida_1().setPontuacao(controlador.getPartida_1().getPontuacao() + 1);
			lblpontuacao.setText(controlador.getPartida_1().getPontuacao() + "");

			i = 0;
			break;

		case 2:
			controlador.getPartida_1().setPontuacao(controlador.getPartida_1().getPontuacao() + 1);
			lblpontuacao.setText(controlador.getPartida_1().getPontuacao() + "");
			// solicitar o array de numeros
			Demonstrar_Nova_Sequencia();
			i = 1;
			break;
		case 3:

			controlador_user.Atualizar(getId(), controlador.getPartida_1().getPontuacao());

			JOptionPane.showMessageDialog(null, "O usuario com id : " + getId() + " Recebeu a pontação de : "
					+ controlador.getPartida_1().getPontuacao());

			Menu menu = new Menu();
					menu.setId(getId());
					menu.setVisible(true);
			Jogo.this.dispose();
			i = 2;
			break;
		default:
			break;
		}

		return i;

	}

	public void Piscar_botoes(JButton e, int numero) {
		Color c = e.getBackground();
		try {
			Thread.currentThread();
			e.setBackground(Color.WHITE);
			Thread.sleep(controlador.getPartida_1().getPISCAR_BRANCO());
			controlador.Tocar_Musica("Botao " + numero);
			e.setBackground(c);
		} catch (InterruptedException P) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, P.getMessage() + "erro no bloco de piscar botao");
		}

	}

	public void Jogada(JButton e, Color c, int i, int numero) {

		if (i != 2) {
			try {
				Thread.currentThread();
				e.setBackground(Color.WHITE);
				Thread.sleep(controlador.getPartida_1().getPISCAR_BRANCO());
				controlador.Tocar_Musica("Botao " + numero);
				e.setBackground(c);
			} catch (InterruptedException P) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, P.getMessage() + "Erro no bloco de jogada");
			}
		}

	}

	public void Bloquear_Botoes() {
		btnNewButton.setEnabled(false);
		btnNewButton_1.setEnabled(false);
		btnNewButton_2.setEnabled(false);
		btnNewButton_3.setEnabled(false);
		btn_repetir.setEnabled(false);
		btn_dica.setEnabled(false);
	}

	public void Desbloquear_Botoes() {
		btnNewButton.setEnabled(true);
		btnNewButton_1.setEnabled(true);
		btnNewButton_2.setEnabled(true);
		btnNewButton_3.setEnabled(true);
		btn_repetir.setEnabled(true);
		btn_dica.setEnabled(true);
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

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
		
		switch (nivel) {
		case 1:
			lblNivel.setText("NIVEL FACIL");
			break;
		case 2:
			lblNivel.setText("NIVEL MEDIO");
			break;
		case 3:
			lblNivel.setText("NIVEL DIFICIL");
			break;
		case 4:
			lblNivel.setText("NIVEL SUPER DIFICL");
			break;

		default:
			break;
		}
	}
	
	
}
