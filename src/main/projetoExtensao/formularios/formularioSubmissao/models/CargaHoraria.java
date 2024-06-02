package main.projetoExtensao.formularios.formularioSubmissao.models;

import java.io.Serializable;

public class CargaHoraria implements Serializable {
    private String inicio;
    private String fim;
    private String ch_semanal;
    private String ch_anual;

    public CargaHoraria (){

    }

    public String getInicio() {
        return inicio;
    }

    public String getCh_anual() {
        return ch_anual;
    }

    public String getCh_semanal() {
        return ch_semanal;
    }

    public String getFim() {
        return fim;
    }

    public void setCh_anual(String ch_anual) {
        this.ch_anual = ch_anual;
    }

    public void setCh_semanal(String ch_semanal) {
        this.ch_semanal = ch_semanal;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

}
