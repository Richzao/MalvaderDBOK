package br.com.model;

public class Conta {
	private int numero;
	private String agencia;
	private double saldo;
	private Cliente cliente;
	private int id_cliente;
	private int id;
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo (String tipo) {
		this.tipo = tipo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public void depositar(double valor) {
		this.saldo = this.saldo + valor;
	}

	public boolean sacar(double valor) {
		if (valor > this.saldo) return false;
		this.saldo = this.saldo - valor;
		return true;
	}
	
	public double consultarSaldo() {
		return this.saldo;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getAgencia() {
		return agencia;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

}