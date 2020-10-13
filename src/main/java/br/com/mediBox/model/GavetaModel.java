package br.com.mediBox.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_GAVETA")
public class GavetaModel {
	@Id
	@Column(name = "idGaveta")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GAVETA_SEQ")
	@SequenceGenerator(name = "GAVETA_SEQ", initialValue = 1, allocationSize = 1)
	private long idGaveta;

	@ManyToOne
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCaixa")
	@JsonIdentityReference(alwaysAsId = true)
	@JsonProperty("caixaModel")
	@JoinColumn (name="idCaixa", nullable = false)
	private CaixaModel caixaModel;

	@Column(name = "temperatura")
	private double temperatura;

	@Column(name = "nomeGaveta")
	private String nomeGaveta;

	@OneToMany(mappedBy = "gavetaModel")
	private List<MedicamentoModel> listMedicamentoModel = new ArrayList<MedicamentoModel>();

	public GavetaModel() {

	}

	public GavetaModel(long idGaveta, CaixaModel caixaModel, double temperatura, String nomeGaveta) {
		this.idGaveta = idGaveta;
		this.caixaModel = caixaModel;
		this.temperatura = temperatura;
		this.nomeGaveta = nomeGaveta;
	}

	public long getIdGaveta() {
		return idGaveta;
	}

	public void setIdGaveta(long idGaveta) {
		this.idGaveta = idGaveta;
	}

	public CaixaModel getCaixaModel() {
		return caixaModel;
	}

	public void setCaixaModel(CaixaModel caixaModel) {
		this.caixaModel = caixaModel;
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
