package br.com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dao.UsuarioDAO;
import br.com.model.Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLoginFuncionarioView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFId;
	private JPasswordField TFSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLoginFuncionarioView frame = new TelaLoginFuncionarioView();
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
	public TelaLoginFuncionarioView() {
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
		panel_1.setBackground(new Color(56, 56, 56));
		panel_1.setBounds(0, 27, 434, 234);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(138, 31, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		tFId = new JTextField();
		tFId.setForeground(new Color(255, 0, 0));
		tFId.setBackground(new Color(0, 0, 0));
		tFId.setBounds(194, 29, 86, 20);
		panel_1.add(tFId);
		tFId.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(138, 68, 46, 14);
		panel_1.add(lblNewLabel_1_1);
		
		TFSenha = new JPasswordField();
		TFSenha.setForeground(new Color(255, 0, 0));
		TFSenha.setBackground(new Color(0, 0, 0));
		TFSenha.setBounds(194, 66, 86, 20);
		panel_1.add(TFSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDAO uDao = new UsuarioDAO();
				Usuario u = new Usuario();
				String senha = "";
				int id;
				
				try {
					if (tFId.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Preencha o campo!");
					} else {
						u.setID(Integer.valueOf(tFId.getText()));
						id = u.getID();
						if (TFSenha.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Preencha o campo!");
						} else {
							senha = TFSenha.getText();
							if(uDao.findPasswordFuncionario(id).equals(senha)) {
								TelaFuncionarioView tf = new TelaFuncionarioView();
								tf.setVisible(true);
								setVisible(false);
								
							} else {
								JOptionPane.showMessageDialog(null, "login ou senha inválida!");
							}
						}
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Insira um número!");
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NullPointerException ex) {
					JOptionPane.showMessageDialog(null, "Insira um id existente!");
				}
				
			}
		});
		btnEntrar.setForeground(new Color(255, 0, 0));
		btnEntrar.setBackground(new Color(0, 0, 0));
		btnEntrar.setBounds(168, 102, 89, 23);
		panel_1.add(btnEntrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVoltar.setBackground(new Color(0, 0, 0));
		btnVoltar.setForeground(new Color(255, 0, 0));
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBounds(335, 200, 89, 23);
		panel_1.add(btnVoltar);
	}
}
