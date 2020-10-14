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
        "idTimeLine",
        "dataHoraMedicacao",
        "status",
        "residenteMedicamentoModel",
        "clienteModel"
})
public class TimeLineDto {

    @JsonProperty("idTimeLine")
    private Integer idTimeLine;
    @JsonProperty("dataHoraMedicacao")
    private String dataHoraMedicacao;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("residenteMedicamentoModel")
    private Integer residenteMedicamentoModel;
    @JsonProperty("clienteModel")
    private Integer clienteModel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("idTimeLine")
    public Integer getIdTimeLine() {
        return idTimeLine;
    }

    @JsonProperty("idTimeLine")
    public void setIdTimeLine(Integer idTimeLine) {
        this.idTimeLine = idTimeLine;
    }

    @JsonProperty("dataHoraMedicacao")
    public String getDataHoraMedicacao() {
        return dataHoraMedicacao;
    }

    @JsonProperty("dataHoraMedicacao")
    public void setDataHoraMedicacao(String dataHoraMedicacao) {
        this.dataHoraMedicacao = dataHoraMedicacao;
    }

    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty("residenteMedicamentoModel")
    public Integer getResidenteMedicamentoModel() {
        return residenteMedicamentoModel;
    }

    @JsonProperty("residenteMedicamentoModel")
    public void setResidenteMedicamentoModel(Integer residenteMedicamentoModel) {
        this.residenteMedicamentoModel = residenteMedicamentoModel;
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