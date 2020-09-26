package br.com.mediBox.model;

public class Gaveta {
	
	private int idGaveta;
	private int idMedicamento;
	private int idCaixa;
	private double temperatura;
	private String nomeGaveta;
		
	
	public Gaveta(int idGaveta, int idMedicamento, int idCaixa, double temperatura, String nomeGaveta) {
		super();
		this.idGaveta = idGaveta;
		this.idMedicamento = idMedicamento;
		this.idCaixa = idCaixa;
		this.temperatura = temperatura;
		this.nomeGaveta = nomeGaveta;
	}
	public int getIdGaveta() {
		return idGaveta;
	}
	public void setIdGaveta(int idGaveta) {
		this.idGaveta = idGaveta;
	}
	public int getIdMedicamento() {
		return idMedicamento;
	}
	public void setIdMedicamento(int idMedicamento) {
		this.idMedicamento = idMedicamento;
	}
	public int getIdCaixa() {
		return idCaixa;
	}
	public void setIdCaixa(int idCaixa) {
		this.idCaixa = idCaixa;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public String getNomeGaveta() {
		return nomeGaveta;
	}
	public void setNomeGaveta(String nomeGaveta) {
		this.nomeGaveta = nomeGaveta;
	}

	
	
	
}
