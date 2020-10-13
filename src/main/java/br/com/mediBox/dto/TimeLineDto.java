package br.com.mediBox.dto;

public class TimeLineDto {
    private int idTimeLine;

    private int residenteMedicamentoModel;

    private int clienteModel;

    private String dataHoraMedicacao;

    private int status;

    public TimeLineDto() {
    }

    public int getIdTimeLine() {
        return idTimeLine;
    }

    public void setIdTimeLine(int idTimeLine) {
        this.idTimeLine = idTimeLine;
    }

    public int getResidenteMedicamentoModel() {
        return residenteMedicamentoModel;
    }

    public void setResidenteMedicamentoModel(int residenteMedicamentoModel) {
        this.residenteMedicamentoModel = residenteMedicamentoModel;
    }

    public int getClienteModel() {
        return clienteModel;
    }

    public void setClienteModel(int clienteModel) {
        this.clienteModel = clienteModel;
    }

    public String getDataHoraMedicacao() {
        return dataHoraMedicacao;
    }

    public void setDataHoraMedicacao(String dataHoraMedicacao) {
        this.dataHoraMedicacao = dataHoraMedicacao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
