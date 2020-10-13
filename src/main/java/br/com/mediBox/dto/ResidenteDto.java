package br.com.mediBox.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idResidente",
        "nomeResidente",
        "dataNascimento",
        "sexo",
        "nomeResponsavel",
        "telResponsavel",
        "quarto",
        "observacoes",
        "clienteModel"
})
public class ResidenteDto {

    @JsonProperty("idResidente")
    private Integer idResidente;
    @JsonProperty("nomeResidente")
    private String nomeResidente;
    @JsonProperty("dataNascimento")
    private String dataNascimento;
    @JsonProperty("sexo")
    private String sexo;
    @JsonProperty("nomeResponsavel")
    private String nomeResponsavel;
    @JsonProperty("telResponsavel")
    private String telResponsavel;
    @JsonProperty("quarto")
    private String quarto;
    @JsonProperty("observacoes")
    private String observacoes;
    @JsonProperty("clienteModel")
    private Integer clienteModel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("idResidente")
    public Integer getIdResidente() {
        return idResidente;
    }

    @JsonProperty("idResidente")
    public void setIdResidente(Integer idResidente) {
        this.idResidente = idResidente;
    }

    @JsonProperty("nomeResidente")
    public String getNomeResidente() {
        return nomeResidente;
    }

    @JsonProperty("nomeResidente")
    public void setNomeResidente(String nomeResidente) {
        this.nomeResidente = nomeResidente;
    }

    @JsonProperty("dataNascimento")
    public String getDataNascimento() {
        return dataNascimento;
    }

    @JsonProperty("dataNascimento")
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @JsonProperty("sexo")
    public String getSexo() {
        return sexo;
    }

    @JsonProperty("sexo")
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @JsonProperty("nomeResponsavel")
    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    @JsonProperty("nomeResponsavel")
    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    @JsonProperty("telResponsavel")
    public String getTelResponsavel() {
        return telResponsavel;
    }

    @JsonProperty("telResponsavel")
    public void setTelResponsavel(String telResponsavel) {
        this.telResponsavel = telResponsavel;
    }

    @JsonProperty("quarto")
    public String getQuarto() {
        return quarto;
    }

    @JsonProperty("quarto")
    public void setQuarto(String quarto) {
        this.quarto = quarto;
    }

    @JsonProperty("observacoes")
    public String getObservacoes() {
        return observacoes;
    }

    @JsonProperty("observacoes")
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @JsonProperty("clienteModel")
    public Integer getClienteModel() {
        return clienteModel;
    }

    @JsonProperty("clienteModel")
    public void setClienteModel(Integer clienteModel) {
        this.clienteModel = clienteModel;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
