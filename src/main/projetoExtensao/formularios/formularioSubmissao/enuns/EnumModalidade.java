package main.projetoExtensao.formularios.formularioSubmissao.enuns;

import java.io.Serializable;

public enum EnumModalidade implements Serializable {

    VAZIO("Você não selecionou nada"),
    PROGRAMA("Programa"),
    PROJETO("Projeto"),
    NUCLEO_TEMATICO("Núcleo Temático"),
    EVENTO("Evento"),
    EMPRESA_JUNIOR("Empresa Junior"),
    LIGA_ACADEMICA("Liga Acadêmica"),
    PRESTACAO_SERVICO("Prestação de Serviço"),
    CURSO("Curso");

    private String texto;

    EnumModalidade(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

}
