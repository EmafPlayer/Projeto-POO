package main.projetoExtensao.controllers;

import main.projetoExtensao.formularios.formularioAvaliacao.enuns.EnumAtende;
import main.projetoExtensao.formularios.formularioAvaliacao.enuns.EnumConsistente;
import main.projetoExtensao.formularios.formularioAvaliacao.enuns.EnumOpcao;
import main.projetoExtensao.formularios.formularioAvaliacao.enuns.EnumParecer;
import main.projetoExtensao.formularios.formularioAvaliacao.models.*;
import main.projetoExtensao.formularios.formularioSubmissao.enuns.EnumModalidade;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerVerFormularioAvaliacao {
    private FormularioAvaliacao formulario_avaliacao;
    private ArrayList<FormularioAvaliacao> formularios;
    private Scanner scanner;

    public ControllerVerFormularioAvaliacao(ArrayList<FormularioAvaliacao> formularios){
        this.formularios = formularios;
        formulario_avaliacao = new FormularioAvaliacao();
        scanner = new Scanner(System.in);
    }

    public void exibirFormularios(){
        if(formularios.isEmpty())
            System.out.println("Nenhum Formulário de Avaliação foi criado. É preciso criar um Formulário de Avaliação para poder Ver, Deletar ou Atualizar.\n");
        else {
            int opcao, indice;
            boolean condicao = true;

            while (condicao) {
                indice = 0;
                System.out.println("\n------- Lista de Formulários -------");
                for (FormularioAvaliacao formulario : formularios) {
                    System.out.println(indice + " - " + formulario.getNome_arquivo());
                    indice++;
                }
                System.out.println(indice + " - Voltar");

                System.out.print("\nQual desses documentos você deseja ver (escolha pelo índice)? ");

                try{
                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    if (opcao >= 0 && opcao < formularios.size()) {
                        formulario_avaliacao = formularios.get(opcao);
                        printDadosFormulario();
                    } else if (opcao == indice)
                        condicao = false;
                    else
                        System.out.println("Escolha um dos índices disponíveis.");

                } catch (InputMismatchException e){
                    System.out.println("Escolha pelo índice.");
                    scanner.nextLine();
                }
            }
        }
    }

    public void printDadosFormulario() {
        EnumModalidade modalidade = formulario_avaliacao.getModalidade();
        IdentificacaoProposta proposta = formulario_avaliacao.getProposta();
        CheckBoxOpcao titulo = formulario_avaliacao.getTitulo();
        CheckBoxConsistente fundamentacao_teorica = formulario_avaliacao.getFundamentacao_teorica();
        CheckBoxConsistente merito_proposta = formulario_avaliacao.getMerito_proposta();
        CheckBoxConsistente estrutura_projeto = formulario_avaliacao.getEstrutura_projeto();
        CheckBoxConsistente iteracao_conhecimento = formulario_avaliacao.getIteracao_conhecimento();
        CheckBoxConsistente publico_alvo = formulario_avaliacao.getPublico_alvo();
        CheckBoxOpcao cronograma = formulario_avaliacao.getCronograma();
        CheckBoxConsistente recursos = formulario_avaliacao.getRecursos();
        CheckBoxConsistente resultados_esperados = formulario_avaliacao.getResultados_esperados();
        CheckBoxOpcao avaliacao = formulario_avaliacao.getAvaliacao();
        CheckBoxOpcao extensao = formulario_avaliacao.getExtensao();
        CheckBoxParecer parecer = formulario_avaliacao.getParecer();
        CheckBoxAtende[] natureza_academica = formulario_avaliacao.getNatureza_academica();
        CheckBoxAtende[] relacoes_sociedade = formulario_avaliacao.getRelacoes_sociedade();;

        EnumConsistente consistente;
        EnumOpcao opcao;
        EnumAtende atende;
        EnumParecer parece;


        System.out.println("\n\n\n---------------------------- " + formulario_avaliacao.getNome_arquivo() + " (" + formulario_avaliacao.getAvaliando() + ") ----------------------------");

        System.out.println("\nAVALIADOR(A):\n" + formulario_avaliacao.getAvaliador());

        System.out.println("\nCOLEGIADO:\n" + formulario_avaliacao.getColegiado());

        System.out.println("\nMODALIDADE DA PROPOSTA:");
        System.out.println(modalidade.getTexto());

        System.out.println("\n------------ IDENTIFICAÇÃO DA PROPOSTA ------------");
        System.out.println("COORDENADOR(A): " + proposta.getCoordenador());
        System.out.println("COLEGIADO/SETOR: " + proposta.getColegiado_setor());
        System.out.println("TÍTULO DA PROPOSTA: " + proposta.getTitulo_proposta());

        opcao = titulo.getOpcao();
        System.out.println("\nO título condiz com a proposta apresentada?\n" + opcao.getTexto());
        System.out.println("CONSIDERAÇÕES SOBRE O TÍTULO:\n" + titulo.getConsideracoes());

        System.out.println("CONSIDERAÇÕES SOBRE OS OBJETIVOS (Geral e Específicos):\n" + formulario_avaliacao.getConsideracoes_objetivos());


        System.out.println("\n------------ ANÁLISE DO MÉRITO E RELEVÂNCIA SOCIAL DO PROJETO/PROPOSTA ------------");
        System.out.println("\n01 - NATUREZA ACADÊMICA:");

        atende = natureza_academica[0].getOpcao();
        System.out.println("Quanto à contribuição para aprimoramento e/ou reformulações de concepções e práticas curriculares da Universidade;\n" + atende.getTexto());
        atende = natureza_academica[1].getOpcao();
        System.out.println("Quanto à sistematização/divulgação do conhecimento produzido pela proposta;\n" + atende.getTexto());
        atende = natureza_academica[2].getOpcao();
        System.out.println("Quanto ao cumprimento do preceito da indissociabilidade entre extensão, ensino e pesquisa, com intuito de integrar as ações para atender as demandas da sociedade e/ou público-alvo, de modo a demonstrar a natureza extensionista da proposta;\n" + atende.getTexto());
        atende = natureza_academica[3].getOpcao();
        System.out.println("Quanto à implementação do processo de socialização do conhecimento acadêmico de modo que os resultados oriundos das ações contribuam na formação técnico-científica, cultural, social e pessoal dos acadêmicos.\n" + atende.getTexto());
        System.out.println("CONSIDERAÇÕES SOBRE O ITEM “NATUREZA ACADÊMICA”:\n" +  natureza_academica[0].getConsideracoes());

        System.out.println("\n02 - RELAÇÕES COM A SOCIEDADE:");
        atende = relacoes_sociedade[0].getOpcao();
        System.out.println("A ação propõe indicadores que apontam relação integradora e/ou transformadora entre a Universidade e a Sociedade, de forma que haja contribuição à inclusão de grupos sociais e ampliação de oportunidades educacionais;\n" + atende.getTexto());
        atende = relacoes_sociedade[1].getOpcao();
        System.out.println("A ação propõe indicadores que apontam estabelecimento de mecanismos de diálogo entre o saber acadêmico e o saber popular, visando a geração de novos conhecimentos;\n" + atende.getTexto());
        atende = relacoes_sociedade[2].getOpcao();
        System.out.println("A ação propõe indicadores que apontam contribuição para o desenvolvimento econômico, social e cultural priorizando especificidades regionais, por meio de propostas, formulação e acompanhamento das políticas públicas.\n" + atende.getTexto());
        System.out.println("CONSIDERAÇÕES SOBRE O ITEM “RELAÇÃO COM A SOCIEDADE”:\n" +  relacoes_sociedade[0].getConsideracoes());

        consistente = fundamentacao_teorica.getOpcao();
        System.out.println("\n03 - FUNDAMENTAÇÃO TEÓRICA:");
        System.out.println("A base teórica que fundamenta a proposta encontra-se:\n" + consistente.getTexto());
        System.out.println("CONSIDERAÇÕES SOBRE O ITEM “FORMULAÇÃO TEÓRICA”:\n" + fundamentacao_teorica.getConsideracoes());

        consistente = merito_proposta.getOpcao();
        System.out.println("\n04 - MÉRITO DA PROPOSTA:");
        System.out.println("Quanto à coerência lógica entre os itens: relevância, metas e objetivos relacionados aos resultados esperados, a proposta encontra-se:\n" + consistente.getTexto());
        System.out.println("CONSIDERAÇÕES SOBRE O ITEM “MÉRITO DA PROPOSTA”:\n" + merito_proposta.getConsideracoes());

        consistente = estrutura_projeto.getOpcao();
        System.out.println("\n05 - ESTRUTURA DO PROJETO:");
        System.out.println("Quanto à estrutura e metodologia a proposta encontra-se:\n" + consistente.getTexto());
        System.out.println("CONSIDERAÇÕES SOBRE O ITEM “ESTRUTURA DO PROJETO”:\n" + estrutura_projeto.getConsideracoes());

        consistente = iteracao_conhecimento.getOpcao();
        System.out.println("\n06 - INTERAÇÃO DO CONHECIMENTO:");
        System.out.println("Quanto à interdisciplinaridade e/ou multidisciplinaridade a proposta encontra-se:\n" + consistente.getTexto());
        System.out.println("CONSIDERAÇÕES SOBRE O ITEM “INTERAÇÃO DO CONHECIMENTO”:\n" + iteracao_conhecimento.getConsideracoes());

        consistente = publico_alvo.getOpcao();
        System.out.println("\n07 - PÚBLICO ALVO:");
        System.out.println("Quanto à descrição e ao quantitativo do público alvo a proposta encontra-se:\n" + consistente.getTexto());
        System.out.println("CONSIDERAÇÕES SOBRE O ITEM “PÚBLICO ALVO”:\n" + publico_alvo.getConsideracoes());

        opcao = cronograma.getOpcao();
        System.out.println("\n08 - CRONOGRAMA:");
        System.out.println("Quanto à exequibilidade do cronograma em relação às atividades da proposta para obtenção dos resultados esperados, a proposição encontra-se adequada e/ou suficiente?\n" + opcao.getTexto());
        System.out.println("SUGESTÕES DAS ADEQUAÇÕES “CRONOGRAMA”:\n" + cronograma.getConsideracoes());

        consistente = recursos.getOpcao();
        System.out.println("\n09 - RECURSOS:");
        System.out.println("Quanto à discriminação dos recursos e custos:\n" + consistente.getTexto());
        System.out.println("CONSIDERAÇÕES SOBRE O ITEM “RECURSOS”:\n" + recursos.getConsideracoes());

        consistente = resultados_esperados.getOpcao();
        System.out.println("\n10 - RESULTADOS ESPERADOS:");
        System.out.println("Quanto aos resultados esperados, bem como os benefícios potenciais para a Sociedade a proposta encontra-se:\n" + consistente.getTexto());
        System.out.println("CONSIDERAÇÕES SOBRE O ITEM “RESULTADOS ESPERADOS”:\n" + resultados_esperados.getConsideracoes());

        opcao = cronograma.getOpcao();
        System.out.println("\n11 - AVALIAÇÃO:");
        System.out.println("A proposta estabelece indicadores adequados que favoreçam a melhor forma de avaliar o que se pretende com o projeto?\n" + opcao.getTexto());
        System.out.println("CONSIDERAÇÕES SOBRE O ITEM “AVALIAÇÃO”:\n" + avaliacao.getConsideracoes());

        opcao = cronograma.getOpcao();
        System.out.println("\n12 - EXTENSÃO:");
        System.out.println("A proposta apresentada realmente trata de atividade de extensão?\n" + opcao.getTexto());
        System.out.println("CONSIDERAÇÕES SOBRE O ITEM “EXTENSÃO”:\n" + extensao.getConsideracoes());

        parece = parecer.getOpcao();
        System.out.println("\n------------ PARECER ------------");
        System.out.println(parece.getTexto());
        System.out.println("FUNDAMENTAÇÃO GERAL DA ANÁLISE DA PROPOSTA (PREENCHIMENTO OBRIGATÓRIO)");
        System.out.println(parecer.getConsideracoes());

        System.out.println("\nLOCAL E DATA:");
        System.out.println(formulario_avaliacao.getLocal_data());

    }

}
