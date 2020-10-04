package br.com.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.controller.Controller_usuario;

public class Cadastrar extends JFrame {

	private JPanel contentPane;
	private JTextField txtnome;
	private JTextField txtsenha;
	private JTextField txtconfirma;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtnome = new JTextField();
		txtnome.setBounds(107, 36, 146, 20);
		contentPane.add(txtnome);
		txtnome.setColumns(10);
		
		txtsenha = new JTextField();
		txtsenha.setBounds(107, 78, 146, 20);
		contentPane.add(txtsenha);
		txtsenha.setColumns(10);
		
		txtconfirma = new JTextField();
		txtconfirma.setBounds(142, 114, 153, 20);
		contentPane.add(txtconfirma);
		txtconfirma.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controlador.Salvar(txtnome.getText(), txtconfirma.getText());
				if(!txtnome.getText().trim().isEmpty() && !txtsenha.getText().trim().isEmpty() && !txtconfirma.getText().trim().isEmpty()) {
					if(txtsenha.getText().equals(txtconfirma.getText())) {
						controlador.Salvar(txtnome.getText(), txtconfirma.getText());
						//controlador.Ler_arquivo();
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
		btnSalvar.setBounds(107, 158, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(206, 158, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio");
		lblUsuario.setBounds(51, 39, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(51, 81, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel lblconfirmacao = new JLabel("Confirmar senha");
		lblconfirmacao.setBounds(51, 117, 81, 14);
		contentPane.add(lblconfirmacao);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controlador.Ler_arquivo();
				

		        Path path = Paths.get("C:\\Users\\bielg\\Desktop\\Usuarios.txt");
		        List<String> linhas;
				try {
					linhas = Files.readAllLines(path);
					String novoConteudo = "klasknlaklafklasnas";
//				            linhas.get(0).substring(0, 7) + "conteudo" + linhas.get(0).substring(15);

				        linhas.remove(0);
				        linhas.add(10, novoConteudo);
				        linhas.size();

				        Files.write(path, linhas);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

		        
				
				
			}
		});
		btnNewButton.setBounds(61, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controlador.Atualizar(4, 200);
			}
		});
		btnNewButton_1.setBounds(248, 227, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
