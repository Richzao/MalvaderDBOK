package br.com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dao.ContaCorrenteDAO;
import br.com.dao.ContaDAO;
import br.com.dao.ContaPoupancaDAO;
import br.com.model.Conta;
import br.com.model.ContaCorrente;
import br.com.model.ContaPoupanca;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class TelaAberturaContaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFNmrConta;
	private JTextField tFAgencia;
	private JTextField textFieldIdCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAberturaContaView frame = new TelaAberturaContaView();
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
	public TelaAberturaContaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 289);
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
		panel_1.setBounds(0, 27, 434, 223);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Número da conta:");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(104, 11, 107, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Agência:");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(104, 36, 59, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tipo da conta:");
		lblNewLabel_1_1_1.setForeground(Color.RED);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1.setBounds(104, 61, 88, 14);
		panel_1.add(lblNewLabel_1_1_1);
		
		JComboBox comboBoxTipoConta = new JComboBox();
		comboBoxTipoConta.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBoxTipoConta.setForeground(new Color(255, 0, 0));
		comboBoxTipoConta.setBackground(new Color(0, 0, 0));
		comboBoxTipoConta.setModel(new DefaultComboBoxModel(new String[] {"Conta corrente", "Conta poupança"}));
		comboBoxTipoConta.setBounds(202, 57, 121, 22);
		panel_1.add(comboBoxTipoConta);
		
		tFNmrConta = new JTextField();
		tFNmrConta.setForeground(new Color(255, 0, 0));
		tFNmrConta.setBackground(new Color(0, 0, 0));
		tFNmrConta.setBounds(237, 8, 86, 20);
		panel_1.add(tFNmrConta);
		tFNmrConta.setColumns(10);
		
		tFAgencia = new JTextField();
		tFAgencia.setForeground(new Color(255, 0, 0));
		tFAgencia.setBackground(new Color(0, 0, 0));
		tFAgencia.setBounds(237, 33, 86, 20);
		panel_1.add(tFAgencia);
		tFAgencia.setColumns(10);
		
		JButton btnAbrirConta = new JButton("Abrir");
		btnAbrirConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContaDAO cdao = new ContaDAO();
				ContaCorrenteDAO ccdao = new ContaCorrenteDAO();
				ContaPoupancaDAO cpdao = new ContaPoupancaDAO();
				Conta c = new Conta();
				ContaCorrente cc = new ContaCorrente();
				ContaPoupanca cp = new ContaPoupanca();
				System.out.println("oi");
				if (comboBoxTipoConta.getSelectedItem().equals("Conta corrente")) {
					if (tFNmrConta.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
					} else {
						c.setNumero(Integer.valueOf(tFNmrConta.getText()));
						if (tFAgencia.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
						} else {
							c.setAgencia(tFAgencia.getText());
							c.setSaldo(0);
							if (textFieldIdCliente.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
							} else {
								c.setId_cliente(Integer.valueOf(textFieldIdCliente.getText()));
								cc.setLimite(10000);
								cc.setDataVencimento(LocalDate.parse("2026-04-30"));
								
								try {
									cdao.saveCc(c);
									ccdao.updateCc(cc);
									JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
									
									textFieldIdCliente.setText("");
									tFAgencia.setText("");
									tFNmrConta.setText("");
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									JOptionPane.showMessageDialog(null, "Erro ao cadastrar " + e1);
									e1.printStackTrace();
								}
							}
					}
				}
				} if (comboBoxTipoConta.getSelectedItem().equals("Conta poupança")) {
					if (tFNmrConta.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
					} else {
						c.setNumero(Integer.valueOf(tFNmrConta.getText()));
						if (tFAgencia.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
						} else {
							c.setAgencia(tFAgencia.getText());
							c.setSaldo(0);
							if (textFieldIdCliente.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
							} else {
								c.setId_cliente(Integer.valueOf(textFieldIdCliente.getText()));
								cp.setTaxaRendimento(1.5);
								
								try {
									cdao.saveP(c);
									cpdao.updateCp(cp);
									JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
									
									textFieldIdCliente.setText("");
									tFAgencia.setText("");
									tFNmrConta.setText("");
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									JOptionPane.showMessageDialog(null, "Erro ao cadastrar " + e1);
									e1.printStackTrace();
								}
							}
					}
				}
				}
				}
				
		});
		btnAbrirConta.setForeground(new Color(255, 0, 0));
		btnAbrirConta.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAbrirConta.setBackground(new Color(0, 0, 0));
		btnAbrirConta.setBounds(168, 140, 89, 23);
		panel_1.add(btnAbrirConta);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setForeground(Color.RED);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBackground(Color.BLACK);
		btnSair.setBounds(335, 189, 89, 23);
		panel_1.add(btnSair);
		
		JLabel lblNewLabel_1_2 = new JLabel("Id cliente:");
		lblNewLabel_1_2.setForeground(Color.RED);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(104, 86, 69, 14);
		panel_1.add(lblNewLabel_1_2);
		
		textFieldIdCliente = new JTextField();
		textFieldIdCliente.setForeground(Color.RED);
		textFieldIdCliente.setColumns(10);
		textFieldIdCliente.setBackground(Color.BLACK);
		textFieldIdCliente.setBounds(237, 84, 86, 20);
		panel_1.add(textFieldIdCliente);
	}
}
