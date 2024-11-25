package br.com.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.dao.UsuarioDAO;

public class Usuario {
	private int id;
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String telefone;
	private Endereco endereco;
	private String senha;
	private String tipoUsuario;

	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha; 
    }
	public enum tipoUsuario {
		FUNCIONARIO,
		CLIENTE
	}

	public boolean loginCliente(String senha, int id) throws ClassNotFoundException {
		String senhaDAO = UsuarioDAO.findPasswordCliente(id);
		return senhaDAO == senha;
	}
	public boolean loginFuncionario(String senha, int id) throws ClassNotFoundException {
		String senhaDAO = UsuarioDAO.findPasswordFuncionario(id);
		return senhaDAO == senha;
	}

	public void logout() {

	}

	public String consultarDados() {
		return "WIP";
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setTelefone(String telefone) {
		if (telefone != null) this.telefone = telefone;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public int getID() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public String formatarData(String dataNascimento) {
		// Converte a string para LocalDate
        LocalDate data = LocalDate.parse(dataNascimento);
        
        // Retorna a data formatada no padrão ISO (yyyy-MM-dd)
        return data.format(DateTimeFormatter.ISO_DATE);
	}
}


