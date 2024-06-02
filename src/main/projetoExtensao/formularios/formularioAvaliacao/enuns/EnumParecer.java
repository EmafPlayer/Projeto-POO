package main.projetoExtensao.formularios.formularioAvaliacao.enuns;

import java.io.Serializable;

public enum EnumParecer implements Serializable {
    VAZIO("Vazio"),
    RECOMENDO("Recomendo"),
    NAO_RECOMENDO("Não Recomendo"),
    RECOMENDO_ADEQUACOES("Recomendo com Adequações Necessárias");

    private String texto;

    EnumParecer(String texto){
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
