package br.com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.dao.ContaDAO;
import br.com.dao.UsuarioDAO;
import br.com.model.Conta;
import br.com.model.Usuario;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaConsultarClientesView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultarClientesView frame = new TelaConsultarClientesView();
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
	public TelaConsultarClientesView() {
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
		panel_1.setBackground(new Color(65, 65, 65));
		panel_1.setBounds(0, 27, 434, 234);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnListar = new JButton("Listar ");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            Usuario u = new Usuario();
		            UsuarioDAO uDao = new UsuarioDAO();
		            DefaultTableModel contaPesque = (DefaultTableModel) tableListar.getModel();
		            contaPesque.setRowCount(0);
		            ArrayList<Usuario> usuarios = uDao.listarClientes();
		            for (int i = 0; i < usuarios.size(); i++){
		                u = usuarios.get(i);
		                contaPesque.addRow(new Object[]{u.getNome(), u.getCPF(), u.getDataNascimento(), u.getTelefone()});
		            }
		        } catch (Exception ex) {
		        	JOptionPane.showMessageDialog(null, "ERRO" + e);
		        }
			}
		});
		btnListar.setForeground(new Color(255, 0, 0));
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnListar.setBackground(new Color(0, 0, 0));
		btnListar.setBounds(166, 11, 89, 23);
		panel_1.add(btnListar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVoltar.setForeground(Color.RED);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setBounds(335, 200, 89, 23);
		panel_1.add(btnVoltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 414, 151);
		panel_1.add(scrollPane);
		
		tableListar = new JTable();
		scrollPane.setViewportView(tableListar);
		tableListar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF", "Data de nascimento", "Telefone"
			}
		));
		tableListar.getColumnModel().getColumn(2).setPreferredWidth(109);
	}

}
