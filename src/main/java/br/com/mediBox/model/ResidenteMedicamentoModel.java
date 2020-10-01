package br.com.mediBox.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javafx.animation.Timeline;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_RESIDENTEMEDICAMENTO")
public class ResidenteMedicamentoModel {

    @Id
    @Column(name = "idResidenteMedicamento")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESIDENTEMEDICAMENTO_SEQ")
    @SequenceGenerator(name = "RESIDENTEMEDICAMENTO_SEQ", initialValue = 1, allocationSize = 1)
    private long idResidenteMedicamento;

    @ManyToOne
    @JoinColumn (name="idResidente", nullable = false)
    private ResidenteModel residenteModel;

    @ManyToOne
    @JoinColumn (name="idMedicamento", nullable = false)
    private MedicamentoModel medicamentoModel;

    @ManyToOne
    @JoinColumn (name="idCliente", nullable = false)
    private ClienteModel clienteModel;

    @ManyToOne
    @JoinColumn (name="idGaveta", nullable = false)
    private GavetaModel gavetaModel;

    @Column(name = "dosagem")
    private String dosagem;

    @Column(name = "intervalo")
    private double intervalo;

    @Column(name = "dataInicio")
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataInicio;

    @Column(name = "horaInicio")
    private Time horaInicio;

    @Column(name = "doses")
    private int doses;

    @OneToMany (mappedBy = "residenteMedicamentoModel")
    private List<TimeLineModel> listTimeLine = new ArrayList<TimeLineModel>();



    public ResidenteMedicamentoModel(long idResidenteMedicamento, ResidenteModel residenteModel,
                                     MedicamentoModel medicamentoModel, ClienteModel clienteModel,
                                     GavetaModel gavetaModel, String dosagem, double intervalo,
                                     Date dataInicio, Time horaInicio, int doses) {
        this.idResidenteMedicamento = idResidenteMedicamento;
        this.residenteModel = residenteModel;
        this.medicamentoModel = medicamentoModel;
        this.clienteModel = clienteModel;
        this.gavetaModel = gavetaModel;
        this.dosagem = dosagem;
        this.intervalo = intervalo;
        this.dataInicio = dataInicio;
        this.horaInicio = horaInicio;
        this.doses = doses;
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

    public GavetaModel getGavetaModel() {
        return gavetaModel;
    }

    public void setGavetaModel(GavetaModel gavetaModel) {
        this.gavetaModel = gavetaModel;
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getDoses() {
        return doses;
    }

    public void setDoses(int doses) {
        this.doses = doses;
    }
}
