package main.projetoExtensao.formularios.formularioSubmissao.enuns;

import java.io.Serializable;

public enum EnumCursos implements Serializable {

    VAZIO("Você não selecionou nada"),
    INICIALIZACAO("Inicialiazação"),
    ATUALIZACAO("Atualização"),
    FORMACAO("Formação"),
    QUALIFICACAO_APERFEICOAMENTO("Qualificação/Aperfeiçoamento");

    private String texto;

    EnumCursos(String texto){
        this.texto = texto;
    }

    public String getTexto(){
        return texto;
    }

}
