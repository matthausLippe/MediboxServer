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
        "idEndereco",
        "rua",
        "numero",
        "complemento",
        "bairro",
        "cidade",
        "estado",
        "cep",
        "clienteModel"
})
public class EnderecoDto {

    @JsonProperty("idEndereco")
    private Integer idEndereco;
    @JsonProperty("rua")
    private String rua;
    @JsonProperty("numero")
    private String numero;
    @JsonProperty("complemento")
    private String complemento;
    @JsonProperty("bairro")
    private String bairro;
    @JsonProperty("cidade")
    private String cidade;
    @JsonProperty("estado")
    private String estado;
    @JsonProperty("cep")
    private String cep;
    @JsonProperty("clienteModel")
    private Integer clienteModel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("idEndereco")
    public Integer getIdEndereco() {
        return idEndereco;
    }

    @JsonProperty("idEndereco")
    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    @JsonProperty("rua")
    public String getRua() {
        return rua;
    }

    @JsonProperty("rua")
    public void setRua(String rua) {
        this.rua = rua;
    }

    @JsonProperty("numero")
    public String getNumero() {
        return numero;
    }

    @JsonProperty("numero")
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @JsonProperty("complemento")
    public String getComplemento() {
        return complemento;
    }

    @JsonProperty("complemento")
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @JsonProperty("bairro")
    public String getBairro() {
        return bairro;
    }

    @JsonProperty("bairro")
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @JsonProperty("cidade")
    public String getCidade() {
        return cidade;
    }

    @JsonProperty("cidade")
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @JsonProperty("estado")
    public String getEstado() {
        return estado;
    }

    @JsonProperty("estado")
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JsonProperty("cep")
    public String getCep() {
        return cep;
    }

    @JsonProperty("cep")
    public void setCep(String cep) {
        this.cep = cep;
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
