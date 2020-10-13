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
        "idGaveta",
        "temperatura",
        "nomeGaveta",
        "caixaModel"
})
public class GavetaDto {

    @JsonProperty("idGaveta")
    private Integer idGaveta;
    @JsonProperty("temperatura")
    private Double temperatura;
    @JsonProperty("nomeGaveta")
    private String nomeGaveta;
    @JsonProperty("caixaModel")
    private Integer caixaModel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("idGaveta")
    public Integer getIdGaveta() {
        return idGaveta;
    }

    @JsonProperty("idGaveta")
    public void setIdGaveta(Integer idGaveta) {
        this.idGaveta = idGaveta;
    }

    @JsonProperty("temperatura")
    public Double getTemperatura() {
        return temperatura;
    }

    @JsonProperty("temperatura")
    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    @JsonProperty("nomeGaveta")
    public String getNomeGaveta() {
        return nomeGaveta;
    }

    @JsonProperty("nomeGaveta")
    public void setNomeGaveta(String nomeGaveta) {
        this.nomeGaveta = nomeGaveta;
    }

    @JsonProperty("caixaModel")
    public Integer getCaixaModel() {
        return caixaModel;
    }

    @JsonProperty("caixaModel")
    public void setCaixaModel(Integer caixaModel) {
        this.caixaModel = caixaModel;
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