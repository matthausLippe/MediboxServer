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
        "idResidenteMedicamento",
        "dosagem",
        "intervalo",
        "dataHoraInicio",
        "doses",
        "residenteModel",
        "medicamentoModel",
        "clienteModel"
})
public class ResidenteMedicamentoDto {

    @JsonProperty("idResidenteMedicamento")
    private Integer idResidenteMedicamento;
    @JsonProperty("dosagem")
    private String dosagem;
    @JsonProperty("intervalo")
    private Double intervalo;
    @JsonProperty("dataHoraInicio")
    private String dataHoraInicio;
    @JsonProperty("doses")
    private Integer doses;
    @JsonProperty("residenteModel")
    private Integer residenteModel;
    @JsonProperty("medicamentoModel")
    private Integer medicamentoModel;
    @JsonProperty("clienteModel")
    private Integer clienteModel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("idResidenteMedicamento")
    public Integer getIdResidenteMedicamento() {
        return idResidenteMedicamento;
    }

    @JsonProperty("idResidenteMedicamento")
    public void setIdResidenteMedicamento(Integer idResidenteMedicamento) {
        this.idResidenteMedicamento = idResidenteMedicamento;
    }

    @JsonProperty("dosagem")
    public String getDosagem() {
        return dosagem;
    }

    @JsonProperty("dosagem")
    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    @JsonProperty("intervalo")
    public Double getIntervalo() {
        return intervalo;
    }

    @JsonProperty("intervalo")
    public void setIntervalo(Double intervalo) {
        this.intervalo = intervalo;
    }

    @JsonProperty("dataHoraInicio")
    public String getDataHoraInicio() {
        return dataHoraInicio;
    }

    @JsonProperty("dataHoraInicio")
    public void setDataHoraInicio(String dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    @JsonProperty("doses")
    public Integer getDoses() {
        return doses;
    }

    @JsonProperty("doses")
    public void setDoses(Integer doses) {
        this.doses = doses;
    }

    @JsonProperty("residenteModel")
    public Integer getResidenteModel() {
        return residenteModel;
    }

    @JsonProperty("residenteModel")
    public void setResidenteModel(Integer residenteModel) {
        this.residenteModel = residenteModel;
    }

    @JsonProperty("medicamentoModel")
    public Integer getMedicamentoModel() {
        return medicamentoModel;
    }

    @JsonProperty("medicamentoModel")
    public void setMedicamentoModel(Integer medicamentoModel) {
        this.medicamentoModel = medicamentoModel;
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