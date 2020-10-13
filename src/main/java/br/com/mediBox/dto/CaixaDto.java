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
        "idCaixa",
        "mac",
        "status",
        "clienteModel"
})
public class CaixaDto {

    @JsonProperty("idCaixa")
    private Integer idCaixa;
    @JsonProperty("mac")
    private String mac;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("clienteModel")
    private Integer clienteModel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("idCaixa")
    public Integer getIdCaixa() {
        return idCaixa;
    }

    @JsonProperty("idCaixa")
    public void setIdCaixa(Integer idCaixa) {
        this.idCaixa = idCaixa;
    }

    @JsonProperty("mac")
    public String getMac() {
        return mac;
    }

    @JsonProperty("mac")
    public void setMac(String mac) {
        this.mac = mac;
    }

    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
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
