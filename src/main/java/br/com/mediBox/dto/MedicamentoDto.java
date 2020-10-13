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
        "idMedicamento",
        "nomeMedicamento",
        "laboratorio",
        "dosagem",
        "descricao",
        "gavetaModel"
})
public class MedicamentoDto {

    @JsonProperty("idMedicamento")
    private Integer idMedicamento;
    @JsonProperty("nomeMedicamento")
    private String nomeMedicamento;
    @JsonProperty("laboratorio")
    private String laboratorio;
    @JsonProperty("dosagem")
    private String dosagem;
    @JsonProperty("descricao")
    private String descricao;
    @JsonProperty("gavetaModel")
    private Integer gavetaModel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("idMedicamento")
    public Integer getIdMedicamento() {
        return idMedicamento;
    }

    @JsonProperty("idMedicamento")
    public void setIdMedicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    @JsonProperty("nomeMedicamento")
    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    @JsonProperty("nomeMedicamento")
    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }

    @JsonProperty("laboratorio")
    public String getLaboratorio() {
        return laboratorio;
    }

    @JsonProperty("laboratorio")
    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    @JsonProperty("dosagem")
    public String getDosagem() {
        return dosagem;
    }

    @JsonProperty("dosagem")
    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    @JsonProperty("descricao")
    public String getDescricao() {
        return descricao;
    }

    @JsonProperty("descricao")
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @JsonProperty("gavetaModel")
    public Integer getGavetaModel() {
        return gavetaModel;
    }

    @JsonProperty("gavetaModel")
    public void setGavetaModel(Integer gavetaModel) {
        this.gavetaModel = gavetaModel;
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
