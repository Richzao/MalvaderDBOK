package br.com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dao.ContaCorrenteDAO;
import br.com.model.ContaCorrente;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class TelaSaldoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSaldoView frame = new TelaSaldoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public TelaSaldoView() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 434, 31);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Banco Malvader");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(0, 30, 434, 164);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Id Cliente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(112, 29, 64, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblSaldo = new JLabel("");
		lblSaldo.setForeground(Color.RED);
		lblSaldo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSaldo.setBounds(231, 54, 93, 14);
		panel_1.add(lblSaldo);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setForeground(new Color(255, 0, 0));
		btnSair.setBackground(new Color(0, 0, 0));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBounds(335, 130, 89, 23);
		panel_1.add(btnSair);
		
		JLabel lblNewLabel_1_1 = new JLabel("Saldo da conta:");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(112, 54, 93, 14);
		panel_1.add(lblNewLabel_1_1);
		
		textFieldID = new JTextField();
		textFieldID.setForeground(new Color(255, 0, 0));
		textFieldID.setBackground(new Color(0, 0, 0));
		textFieldID.setBounds(238, 26, 86, 20);
		panel_1.add(textFieldID);
		textFieldID.setColumns(10);
		
		JButton btnSaldo = new JButton("Verificar");
		btnSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = 0;
				ContaCorrenteDAO cDao = new ContaCorrenteDAO();
				if (textFieldID.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insira seu ID!");
				} else {
					id = Integer.valueOf(textFieldID.getText());
					try {
						lblSaldo.setText(cDao.ConsultarSaldo(id).toString());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnSaldo.setForeground(new Color(255, 0, 0));
		btnSaldo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSaldo.setBackground(new Color(0, 0, 0));
		btnSaldo.setBounds(241, 79, 89, 23);
		panel_1.add(btnSaldo);
	}

}
