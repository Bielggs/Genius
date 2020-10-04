package br.com.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.controller.Controller_usuario;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtnome;
	private JTextField txtsenha;

	Controller_usuario controlador = new Controller_usuario(); 
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtnome = new JTextField();
		txtnome.setBounds(133, 60, 134, 20);
		contentPane.add(txtnome);
		txtnome.setColumns(10);
		
		txtsenha = new JTextField();
		txtsenha.setBounds(133, 87, 134, 20);
		contentPane.add(txtsenha);
		txtsenha.setColumns(10);
		
		JLabel lblnome = new JLabel("Usu\u00E1rio");
		lblnome.setBounds(72, 63, 46, 14);
		contentPane.add(lblnome);
		
		JLabel lblsenha = new JLabel("Senha");
		lblsenha.setBounds(72, 90, 46, 14);
		contentPane.add(lblsenha);
		
		JLabel lblNewLabel_2 = new JLabel("Cadastrar-se");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(133, 112, 134, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = controlador.Verificar_Login(txtnome.getText(), txtsenha.getText());
				if(id!= 0){
					Menu menu =new Menu();
					menu.Receber_id(id);
					menu.show();
					Login.this.dispose();
				};
			}
		});
		btnNewButton.setBounds(155, 137, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Entrar sem login");
		btnNewButton_1.setBounds(126, 199, 141, 23);
		contentPane.add(btnNewButton_1);
	}
}
