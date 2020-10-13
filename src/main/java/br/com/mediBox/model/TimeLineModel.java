package br.com.mediBox.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "TB_TIMELINE")
public class TimeLineModel {

    @Id
    @Column(name = "idTimeLine")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIMELINE_SEQ")
    @SequenceGenerator(name = "TIMELINE_SEQ", initialValue = 1, allocationSize = 1)
    private long idTimeLine;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResidenteMedicamento")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("residenteMedicamentoModel")
    @JoinColumn (name="idResidenteMedicamento", nullable = false)
    private ResidenteMedicamentoModel residenteMedicamentoModel;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCliente")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("clienteModel")
    @JoinColumn (name="idCliente", nullable = false)
    private ClienteModel clienteModel;

    @JsonFormat(pattern="yyyy-MM-dd@HH:mm", timezone = "UTC")
    @Column(name = "dataHoraMedicacao")
    private Date dataHoraMedicacao;

    @Column(name = "status")
    private int status ;


    public TimeLineModel() {
       
    }

    public long getIdTimeLine() {
        return idTimeLine;
    }

    public void setIdTimeLine(long idTimeLine) {
        this.idTimeLine = idTimeLine;
    }

    public ResidenteMedicamentoModel getResidenteMedicamentoModel() {
        return residenteMedicamentoModel;
    }

    public void setResidenteMedicamentoModel(ResidenteMedicamentoModel residenteMedicamentoModel) {
        this.residenteMedicamentoModel = residenteMedicamentoModel;
    }

    public ClienteModel getClienteModel() {
        return clienteModel;
    }

    public void setClienteModel(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }

    public Date getDataHoraMedicacao() {
        return dataHoraMedicacao;
    }

    public void setDataHoraMedicacao(Date dataHoraMedicacao) {
        this.dataHoraMedicacao = dataHoraMedicacao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
