package main.projetoExtensao.formularios.formularioAvaliacao.models;

import main.projetoExtensao.formularios.formularioAvaliacao.enuns.EnumParecer;

import java.io.Serializable;

public class CheckBoxParecer implements Serializable {
    private EnumParecer opcao;
    private String consideracoes;

    public CheckBoxParecer(){
        opcao = EnumParecer.VAZIO;
    }

    public String getConsideracoes() {
        return consideracoes;
    }

    public EnumParecer getOpcao() {
        return opcao;
    }

    public void setConsideracoes(String consideracoes) {
        this.consideracoes = consideracoes;
    }

    public void setOpcao(EnumParecer opcao) {
        this.opcao = opcao;
    }
}
