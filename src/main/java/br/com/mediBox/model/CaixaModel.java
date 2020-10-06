package br.com.mediBox.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_CAIXA")
public class CaixaModel {
	@Id
	@Column(name = "idCaixa")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAIXA_SEQ")
	@SequenceGenerator(name = "CAIXA_SEQ", initialValue = 1, allocationSize = 1)
	private long idCaixa;

	@ManyToOne
	@JoinColumn(name="idCliente", nullable = false)
	private ClienteModel clienteModel;

	@Column(name = "mac")
	private String mac;

	@Column(name = "status")
	private int status;

	@OneToMany(mappedBy = "caixaModel")
	private List<GavetaModel> listGaveta = new ArrayList<GavetaModel>();

	public static int ATIVO = 1;
	public static int INATIVO = 0;

	public CaixaModel() {

	}

	public long getIdCaixa() {
		return idCaixa;
	}

	public void setIdCaixa(long idCaixa) {
		this.idCaixa = idCaixa;
	}

	public ClienteModel getClienteModel() {
		return clienteModel;
	}

	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
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
