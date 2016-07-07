package br.com.lel.dominio.entidade;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author lincoln
 * 
 * 
 */

public class MonitoramentoDiabetico {
	
	private Date dataHora;
	
	private int dextro;
	
	private double quantidadeCarboidrato;
	
	private double quantidadeInsulina;

	public MonitoramentoDiabetico(int dextro, double quantidadeCarboidrato, double quantidadeInsulina) {
		this.dextro = dextro;
		this.quantidadeCarboidrato = quantidadeCarboidrato;
		this.quantidadeInsulina = quantidadeInsulina;
	}
	
	public double calcularQuantidadeInsulina() {
		return 10;
	}

}
