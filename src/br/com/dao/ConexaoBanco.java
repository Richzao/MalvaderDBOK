package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	private String url;
	private String usuario;
	private String senha;

	public Connection conectar() {
		try {
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao conectar com o bando de dados!");
		}
	}

	public void desconectar() {

	}
}