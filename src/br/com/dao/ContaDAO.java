package br.com.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.model.Cliente;
import br.com.model.Conta;
import br.com.model.ContaCorrente;
import br.com.model.ContaPoupanca;

public class ContaDAO {
	static public void saveCc(Conta conta) throws ClassNotFoundException {
		String comando_sql = "INSERT INTO conta (numero_conta, agencia, saldo, tipo_conta, id_cliente) VALUES (?, ?, ?, ?, ?)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, String.valueOf(conta.getNumero()));	//NOTA: Garanta que o número seja unico antes de atualizar.
			comando.setString(2, conta.getAgencia());
			comando.setBigDecimal(3, BigDecimal.valueOf(conta.getSaldo()));
			comando.setString(4, "CORRENTE");
			comando.setInt(5, conta.getId_cliente());
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void saveP(Conta conta) throws ClassNotFoundException {
		String comando_sql = "INSERT INTO conta (numero_conta, agencia, saldo, tipo_conta, id_cliente) VALUES (?, ?, ?, ?, ?)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, String.valueOf(conta.getNumero()));
			comando.setString(2, conta.getAgencia());
			comando.setBigDecimal(3, BigDecimal.valueOf(conta.getSaldo()));
			comando.setString(4, "POUPANCA");
			comando.setInt(5, conta.getId_cliente());
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	public void deposito (int id, Conta c) throws Exception{
		ContaCorrenteDAO cDao = new ContaCorrenteDAO();
		double saldo = cDao.ConsultarSaldo(id);
		String query = "UPDATE conta SET saldo = ? WHERE id_cliente = ?";
		
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(query);
			comando.setDouble(1, c.getSaldo() + saldo);
			comando.setInt(2, id);
			
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	public void saque (int id, Conta c) throws Exception{
		ContaCorrenteDAO cDao = new ContaCorrenteDAO();
		double saldo = cDao.ConsultarSaldo(id);
		String query = "UPDATE conta SET saldo = ? WHERE id_cliente = ?";
		
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(query);
			if (c.getSaldo() > saldo) {
				JOptionPane.showMessageDialog(null, "Não é possível sacar mais do que o saldo!");
			} else {
				System.out.println(saldo);
				System.out.println(c.getSaldo());
				System.out.println(saldo - c.getSaldo());
				comando.setDouble(1, saldo - c.getSaldo());
				comando.setInt(2, id);
				comando.executeUpdate();
			}
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void updateContaCorrente(int id, ContaCorrente cc) throws ClassNotFoundException {
		String comando_sql = "UPDATE conta c\r\n"
				+ "JOIN conta_corrente cc ON c.id_conta = cc.id_conta_corrente\r\n"
				+ "SET c.tipo_conta = ?, cc.limite = ?, cc.data_vencimento = ?\r\n"
				+ "WHERE c.id_conta = ?\r\n"
				+ "";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, "CORRENTE");
			comando.setDouble(2, cc.getLimite());
			comando.setDate(3, Date.valueOf(cc.getDataVencimento()));
			comando.setInt(4, id);
					
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void updateContaPoupanca(int id, ContaPoupanca cp) throws ClassNotFoundException {
		String comando_sql = "UPDATE conta SET tipo_conta = 'POUPANCA' WHERE id_conta=?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			
			comando.setInt(1, id);
					
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void delete(int id) throws ClassNotFoundException {
		String comando_sql = "DELETE FROM conta WHERE id_conta = ?";
		String comando_sql1 = "DELETE FROM conta_corrente WHERE id_conta = ?";
		String comando_sql2 = "DELETE FROM conta_poupanca WHERE id_conta = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			PreparedStatement comando1 = conexao.prepareStatement(comando_sql1);
			PreparedStatement comando2 = conexao.prepareStatement(comando_sql2);
			comando1.setInt(1, id);
			comando2.setInt(1, id);
			comando.setInt(1, id);
			
			comando1.executeUpdate();
			comando2.executeUpdate();
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public Conta findById(int id) throws ClassNotFoundException {
		Conta conta = new Conta();
		
		String comando_sql = "SELECT * FROM conta WHERE conta.id_conta = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			ResultSet data = comando.executeQuery();
			
			conta.setNumero(data.getInt("numero_conta"));
			conta.setAgencia(data.getString("agencia"));
			conta.setSaldo(data.getDouble("saldo"));
			
			Cliente cliente = ClienteDao.findById(data.getInt("id_cliente"));
			
			conta.setCliente(cliente);
			
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}

		return conta;
	}
	
	public ArrayList<Conta> listarContas () throws Exception{
		ArrayList<Conta> contas = new ArrayList<Conta>();
		
		String comando_sql = "SELECT * FROM conta";
		try (Connection conexao = ConnectionFactory.getConnection()){
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			ResultSet data = comando.executeQuery();
			Conta c;
			while (data.next()) {
				c = new Conta();
				c.setId(data.getInt("id_conta"));
				c.setNumero(Integer.valueOf(data.getString("numero_conta")));
				c.setAgencia(data.getString("agencia"));
				c.setSaldo(data.getDouble("saldo"));
				c.setTipo(data.getString("tipo_conta"));
				c.setId_cliente(data.getInt("id_cliente"));
				contas.add(c);
			}
			conexao.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erro!" + e.getMessage());
		}
		
		return contas;
	}
}
