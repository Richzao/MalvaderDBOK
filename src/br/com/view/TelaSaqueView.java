package br.com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dao.ContaDAO;
import br.com.model.Conta;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaSaqueView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSaqueView frame = new TelaSaqueView();
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
	public TelaSaqueView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 434, 27);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Banco Malvader");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(0, 27, 434, 134);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Insira seu ID:");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(55, 11, 82, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Valor a ser sacado:");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(55, 35, 106, 14);
		panel_1.add(lblNewLabel_1_1);
		
		textFieldID = new JTextField();
		textFieldID.setForeground(new Color(255, 0, 0));
		textFieldID.setBackground(new Color(0, 0, 0));
		textFieldID.setBounds(220, 8, 86, 20);
		panel_1.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldValor = new JTextField();
		textFieldValor.setForeground(Color.RED);
		textFieldValor.setColumns(10);
		textFieldValor.setBackground(Color.BLACK);
		textFieldValor.setBounds(220, 32, 86, 20);
		panel_1.add(textFieldValor);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = 0;
				ContaDAO cDao = new ContaDAO();
				Conta c = new Conta();
				
				if(textFieldID.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insira seu id!");
				} else {
					id = Integer.valueOf(textFieldID.getText());
					if (textFieldValor.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Insira um valor!");
					} else {
						//c.setSaldo(Double.valueOf(textFieldID.getText()));
						c.setSaldo(Double.valueOf(textFieldValor.getText()));
						try {
							cDao.saque(id, c);
							textFieldID.setText("");
							textFieldValor.setText("");
							JOptionPane.showMessageDialog(null, "Saque concluído com sucesso!");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnSacar.setForeground(new Color(255, 0, 0));
		btnSacar.setBackground(new Color(0, 0, 0));
		btnSacar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSacar.setBounds(220, 58, 86, 23);
		panel_1.add(btnSacar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setForeground(Color.RED);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBackground(Color.BLACK);
		btnSair.setBounds(338, 100, 86, 23);
		panel_1.add(btnSair);
	}

}
