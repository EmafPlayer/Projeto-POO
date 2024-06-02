package main.projetoExtensao.formularios.formularioSubmissao.models;

import java.io.Serializable;

public class Coordenador implements Serializable {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String titulacao;
    private String area_formacao;


    public Coordenador (){

    }

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public String getArea_formacao() {
        return area_formacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public void setArea_formacao(String area_formacao) {
        this.area_formacao = area_formacao;
    }

}