package main.projetoExtensao.formularios.formularioAvaliacao.models;

import main.projetoExtensao.formularios.formularioAvaliacao.enuns.EnumOpcao;

import java.io.Serializable;

public class CheckBoxOpcao implements Serializable {
    private EnumOpcao opcao;
    private String consideracoes;

    public CheckBoxOpcao(){
        opcao = EnumOpcao.VAZIO;
    }

    public String getConsideracoes() {
        return consideracoes;
    }

    public EnumOpcao getOpcao() {
        return opcao;
    }

    public void setConsideracoes(String consideracoes) {
        this.consideracoes = consideracoes;
    }

    public void setOpcao(EnumOpcao opcao) {
        this.opcao = opcao;
    }
}
