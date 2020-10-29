package br.com.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.com.controller.Controller_usuario;
import br.com.model.Usuario;
import javax.swing.border.LineBorder;

public class Ranque extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Controller_usuario user = new Controller_usuario();
	private int id;

	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ranque frame = new Ranque();
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
	public Ranque() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 531);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);

		table_2 = new JTable();
		table_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		table_2.setBounds(0, 0, 748, 455);
		table_2.setShowVerticalLines(false);
		table_2.setFont(new Font("OCR A Extended", Font.BOLD, 19));
		table_2.setForeground(Color.WHITE);
		table_2.setBackground(Color.BLACK);
		// scrollPane.setViewportView(table_2);
		table_2.setModel(model);

		panel = new JPanel();
		panel.setLayout(null);
		panel.add(table_2);

		JPanel panel_1 = new JPanel();

		lblNewLabel_3 = new JLabel("Ranque");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("OCR A Extended", Font.BOLD, 32));

		JButton btnNewButton_iniciar_2 = new JButton("<-");
		btnNewButton_iniciar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setId(id);
				menu.setVisible(true);
				Ranque.this.dispose();
			}
		});
		btnNewButton_iniciar_2.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		btnNewButton_iniciar_2.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING,
						gl_contentPane.createSequentialGroup()
								.addComponent(btnNewButton_iniciar_2, GroupLayout.PREFERRED_SIZE, 65,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(721, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addGap(39)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 700,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 700,
														Short.MAX_VALUE)
												.addComponent(panel, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
										.addGap(42)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addComponent(btnNewButton_iniciar_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)));
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));

		lblNewLabel = new JLabel("Posi\u00E7\u00E3o");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Jogador");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Pontua\u00E7\u00E3o");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);
		contentPane.setLayout(gl_contentPane);

		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
		Modelo();
		table_2.getColumnModel().getColumn(0).setCellRenderer(centralizado);
		table_2.getColumnModel().getColumn(1).setCellRenderer(centralizado);
		table_2.getColumnModel().getColumn(2).setCellRenderer(centralizado);

		// adicionarLinhas1();

	}

	@SuppressWarnings("serial")
	DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "ID", "NOME", "PONTUACAO" }) {
		boolean[] columnEditables = new boolean[] { false, false, false };

		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	};

	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_3;

	public void Modelo() {
		// seta 0 nas linhas ta table
		model.setRowCount(0);
		ArrayList<Usuario> lista_usuarios = user.ranque();

		if (lista_usuarios == null) {
			JOptionPane.showMessageDialog(null, "Diretorio incorreto");
		} else {
			for (int i = 0; i < lista_usuarios.size(); i++) {
				if (i > 9) {
					break;
				} else {
					int p = i;
					model.addRow(new String[] { (p + 1) + "", lista_usuarios.get(i).getNome(),
							lista_usuarios.get(i).getPontuacao() + "" });
				}
			}
			table_2.setModel(model);
		}

		// limpa e lista as linhas na table

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
