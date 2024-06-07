package main.projetoExtensao.controllers;

import main.projetoExtensao.formularios.formularioAvaliacao.models.FormularioAvaliacao;
import main.projetoExtensao.formularios.formularioSubmissao.FormularioSubmissao;
import main.projetoExtensao.formularios.formularioSubmissao.models.*;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class ControllerDeletarFormularioSubmissao extends ControllerVerFormularioSubmissao {
    private ArrayList<FormularioAvaliacao> formularios_avaliacoes;

    public ControllerDeletarFormularioSubmissao(
            ArrayList<Curso> cursos,
            ArrayList<EmpresaJunior> empresas_juniors,
            ArrayList<Evento> eventos,
            ArrayList<LigaAcademica> ligas_cademicas,
            ArrayList<NucleoTematico> nucleos_tematicos,
            ArrayList<PrestacaoServico> prestacoes_servicos,
            ArrayList<Programa> programas,
            ArrayList<Projeto> projetos,
            ArrayList<FormularioAvaliacao> formularios_avaliacoes){
        super(cursos, empresas_juniors, eventos, ligas_cademicas, nucleos_tematicos, prestacoes_servicos, programas, projetos);
        this.formularios_avaliacoes = formularios_avaliacoes;
    }

    public <T extends FormularioSubmissao> void printNomesFormularios(ArrayList<T> formularios){
        boolean condicao = true;

        if(formularios.isEmpty())
            System.out.println("\n Não há formulários dessa modalidade\n");
        else {
            int indice = 0;

            System.out.println("------- Lista de Formulários -------");
            for (T formulario : formularios) {
                System.out.println(indice + " - " + formulario.getNome_arquivo());
                indice++;
            }
            System.out.print("\n");

            while (condicao) {

                System.out.print("Qual desses documentos você deseja deletar (escolha pelo índice)? ");

                try{
                    indice = scanner.nextInt();
                    scanner.nextLine();

                    if (indice >= 0 && indice < formularios.size()) {
                        String nome_avaliador = formularios.get(indice).getAvaliador();
                        deletarFormulario(formularios, indice);
                        System.out.println("\nDocumento deletado com sucesso!");
                        ControllerConexao.deleteAvaliador(formularios_avaliacoes, nome_avaliador);
                        condicao = false;
                    }
                    else
                        System.out.println("Escolha um dos índices disponíveis.");

                } catch (InputMismatchException e){
                    System.out.println("Escolha pelo índice.");
                    scanner.nextLine();
                }

            }
            this.condicao = false;
        }
    }

    public <T extends FormularioSubmissao> void deletarFormulario(ArrayList<T> formularios, int indice){
        formularios.remove(indice);
    }

}
