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

public class TelaLoginClienteView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFId;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLoginClienteView frame = new TelaLoginClienteView();
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
	public TelaLoginClienteView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 268);
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
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(129, 28, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(129, 53, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		tFId = new JTextField();
		tFId.setForeground(new Color(255, 0, 0));
		tFId.setBackground(new Color(0, 0, 0));
		tFId.setBounds(198, 25, 86, 20);
		panel_1.add(tFId);
		tFId.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(255, 0, 0));
		passwordField.setBackground(new Color(0, 0, 0));
		passwordField.setBounds(198, 50, 86, 20);
		panel_1.add(passwordField);
		
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
						if (passwordField.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Preencha o campo!");
						} else {
							senha = passwordField.getText();
							if(uDao.findPasswordCliente(id).equals(senha)) {
								TelaClienteView tc = new TelaClienteView();
								tc.setVisible(true);
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
		btnEntrar.setBounds(169, 81, 89, 23);
		panel_1.add(btnEntrar);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBounds(335, 173, 89, 23);
		panel_1.add(btnNewButton);
	}
}
