package br.com.mediBox.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteModel {

    @Id
    @Column(name = "idCliente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_SEQ")
    @SequenceGenerator(name = "CLIENTE_SEQ", initialValue = 1, allocationSize = 1)
    private long idCliente;

    @Column(name = "nomeCLiente")
    private String nomeCliente;

    @Column(name = "CPF-CNPJ")
    private String cpfCnpj;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "telefone")
    private String telefone;

    @OneToMany (mappedBy = "clienteModel")
    private List<ResidenteModel> listResidente = new ArrayList<ResidenteModel>();

    @OneToMany (mappedBy = "clienteModel")
    private List<CaixaModel> listCaixa = new ArrayList<CaixaModel>();

    @OneToMany (mappedBy = "clienteModel")
    private List<ResidenteMedicamentoModel> listResidenteMedicamento = new ArrayList<ResidenteMedicamentoModel>();

    @OneToMany (mappedBy = "clienteModel")
    private List<TimeLineModel> listTimeLine = new ArrayList<TimeLineModel>();

    @OneToMany (mappedBy = "clienteModel")
    private List<EnderecoModel> listEndereco = new ArrayList<EnderecoModel>();


    public ClienteModel(long idCliente, String nomeCliente, String cpfCnpj, String email, String senha, String telefone) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
