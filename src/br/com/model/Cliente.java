package br.com.model;

public class Cliente extends Usuario {
	private String senha;

	public double consultarSaldo() {
		return 0.0;
	}

	public void depositar(double valor) {

	}

	public boolean sacar(double valor) {
		return false;
	}

	public String consultarExtrato() {
		return "WIP";
	}

	public double consultarLimite() {
		return 0.0;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public String getTipoUsuario() {
		return tipoUsuario.CLIENTE.toString();
	}
}
