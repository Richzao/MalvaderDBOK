package br.com.model;

public class Endereco {
	private String cep;
	private String local;
	private int numeroCasa;
	private String bairro;
	private String cidade;
	private String estado;

	public String toString() {
		return "WIP";
	}
	
	public void setCEP(String cep) {
		this.cep = cep;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCEP() {
		return cep;
	}
	
	public String getLocal() {
		return local;
	}
	
	public int getNumeroCasa() {
		return numeroCasa;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getEstado() {
		return estado;
	}
}