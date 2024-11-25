package br.com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.dao.ContaDAO;
import br.com.model.Conta;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaConsultarContasView extends JFrame {

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
					TelaConsultarContasView frame = new TelaConsultarContasView();
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
	public TelaConsultarContasView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 363);
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
		panel_1.setBounds(0, 27, 434, 297);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            Conta c = new Conta();
		            ContaDAO cDao = new ContaDAO();
		            DefaultTableModel contaPesque = (DefaultTableModel) tableListar.getModel();
		            contaPesque.setRowCount(0);
		            ArrayList<Conta> contas = cDao.listarContas();
		            for (int i = 0; i < contas.size(); i++){
		                c = contas.get(i);
		                contaPesque.addRow(new Object[]{c.getId(), c.getNumero(), c.getAgencia(), c.getSaldo(), c.getTipo(), c.getId_cliente()});
		            }
		        } catch (Exception ex) {
		        	JOptionPane.showMessageDialog(null, "ERRO" + e);
		        }
			}
		});
		btnListar.setForeground(new Color(255, 0, 0));
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnListar.setBackground(new Color(0, 0, 0));
		btnListar.setBounds(169, 9, 89, 23);
		panel_1.add(btnListar);
		
		JButton btnSair = new JButton("Voltar");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setForeground(Color.RED);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBackground(Color.BLACK);
		btnSair.setBounds(339, 267, 89, 23);
		panel_1.add(btnSair);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 416, 210);
		panel_1.add(scrollPane);
		
		tableListar = new JTable();
		scrollPane.setViewportView(tableListar);
		tableListar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id conta", "N\u00FAmero conta", "Ag\u00EAncia", "Saldo", "Tipo da conta", "Id cliente"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableListar.getColumnModel().getColumn(1).setPreferredWidth(77);
	}
}
