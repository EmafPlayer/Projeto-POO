package main.projetoExtensao.formularios.formularioSubmissao.models;

import main.projetoExtensao.formularios.formularioSubmissao.FormularioSubmissao;
import main.projetoExtensao.formularios.formularioSubmissao.enuns.EnumCursos;

public class Curso extends FormularioSubmissao {
    private EnumCursos tipo_curso;

    public Curso (String nome_arquivo){
        super();
        this.nome_arquivo = nome_arquivo;
        tipo_curso = EnumCursos.VAZIO;
    }

    public EnumCursos getTipo_curso(){
        return tipo_curso;
    }

    public void setTipo_curso(EnumCursos tipo_curso){
        this.tipo_curso = tipo_curso;
    }

}