package br.com.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.model.Cliente;
import br.com.model.Conta;
import br.com.model.ContaCorrente;

public class ContaCorrenteDAO {
	static public void save(int id, ContaCorrente conta) throws ClassNotFoundException {
		String comando_sql = "INSERT INTO conta_corrente (limite, data_vencimento) VALUES (?, ?)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setBigDecimal(1, BigDecimal.valueOf(conta.getLimite()));
			comando.setDate(2, Date.valueOf(conta.getDataVencimento()));
			comando.setInt(3, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void updateCc(ContaCorrente conta) throws ClassNotFoundException {
		String comando_sql = "UPDATE conta_corrente SET limite = ?, data_vencimento = ? WHERE data_criacao = (SELECT MAX(data_criacao) FROM conta_corrente)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setBigDecimal(1, BigDecimal.valueOf(conta.getLimite()));
			comando.setDate(2, Date.valueOf(conta.getDataVencimento()));
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void update(int id, ContaCorrente conta) throws ClassNotFoundException {
		String comando_sql = "UPDATE conta_corrente SET limite = ?, data_vencimento = ? WHERE id_conta_corrente = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setBigDecimal(1, BigDecimal.valueOf(conta.getLimite()));
			comando.setDate(2, Date.valueOf(conta.getDataVencimento()));
			comando.setInt(3, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void delete(int id) throws ClassNotFoundException {
		String comando_sql = "DELETE FROM conta_corrente WHERE id_conta_corrente = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public Double ConsultarSaldo(int id) throws Exception{
		String query = "SELECT saldo FROM conta WHERE id_cliente = ?";
		Conta c = new Conta();
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(query);
			comando.setInt(1, id);
			ResultSet data = comando.executeQuery();
			if (data.next()) {
				c.setSaldo(data.getDouble("saldo"));
				
				conexao.close();
				
				return c.getSaldo();
			} else {
				JOptionPane.showMessageDialog(null, "Saldo inexistente para esse cliente!");
				return 0.;
			}
			
		} catch (SQLException error) {
			error.printStackTrace();
			return 0.;
		}
	}
	
	static public ContaCorrente findById(int id) throws ClassNotFoundException {
		ContaCorrente conta = new ContaCorrente();
		
		String comando_sql = "SELECT * FROM conta JOIN conta_corrente ON conta.id_conta = conta_corrente.id_conta WHERE conta_corrente.id_conta_corrente = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			ResultSet data = comando.executeQuery();
			
			conta.setNumero(data.getInt("numero_conta"));
			conta.setAgencia(data.getString("agencia"));
			conta.setSaldo(data.getDouble("saldo"));
			
			Cliente cliente = ClienteDao.findById(data.getInt("id_cliente"));
			
			conta.setCliente(cliente);
			conta.setLimite(data.getDouble("limite"));
			conta.setDataVencimento(data.getDate("data_vencimento").toLocalDate());
			
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}

		return conta;
	}
}
