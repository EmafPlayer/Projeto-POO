package main.projetoExtensao.formularios.formularioSubmissao.models;

import java.io.Serializable;

public class CronogramaExecucao implements Serializable {
    private String atividade_planejada;
    private String periodo;
    private String local;
    private String observacao;

    public CronogramaExecucao(){

    }

    public String getAtividade_planejada() {
        return atividade_planejada;
    }

    public String getLocal() {
        return local;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setAtividade_planejada(String atividade_planejada) {
        this.atividade_planejada = atividade_planejada;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
