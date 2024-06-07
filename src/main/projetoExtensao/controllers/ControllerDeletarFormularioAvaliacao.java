package main.projetoExtensao.controllers;

import main.projetoExtensao.formularios.formularioAvaliacao.models.FormularioAvaliacao;
import main.projetoExtensao.formularios.formularioSubmissao.FormularioSubmissao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerDeletarFormularioAvaliacao {
    private ArrayList<FormularioAvaliacao> formularios;
    private Scanner scanner;


    public ControllerDeletarFormularioAvaliacao(ArrayList<FormularioAvaliacao> formularios){
        this.formularios = formularios;
        scanner = new Scanner(System.in);
    }

    public String exibirFormularios(){
        String nome_arquivo_avaliado = "";
        if(formularios.isEmpty())
            System.out.println("Nenhum Formulário de Avaliação foi criado. É preciso criar um Formulário de Avaliação para poder Ver, Deletar ou Atualizar.\n");
        else {

            int opcao, indice;
            boolean condicao = true;

            while (condicao) {
                indice = 0;
                System.out.println("\n------- Lista de Formulários -------");
                for (FormularioAvaliacao formulario : formularios) {
                    System.out.println(indice + " - " + formulario.getNome_arquivo() + " (" + formulario.getAvaliando() + ")");
                    indice++;
                }
                System.out.println(indice + " - Voltar");

                System.out.print("\nQual desses documentos você deseja deletar (escolha pelo índice)? ");

                try {
                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    if (opcao >= 0 && opcao < formularios.size()) {
                        nome_arquivo_avaliado = formularios.get(opcao).getAvaliando();
                        deletarFormulario(formularios, opcao);
                        System.out.println("\nDocumento deletado com sucesso!");
                    } else if (opcao == indice)
                        condicao = false;
                    else
                        System.out.println("Escolha um dos índices disponíveis.");

                } catch (InputMismatchException e) {
                    System.out.println("Escolha pelo índice.");
                    scanner.nextLine();
                }
            }
        }
        return nome_arquivo_avaliado;
    }

    public void deletarFormulario(ArrayList<FormularioAvaliacao> formularios, int indice){
        formularios.remove(indice);
    }
}
