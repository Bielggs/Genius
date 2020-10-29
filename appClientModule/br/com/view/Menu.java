package br.com.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.controller.Controller_jogo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int nivel = 1;
	private int id;
	
	



	Controller_jogo controlador= new Controller_jogo();
	Jogo partida = new Jogo();
	
	Font font = new Font("OCR A Extended", Font.BOLD, 55);
	Font font_14 = new Font("OCR A Extended", Font.BOLD, 20);
	
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
		setBounds(100, 100, 748, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		
		JButton btn_Facil = new JButton("Facil");
		btn_Facil.setFont(font_14);
		btn_Facil.setBounds(268, 151, 172, 35);
		btn_Facil.setBackground(Color.WHITE);
		btn_Facil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Iniciar(1); 
			}
		});
		
		JButton btn_Medio = new JButton("M\u00E9dio");
		btn_Medio.setForeground(Color.WHITE);
		btn_Medio.setFont(font_14);
		btn_Medio.setBounds(268, 197, 172, 35);
		btn_Medio.setBackground(Color.GREEN);
		btn_Medio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Iniciar(2); 
			
			}
		});
		
		JButton btn_Dificil = new JButton("Dific\u00EDl");
		btn_Dificil.setBackground(Color.BLUE);
		btn_Dificil.setForeground(Color.WHITE);
		btn_Dificil.setFont(font_14);
		btn_Dificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Iniciar(3); 
			}
		});
		btn_Dificil.setBounds(268, 243, 172, 35);
		
		JLabel lblNewLabel = new JLabel("GENIUS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(font);
		lblNewLabel.setBounds(214, 44, 274, 77);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.setLayout(null);
		contentPane.add(btn_Medio);
		contentPane.add(btn_Facil);
		contentPane.add(btn_Dificil);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_Ranque = new JLabel("Ranque");
		lbl_Ranque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ranque ranque =new Ranque();
				ranque.setId(id);
				ranque.setVisible(true);
				Menu.this.dispose();
			}
		});
		lbl_Ranque.setIcon(new ImageIcon(Controller_jogo.class.getResource("trofeuu.png")));
		lbl_Ranque.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Ranque.setBounds(583, 20, 120, 121);
		contentPane.add(lbl_Ranque);
		
		JButton btn_Hard = new JButton("SUPER DIFI\u00C9CIL");
		btn_Hard.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		btn_Hard.setBackground(Color.RED);
		btn_Hard.setForeground(Color.WHITE);
		btn_Hard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Iniciar(4);
			}
		});
		btn_Hard.setBounds(268, 289, 172, 35);
		contentPane.add(btn_Hard);
		
		JButton btnNewButton_iniciar_2 = new JButton("<-");
		btnNewButton_iniciar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				Menu.this.dispose();
			}
		});
		btnNewButton_iniciar_2.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		btnNewButton_iniciar_2.setBackground(Color.WHITE);
		btnNewButton_iniciar_2.setBounds(10, 11, 65, 35);
		contentPane.add(btnNewButton_iniciar_2);
		
		JLabel lblRanque = new JLabel("Ranque");
		lblRanque.setHorizontalAlignment(SwingConstants.CENTER);
		lblRanque.setForeground(new Color(248, 248, 255));
		lblRanque.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblRanque.setBounds(583, 141, 108, 19);
		contentPane.add(lblRanque);
	}
	
	public void Iniciar(int nivel) {
		controlador.Escolher_nivel(nivel);
		partida.Recebe_Controller(controlador, getId());
		partida.setNivel(nivel);
		partida.setVisible(true);
		
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
