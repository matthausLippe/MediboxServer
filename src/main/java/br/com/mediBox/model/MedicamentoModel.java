package br.com.mediBox.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_MEDICAMENTO")
public class MedicamentoModel {

    @Id
    @Column(name = "idMedicamento")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEDICAMENTO_SEQ")
    @SequenceGenerator(name = "MEDICAMENTO_SEQ", initialValue = 1, allocationSize = 1)
    private long idMedicamento;

    @Column(name = "nomeMedicamento")
    private String nomeMedicamento;

    @Column(name = "laboratorio")
    private String laboratorio;

    @Column(name = "dosagem")
    private String dosagem;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idGaveta")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("gavetaModel")
    @JoinColumn (name="idGaveta", nullable = false)
    private GavetaModel gavetaModel;

    @OneToMany (mappedBy = "medicamentoModel")
    private List<ResidenteMedicamentoModel> listResidenteMedicamento = new ArrayList<ResidenteMedicamentoModel>();

    public MedicamentoModel() {

    }

    public MedicamentoModel(long idMedicamento, String nomeMedicamento, String laboratorio, String dosagem) {
        this.idMedicamento = idMedicamento;
        this.nomeMedicamento = nomeMedicamento;
        this.laboratorio = laboratorio;
        this.dosagem = dosagem;
    }

    public long getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(long idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getDosagem() {
        return dosagem;
    }

    public GavetaModel getGavetaModel() {
        return gavetaModel;
    }

    public void setGavetaModel(GavetaModel gavetaModel) {
        this.gavetaModel = gavetaModel;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
