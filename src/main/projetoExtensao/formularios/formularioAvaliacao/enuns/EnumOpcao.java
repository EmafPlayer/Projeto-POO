package main.projetoExtensao.formularios.formularioAvaliacao.enuns;

import java.io.Serializable;

public enum EnumOpcao implements Serializable {
    VAZIO("Vazio"),
    SIM("Sim"),
    NAO("Não"),
    PARCIALMENTE("Parcialmente");

    private String texto;

    EnumOpcao(String texto){
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
