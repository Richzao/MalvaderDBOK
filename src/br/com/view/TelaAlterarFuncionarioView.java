package br.com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dao.FuncionarioDAO;
import br.com.model.Funcionario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAlterarFuncionarioView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldCargo;
	private JTextField textFieldCod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarFuncionarioView frame = new TelaAlterarFuncionarioView();
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
	public TelaAlterarFuncionarioView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 237);
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
		panel_1.setBounds(0, 27, 434, 234);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Id do funcionário a ser alterado:\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setBounds(37, 11, 186, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cargo:");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_1.setBounds(37, 36, 53, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Código funcionário:");
		lblNewLabel_1_2.setForeground(Color.RED);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_2.setBounds(37, 61, 123, 14);
		panel_1.add(lblNewLabel_1_2);
		
		textFieldID = new JTextField();
		textFieldID.setForeground(new Color(255, 0, 0));
		textFieldID.setBackground(new Color(0, 0, 0));
		textFieldID.setBounds(233, 8, 86, 20);
		panel_1.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldCargo = new JTextField();
		textFieldCargo.setForeground(Color.RED);
		textFieldCargo.setColumns(10);
		textFieldCargo.setBackground(Color.BLACK);
		textFieldCargo.setBounds(233, 33, 86, 20);
		panel_1.add(textFieldCargo);
		
		textFieldCod = new JTextField();
		textFieldCod.setForeground(Color.RED);
		textFieldCod.setColumns(10);
		textFieldCod.setBackground(Color.BLACK);
		textFieldCod.setBounds(233, 58, 86, 20);
		panel_1.add(textFieldCod);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario f = new Funcionario();
				FuncionarioDAO fDao = new FuncionarioDAO();
				if (textFieldID.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
				} else {
					int id = Integer.valueOf(textFieldID.getText());
					if(textFieldCargo.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
					} else {
						f.setCargo(textFieldCargo.getText());
						if(textFieldCod.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
						} else {
							f.setCodigofuncionario(textFieldCod.getText());
							
							try {
								fDao.update(id, f);
								JOptionPane.showMessageDialog(null, "Funcionário alterado com sucesso!");
								textFieldID.setText("");
								textFieldCargo.setText("");
								textFieldCod.setText("");
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			}
		});
		btnAlterar.setForeground(new Color(255, 0, 0));
		btnAlterar.setBackground(new Color(0, 0, 0));
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterar.setBounds(233, 89, 89, 23);
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
		btnSair.setBounds(335, 144, 89, 23);
		panel_1.add(btnSair);
	}
}
