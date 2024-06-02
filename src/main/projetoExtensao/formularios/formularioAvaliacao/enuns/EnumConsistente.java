package main.projetoExtensao.formularios.formularioAvaliacao.enuns;

import java.io.Serializable;

public enum EnumConsistente implements Serializable {
    VAZIO("Vazio"),
    CONSISTENTE("Consistente"),
    INCONSISTENTE("Inconsistente"),
    PARCIALMENTE("Parcialmente Consistente");

    private String texto;

    EnumConsistente(String texto){
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

}
