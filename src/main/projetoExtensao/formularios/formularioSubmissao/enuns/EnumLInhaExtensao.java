package main.projetoExtensao.formularios.formularioSubmissao.enuns;

import java.io.Serializable;

public enum EnumLInhaExtensao implements Serializable {

    VAZIO("Você não selecionou nada"),
    CULTURA("Cultura"),
    COMUNICACAO("Comunicação"),
    EDUCACAO("Educação"),
    DIREITOS_HUMANOS_JUSTICA("Direitos Humanos e Justiça"),
    SAUDE("Saúde"),
    MEIO_AMBIENTE("Meio Ambiente"),
    TRABALHO("Trabalho"),
    TECNOLOGIA_PRODUCAO("Tecnologia e Produção");

    private String texto;

    EnumLInhaExtensao(String texto){
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

}


