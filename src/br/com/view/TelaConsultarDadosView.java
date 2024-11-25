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

public class TelaConsultarDadosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultarDadosView frame = new TelaConsultarDadosView();
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
	public TelaConsultarDadosView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 236);
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
		panel_1.setBounds(0, 26, 434, 235);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnContas = new JButton("Consultar contas");
		btnContas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultarContasView tcc = new TelaConsultarContasView();
				tcc.setVisible(true);
			}
		});
		btnContas.setBackground(new Color(0, 0, 0));
		btnContas.setForeground(new Color(255, 0, 0));
		btnContas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnContas.setBounds(79, 33, 135, 23);
		panel_1.add(btnContas);
		
		JButton btnFuncionarios = new JButton("Consultar funcionários");
		btnFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultarFuncionariosView tcf = new TelaConsultarFuncionariosView();
				tcf.setVisible(true);
			}
		});
		btnFuncionarios.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFuncionarios.setForeground(new Color(255, 0, 0));
		btnFuncionarios.setBackground(new Color(0, 0, 0));
		btnFuncionarios.setBounds(79, 67, 284, 23);
		panel_1.add(btnFuncionarios);
		
		JButton btnClientes = new JButton("Consultar clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultarClientesView tcc = new TelaConsultarClientesView();
				tcc.setVisible(true);
			}
		});
		btnClientes.setBackground(new Color(0, 0, 0));
		btnClientes.setForeground(new Color(255, 0, 0));
		btnClientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClientes.setBounds(228, 33, 135, 23);
		panel_1.add(btnClientes);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setForeground(new Color(255, 0, 0));
		btnSair.setBackground(new Color(0, 0, 0));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBounds(335, 131, 89, 23);
		panel_1.add(btnSair);
	}
}
