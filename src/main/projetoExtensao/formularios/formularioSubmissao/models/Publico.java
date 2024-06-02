package main.projetoExtensao.formularios.formularioSubmissao.models;

import java.io.Serializable;

public class Publico implements Serializable {
    private String publico_alvo;
    private int pessoas_beneficiadas;

    public Publico(){

    }

    public String getPublico_alvo() {
        return publico_alvo;
    }

    public int getPessoas_beneficiadas() {
        return pessoas_beneficiadas;
    }

    public void setPublico_alvo(String publico_alvo) {
        this.publico_alvo = publico_alvo;
    }

    public void setPessoas_beneficiadas(int pessoas_beneficiadas) {
        this.pessoas_beneficiadas = pessoas_beneficiadas;
    }
}
