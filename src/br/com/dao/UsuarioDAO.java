package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.model.Cliente;
import br.com.model.Conta;
import br.com.model.Funcionario;
import br.com.model.Usuario;

public class UsuarioDAO {
	static public void saveFuncionario(Usuario funcionario) throws ClassNotFoundException {
		String comando_sql = "INSERT INTO usuario (nome, cpf, data_nascimento, telefone, tipo_usuario, senha) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, funcionario.getNome());
			comando.setString(2, funcionario.getCPF());
			comando.setString(3, funcionario.getDataNascimento());
			comando.setString(4, funcionario.getTelefone());
			comando.setString(5, funcionario.getTipoUsuario());
			comando.setString(6, funcionario.getSenha());
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void saveCliente(Cliente cliente) throws ClassNotFoundException {
		String comando_sql = "INSERT INTO usuario (nome, cpf, data_nascimento, telefone, tipo_usuario, senha) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, cliente.getNome());
			comando.setString(2, cliente.getCPF());
			comando.setString(3, cliente.getDataNascimento());
			comando.setString(4, cliente.getTelefone());
			comando.setString(5, cliente.getTipoUsuario());
			comando.setString(6, cliente.getSenha());
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void updateCliente(int id, Cliente cliente) throws ClassNotFoundException {
		String comando_sql = "UPDATE usuario u\r\n"
				+ "JOIN cliente c ON u.id_usuario = c.id_usuario\r\n"
				+ "SET u.telefone = ?\r\n"
				+ "WHERE c.id_cliente = ?;\r\n"
				+ "";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, cliente.getTelefone());
			comando.setInt(2, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void update(int id, Funcionario funcionario) throws ClassNotFoundException {
		String comando_sql = "UPDATE usuario SET nome = ?, cpf = ?, data_nascimento = ?, telefone = ?, tipo_usuario = ?, senha = ? WHERE id_usuario = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, funcionario.getNome());
			comando.setString(2, funcionario.getCPF());
			comando.setString(3, funcionario.getDataNascimento());
			comando.setString(4, funcionario.getTelefone());
			comando.setString(5, funcionario.getTipoUsuario());
			comando.setString(6, funcionario.getSenha());
			comando.setInt(7, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void delete(int id) throws ClassNotFoundException {
		String comando_sql = "DELETE FROM usuario WHERE id_usuario = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public String findPasswordCliente(int id) throws ClassNotFoundException {
		String password = null;
		String comando_sql = "SELECT senha FROM usuario WHERE id_usuario = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			ResultSet data = comando.executeQuery();
			if (data.next()) {
				password = data.getString("senha");
				conexao.close();
			} else {
				return null;
			}
		} catch (SQLException error) {
			error.printStackTrace();
		}
		
		return password;
	}
	static public String findPasswordFuncionario(int id) throws ClassNotFoundException {
		String password = null;
		String comando_sql = "SELECT senha FROM usuario WHERE id_usuario = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			ResultSet data = comando.executeQuery();
			
			if (data.next()) {
				password = data.getString("senha");
				conexao.close();
			} else {
				return null;
			}
			
		} catch (SQLException error) {
			error.printStackTrace();
		}
		
		return password;
	}
	
	//Encontra um Usuario no Banco de Dados e retorna a table.
	//ATENÇÃO!!!EVITA DE USAR ESTA FUNÇÃO JA QUE ELA E UM USUARIO INCOMPLETO BASEADO
	//NO BANCO DE DADOS!!!
	static public Usuario findById(int id) throws ClassNotFoundException {
		Usuario usuario = new Usuario();
		String comando_sql = "SELECT * FROM usuario WHERE cliente.id_usuario = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			ResultSet data = comando.executeQuery();
						
			usuario.setID(data.getInt("funcionario.id_usuario"));
			usuario.setNome(data.getString("nome"));
			usuario.setCPF(data.getString("cpf"));
			usuario.setDataNascimento(data.getString("data_nascimento"));
			usuario.setTelefone(data.getString("telefone"));
			
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
		return usuario;
	}
	
	public ArrayList<Usuario> listarClientes () throws Exception{
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		String comando_sql = "SELECT nome, cpf, data_nascimento, telefone FROM usuario where tipo_usuario = 'CLIENTE'";
		try (Connection conexao = ConnectionFactory.getConnection()){
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			ResultSet data = comando.executeQuery();
			Usuario u;
			while (data.next()) {
				u = new Usuario();
				u.setNome(data.getString("nome"));
				u.setCPF(data.getString("cpf"));
				u.setDataNascimento(data.getString("data_nascimento"));
				u.setTelefone(data.getString("telefone"));
				usuarios.add(u);
			}
			conexao.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erro!" + e.getMessage());
		}
		
		return usuarios;
	}
	public ArrayList<Funcionario> listarFuncionarios () throws Exception{
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		String comando_sql = "SELECT \r\n"
				+ "    usuario.nome, \r\n"
				+ "    usuario.cpf, \r\n"
				+ "    usuario.data_nascimento, \r\n"
				+ "    usuario.telefone, \r\n"
				+ "    funcionario.codigo_funcionario, \r\n"
				+ "    funcionario.cargo\r\n"
				+ "FROM \r\n"
				+ "    usuario\r\n"
				+ "JOIN \r\n"
				+ "    funcionario \r\n"
				+ "ON \r\n"
				+ "    usuario.id_usuario = funcionario.id_usuario\r\n"
				+ "WHERE \r\n"
				+ "    usuario.tipo_usuario = 'FUNCIONARIO';\r\n"
				+ "";
		try (Connection conexao = ConnectionFactory.getConnection()){
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			ResultSet data = comando.executeQuery();
			Funcionario f;
			while (data.next()) {
				f = new Funcionario();
				f.setNome(data.getString("nome"));
				f.setCPF(data.getString("cpf"));
				f.setDataNascimento(data.getString("data_nascimento"));
				f.setTelefone(data.getString("telefone"));
				f.setCodigofuncionario(data.getString("codigo_funcionario"));
				f.setCargo(data.getString("cargo"));
				funcionarios.add(f);
			}
			conexao.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erro!" + e.getMessage());
		}
		
		return funcionarios;
	}
}
