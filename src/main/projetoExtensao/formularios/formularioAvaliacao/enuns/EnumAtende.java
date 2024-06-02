package main.projetoExtensao.formularios.formularioAvaliacao.enuns;

import java.io.Serializable;

public enum EnumAtende implements Serializable {
    VAZIO("Vazio"),
    ATENDE("Atende"),
    NAO_ATENDE("Não Atende"),
    PARCIALMENTE("Atende Parcialmente");

    private String texto;

    EnumAtende(String texto){
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
