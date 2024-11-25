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

public class TelaFuncionarioView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionarioView frame = new TelaFuncionarioView();
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
	public TelaFuncionarioView() {
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
		panel_1.setBounds(0, 27, 434, 234);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAbertura = new JButton("Abertura de conta");
		btnAbertura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAberturaContaView tac = new TelaAberturaContaView();
				tac.setVisible(true);
			}
		});
		btnAbertura.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAbertura.setForeground(new Color(255, 0, 0));
		btnAbertura.setBackground(new Color(0, 0, 0));
		btnAbertura.setBounds(74, 27, 135, 23);
		panel_1.add(btnAbertura);
		
		JButton btnEncerrar = new JButton("Encerrar conta");
		btnEncerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEncerramentoView te = new TelaEncerramentoView();
				te.setVisible(true);
			}
		});
		btnEncerrar.setForeground(new Color(255, 0, 0));
		btnEncerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEncerrar.setBackground(new Color(0, 0, 0));
		btnEncerrar.setBounds(219, 27, 129, 23);
		panel_1.add(btnEncerrar);
		
		JButton btnConsultar = new JButton("Consultar dados");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultarDadosView tcd = new TelaConsultarDadosView();
				tcd.setVisible(true);
			}
		});
		btnConsultar.setForeground(new Color(255, 0, 0));
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBackground(new Color(0, 0, 0));
		btnConsultar.setBounds(74, 61, 135, 23);
		panel_1.add(btnConsultar);
		
		JButton btnAlterar = new JButton("Alterar dados");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAlterarDadosView tad = new TelaAlterarDadosView();
				tad.setVisible(true);
			}
		});
		btnAlterar.setForeground(new Color(255, 0, 0));
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterar.setBackground(new Color(0, 0, 0));
		btnAlterar.setBounds(219, 61, 129, 23);
		panel_1.add(btnAlterar);
		
		JButton btnCadastrarFunf = new JButton("Cadastrar funcionário");
		btnCadastrarFunf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarFuncionarioView tcf = new TelaCadastrarFuncionarioView();
				tcf.setVisible(true);
			}
		});
		btnCadastrarFunf.setForeground(new Color(255, 0, 0));
		btnCadastrarFunf.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrarFunf.setBackground(new Color(0, 0, 0));
		btnCadastrarFunf.setBounds(74, 95, 274, 23);
		panel_1.add(btnCadastrarFunf);
		
		JButton btnGerarRelatório = new JButton("Gerar relatórios");
		btnGerarRelatório.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGerarRelatório.setForeground(new Color(255, 0, 0));
		btnGerarRelatório.setBackground(new Color(0, 0, 0));
		btnGerarRelatório.setBounds(74, 129, 274, 23);
		panel_1.add(btnGerarRelatório);
		
		JButton btnSair = new JButton("Voltar");
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setForeground(new Color(255, 0, 0));
		btnSair.setBackground(new Color(0, 0, 0));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setBounds(335, 200, 89, 23);
		panel_1.add(btnSair);
	}

}
