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

public class TelaAlterarDadosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarDadosView frame = new TelaAlterarDadosView();
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
	public TelaAlterarDadosView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 249);
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
		panel_1.setBackground(new Color(65, 65, 65));
		panel_1.setBounds(0, 27, 434, 234);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAlterarCliente = new JButton("Alterar Cliente");
		btnAlterarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAlterarClienteView tac = new TelaAlterarClienteView();
				tac.setVisible(true);
			}
		});
		btnAlterarCliente.setForeground(new Color(255, 0, 0));
		btnAlterarCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterarCliente.setBackground(new Color(0, 0, 0));
		btnAlterarCliente.setBounds(85, 39, 120, 23);
		panel_1.add(btnAlterarCliente);
		
		JButton btnAlterarConta = new JButton("Alterar Conta");
		btnAlterarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAlterarContaView tac = new TelaAlterarContaView();
				tac.setVisible(true);
			}
		});
		btnAlterarConta.setForeground(Color.RED);
		btnAlterarConta.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterarConta.setBackground(Color.BLACK);
		btnAlterarConta.setBounds(215, 39, 120, 23);
		panel_1.add(btnAlterarConta);
		
		JButton btnAlterarFuncionrio = new JButton("Alterar Funcionário");
		btnAlterarFuncionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAlterarFuncionarioView taf = new TelaAlterarFuncionarioView();
				taf.setVisible(true);
			}
		});
		btnAlterarFuncionrio.setForeground(Color.RED);
		btnAlterarFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterarFuncionrio.setBackground(Color.BLACK);
		btnAlterarFuncionrio.setBounds(85, 73, 250, 23);
		panel_1.add(btnAlterarFuncionrio);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setForeground(Color.RED);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBackground(Color.BLACK);
		btnSair.setBounds(335, 149, 89, 23);
		panel_1.add(btnSair);
	}

}
