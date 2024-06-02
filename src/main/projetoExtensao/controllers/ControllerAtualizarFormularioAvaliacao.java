package main.projetoExtensao.controllers;

import main.projetoExtensao.formularios.formularioAvaliacao.enuns.EnumAtende;
import main.projetoExtensao.formularios.formularioAvaliacao.enuns.EnumConsistente;
import main.projetoExtensao.formularios.formularioAvaliacao.enuns.EnumOpcao;
import main.projetoExtensao.formularios.formularioAvaliacao.enuns.EnumParecer;
import main.projetoExtensao.formularios.formularioAvaliacao.models.*;
import main.projetoExtensao.formularios.formularioSubmissao.enuns.EnumModalidade;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class ControllerAtualizarFormularioAvaliacao extends ControllerCriarFormularioAvaliacao{
    private ArrayList<FormularioAvaliacao> formularios;

    public ControllerAtualizarFormularioAvaliacao(ArrayList<FormularioAvaliacao> formularios){
        super();
        this.formularios = formularios;
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

                System.out.print("\nQual desses documentos você deseja atualizar (escolha pelo índice)? ");

                try{
                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    if (opcao >= 0 && opcao < formularios.size()) {
                        formulario_avaliacao = formularios.get(opcao);
                        atualizarFormularioAvaliacao();
                        System.out.println("\nDocumento Atualizado com sucesso!");
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

    public void atualizarFormularioAvaliacao(){
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
        boolean condicao = true;



        while (condicao) {

            System.out.println("\n\n\n---------------------------- " + formulario_avaliacao.getNome_arquivo() + " ----------------------------");

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
            System.out.println("CONSIDERAÇÕES SOBRE O ITEM “NATUREZA ACADÊMICA”:\n" + natureza_academica[0].getConsideracoes());

            System.out.println("\n02 - RELAÇÕES COM A SOCIEDADE:");
            atende = relacoes_sociedade[0].getOpcao();
            System.out.println("A ação propõe indicadores que apontam relação integradora e/ou transformadora entre a Universidade e a Sociedade, de forma que haja contribuição à inclusão de grupos sociais e ampliação de oportunidades educacionais;\n" + atende.getTexto());
            atende = relacoes_sociedade[1].getOpcao();
            System.out.println("A ação propõe indicadores que apontam estabelecimento de mecanismos de diálogo entre o saber acadêmico e o saber popular, visando a geração de novos conhecimentos;\n" + atende.getTexto());
            atende = relacoes_sociedade[2].getOpcao();
            System.out.println("A ação propõe indicadores que apontam contribuição para o desenvolvimento econômico, social e cultural priorizando especificidades regionais, por meio de propostas, formulação e acompanhamento das políticas públicas.\n" + atende.getTexto());
            System.out.println("CONSIDERAÇÕES SOBRE O ITEM “RELAÇÃO COM A SOCIEDADE”:\n" + relacoes_sociedade[0].getConsideracoes());

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

            System.out.println("\n13 - Modificar as Observações sobre o Título");
            System.out.println("14 - Modificar as Considerações sobre os Objetivos");
            System.out.println("15 - Modificar o Parecer");
            System.out.println("16 - Modificar Local e Data");
            System.out.println("17 - Modificar o Avaliador");
            System.out.println("18 - Modificar o Colegiado");
            System.out.println("19 - Modificar o Nome do Arquivo");

            System.out.println("0 - Voltar");


            System.out.println("\nQual desses campos você deseja alterar (escolha pelo índice)? ");
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                switch (input) {

                    case 1:
                        modificarNaturezaAcademica(formulario_avaliacao);
                        break;

                    case 2:
                        modificarRelacoesSociedade(formulario_avaliacao);
                        break;

                    case 3:
                        modificarFundamentacaoTeorica(formulario_avaliacao);
                        break;

                    case 4:
                        modificarMeritoProposta(formulario_avaliacao);
                        break;

                    case 5:
                        modificarEstruturaProjeto(formulario_avaliacao);
                        break;

                    case 6:
                        modificarIteracaoConhecimento(formulario_avaliacao);
                        break;

                    case 7:
                        modificarPublicoAlvo(formulario_avaliacao);
                        break;

                    case 8:
                        modificarCronograma(formulario_avaliacao);
                        break;

                    case 9:
                        modificarRecursos(formulario_avaliacao);
                        break;

                    case 10:
                        modificarResultadosEsperados(formulario_avaliacao);
                        break;

                    case 11:
                        modificarAvaliacao(formulario_avaliacao);
                        break;

                    case 12:
                        modificarExtensao(formulario_avaliacao);
                        break;

                    case 13:
                        modificarObservacoesTitulo(formulario_avaliacao);
                        break;

                    case 14:
                        modificarConsideracoesObjetivos(formulario_avaliacao);
                        break;

                    case 15:
                        modificarParecer(formulario_avaliacao);
                        break;

                    case 16:
                        modificarLocalData(formulario_avaliacao);
                        break;

                    case 17:
                        modificarAvaliador(formulario_avaliacao);
                        break;

                    case 18:
                        modificarColegiado(formulario_avaliacao);
                        break;

                    case 19:
                        modificarNomeArquivo(formulario_avaliacao);
                        break;

                    case 0:
                        condicao = false;
                        break;

                    default:
                        System.out.println("Escolha um dos índices disponíveis.");
                        break;

                }

            } catch (InputMismatchException e) {
                System.out.println("Escolha pelo índice.");
                scanner.nextLine();
            }
        }

    }

    public void modificarNaturezaAcademica(FormularioAvaliacao formulario_avaliacao){
        CheckBoxAtende[] natureza_academica = formulario_avaliacao.getNatureza_academica();

        System.out.println("\n01 - NATUREZA ACADÊMICA (Novo):");
        natureza_academica[0].setOpcao(perguntaAtende("Quanto à contribuição para aprimoramento e/ou reformulações de concepções e práticas curriculares da Universidade;"));
        natureza_academica[1].setOpcao(perguntaAtende("Quanto à sistematização/divulgação do conhecimento produzido pela proposta;"));
        natureza_academica[2].setOpcao(perguntaAtende("Quanto ao cumprimento do preceito da indissociabilidade entre extensão, ensino e pesquisa, com intuito de integrar as ações para atender as demandas da sociedade e/ou público-alvo, de modo a demonstrar a natureza extensionista da proposta;"));
        natureza_academica[3].setOpcao(perguntaAtende("Quanto à implementação do processo de socialização do conhecimento acadêmico de modo que os resultados oriundos das ações contribuam na formação técnico-científica, cultural, social e pessoal dos acadêmicos."));
        natureza_academica[0].setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “NATUREZA ACADÊMICA” (Opcional):"));
    }

    public void modificarRelacoesSociedade(FormularioAvaliacao formulario_avaliacao){
        CheckBoxAtende[] relacoes_sociedade = formulario_avaliacao.getRelacoes_sociedade();

        System.out.println("\n02 - RELAÇÕES COM A SOCIEDADE (Novo):");
        relacoes_sociedade[0].setOpcao(perguntaAtende("A ação propõe indicadores que apontam relação integradora e/ou transformadora entre a Universidade e a Sociedade, de forma que haja contribuição à inclusão de grupos sociais e ampliação de oportunidades educacionais;"));
        relacoes_sociedade[1].setOpcao(perguntaAtende("A ação propõe indicadores que apontam estabelecimento de mecanismos de diálogo entre o saber acadêmico e o saber popular, visando a geração de novos conhecimentos;"));
        relacoes_sociedade[2].setOpcao(perguntaAtende("A ação propõe indicadores que apontam contribuição para o desenvolvimento econômico, social e cultural priorizando especificidades regionais, por meio de propostas, formulação e acompanhamento das políticas públicas."));
        relacoes_sociedade[0].setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “RELAÇÃO COM A SOCIEDADE” (Opcional):"));


    }

    public void modificarFundamentacaoTeorica(FormularioAvaliacao formulario_avaliacao){
        CheckBoxConsistente fundamentacao_teorica = formulario_avaliacao.getFundamentacao_teorica();

        System.out.println("\n03 - FUNDAMENTAÇÃO TEÓRICA (Novo):");
        fundamentacao_teorica.setOpcao(perguntaConsistente("A base teórica que fundamenta a proposta encontra-se:"));
        fundamentacao_teorica.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “FORMULAÇÃO TEÓRICA” (Opcional):"));
    }

    public void modificarMeritoProposta(FormularioAvaliacao formulario_avaliacao){
        CheckBoxConsistente merito_proposta = formulario_avaliacao.getMerito_proposta();

        System.out.println("\n04 - MÉRITO DA PROPOSTA (Novo):");
        merito_proposta.setOpcao(perguntaConsistente("Quanto à coerência lógica entre os itens: relevância, metas e objetivos relacionados aos resultados esperados, a proposta encontra-se:"));
        merito_proposta.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “MÉRITO DA PROPOSTA” (Opcional):"));
    }

    public void modificarEstruturaProjeto(FormularioAvaliacao formulario_avaliacao){
        CheckBoxConsistente estrutura_projeto = formulario_avaliacao.getEstrutura_projeto();

        System.out.println("\n05 - ESTRUTURA DO PROJETO (Novo):");
        estrutura_projeto.setOpcao(perguntaConsistente("Quanto à estrutura e metodologia a proposta encontra-se:"));
        estrutura_projeto.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “ESTRUTURA DO PROJETO” (Opcional):"));
    }

    public void modificarIteracaoConhecimento(FormularioAvaliacao formulario_avaliacao){
        CheckBoxConsistente iteracao_conhecimento = formulario_avaliacao.getIteracao_conhecimento();

        System.out.println("\n06 - INTERAÇÃO DO CONHECIMENTO (Novo):");
        iteracao_conhecimento.setOpcao(perguntaConsistente("Quanto à interdisciplinaridade e/ou multidisciplinaridade a proposta encontra-se:"));
        iteracao_conhecimento.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “INTERAÇÃO DO CONHECIMENTO” (Opcional):"));
    }

    public void modificarPublicoAlvo(FormularioAvaliacao formulario_avaliacao){
        CheckBoxConsistente publico_alvo = formulario_avaliacao.getPublico_alvo();

        System.out.println("\n07 - PÚBLICO ALVO (Novo):");
        publico_alvo.setOpcao(perguntaConsistente("Quanto à descrição e ao quantitativo do público alvo a proposta encontra-se:"));
        publico_alvo.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “PÚBLICO ALVO” (Opcional):"));
    }

    public void modificarCronograma(FormularioAvaliacao formulario_avaliacao){
        CheckBoxOpcao cronograma = formulario_avaliacao.getCronograma();

        System.out.println("\n08 - CRONOGRAMA (Novo):");
        cronograma.setOpcao(perguntaOpcao("Quanto à exequibilidade do cronograma em relação às atividades da proposta para obtenção dos resultados esperados, a proposição encontra-se adequada e/ou suficiente?"));
        cronograma.setConsideracoes(pergunta("SUGESTÕES DAS ADEQUAÇÕES “CRONOGRAMA” (Opcional):"));
    }

    public void modificarRecursos(FormularioAvaliacao formulario_avaliacao){
        CheckBoxConsistente recursos = formulario_avaliacao.getRecursos();

        System.out.println("\n09 - RECURSOS (Novo):");
        recursos.setOpcao(perguntaConsistente("Quanto à discriminação dos recursos e custos:"));
        recursos.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “RECURSOS” (Opcional):"));
    }

    public void modificarResultadosEsperados(FormularioAvaliacao formulario_avaliacao){
        CheckBoxConsistente resultados_esperados = formulario_avaliacao.getResultados_esperados();

        System.out.println("\n10 - RESULTADOS ESPERADOS (Novo):");
        resultados_esperados.setOpcao(perguntaConsistente("Quanto aos resultados esperados, bem como os benefícios potenciais para a Sociedade a proposta encontra-se:"));
        resultados_esperados.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “RESULTADOS ESPERADOS” (Opcional):"));
    }

    public void modificarAvaliacao(FormularioAvaliacao formulario_avaliacao){
        CheckBoxOpcao avaliacao = formulario_avaliacao.getAvaliacao();

        System.out.println("\n11 - AVALIAÇÃO (Novo):");
        avaliacao.setOpcao(perguntaOpcao("A proposta estabelece indicadores adequados que favoreçam a melhor forma de avaliar o que se pretende com o projeto?"));
        avaliacao.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “AVALIAÇÃO” (opcional):"));
    }

    public void modificarExtensao(FormularioAvaliacao formulario_avaliacao){
        CheckBoxOpcao extensao = formulario_avaliacao.getExtensao();

        System.out.println("\n12 - EXTENSÃO (Novo):");
        extensao.setOpcao(perguntaOpcao("A proposta apresentada realmente trata de atividade de extensão?"));
        extensao.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O ITEM “EXTENSÃO” (Opcional):"));
    }

    public void modificarObservacoesTitulo(FormularioAvaliacao formulario_avaliacao){
        CheckBoxOpcao titulo = formulario_avaliacao.getTitulo();

        titulo.setOpcao(perguntaOpcaoTitulo("O título condiz com a proposta apresentada?"));
        titulo.setConsideracoes(pergunta("CONSIDERAÇÕES SOBRE O TÍTULO (Opcional):"));
    }

    public void modificarConsideracoesObjetivos(FormularioAvaliacao formulario_avaliacao){
        System.out.println("\nCONSIDERAÇÕES SOBRE OS OBJETIVOS (Geral e Específicos):");
        String texto = scanner.nextLine();
        formulario_avaliacao.setConsideracoes_objetivos(texto);
    }

    public void modificarParecer(FormularioAvaliacao formulario_avaliacao){
        CheckBoxParecer parecer = formulario_avaliacao.getParecer();

        System.out.println("\n------------ PARECER (Novo) ------------");
        parecer.setOpcao(perguntaParecer());
        System.out.println("FUNDAMENTAÇÃO GERAL DA ANÁLISE DA PROPOSTA (PREENCHIMENTO OBRIGATÓRIO)");
        String texto = scanner.nextLine();
        parecer.setConsideracoes(texto);
    }

    public void modificarLocalData(FormularioAvaliacao formulario_avaliacao){
        System.out.println("\nLOCAL E DATA (Novo):");
        String texto = scanner.nextLine();
        formulario_avaliacao.setLocal_data(texto);
    }

    public void modificarAvaliador(FormularioAvaliacao formulario_avaliacao){
        System.out.println("\nAVALIADOR(A) (Novo):");
        String texto = scanner.nextLine();
        formulario_avaliacao.setAvaliador(texto);
    }

    public void modificarColegiado(FormularioAvaliacao formulario_avaliacao){
        System.out.println("\nCOLEGIADO (Novo):");
        String texto = scanner.nextLine();
        formulario_avaliacao.setColegiado(texto);
    }

    public void modificarNomeArquivo(FormularioAvaliacao formulario_avaliacao){
        System.out.println("\nQual nome você deseja dar ao documento?");
        String nome_arquivo = scanner.nextLine();
        formulario_avaliacao.setNome_arquivo(nome_arquivo);
    }
}
