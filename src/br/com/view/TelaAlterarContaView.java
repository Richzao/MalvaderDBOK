package br.com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dao.ContaDAO;
import br.com.dao.ContaPoupancaDAO;
import br.com.model.Conta;
import br.com.model.ContaCorrente;
import br.com.model.ContaPoupanca;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class TelaAlterarContaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldLimite;
	private JTextField textFieldData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarContaView frame = new TelaAlterarContaView();
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
	public TelaAlterarContaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 260);
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
		
		JLabel lblNewLabel_1 = new JLabel("Insira o ID da conta que deseja alterar:");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 11, 230, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo de conta:");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(10, 36, 91, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Limite disponível:");
		lblNewLabel_1_1_1.setForeground(Color.RED);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1.setBounds(10, 61, 106, 14);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Data de vencimento:");
		lblNewLabel_1_1_1_1.setForeground(Color.RED);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1_1.setBounds(10, 86, 125, 14);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		textFieldID = new JTextField();
		textFieldID.setBackground(new Color(0, 0, 0));
		textFieldID.setForeground(new Color(255, 0, 0));
		textFieldID.setBounds(250, 8, 106, 20);
		panel_1.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldLimite = new JTextField();
		textFieldLimite.setForeground(Color.RED);
		textFieldLimite.setColumns(10);
		textFieldLimite.setBackground(Color.BLACK);
		textFieldLimite.setBounds(250, 58, 106, 20);
		panel_1.add(textFieldLimite);
		
		textFieldData = new JTextField();
		textFieldData.setForeground(Color.RED);
		textFieldData.setColumns(10);
		textFieldData.setBackground(Color.BLACK);
		textFieldData.setBounds(250, 83, 106, 20);
		panel_1.add(textFieldData);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 0, 0));
		comboBox.setBackground(new Color(0, 0, 0));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Conta corrente", "Conta poupança"}));
		comboBox.setBounds(250, 32, 106, 22);
		panel_1.add(comboBox);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conta c = new Conta();
				ContaCorrente cc = new ContaCorrente();
				ContaDAO cDao = new ContaDAO();
				ContaPoupancaDAO cpdao = new ContaPoupancaDAO();
				ContaPoupanca cp = new ContaPoupanca();
				if (comboBox.getSelectedItem().equals("Conta corrente")) {
					if (textFieldID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
					} else {
						int id = Integer.valueOf(textFieldID.getText());
						if (textFieldLimite.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
						} else {
							cc.setLimite(Double.valueOf(textFieldLimite.getText()));
							if (textFieldData.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
							} else {
								cc.setDataVencimento(LocalDate.parse(textFieldData.getText()));
								
								try {
									cDao.updateContaCorrente(id, cc);
									
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							
						}
					}
				} if (comboBox.getSelectedItem().equals("Conta poupança")) {
					if (textFieldID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
					} else {
						int id = Integer.valueOf(textFieldID.getText());
						c.setId(Integer.valueOf(textFieldID.getText()));
						//if (textFieldLimite.getText().equals("")) {
							//JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
						//} else {
							//cc.setLimite(Double.valueOf(textFieldLimite.getText()));
							//if (textFieldData.getText().equals("")) {
								//JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
							//} else {
								//cc.setDataVencimento(LocalDate.parse(textFieldData.getText()));
								
								try {
									cDao.updateContaPoupanca(id, cp);
									cpdao.update(cp, c);
									
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							
						}
					}
				//}
			//}
		});
		btnAlterar.setForeground(new Color(255, 0, 0));
		btnAlterar.setBackground(new Color(0, 0, 0));
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterar.setBounds(260, 114, 89, 23);
		panel_1.add(btnAlterar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setForeground(Color.RED);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBackground(Color.BLACK);
		btnSair.setBounds(335, 161, 89, 23);
		panel_1.add(btnSair);
	}
}
