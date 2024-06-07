package main.projetoExtensao.controllers;

import main.projetoExtensao.formularios.formularioAvaliacao.models.FormularioAvaliacao;
import main.projetoExtensao.formularios.formularioSubmissao.FormularioSubmissao;
import main.projetoExtensao.formularios.formularioSubmissao.models.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public abstract class ControllerConexao {
    private Scanner scanner;

    ControllerConexao(){
        scanner = new Scanner(System.in);
    }

    static public <T extends FormularioSubmissao> boolean existeFormularioSubmissao(ArrayList<T> formularios_submissao, String nome_arquivo){
        boolean ja_existe = false;
        for(T formulario : formularios_submissao){
            if (Objects.equals(formulario.getNome_arquivo(), nome_arquivo))
                return !ja_existe;
        }
        return ja_existe;
    }

    static public boolean existeFormularioAvaliacao(ArrayList<FormularioAvaliacao> formularios_avaliacao, String nome_arquivo){
        boolean ja_existe = false;
        for(FormularioAvaliacao formulario : formularios_avaliacao){
            if (Objects.equals(formulario.getNome_arquivo(), nome_arquivo))
                return !ja_existe;
        }
        return ja_existe;
    }

    static public void removerAvaliacao(ArrayList<Curso> cursos,
                                        ArrayList<EmpresaJunior> empresas_juniors,
                                        ArrayList<Evento> eventos,
                                        ArrayList<LigaAcademica> ligas_cademicas,
                                        ArrayList<NucleoTematico> nucleos_tematicos,
                                        ArrayList<PrestacaoServico> prestacoes_servicos,
                                        ArrayList<Programa> programas,
                                        ArrayList<Projeto> projetos,
                                        String nome_arquivo){

        for(Curso formulario : cursos){
            if (Objects.equals(formulario.getNome_arquivo(), nome_arquivo)){
                formulario.setAvaliador("Formulário ainda não avaliado");
                return;
            }
        }

        for(EmpresaJunior formulario : empresas_juniors){
            if (Objects.equals(formulario.getNome_arquivo(), nome_arquivo)){
                formulario.setAvaliador("Formulário ainda não avaliado");
                return;
            }
        }

        for(Evento formulario : eventos){
            if (Objects.equals(formulario.getNome_arquivo(), nome_arquivo)){
                formulario.setAvaliador("Formulário ainda não avaliado");
                return;
            }
        }

        for(LigaAcademica formulario : ligas_cademicas){
            if (Objects.equals(formulario.getNome_arquivo(), nome_arquivo)){
                formulario.setAvaliador("Formulário ainda não avaliado");
                return;
            }
        }

        for(NucleoTematico formulario : nucleos_tematicos){
            if (Objects.equals(formulario.getNome_arquivo(), nome_arquivo)){
                formulario.setAvaliador("Formulário ainda não avaliado");
                return;
            }
        }

        for(PrestacaoServico formulario : prestacoes_servicos){
            if (Objects.equals(formulario.getNome_arquivo(), nome_arquivo)){
                formulario.setAvaliador("Formulário ainda não avaliado");
                return;
            }
        }

        for(Programa formulario : programas){
            if (Objects.equals(formulario.getNome_arquivo(), nome_arquivo)){
                formulario.setAvaliador("Formulário ainda não avaliado");
                return;
            }
        }

        for(Projeto formulario : projetos){
            if (Objects.equals(formulario.getNome_arquivo(), nome_arquivo)){
                formulario.setAvaliador("Formulário ainda não avaliado");
                return;
            }
        }

    }

    static public void deleteAvaliador(ArrayList<FormularioAvaliacao> formularios_avaliacao, String nome_arquivo){

        if(!Objects.equals(nome_arquivo,"Formulário ainda não avaliado")) {
            int count = 0;
            for (FormularioAvaliacao formulario : formularios_avaliacao) {
                if (Objects.equals(formulario.getNome_arquivo(), nome_arquivo)) {
                    System.out.println("\nO Formulário de Avaliação que avaliava o Formulário de Submissão deletado também será deletado, pois o Formulário de Submissão já foi avaliado.");
                    formularios_avaliacao.remove(count);
                    break;
                }
                count++;
            }
        }
    }

}
