package br.com.model;

import java.time.LocalDate;

public class ContaCorrente extends Conta {
	private double limite;
	private LocalDate dataVencimento;

	public double consultarLimite() {
		return 0.0;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	public double getLimite() {
		return limite;
	}
	
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
}