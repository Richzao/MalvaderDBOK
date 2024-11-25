package br.com.model;

import java.time.LocalDateTime;
import java.util.List;

public class Relatorio {
	private String tipo;
	private LocalDateTime dataGeracao;
	private List<String> dados;
	
	public void gerarRelatorio() {

	}
	
	public void exportarParaExcel() {
		
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setDataGeracao(LocalDateTime dataGeracao) {
		this.dataGeracao = dataGeracao;
	}
	
	public void setDados(List<String> dados) {
		this.dados = dados;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public LocalDateTime getDataGeracao() {
		return dataGeracao;
	}
	
	public List<String> getDados() {
		return dados;
	}
}
