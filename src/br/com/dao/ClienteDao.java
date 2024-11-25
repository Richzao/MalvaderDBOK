package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.model.Cliente;

public class ClienteDao {
	static public void save(Cliente cliente) throws ClassNotFoundException {
		String comando_sql = "INSERT INTO cliente (id_usuario) VALUE (?)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, String.valueOf(cliente.getID()));
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void update(int id, Cliente cliente) throws ClassNotFoundException {
		String comando_sql = "UPDATE cliente SET id_usuario = ? where id_cliente = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, String.valueOf(cliente.getID()));
			comando.setString(2, String.valueOf(id));
					
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void delete(int id) throws ClassNotFoundException {
		String comando_sql = "DELETE FROM cliente WHERE id_cliente = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public Cliente findById(int id) throws ClassNotFoundException {
		Cliente cliente = new Cliente();
		String comando_sql = "SELECT * FROM usuario JOIN cliente ON usuario.id_usuario = cliente.id_usuario WHERE cliente.id_usuario = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			ResultSet data = comando.executeQuery();
						
			cliente.setID(data.getInt("funcionario.id_usuario"));
			cliente.setNome(data.getString("nome"));
			cliente.setCPF(data.getString("cpf"));
			cliente.setDataNascimento(data.getString("data_nascimento"));
			cliente.setTelefone(data.getString("telefone"));
			cliente.setSenha(data.getString("senha"));
			
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
		return cliente;
	}
}
