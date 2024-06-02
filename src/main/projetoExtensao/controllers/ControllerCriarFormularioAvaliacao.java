package main.projetoExtensao.controllers;

import main.projetoExtensao.formularios.formularioAvaliacao.enuns.EnumAtende;
import main.projetoExtensao.formularios.formularioAvaliacao.enuns.EnumConsistente;
import main.projetoExtensao.formularios.formularioAvaliacao.enuns.EnumOpcao;
import main.projetoExtensao.formularios.formularioAvaliacao.enuns.EnumParecer;
import main.projetoExtensao.formularios.formularioAvaliacao.models.*;
import main.projetoExtensao.formularios.formularioSubmissao.FormularioSubmissao;
import main.projetoExtensao.formularios.formularioSubmissao.models.Coordenador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerCriarFormularioAvaliacao {
    protected Scanner scanner;
    protected FormularioAvaliacao formulario_avaliacao;

    public ControllerCriarFormularioAvaliacao(){
        scanner = new Scanner(System.in);
        formulario_avaliacao = new FormularioAvaliacao();
    }

    public FormularioAvaliacao criarFormulario(FormularioSubmissao formulario_subimissao){
        String nome_arquivo;
        IdentificacaoProposta proposta = formulario_avaliacao.getProposta();
        CheckBoxOpcao titulo = formulario_avaliacao.getTitulo();
        CheckBoxAtende[] natureza_academica = formulario_avaliacao.getNatureza_academica();
        CheckBoxAtende[] relacoes_sociedade = formulario_avaliacao.getRelacoes_sociedade();
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
        Coordenador coordenador = formulario_subimissao.getCoordenador();

        formulario_avaliacao.setModalidade(formulario_subimissao.getModalidade());
        proposta.setCoordenador(coordenador.getNome());
        proposta.setColegiado_setor(formulario_subimissao.getColegiado_campus());
        proposta.setTitulo_proposta(formulario_subimissao.getTitulo_proposta());


        try {
            System.out.println("\nQual nome você deseja dar ao documento? ");
            nome_arquivo = scanner.nextLine();
            formulario_avaliacao.setNome_arquivo(nome_arquivo);

            System.out.println("\nAVALIADOR(A):");
            String texto = scanner.nextLine();
            formulario_avaliacao.setAvaliador(texto);

            System.out.println("\nCOLEGIADO:");
            texto = scanner.nextLine();
            formulario_avaliacao.setColegiado(texto);

        }catch (InputMismatchException e){
            System.out.println("Erro ao inserir os dados");
            scanner.nextLine();
        }

        titulo.setOpcao(perguntaOpcaoTitulo("O título condiz com a proposta apresentada?"));
        titulo.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O TÍTULO (Opcional):"));
        System.out.println("\nCONSIDERAÇÕES SOBRE OS OBJETIVOS (Geral e Específicos):");
        String texto = scanner.nextLine();
        formulario_avaliacao.setConsideracoes_objetivos(texto);

        System.out.println("\n------------ ANÁLISE DO MÉRITO E RELEVÂNCIA SOCIAL DO PROJETO/PROPOSTA ------------");
        System.out.println("\n01 - NATUREZA ACADÊMICA:");
        natureza_academica[0].setOpcao(perguntaAtende("Quanto à contribuição para aprimoramento e/ou reformulações de concepções e práticas curriculares da Universidade;"));
        natureza_academica[1].setOpcao(perguntaAtende("Quanto à sistematização/divulgação do conhecimento produzido pela proposta;"));
        natureza_academica[2].setOpcao(perguntaAtende("Quanto ao cumprimento do preceito da indissociabilidade entre extensão, ensino e pesquisa, com intuito de integrar as ações para atender as demandas da sociedade e/ou público-alvo, de modo a demonstrar a natureza extensionista da proposta;"));
        natureza_academica[3].setOpcao(perguntaAtende("Quanto à implementação do processo de socialização do conhecimento acadêmico de modo que os resultados oriundos das ações contribuam na formação técnico-científica, cultural, social e pessoal dos acadêmicos."));
        natureza_academica[0].setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “NATUREZA ACADÊMICA” (Opcional):"));

        System.out.println("\n02 - RELAÇÕES COM A SOCIEDADE:");
        relacoes_sociedade[0].setOpcao(perguntaAtende("A ação propõe indicadores que apontam relação integradora e/ou transformadora entre a Universidade e a Sociedade, de forma que haja contribuição à inclusão de grupos sociais e ampliação de oportunidades educacionais;"));
        relacoes_sociedade[1].setOpcao(perguntaAtende("A ação propõe indicadores que apontam estabelecimento de mecanismos de diálogo entre o saber acadêmico e o saber popular, visando a geração de novos conhecimentos;"));
        relacoes_sociedade[2].setOpcao(perguntaAtende("A ação propõe indicadores que apontam contribuição para o desenvolvimento econômico, social e cultural priorizando especificidades regionais, por meio de propostas, formulação e acompanhamento das políticas públicas."));
        relacoes_sociedade[0].setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “RELAÇÃO COM A SOCIEDADE” (Opcional):"));

        System.out.println("\n03 - FUNDAMENTAÇÃO TEÓRICA:");
        fundamentacao_teorica.setOpcao(perguntaConsistente("A base teórica que fundamenta a proposta encontra-se:"));
        fundamentacao_teorica.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “FORMULAÇÃO TEÓRICA” (Opcional):"));

        System.out.println("\n04 - MÉRITO DA PROPOSTA:");
        merito_proposta.setOpcao(perguntaConsistente("Quanto à coerência lógica entre os itens: relevância, metas e objetivos relacionados aos resultados esperados, a proposta encontra-se:"));
        merito_proposta.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “MÉRITO DA PROPOSTA” (Opcional):"));

        System.out.println("\n05 - ESTRUTURA DO PROJETO:");
        estrutura_projeto.setOpcao(perguntaConsistente("Quanto à estrutura e metodologia a proposta encontra-se:"));
        estrutura_projeto.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “ESTRUTURA DO PROJETO” (Opcional):"));

        System.out.println("\n06 - INTERAÇÃO DO CONHECIMENTO:");
        iteracao_conhecimento.setOpcao(perguntaConsistente("Quanto à interdisciplinaridade e/ou multidisciplinaridade a proposta encontra-se:"));
        iteracao_conhecimento.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “INTERAÇÃO DO CONHECIMENTO” (Opcional):"));

        System.out.println("\n07 - PÚBLICO ALVO:");
        publico_alvo.setOpcao(perguntaConsistente("Quanto à descrição e ao quantitativo do público alvo a proposta encontra-se:"));
        publico_alvo.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “PÚBLICO ALVO” (Opcional):"));

        System.out.println("\n08 - CRONOGRAMA:");
        cronograma.setOpcao(perguntaOpcao("Quanto à exequibilidade do cronograma em relação às atividades da proposta para obtenção dos resultados esperados, a proposição encontra-se adequada e/ou suficiente?"));
        cronograma.setConsideracoes(pergunta("SUGESTÕES DAS ADEQUAÇÕES “CRONOGRAMA” (Opcional):"));

        System.out.println("\n09 - RECURSOS:");
        recursos.setOpcao(perguntaConsistente("Quanto à discriminação dos recursos e custos:"));
        recursos.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “RECURSOS” (Opcional):"));

        System.out.println("\n10 - RESULTADOS ESPERADOS:");
        resultados_esperados.setOpcao(perguntaConsistente("Quanto aos resultados esperados, bem como os benefícios potenciais para a Sociedade a proposta encontra-se:"));
        resultados_esperados.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “RESULTADOS ESPERADOS” (Opcional):"));

        System.out.println("\n11 - AVALIAÇÃO:");
        avaliacao.setOpcao(perguntaOpcao("A proposta estabelece indicadores adequados que favoreçam a melhor forma de avaliar o que se pretende com o projeto?"));
        avaliacao.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “AVALIAÇÃO” (opcional):"));

        System.out.println("\n12 - EXTENSÃO:");
        extensao.setOpcao(perguntaOpcao("A proposta apresentada realmente trata de atividade de extensão?"));
        extensao.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “EXTENSÃO” (Opcional):"));

        try {
            System.out.println("\n------------ PARECER ------------");
            parecer.setOpcao(perguntaParecer());
            System.out.println("FUNDAMENTAÇÃO GERAL DA ANÁLISE DA PROPOSTA (PREENCHIMENTO OBRIGATÓRIO)");
            texto = scanner.nextLine();
            parecer.setConsideracoes(texto);

            System.out.println("\nLOCAL E DATA:");
            texto = scanner.nextLine();
            formulario_avaliacao.setLocal_data(texto);

        }catch (InputMismatchException e){
            System.out.println("Erro ao inserir os dados");
            scanner.nextLine();
        }

        return formulario_avaliacao;
    }

    public EnumAtende perguntaAtende(String corpo){
        int opcao = 0;
        EnumAtende atende = EnumAtende.VAZIO;

        while (opcao < 1 || opcao > 3) {
            System.out.println("\n" + corpo);
            System.out.println("1 - ATENDE\n2 - ATENDE PARCIALMENTE\n3 - NÃO ATENDE");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        atende = EnumAtende.ATENDE;
                        break;

                    case 2:
                        atende = EnumAtende.PARCIALMENTE;
                        break;

                    case 3:
                        atende = EnumAtende.NAO_ATENDE;
                        break;

                    default:
                        System.out.println("Esses campos são obrigatórios! Marque uma das opções disponíveis.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Selecione pelos índices disponíveis");
                scanner.nextLine();
            }
        }
        return atende;
    }

    public EnumOpcao perguntaOpcao(String corpo){
        int opcao = 0;
        EnumOpcao atende = EnumOpcao.VAZIO;

        while (opcao < 1 || opcao > 3) {
            System.out.println("\n" + corpo);
            System.out.println("1 - SIM\n2 - NÃO\n3 - PARCIALMENTE");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        atende = EnumOpcao.SIM;
                        break;

                    case 2:
                        atende = EnumOpcao.NAO;
                        break;

                    case 3:
                        atende = EnumOpcao.PARCIALMENTE;
                        break;

                    default:
                        System.out.println("Esses campos são obrigatórios! Marque uma das opções disponíveis.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Selecione pelos índices disponíveis");
                scanner.nextLine();
            }
        }
        return atende;
    }

    public EnumOpcao perguntaOpcaoTitulo(String corpo){
        int opcao = 0;
        EnumOpcao atende = EnumOpcao.VAZIO;

        while (opcao < 1 || opcao > 2) {
            System.out.println("\n" + corpo);
            System.out.println("1 - SIM\n2 - NÃO");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        atende = EnumOpcao.SIM;
                        break;

                    case 2:
                        atende = EnumOpcao.NAO;
                        break;

                    default:
                        System.out.println("Esses campos são obrigatórios! Marque uma das opções disponíveis.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Selecione pelos índices disponíveis");
                scanner.nextLine();
            }
        }
        return atende;
    }

    public EnumParecer perguntaParecer(){
        int opcao = 0;
        EnumParecer atende = EnumParecer.VAZIO;

        while (opcao < 1 || opcao > 3) {
            System.out.println("1 - RECOMENDADO\n2 - RECOMENDADO COM ADEQUAÇÕES NECESSÁRIAS\n3 - NÃO RECOMENDADO");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        atende = EnumParecer.RECOMENDO;
                        break;

                    case 2:
                        atende = EnumParecer.RECOMENDO_ADEQUACOES;
                        break;

                    case 3:
                        atende = EnumParecer.NAO_RECOMENDO;
                        break;

                    default:
                        System.out.println("Esses campos são obrigatórios! Marque uma das opções disponíveis.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Selecione pelos índices disponíveis");
                scanner.nextLine();
            }
        }
        return atende;
    }

    public EnumConsistente perguntaConsistente(String corpo){
        int opcao = 0;
        EnumConsistente atende = EnumConsistente.VAZIO;

        while (opcao < 1 || opcao > 3) {
            System.out.println("\n" + corpo);
            System.out.println("1 - CONSISTENTE\n2 - PARCIALMENTE CONSISTENTE\n3 - INCONSISTENTE");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        atende = EnumConsistente.CONSISTENTE;
                        break;

                    case 2:
                        atende = EnumConsistente.PARCIALMENTE;
                        break;

                    case 3:
                        atende = EnumConsistente.INCONSISTENTE;
                        break;

                    default:
                        System.out.println("Esses campos são obrigatórios! Marque uma das opções disponíveis.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Selecione pelos índices disponíveis");
                scanner.nextLine();
            }
        }
        return atende;
    }

    public String pergunta(String titulo) {
        boolean condicao = true;
        String texto = "Campo não preenchido";

        while (condicao) {
            System.out.println("\n" + titulo);
            System.out.println("0 - Preencher\n1 - Seguir");
            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 0:
                        System.out.println("Disserte:");
                        texto = scanner.nextLine();
                        condicao = false;
                        break;

                    case 1:
                        condicao = false;
                        break;

                    default:
                        System.out.println("Esses campos são obrigatórios! Marque uma das opções disponíveis.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Selecione pelos índices disponíveis");
                scanner.nextLine();
            }
        }
        return texto;
    }

}
