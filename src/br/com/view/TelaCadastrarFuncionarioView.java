package br.com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dao.FuncionarioDAO;
import br.com.dao.UsuarioDAO;
import br.com.model.Funcionario;
import br.com.model.Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class TelaCadastrarFuncionarioView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldDtNascimento;
	private JTextField textFieldTelefone;
	private JTextField textFieldSenha;
	private JTextField textFieldCodFunf;
	private JTextField textFieldCargo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarFuncionarioView frame = new TelaCadastrarFuncionarioView();
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
	public TelaCadastrarFuncionarioView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 331);
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
		panel_1.setBounds(0, 26, 434, 266);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(90, 11, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(90, 36, 46, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Data de nascimento:");
		lblNewLabel_1_2.setForeground(Color.RED);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(90, 61, 126, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Telefone:");
		lblNewLabel_1_3.setForeground(Color.RED);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3.setBounds(90, 86, 61, 14);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Cargo:");
		lblNewLabel_1_4.setForeground(Color.RED);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_4.setBounds(90, 136, 46, 14);
		panel_1.add(lblNewLabel_1_4);
		
		textFieldNome = new JTextField();
		textFieldNome.setForeground(new Color(255, 0, 0));
		textFieldNome.setBackground(new Color(0, 0, 0));
		textFieldNome.setBounds(257, 8, 120, 20);
		panel_1.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setForeground(Color.RED);
		textFieldCpf.setColumns(10);
		textFieldCpf.setBackground(Color.BLACK);
		textFieldCpf.setBounds(257, 33, 120, 20);
		panel_1.add(textFieldCpf);
		
		textFieldDtNascimento = new JTextField();
		textFieldDtNascimento.setForeground(Color.RED);
		textFieldDtNascimento.setColumns(10);
		textFieldDtNascimento.setBackground(Color.BLACK);
		textFieldDtNascimento.setBounds(257, 58, 120, 20);
		panel_1.add(textFieldDtNascimento);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setForeground(Color.RED);
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBackground(Color.BLACK);
		textFieldTelefone.setBounds(257, 83, 120, 20);
		panel_1.add(textFieldTelefone);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setForeground(Color.RED);
		textFieldSenha.setColumns(10);
		textFieldSenha.setBackground(Color.BLACK);
		textFieldSenha.setBounds(257, 158, 120, 20);
		panel_1.add(textFieldSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario uf = new Usuario();
				Funcionario f = new Funcionario();
				UsuarioDAO uDao = new UsuarioDAO();
				FuncionarioDAO fDao = new FuncionarioDAO();
				
				if (textFieldNome.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
				} else {
					uf.setNome(textFieldNome.getText());
					if (textFieldCpf.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
					} else {
						uf.setCPF(textFieldCpf.getText());
						if (textFieldDtNascimento.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
						} else {
							uf.setDataNascimento(uf.formatarData(textFieldDtNascimento.getText()));
							
							if (textFieldTelefone.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
							} else {
								uf.setTelefone(textFieldTelefone.getText());
								if (textFieldCodFunf.getText().equals("")) {
									JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
								} else {
									f.setCodigofuncionario(textFieldCodFunf.getText());
									if (textFieldCargo.getText().equals("")) {
										JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
									} else {
										f.setCargo(textFieldCargo.getText());
										if (textFieldSenha.getText().equals("")) {
											JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
										} else {
											uf.setSenha(textFieldSenha.getText());
											uf.setTipoUsuario("FUNCIONARIO");
											try {
												uDao.saveFuncionario(uf);
												fDao.InsereCOD(f);
												
												textFieldNome.setText("");
												textFieldCpf.setText("");
												textFieldDtNascimento.setText("");
												textFieldTelefone.setText("");
												textFieldCodFunf.setText("");
												textFieldCargo.setText("");
												textFieldSenha.setText("");
												JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
											} catch (Exception ex) {
												JOptionPane.showMessageDialog(null, "Erro ao cadastrar " + ex);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		});
		btnCadastrar.setForeground(new Color(255, 0, 0));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBackground(new Color(0, 0, 0));
		btnCadastrar.setBounds(257, 189, 120, 23);
		panel_1.add(btnCadastrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setForeground(Color.RED);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBackground(Color.BLACK);
		btnSair.setBounds(363, 232, 61, 23);
		panel_1.add(btnSair);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Código funcionário:");
		lblNewLabel_1_4_1.setForeground(Color.RED);
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_4_1.setBounds(90, 111, 120, 14);
		panel_1.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Senha:");
		lblNewLabel_1_4_2.setForeground(Color.RED);
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_4_2.setBounds(90, 161, 46, 14);
		panel_1.add(lblNewLabel_1_4_2);
		
		textFieldCodFunf = new JTextField();
		textFieldCodFunf.setForeground(Color.RED);
		textFieldCodFunf.setColumns(10);
		textFieldCodFunf.setBackground(Color.BLACK);
		textFieldCodFunf.setBounds(257, 108, 120, 20);
		panel_1.add(textFieldCodFunf);
		
		textFieldCargo = new JTextField();
		textFieldCargo.setForeground(Color.RED);
		textFieldCargo.setColumns(10);
		textFieldCargo.setBackground(Color.BLACK);
		textFieldCargo.setBounds(257, 133, 120, 20);
		panel_1.add(textFieldCargo);
	}

}
