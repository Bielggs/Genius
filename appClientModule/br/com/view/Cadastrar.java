package br.com.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.controller.Controller_usuario;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Cadastrar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtnome;
	private JPasswordField  txtsenha, txtconfirma;
	Controller_usuario controlador = new Controller_usuario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastrar frame = new Cadastrar();
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
	public Cadastrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 455);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		txtnome = new JTextField();
		txtnome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtnome.setBounds(299, 116, 168, 20);
		contentPane.add(txtnome);
		txtnome.setColumns(10);
		
		txtsenha = new JPasswordField();
		txtsenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtsenha.setBounds(299, 147, 168, 20);
		contentPane.add(txtsenha);
		txtsenha.setColumns(10);
		
		txtconfirma = new JPasswordField();
		txtconfirma.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtconfirma.setBounds(299, 178, 168, 20);
		contentPane.add(txtconfirma);
		txtconfirma.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controlador.Salvar(txtnome.getText(), txtconfirma.getText());
				if(!txtnome.getText().trim().isEmpty() && !txtsenha.getText().trim().isEmpty() && !txtconfirma.getText().trim().isEmpty()) {
					if(txtsenha.getText().equals(txtconfirma.getText())) {
						int difinicao = controlador.Salvar(txtnome.getText(), txtconfirma.getText());
						if(difinicao == 1 ) {
							JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");	
						}else {
							JOptionPane.showMessageDialog(null, "Este nome de usuário ja existe");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Verifique a senha novamente");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Há campos em branco");
				}

				
		/*
				try {
					System.out.println("/ -> " + new File("/").getCanonicalPath());
					System.out.println("… -> " + new File("…").getCanonicalPath());
					System.out.println(". -> " + new File(".").getCanonicalPath());
				
					String path = new File( new File(".").getCanonicalPath()+ "/appClientModule/br/com/controller/Usuarios.txt").getCanonicalPath();
					System.out.println(path);
					} catch (IOException ee) {
					ee.printStackTrace();
					}
				*/
			}
		});
		btnSalvar.setBounds(324, 226, 123, 35);
		contentPane.add(btnSalvar);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio");
		lblUsuario.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(201, 114, 77, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(223, 145, 55, 20);
		contentPane.add(lblSenha);
		
		JLabel lblconfirmacao = new JLabel("Confirmar senha");
		lblconfirmacao.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblconfirmacao.setForeground(Color.WHITE);
		lblconfirmacao.setBounds(117, 176, 165, 20);
		contentPane.add(lblconfirmacao);
		
		JLabel lblCadastrese = new JLabel("Cadastre-se");
		lblCadastrese.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrese.setForeground(Color.WHITE);
		lblCadastrese.setFont(new Font("OCR A Extended", Font.BOLD, 55));
		lblCadastrese.setBounds(157, 28, 385, 58);
		contentPane.add(lblCadastrese);
		
		JButton btnNewButton_iniciar_2 = new JButton("<-");
		btnNewButton_iniciar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				Cadastrar.this.dispose();
			}
		});
		btnNewButton_iniciar_2.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		btnNewButton_iniciar_2.setBackground(Color.WHITE);
		btnNewButton_iniciar_2.setBounds(10, 11, 65, 30);
		contentPane.add(btnNewButton_iniciar_2);
	}
}
