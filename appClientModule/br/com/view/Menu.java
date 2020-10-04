package br.com.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.controller.Controller_jogo;

public class Menu extends JFrame {

	private JPanel contentPane;
	int nivel = 1;
	private int id;
	
	



	Controller_jogo controlador= new Controller_jogo();
	Jogo partida = new Jogo();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btn_Facil = new JButton("Facil");
		btn_Facil.setBounds(181, 125, 97, 23);
		btn_Facil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Iniciar(1); 
			}
		});
		
		JButton btn_Medio = new JButton("M\u00E9dio");
		btn_Medio.setBounds(181, 154, 97, 23);
		btn_Medio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Iniciar(2); 
			
			}
		});
		
		JButton btn_Dificil = new JButton("Dific\u00EDl");
		btn_Dificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Iniciar(3); 
			}
		});
		btn_Dificil.setBounds(181, 183, 97, 23);
		
		JButton btn_Sair = new JButton("Sair");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Jogo j =	new Jogo();
			controlador.Escolher_nivel(4);
			j.Recebe_Controller(controlador);
				j.show();
			}
		});
		btn_Sair.setBounds(181, 255, 97, 23);
		
		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setBounds(98, 30, 274, 77);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbl_iniciar = new JLabel("Iniciar");
		lbl_iniciar.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_iniciar.setBounds(318, 107, 148, 117);
		contentPane.setLayout(null);
		contentPane.add(btn_Sair);
		contentPane.add(btn_Medio);
		contentPane.add(btn_Facil);
		contentPane.add(btn_Dificil);
		contentPane.add(lblNewLabel);
		contentPane.add(lbl_iniciar);
		
		JLabel lbl_Ranque = new JLabel("Ranque");
		lbl_Ranque.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Ranque.setBounds(382, 11, 98, 87);
		contentPane.add(lbl_Ranque);
		
		JButton btn_Hard = new JButton("Hard");
		btn_Hard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Iniciar(4);
			}
		});
		btn_Hard.setBounds(181, 217, 97, 23);
		contentPane.add(btn_Hard);
	}
	
	public void Iniciar(int nivel) {
		controlador.Escolher_nivel(3);
		partida.Recebe_Controller(controlador, getId());
		partida.show();
		Menu.this.dispose();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void Receber_id(int id) {
	this.id = id;	
	}
	
	
}
