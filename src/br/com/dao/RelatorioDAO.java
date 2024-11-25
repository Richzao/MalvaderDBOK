package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import br.com.model.Relatorio;

public class RelatorioDAO {
	static public void save(int id, Relatorio relatorio) throws ClassNotFoundException {
		String comando_sql = "INSERT INTO relatorio (tipo_relatorio, data_geracao, conteudo, id_funcionario) VALUES (?, ?, ?, ?)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, relatorio.getTipo());
			comando.setTimestamp(2, Timestamp.valueOf(relatorio.getDataGeracao()));
			comando.setString(3, relatorio.getDados().toString());
			comando.setInt(4, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void update(int id, Relatorio relatorio) throws ClassNotFoundException {
		String comando_sql = "UPDATE relatorio SET tipo_relatorio = ?, data_geracao = ?, conteudo = ? WHERE id_relatorio = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, relatorio.getTipo());
			comando.setTimestamp(2, Timestamp.valueOf(relatorio.getDataGeracao()));
			comando.setString(3, relatorio.getDados().toString());
			comando.setInt(4, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void delete(int id) throws ClassNotFoundException {
		String comando_sql = "DELETE FROM relatorio WHERE id_relatorio = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	@SuppressWarnings("null")
	static public Relatorio findById(int id) throws ClassNotFoundException {
		Relatorio relatorio = new Relatorio();
		List<String> lista = null;
		
		String comando_sql = "SELECT * FROM relatorio WHERE id_relatorio = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			ResultSet data = comando.executeQuery();
			
			relatorio.setTipo(data.getString("tipo_relatorio"));
			relatorio.setDataGeracao(data.getTimestamp("data_geracao").toLocalDateTime());

			lista.add(data.getString("conteudo"));
			relatorio.setDados(lista);
			
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}

		return relatorio;
	}
}
