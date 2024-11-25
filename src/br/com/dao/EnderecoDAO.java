package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.model.Endereco;

public class EnderecoDAO {
	//Salva um enedereço para o Banco de Dados, mas precisa de um ID para ser associado.
	static public void save(int id_usuario, Endereco endereco) throws ClassNotFoundException {
		String comando_sql = "INSERT INTO endereco (cep, local, numero_casa, bairro, cidade, estado, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, endereco.getCEP());
			comando.setString(2, endereco.getLocal());
			comando.setInt(3, endereco.getNumeroCasa());
			comando.setString(4, endereco.getBairro());
			comando.setString(5, endereco.getCidade());
			comando.setString(6, endereco.getEstado());
			comando.setInt(7, id_usuario);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void update(int id, Endereco endereco) throws ClassNotFoundException {
		String comando_sql = "UPDATE cliente SET cep = ?, local = ?, numero_casa = ?, bairro = ?, cidade = ?, estado = ? WHERE id_endereco = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, endereco.getCEP());
			comando.setString(2, endereco.getLocal());
			comando.setInt(3, endereco.getNumeroCasa());
			comando.setString(4, endereco.getBairro());
			comando.setString(5, endereco.getCidade());
			comando.setString(6, endereco.getEstado());
			comando.setInt(7, id);
					
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void delete(int id) throws ClassNotFoundException {
		String comando_sql = "DELETE FROM endereco WHERE id_endereco = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public Endereco findById(int id) throws ClassNotFoundException {
		Endereco endereco = new Endereco();
		
		String comando_sql = "SELECT * FROM endereco WHERE id_endereco = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			ResultSet data = comando.executeQuery();
						
			endereco.setCEP(data.getString("cep"));
			endereco.setLocal(data.getString("local"));
			endereco.setNumeroCasa(data.getInt("numero_casa"));
			endereco.setBairro(data.getString("bairro"));
			endereco.setCidade(data.getString("cidade"));
			endereco.setEstado(data.getString("estado"));
			
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}

		return endereco;
	}
}
