package main.projetoExtensao.formularios.formularioSubmissao.models;

import main.projetoExtensao.formularios.formularioSubmissao.FormularioSubmissao;
import main.projetoExtensao.formularios.formularioSubmissao.enuns.EnumEvento;

public class Evento extends FormularioSubmissao {
    private EnumEvento tipo_evento;

    public Evento (String nome_arquivo){
        super();
        this.nome_arquivo  = nome_arquivo;
        tipo_evento = EnumEvento.VAZIO;
    }

    public EnumEvento getTipo_evento(){
        return tipo_evento;
    }

    public void setTipo_evento(EnumEvento tipo_evento){
        this.tipo_evento = tipo_evento;
    }

}
