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

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 434, 33);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Banco Malvader");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(56, 56, 56));
		panel_1.setBounds(0, 28, 434, 233);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnFuncionario = new JButton("Funcionário");
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLoginFuncionarioView tl = new TelaLoginFuncionarioView();
				tl.setVisible(true);
			}
		});
		btnFuncionario.setBackground(new Color(0, 0, 0));
		btnFuncionario.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFuncionario.setForeground(new Color(255, 0, 0));
		btnFuncionario.setBounds(154, 21, 112, 23);
		panel_1.add(btnFuncionario);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLoginClienteView tl = new TelaLoginClienteView();
				tl.setVisible(true);
			}
		});
		btnCliente.setBackground(new Color(0, 0, 0));
		btnCliente.setForeground(new Color(255, 0, 0));
		btnCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCliente.setBounds(164, 55, 89, 23);
		panel_1.add(btnCliente);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setBackground(new Color(0, 0, 0));
		btnSair.setForeground(new Color(255, 0, 0));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBounds(335, 193, 89, 23);
		panel_1.add(btnSair);
	}
}
