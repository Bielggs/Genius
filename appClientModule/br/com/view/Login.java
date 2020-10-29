package br.com.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.controller.Controller_usuario;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtnome;
	private JPasswordField txtsenha;

	Controller_usuario controlador = new Controller_usuario(); 
	Color[]  array_cor  = {Color.WHITE, Color.GREEN, Color.YELLOW, Color.RED, Color.BLUE};
	
	JLabel lbl_G = new JLabel("G"); 
	JLabel lbl_E = new JLabel("E");
	JLabel lbl_N = new JLabel("N");
	JLabel lbl_I = new JLabel("I");
	JLabel lbl_U = new JLabel("U");
	JLabel lbl_S = new JLabel("S");
	
	JLabel [] array_letras = {lbl_G, lbl_E, lbl_N, lbl_I, lbl_U, lbl_S};

	Random rand =  new Random();
	int i = 1;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 455);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
	
		
		
		
		
		Thread letras = new Thread(new Runnable() {
				@Override
				public void run() {
					do {
						
						try {
							array_letras[rand.nextInt(6)].setForeground(array_cor[rand.nextInt(5)]);
							Thread.sleep(30);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} while (i != 0);
				
				}
			});
		letras.start();
		
		
		
		txtnome = new JTextField();
		txtnome.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtnome.setBounds(283, 174, 184, 29);
		contentPane.add(txtnome);
		txtnome.setColumns(10);
		
		txtsenha = new JPasswordField();
		txtsenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtsenha.setBounds(283, 215, 184, 28);
		contentPane.add(txtsenha);
		txtsenha.setColumns(10);
		
		
		
		JLabel lblnome = new JLabel("Usu\u00E1rio");
		lblnome.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblnome.setForeground(Color.WHITE);
		lblnome.setBounds(184, 180, 89, 20);
		contentPane.add(lblnome);
		
		JLabel lblsenha = new JLabel("Senha");
		lblsenha.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblsenha.setForeground(Color.WHITE);
		lblsenha.setBounds(194, 208, 89, 36);
		contentPane.add(lblsenha);
		
		JLabel lblNewLabel_2 = new JLabel("Cadastrar-se");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Cadastrar().setVisible(true);;
				Login.this.dispose();
				letras.stop();
				
			}
		});
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(256, 244, 235, 46);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = controlador.Verificar_Login(txtnome.getText(), txtsenha.getText());
				if(id!= 0){
					Menu menu =new Menu();
					menu.Receber_id(id);
					menu.setVisible(true);
					Login.this.dispose();
					letras.stop();
				}else{
					JOptionPane.showConfirmDialog(null, "Usuário ou senha incorreto");
				};
			}
		});
		btnNewButton.setBounds(318, 301, 123, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Entrar sem login");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu =new Menu();
				menu.Receber_id(0);
				menu.setVisible(true);
				Login.this.dispose();
				letras.stop();
			}
		});
		btnNewButton_1.setBounds(267, 341, 235, 29);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(149, 31, 418, 124);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		
		lbl_G.setForeground(Color.WHITE);
		lbl_G.setFont(new Font("OCR A Extended", Font.BOLD, 58));
		lbl_G.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_G);
		
		lbl_E.setForeground(Color.WHITE);
		lbl_E.setFont(new Font("OCR A Extended", Font.BOLD, 58));
		lbl_E.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_E);
		
		lbl_N.setForeground(Color.WHITE);
		lbl_N.setFont(new Font("OCR A Extended", Font.BOLD, 58));
		lbl_N.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_N);
		
		
		lbl_I.setForeground(Color.WHITE);
		lbl_I.setFont(new Font("OCR A Extended", Font.BOLD, 58));
		lbl_I.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_I);
		
		lbl_U.setForeground(Color.WHITE);
		lbl_U.setFont(new Font("OCR A Extended", Font.BOLD, 58));
		lbl_U.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_U);
		
		
		lbl_S.setForeground(Color.WHITE);
		lbl_S.setFont(new Font("OCR A Extended", Font.BOLD, 58));
		lbl_S.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_S);
		
		
	}
	
	
	
	public void PiscarLetras() {
		
	}
}
