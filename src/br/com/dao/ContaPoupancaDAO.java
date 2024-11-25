package br.com.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.model.Cliente;
import br.com.model.Conta;
import br.com.model.ContaPoupanca;

public class ContaPoupancaDAO {
	static public void save(int id, ContaPoupanca conta) throws ClassNotFoundException {
		String comando_sql = "INSERT INTO conta_poupanca (taxa_rendimento, id_conta) VALUES (?, ?)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setBigDecimal(1, BigDecimal.valueOf(conta.getTaxaRendimento()));
			comando.setInt(2, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void updateCp(ContaPoupanca conta) throws ClassNotFoundException {
		String comando_sql = "UPDATE conta_poupanca SET taxa_rendimento = ?  WHERE data_criacao = (SELECT MAX(data_criacao) FROM conta_poupanca)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setBigDecimal(1, BigDecimal.valueOf(conta.getTaxaRendimento()));
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void update(ContaPoupanca conta, Conta c) throws ClassNotFoundException {
		String comando_sql = "UPDATE conta_poupanca SET taxa_rendimento = ? WHERE data_criacao = (SELECT MAX(data_criacao) FROM conta_poupanca)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setDouble(1, 1.50);
			comando.setInt(2, c.getId());
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void delete(int id) throws ClassNotFoundException {
		String comando_sql = "DELETE FROM conta_poupanca WHERE id_conta_poupanca = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public ContaPoupanca findById(int id) throws ClassNotFoundException {
		ContaPoupanca conta = new ContaPoupanca();
		
		String comando_sql = "SELECT * FROM conta JOIN conta_poupanca ON conta.id_conta = conta_poupanca.id_conta WHERE conta_poupanca.id_conta_poupanca = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			ResultSet data = comando.executeQuery();
			
			conta.setNumero(data.getInt("numero_conta"));
			conta.setAgencia(data.getString("agencia"));
			conta.setSaldo(data.getDouble("saldo"));
			
			Cliente cliente = ClienteDao.findById(data.getInt("id_cliente"));
			
			conta.setCliente(cliente);
			conta.setTaxaRendimento(data.getDouble("taxa_rendimento"));
			
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}

		return conta;
	}
}
