package br.com.mediBox.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table (name = "TB_TIMELINE")
public class TimeLineModel {

    @Id
    @Column(name = "idTimeLine")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIMELINE_SEQ")
    @SequenceGenerator(name = "TIMELINE_SEQ", initialValue = 1, allocationSize = 1)
    private long idTimeLine;

    @ManyToOne
    @JoinColumn (name="idResidenteMedicamento", nullable = false)
    private ResidenteMedicamentoModel residenteMedicamentoModel;

    @ManyToOne
    @JoinColumn (name="idCliente", nullable = false)
    private ClienteModel clienteModel;

    //@Column(name = "dataMedicacao")
    //@JsonFormat(pattern="dd/MM/yyyy")
    //private Date dataMedicacao;

    //@Column(name = "horaMedicacao")
    //private Time horaMedicacao;

    @JsonFormat(pattern="yyyy-MM-dd@HH:mm:ss.SSSZ")
    @Column(name = "dataHoraMedicacao")
    private Timestamp dataHoraMedicacao;

    @Column(name = "status")
    private int status ;

    public static int MEDICADO = 1;
    public static int NAO_MEDICADO = 0;

    public TimeLineModel(long idTimeLine, ResidenteMedicamentoModel residenteMedicamentoModel, ClienteModel clienteModel, Timestamp dataHoraMedicacao, int status) {
        this.idTimeLine = idTimeLine;
        this.residenteMedicamentoModel = residenteMedicamentoModel;
        this.clienteModel = clienteModel;
        this.dataHoraMedicacao = dataHoraMedicacao;
        //this.horaMedicacao = horaMedicacao;
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

    public Timestamp getDataHoraMedicacao() {
        return dataHoraMedicacao;
    }

    public void setDataHoraMedicacao(Timestamp dataHoraMedicacao) {
        this.dataHoraMedicacao = dataHoraMedicacao;
    }

    /*public Date getDataMedicacao() {
        return dataMedicacao;
    }

    public void setDataMedicacao(Date dataMedicacao) {
        this.dataMedicacao = dataMedicacao;
    }

    public Time getHoraMedicacao() {
        return horaMedicacao;
    }

    public void setHoraMedicacao(Time horaMedicacao) {
        this.horaMedicacao = horaMedicacao;
    }*/

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
