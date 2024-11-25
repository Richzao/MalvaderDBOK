package br.com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dao.ContaDAO;
import br.com.model.Conta;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEncerramentoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldId_conta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEncerramentoView frame = new TelaEncerramentoView();
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
	public TelaEncerramentoView() {
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
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(40, 40, 40));
		panel_1.setBounds(0, 28, 434, 233);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Id da conta a ser excluída:\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(65, 34, 153, 14);
		panel_1.add(lblNewLabel_1);
		
		textFieldId_conta = new JTextField();
		textFieldId_conta.setForeground(new Color(255, 0, 0));
		textFieldId_conta.setBackground(new Color(0, 0, 0));
		textFieldId_conta.setBounds(228, 31, 86, 20);
		panel_1.add(textFieldId_conta);
		textFieldId_conta.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContaDAO cdao = new ContaDAO();
				Conta c = new Conta();
				if (textFieldId_conta.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
				} else {
					try {
						cdao.delete(Integer.valueOf(textFieldId_conta.getText()));
						JOptionPane.showMessageDialog(null, "Conta excluída!");
						textFieldId_conta.setText("");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluir.setForeground(new Color(255, 0, 0));
		btnExcluir.setBackground(new Color(0, 0, 0));
		btnExcluir.setBounds(165, 62, 89, 23);
		panel_1.add(btnExcluir);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setForeground(Color.RED);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBackground(Color.BLACK);
		btnSair.setBounds(335, 199, 89, 23);
		panel_1.add(btnSair);
	}

}
