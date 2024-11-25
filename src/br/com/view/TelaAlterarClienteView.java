package br.com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dao.UsuarioDAO;
import br.com.model.Cliente;
import br.com.model.Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAlterarClienteView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarClienteView frame = new TelaAlterarClienteView();
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
	public TelaAlterarClienteView() {
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
		panel_1.setBounds(0, 27, 434, 234);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setForeground(new Color(255, 0, 0));
		btnSair.setBackground(new Color(0, 0, 0));
		btnSair.setBounds(335, 144, 89, 23);
		panel_1.add(btnSair);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario u = new Usuario();
				Cliente c = new Cliente();
				UsuarioDAO uDao = new UsuarioDAO();
				if (textFieldID.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
				} else {
					int id = Integer.valueOf(textFieldID.getText());
					if (textFieldTelefone.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
					} else {
						c.setTelefone(textFieldTelefone.getText());
						
						try {
							uDao.updateCliente(id, c);
							JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnAlterar.setForeground(Color.RED);
		btnAlterar.setBackground(Color.BLACK);
		btnAlterar.setBounds(165, 85, 89, 23);
		panel_1.add(btnAlterar);
		
		JLabel lblNewLabel_1 = new JLabel("Insira o id do cliente a ser alterado:");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(20, 29, 216, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Telefone:");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(20, 54, 65, 14);
		panel_1.add(lblNewLabel_1_1);
		
		textFieldID = new JTextField();
		textFieldID.setForeground(new Color(255, 0, 0));
		textFieldID.setBackground(new Color(0, 0, 0));
		textFieldID.setBounds(230, 26, 120, 20);
		panel_1.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setForeground(Color.RED);
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBackground(Color.BLACK);
		textFieldTelefone.setBounds(230, 54, 120, 20);
		panel_1.add(textFieldTelefone);
	}
}
