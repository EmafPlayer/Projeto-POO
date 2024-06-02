package main.projetoExtensao.formularios.formularioSubmissao.enuns;

import java.io.Serializable;

public enum EnumEvento implements Serializable {

    VAZIO("Você não selecionou nada"),
    CONGRESSO("Congresso"),
    CONFERENCIA("Conferência"),
    SEMINARIO("Seminário"),
    FORUM("Fórum"),
    SIMPOSIO("Simpósio"),
    OFICINA("Oficina"),
    PALESTRA("Palestra"),
    MESA_REDONDA("Mesa redonda"),
    ENCONTRO("Encontro"),
    WORKSHOP("Workshop"),
    FEIRA("Feira"),
    SEMANA("Semana"),
    EXPOSICAO("Exposição"),
    FESTIVAL("Festival");

    private String texto;

    EnumEvento(String texto){
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

}
