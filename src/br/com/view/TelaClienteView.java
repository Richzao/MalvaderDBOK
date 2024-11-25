package br.com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaClienteView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClienteView frame = new TelaClienteView();
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
	public TelaClienteView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		panel_1.setBackground(new Color(40, 40, 40));
		panel_1.setBounds(0, 26, 434, 235);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSaque = new JButton("Saque");
		btnSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSaqueView tsq = new TelaSaqueView();
				tsq.setVisible(true);
			}
		});
		btnSaque.setForeground(new Color(255, 0, 0));
		btnSaque.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSaque.setBackground(new Color(0, 0, 0));
		btnSaque.setBounds(215, 56, 89, 23);
		panel_1.add(btnSaque);
		
		JButton btnSaldo = new JButton("Saldo");
		btnSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaSaldoView ts = new TelaSaldoView();
					ts.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSaldo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSaldo.setForeground(new Color(255, 0, 0));
		btnSaldo.setBackground(new Color(0, 0, 0));
		btnSaldo.setBounds(116, 22, 188, 23);
		panel_1.add(btnSaldo);
		
		JButton btnLimite = new JButton("Limite");
		btnLimite.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimite.setForeground(new Color(255, 0, 0));
		btnLimite.setBackground(new Color(0, 0, 0));
		btnLimite.setBounds(116, 124, 188, 23);
		panel_1.add(btnLimite);
		
		JButton btnExtrato = new JButton("Extrato");
		btnExtrato.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExtrato.setForeground(new Color(255, 0, 0));
		btnExtrato.setBackground(new Color(0, 0, 0));
		btnExtrato.setBounds(116, 90, 188, 23);
		panel_1.add(btnExtrato);
		
		JButton btnDeposito = new JButton("Depósito");
		btnDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDepositoView tdp = new TelaDepositoView();
				tdp.setVisible(true);
			}
		});
		btnDeposito.setForeground(new Color(255, 0, 0));
		btnDeposito.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDeposito.setBackground(new Color(0, 0, 0));
		btnDeposito.setBounds(116, 56, 89, 23);
		panel_1.add(btnDeposito);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setForeground(new Color(255, 0, 0));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBackground(new Color(0, 0, 0));
		btnSair.setBounds(335, 201, 89, 23);
		panel_1.add(btnSair);
	}

}
