package br.com.mediBox.model;

import javax.persistence.*;
import java.sql.Date;
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
    @JoinColumn (name="idCliente", nullable = false)
    private ClienteModel clienteModel;

    @Column(name = "nomeResidente")
    private String nomeResidente;

    @Column(name = "dataNascimento")
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

    @OneToMany (mappedBy = "residenteModel")
    private List<ResidenteMedicamentoModel> residenteMedicamento = new ArrayList<ResidenteMedicamentoModel>();


    public ResidenteModel(ClienteModel clienteModel, long idResidente, String nomeResidente, Date dataNascimento,
                          String sexo, String nomeResponsavel, String telResponsavel, String quarto, String observacoes) {
        this.clienteModel = clienteModel;
        this.idResidente = idResidente;
        this.nomeResidente = nomeResidente;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.nomeResponsavel = nomeResponsavel;
        this.telResponsavel = telResponsavel;
        this.quarto = quarto;
        this.observacoes = observacoes;
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
}
