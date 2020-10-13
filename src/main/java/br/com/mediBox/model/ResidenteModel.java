package br.com.mediBox.model;

import com.fasterxml.jackson.annotation.*;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_RESIDENTE")
public class ResidenteModel {

    @Id
    @Column(name = "idResidente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESIDENTE_SEQ")
    @SequenceGenerator(name = "RESIDENTE_SEQ", initialValue = 1, allocationSize = 1)
    private long idResidente;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCliente")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("clienteModel")
    @JoinColumn (name="idCliente", nullable = false)
    private ClienteModel clienteModel;

    @Column(name = "nomeResidente")
    private String nomeResidente;

    @Column(name = "dataNascimento")
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm")
    private Date dataNascimento;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "nomeResponsavel")
    private String nomeResponsavel;

    @Column(name = "telResponsavel")
    private String telResponsavel;

    @Column(name = "quarto")
    private String quarto;

    @Column(name = "observacoes")
    private String observacoes;

    @JsonIgnore
    @OneToMany (mappedBy = "residenteModel")
    private List<ResidenteMedicamentoModel> residenteMedicamento = new ArrayList<ResidenteMedicamentoModel>();


    public ResidenteModel() {

    }

    public ClienteModel getClienteModel() {
        return clienteModel;
    }

    public void setClienteModel(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }

    public long getIdResidente() {
        return idResidente;
    }

    public void setIdResidente(long idResidente) {
        this.idResidente = idResidente;
    }

    public String getNomeResidente() {
        return nomeResidente;
    }

    public void setNomeResidente(String nomeResidente) {
        this.nomeResidente = nomeResidente;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getTelResponsavel() {
        return telResponsavel;
    }

    public void setTelResponsavel(String telResponsavel) {
        this.telResponsavel = telResponsavel;
    }

    public String getQuarto() {
        return quarto;
    }

    public void setQuarto(String quarto) {
        this.quarto = quarto;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public List<ResidenteMedicamentoModel> getResidenteMedicamento() {
        return residenteMedicamento;
    }

    public void setResidenteMedicamento(List<ResidenteMedicamentoModel> residenteMedicamento) {
        this.residenteMedicamento = residenteMedicamento;
    }

    //+
    // @JsonProperty("clienteModel")
    public void setidCliente(long idCliente){
        clienteModel.setIdCliente(idCliente);
    }

    @Override
    public String toString() {
        return "ResidenteModel{" +
                "idResidente=" + idResidente +
                ", idCliente=" + clienteModel.getIdCliente() +
                ", nomeResidente='" + nomeResidente + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", sexo='" + sexo + '\'' +
                ", nomeResponsavel='" + nomeResponsavel + '\'' +
                ", telResponsavel='" + telResponsavel + '\'' +
                ", quarto='" + quarto + '\'' +
                ", observacoes='" + observacoes + '\'' +
                ", residenteMedicamento=" + residenteMedicamento +
                '}';
    }
}
