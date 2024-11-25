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

import br.com.dao.UsuarioDAO;
import br.com.model.Funcionario;
import br.com.model.Usuario;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaConsultarFuncionariosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultarFuncionariosView frame = new TelaConsultarFuncionariosView();
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
	public TelaConsultarFuncionariosView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 434, 31);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Banco Malvader");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(65, 65, 65));
		panel_1.setBounds(0, 30, 434, 231);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            Funcionario f = new Funcionario();
		            UsuarioDAO uDao = new UsuarioDAO();
		            DefaultTableModel contaPesque = (DefaultTableModel) table.getModel();
		            contaPesque.setRowCount(0);
		            ArrayList<Funcionario> funcionarios = uDao.listarFuncionarios();
		            for (int i = 0; i < funcionarios.size(); i++){
		                f = funcionarios.get(i);
		                contaPesque.addRow(new Object[]{f.getCargo(), f.getCodigofuncionario(), f.getNome(), f.getCPF(), f.getDataNascimento(), f.getTelefone()});
		            }
		        } catch (Exception ex) {
		        	JOptionPane.showMessageDialog(null, "ERRO" + e);
		        }
			}
		});
		btnListar.setForeground(new Color(255, 0, 0));
		btnListar.setBackground(new Color(0, 0, 0));
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnListar.setBounds(161, 11, 89, 23);
		panel_1.add(btnListar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setForeground(Color.RED);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBackground(Color.BLACK);
		btnSair.setBounds(335, 197, 89, 23);
		panel_1.add(btnSair);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 414, 141);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Cargo", "Nome", "CPF", "Data de nascimeto", "Telefone"
			}
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(101);
	}

}
