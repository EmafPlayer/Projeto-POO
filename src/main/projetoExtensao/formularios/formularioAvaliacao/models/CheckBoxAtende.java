package main.projetoExtensao.formularios.formularioAvaliacao.models;

import main.projetoExtensao.formularios.formularioAvaliacao.enuns.EnumAtende;

import java.io.Serializable;

public class CheckBoxAtende implements Serializable {
    private EnumAtende opcao;
    private String consideracoes;

    public CheckBoxAtende(){
        opcao = EnumAtende.VAZIO;
    }

    public EnumAtende getOpcao() {
        return opcao;
    }

    public String getConsideracoes() {
        return consideracoes;
    }

    public void setOpcao(EnumAtende opcao) {
        this.opcao = opcao;
    }

    public void setConsideracoes(String consideracoes) {
        this.consideracoes = consideracoes;
    }

}
