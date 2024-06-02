package main.projetoExtensao.formularios.formularioSubmissao.models;

import java.io.Serializable;

public class Membro implements Serializable {
    private String nome_completo;
    private String cpf;
    private String instituicao;
    private String colegiado_setor;
    private String categoria_profissional;
    private String funcao_projeto;

    public Membro(){

    }

    public String getCpf() {
        return cpf;
    }

    public String getCategoria_profissional() {
        return categoria_profissional;
    }

    public String getColegiado_setor() {
        return colegiado_setor;
    }

    public String getFuncao_projeto() {
        return funcao_projeto;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCategoria_profissional(String categoria_profissional) {
        this.categoria_profissional = categoria_profissional;
    }

    public void setColegiado_setor(String colegiado_setor) {
        this.colegiado_setor = colegiado_setor;
    }

    public void setFuncao_projeto(String funcao_projeto) {
        this.funcao_projeto = funcao_projeto;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }
}
