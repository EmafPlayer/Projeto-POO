package main.projetoExtensao.formularios.formularioSubmissao.models;

import java.io.Serializable;

public class PropostaOrcamentaria implements Serializable {
    private String recursos;
    private String justificativas;
    private double custos_previstos;
    private String origem_recurso;
    private double despesas;
    private double total;

    public PropostaOrcamentaria(){

    }

    public double getCustos_previstos() {
        return custos_previstos;
    }

    public double getDespesas() {
        return despesas;
    }

    public double getTotal() {
        return total;
    }

    public String getJustificativas() {
        return justificativas;
    }

    public String getOrigem_recurso() {
        return origem_recurso;
    }

    public String getRecursos() {
        return recursos;
    }

    public void setOrigem_recurso(String origem_recurso) {
        this.origem_recurso = origem_recurso;
    }

    public void setCustos_previstos(Float custos_previstos) {
        this.custos_previstos = custos_previstos;
    }

    public void setDespesas(Float despesas) {
        this.despesas = despesas;
    }

    public void setJustificativas(String justificativas) {
        this.justificativas = justificativas;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

}
