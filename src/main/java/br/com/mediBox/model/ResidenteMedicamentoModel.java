package br.com.mediBox.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.*;

import static java.util.Locale.*;

@Entity
@Table(name = "TB_RESIDENTEMEDICAMENTO")
public class ResidenteMedicamentoModel {

    @Id
    @Column(name = "idResidenteMedicamento")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESIDENTEMEDICAMENTO_SEQ")
    @SequenceGenerator(name = "RESIDENTEMEDICAMENTO_SEQ", initialValue = 1, allocationSize = 1)
    private long idResidenteMedicamento;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResidente")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("residenteModel")
    @JoinColumn (name="idResidente", nullable = false)
    private ResidenteModel residenteModel;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idMedicamento")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("medicamentoModel")
    @JoinColumn (name="idMedicamento", nullable = false)
    private MedicamentoModel medicamentoModel;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCliente")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("clienteModel")
    @JoinColumn (name="idCliente", nullable = false)
    private ClienteModel clienteModel;

    @Column(name = "dosagem")
    private String dosagem;

    @Column(name = "intervalo")
    private double intervalo;

    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm", timezone = "UTC")
    @Column(name = "dataHoraInicio")
    public Date dataHoraInicio;

    @Column(name = "doses")
    private int doses;

    @OneToMany (mappedBy = "residenteMedicamentoModel")
    @JsonIgnore
    private List<TimeLineModel> listTimeLine = new ArrayList<TimeLineModel>();



    public ResidenteMedicamentoModel() {

    }

    public long getIdResidenteMedicamento() {
        return idResidenteMedicamento;
    }

    public void setIdResidenteMedicamento(long idResidenteMedicamento) {
        this.idResidenteMedicamento = idResidenteMedicamento;
    }

    public ResidenteModel getResidenteModel() {
        return residenteModel;
    }

    public void setResidenteModel(ResidenteModel residenteModel) {
        this.residenteModel = residenteModel;
    }

    public MedicamentoModel getMedicamentoModel() {
        return medicamentoModel;
    }

    public void setMedicamentoModel(MedicamentoModel medicamentoModel) {
        this.medicamentoModel = medicamentoModel;
    }

    public ClienteModel getClienteModel() {
        return clienteModel;
    }

    public void setClienteModel(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public double getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(double intervalo) {
        this.intervalo = intervalo;
    }

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public int getDoses() {
        return doses;
    }

    public void setDoses(int doses) {
        this.doses = doses;
    }
}
