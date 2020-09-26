package br.com.mediBox.model;

public class Caixa {
	
	private int idCaixa;
	private int idCliente;
	private String mac;
	private int status;
	public static int ATIVO = 1;
	public static int INATIVO = 0;
	
	
	
	public Caixa(int idCaixa, int idCliente, String mac, int status) {
		super();
		this.idCaixa = idCaixa;
		this.idCliente = idCliente;
		this.mac = mac;
		this.status = status;
	}
	
	public int getIdCaixa() {
		return idCaixa;
	}
	public void setIdCaixa(int idCaixa) {
		this.idCaixa = idCaixa;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
}
