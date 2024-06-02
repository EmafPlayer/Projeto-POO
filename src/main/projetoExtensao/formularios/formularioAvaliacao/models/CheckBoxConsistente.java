package main.projetoExtensao.formularios.formularioAvaliacao.models;

import main.projetoExtensao.formularios.formularioAvaliacao.enuns.EnumConsistente;

import java.io.Serializable;

public class CheckBoxConsistente implements Serializable {
    private EnumConsistente opcao;
    private String consideracoes;

    public CheckBoxConsistente(){
        opcao = EnumConsistente.VAZIO;
    }

    public String getConsideracoes() {
        return consideracoes;
    }

    public EnumConsistente getOpcao() {
        return opcao;
    }

    public void setConsideracoes(String consideracoes) {
        this.consideracoes = consideracoes;
    }

    public void setOpcao(EnumConsistente opcao) {
        this.opcao = opcao;
    }
}
