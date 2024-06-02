package main.projetoExtensao.formularios.formularioAvaliacao.models;

import java.io.Serializable;

public class IdentificacaoProposta implements Serializable {
    private String coordenador;
    private String colegiado_setor;
    private String titulo_proposta;

    public IdentificacaoProposta(){

    }

    public String getColegiado_setor() {
        return colegiado_setor;
    }

    public String getTitulo_proposta() {
        return titulo_proposta;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setColegiado_setor(String colegiado_setor) {
        this.colegiado_setor = colegiado_setor;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public void setTitulo_proposta(String titulo_proposta) {
        this.titulo_proposta = titulo_proposta;
    }
}
