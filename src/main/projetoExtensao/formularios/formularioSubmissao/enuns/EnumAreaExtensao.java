package main.projetoExtensao.formularios.formularioSubmissao.enuns;

import java.io.Serializable;

public enum EnumAreaExtensao implements Serializable {

    VAZIO("Você não selecionou nada"),
    CIENCIAS_TERRA("Ciências da Terra"),
    CIENCIAS_HUMANAS_SOCIAIS("Ciências Humanas e Ciências Sociais Aplicadas"),
    CIENCIAS_VIDA("Ciências da Vida"),
    ENGENHARIAS_CIENCIAS_EXATAS("Engenharias e Ciências Exatas");

    private String texto;

    EnumAreaExtensao(String texto){
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

}
