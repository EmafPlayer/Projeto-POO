package main.projetoExtensao.controllers;

import main.projetoExtensao.formularios.formularioSubmissao.FormularioSubmissao;
import main.projetoExtensao.formularios.formularioSubmissao.enuns.*;
import main.projetoExtensao.formularios.formularioSubmissao.models.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerCriarFormularioSubmissao {
    private Scanner scanner;
    private Curso curso;
    private EmpresaJunior empresa_junior;
    private Evento evento;
    private LigaAcademica liga_academica;
    private NucleoTematico nucleo_tematico;
    private PrestacaoServico prestacao_servico;
    private Programa programa;
    private Projeto projeto;


    public ControllerCriarFormularioSubmissao(){
        scanner = new Scanner(System.in);
    }

    public FormularioSubmissao iniciarFormulario(){
        int opcao = 0;
        String nome_arquivo;

        try {
            System.out.println("Qual nome você deseja dar ao documento? ");
            nome_arquivo = scanner.nextLine();
            while(opcao < 1 || opcao > 8) {
                System.out.println("\n========= FORMULÁRIO DE SUBMISSÃO DE AÇÃO DE EXTENSÃO =========\n");
                System.out.println("-------- Modalidade da Proposta de Extensão (marcar apenas uma) --------");
                System.out.println("1 - Programa\n2 - Projeto\n3 - Núcleo Temático\n4 - Evento\n5 - Empresa Junior\n6 - Liga Acadêmica\n7 - Prestação de Serviço\n8 - Curso\n");
                try {
                    opcao = scanner.nextInt();
                    switch (opcao) {
                        case 1:
                            programa = new Programa(nome_arquivo);
                            programa.setModalidade(EnumModalidade.PROGRAMA);
                            preencherAreaExtensao(programa);
                            return programa;


                        case 2:
                            projeto = new Projeto(nome_arquivo);
                            preencherAreaExtensao(projeto);
                            projeto.setModalidade(EnumModalidade.PROJETO);
                            return projeto;


                        case 3:
                            nucleo_tematico = new NucleoTematico(nome_arquivo);
                            preencherAreaExtensao(nucleo_tematico);
                            nucleo_tematico.setModalidade(EnumModalidade.NUCLEO_TEMATICO);
                            return nucleo_tematico;

                        case 4:
                            evento = new Evento(nome_arquivo);
                            criarFormularioEvento(evento);
                            evento.setModalidade(EnumModalidade.EVENTO);
                            return evento;

                        case 5:
                            empresa_junior = new EmpresaJunior(nome_arquivo);
                            preencherAreaExtensao(empresa_junior);
                            empresa_junior.setModalidade(EnumModalidade.EMPRESA_JUNIOR);
                            return empresa_junior;

                        case 6:
                            liga_academica = new LigaAcademica(nome_arquivo);
                            preencherAreaExtensao(liga_academica);
                            liga_academica.setModalidade(EnumModalidade.LIGA_ACADEMICA);
                            return liga_academica;

                        case 7:
                            prestacao_servico = new PrestacaoServico(nome_arquivo);
                            preencherAreaExtensao(prestacao_servico);
                            prestacao_servico.setModalidade(EnumModalidade.PRESTACAO_SERVICO);
                            return prestacao_servico;

                        case 8:
                            curso = new Curso(nome_arquivo);
                            criarFormularioCurso(curso);
                            curso.setModalidade(EnumModalidade.CURSO);
                            return curso;

                        default:
                            System.out.println("Esses campos são obrigatórios! Selecione um desses que estão disponíveis.");
                            break;

                    }
                } catch (InputMismatchException e) {
                    System.out.println("Esses campos são obrigatórios! Seleceione um desses que estão disponíveis.");
                    scanner.nextLine();
                }
            }
        } catch (InputMismatchException e){
            System.out.println("Digite um nome válido para o arquivo");
            scanner.nextLine();
        }
        return null;
    }

    public void criarFormularioEvento(Evento evento){
        int opcao = 0;


        while (opcao < 1 || opcao > 14) {
            System.out.println("\n-------- *Eventos --------");
            System.out.println("1 - Congresso\n2 - Conferência\n3 - Seminário\n4 - Fórum\n" +
                                "5 - Simpósio\n6 - Oficina\n7 - Palestra\n8 - Mesa redonda\n" +
                                "9 - Encontro\n10 - Workshop\n11 - Feira\n12 - Semana\n" +
                                "13 - Exposição\n14 - Festival\n");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        evento.setTipo_evento(EnumEvento.CONGRESSO);
                        break;

                    case 2:
                        evento.setTipo_evento(EnumEvento.CONFERENCIA);
                        break;

                    case 3:
                        evento.setTipo_evento(EnumEvento.SEMINARIO);
                        break;

                    case 4:
                        evento.setTipo_evento(EnumEvento.FORUM);
                        break;

                    case 5:
                        evento.setTipo_evento(EnumEvento.SIMPOSIO);
                        break;

                    case 6:
                        evento.setTipo_evento(EnumEvento.OFICINA);
                        break;

                    case 7:
                        evento.setTipo_evento(EnumEvento.PALESTRA);
                        break;

                    case 8:
                        evento.setTipo_evento(EnumEvento.MESA_REDONDA);
                        break;

                    case 9:
                        evento.setTipo_evento(EnumEvento.ENCONTRO);
                        break;

                    case 10:
                        evento.setTipo_evento(EnumEvento.WORKSHOP);
                        break;

                    case 11:
                        evento.setTipo_evento(EnumEvento.FEIRA);
                        break;

                    case 12:
                        evento.setTipo_evento(EnumEvento.SEMANA);
                        break;

                    case 13:
                        evento.setTipo_evento(EnumEvento.EXPOSICAO);
                        break;

                    case 14:
                        evento.setTipo_evento(EnumEvento.FESTIVAL);
                        break;

                    default:
                        System.out.println("Esses campos são obrigatórios! Marque um desses que estão disponíveis.");
                        break;
                }
                if(opcao >= 1 && opcao <= 14)
                    preencherAreaExtensao(evento);
            } catch (InputMismatchException e) {
                System.out.println("Esses campos são obrigatórios! Marque um desses que estão disponíveis.");
                scanner.nextLine();
            }
        }
    }

    public void criarFormularioCurso(Curso curso){
        int opcao = 0;

        while (opcao < 1 || opcao > 4) {
            System.out.println("\n-------- *Cursos --------");
            System.out.println("1 - Inicialiazação\n2 - Atualização\n3 - Formação\n4 - Qualificação/Aperfeiçoamento\n");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        curso.setTipo_curso(EnumCursos.INICIALIZACAO);
                        break;

                    case 2:
                        curso.setTipo_curso(EnumCursos.ATUALIZACAO);
                        break;

                    case 3:
                        curso.setTipo_curso(EnumCursos.FORMACAO);
                        break;

                    case 4:
                        curso.setTipo_curso(EnumCursos.QUALIFICACAO_APERFEICOAMENTO);
                        break;

                    default:
                        System.out.println("Esses campos são obrigatórios! Marque um desses que estão disponíveis.");
                        break;
                }
                if(opcao >= 1 && opcao <= 4)
                    preencherAreaExtensao(curso);
            } catch (InputMismatchException e) {
                System.out.println("Esses campos são obrigatórios! Marque um desses que estão disponíveis.");
                scanner.nextLine();
            }
        }
    }

    public <T extends FormularioSubmissao> void preencherLinhaExtensao(T tipo_formulario){
        int opcao = 0;

        while (opcao < 1 || opcao > 8) {
            System.out.println("\n-------- Linha de Extensão --------");
            System.out.println("1 - Cultura\n2 - Comunicação\n3 - Educação\n4 - Direitos Humanos e Justiça\n" +
                                "5 - Saúde\n6 - Meio Ambiente\n7 - Trabalho\n8 - Tecnologia e Produção\n");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        tipo_formulario.setLinha_extensao(EnumLInhaExtensao.CULTURA);
                        break;

                    case 2:
                        tipo_formulario.setLinha_extensao(EnumLInhaExtensao.COMUNICACAO);
                        break;

                    case 3:
                        tipo_formulario.setLinha_extensao(EnumLInhaExtensao.EDUCACAO);
                        break;

                    case 4:
                        tipo_formulario.setLinha_extensao(EnumLInhaExtensao.DIREITOS_HUMANOS_JUSTICA);
                        break;

                    case 5:
                        tipo_formulario.setLinha_extensao(EnumLInhaExtensao.SAUDE);
                        break;

                    case 6:
                        tipo_formulario.setLinha_extensao(EnumLInhaExtensao.MEIO_AMBIENTE);
                        break;

                    case 7:
                        tipo_formulario.setLinha_extensao(EnumLInhaExtensao.TRABALHO);
                        break;

                    case 8:
                        tipo_formulario.setLinha_extensao(EnumLInhaExtensao.TECNOLOGIA_PRODUCAO);
                        break;

                    default:
                        System.out.println("Esses campos são obrigatórios! Marque um desses que estão disponíveis.");
                        break;
                }
                if(opcao >= 1 && opcao <= 8)
                    preencherTitulo(tipo_formulario);
            } catch (InputMismatchException e) {
                System.out.println("Esses campos são obrigatórios! Marque um desses que estão disponíveis.");
                scanner.nextLine();
            }
        }
    }

    public <T extends FormularioSubmissao> void preencherAreaExtensao(T tipo_formulario) {
        int opcao = 0;

        while (opcao < 1 || opcao > 4) {
            System.out.println("\n-------- Área de Extensão Vinculada --------");
            System.out.println("1 - Ciências da Terra\n2 - Ciências Humanas e Ciências Sociais Aplicadas\n3 - Ciências da Vida\n4 - Engenharias e Ciências Exatas\n");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        tipo_formulario.setArea_extensao(EnumAreaExtensao.CIENCIAS_TERRA);
                        break;

                    case 2:
                        tipo_formulario.setArea_extensao(EnumAreaExtensao.CIENCIAS_HUMANAS_SOCIAIS);
                        break;

                    case 3:
                        tipo_formulario.setArea_extensao(EnumAreaExtensao.CIENCIAS_VIDA);
                        break;

                    case 4:
                        tipo_formulario.setArea_extensao(EnumAreaExtensao.ENGENHARIAS_CIENCIAS_EXATAS);
                        break;

                    default:
                        System.out.println("Esses campos são obrigatórios! Marque uma das opções disponíveis.");
                        break;
                }
                if(opcao >= 1 && opcao <= 4)
                    preencherLinhaExtensao(tipo_formulario);
            } catch (InputMismatchException e) {
                System.out.println("Esses campos são obrigatórios! Marque um desses que estão disponíveis.");
                scanner.nextLine();
            }
        }
    }

    public <T extends FormularioSubmissao> void preencherTitulo(T tipo_formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Título da Ação Proposta --------");
                String titulo_proposta = scanner.nextLine();
                tipo_formulario.setTitulo_proposta(titulo_proposta);
                condicao = false;
                preencherCoordenador(tipo_formulario);
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void preencherCoordenador(T tipo_formulario){
        boolean condicao = true;

        while (condicao) {
            try {
                Coordenador coordenador = tipo_formulario.getCoordenador();
                String texto;
                System.out.println("\n-------- Coordenador --------");

                System.out.println("Coordenador(a) (nome completo):");
                texto = scanner.nextLine();
                coordenador.setNome(texto);

                System.out.println("\nCPF:");
                texto = scanner.nextLine();
                coordenador.setCpf(texto);

                System.out.println("\nEmail:");
                texto = scanner.nextLine();
                coordenador.setEmail(texto);

                System.out.println("\nTelefone:");
                texto = scanner.nextLine();
                coordenador.setTelefone(texto);

                System.out.println("\nTitulação:");
                texto = scanner.nextLine();
                coordenador.setTitulacao(texto);

                System.out.println("\nÁrea de Formação:");
                texto = scanner.nextLine();
                coordenador.setArea_formacao(texto);

                condicao = false;

                preencherColegiadoCampus(tipo_formulario);
            } catch (InputMismatchException e) {
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }
        }

    }

    public <T extends FormularioSubmissao> void preencherColegiadoCampus(T tipo_formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Colegiado/Setor Proponente e campus --------");
                String titulo_proposta = scanner.nextLine();
                tipo_formulario.setColegiado_campus(titulo_proposta);
                condicao = false;
                preencherApresentacaoAcao(tipo_formulario);
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void preencherApresentacaoAcao(T tipo_formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Apresentação da Ação de Extensão --------");
                String titulo_proposta = scanner.nextLine();
                tipo_formulario.setApresentacao_acao(titulo_proposta);
                condicao = false;
                preencherJustificativa(tipo_formulario);
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void preencherJustificativa(T tipo_formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Justificativa --------");
                String titulo_proposta = scanner.nextLine();
                tipo_formulario.setJustificativa(titulo_proposta);
                condicao = false;
                preencherObjetivos(tipo_formulario);
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void preencherObjetivos(T tipo_formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Objetivos --------");
                String titulo_proposta = scanner.nextLine();
                tipo_formulario.setObjetivos(titulo_proposta);
                condicao = false;
                preencherMetas(tipo_formulario);
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void preencherMetas(T tipo_formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Metas --------");
                String titulo_proposta = scanner.nextLine();
                tipo_formulario.setMetas(titulo_proposta);
                condicao = false;
                preencherResultadosEsperados(tipo_formulario);
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void preencherResultadosEsperados(T tipo_formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Resultados Esperados --------");
                String titulo_proposta = scanner.nextLine();
                tipo_formulario.setResultados_esperados(titulo_proposta);
                condicao = false;
                preencherMetodologia(tipo_formulario);
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void preencherMetodologia(T tipo_formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Metodologia --------");
                String titulo_proposta = scanner.nextLine();
                tipo_formulario.setMetodologia(titulo_proposta);
                condicao = false;
                preencherReferencias(tipo_formulario);
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void preencherReferencias(T tipo_formulario){
        boolean condicao = true;
        int opcao;
        ArrayList<String> referencias = tipo_formulario.getReferencias();

        while (condicao){

            try{
                System.out.println("\n-------- Referências Bibliográficas --------");
                System.out.println("0 - Adicionar Referência Bibliográfica\n1 - Seguir");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 0:
                        addReferencia(referencias);
                        break;

                    case 1:
                        if(!referencias.isEmpty()) {
                            preencherPublico(tipo_formulario);
                            condicao = false;
                        } else
                            System.out.println("É obrigatório adicionar, pelo menos, uma referência");
                        break;

                    default:
                        System.out.println("Esses campos são obrigatórios! Marque uma das opções disponíveis.");

                }
            } catch (InputMismatchException e){
                System.out.println("Marque um dos índices disponíveis");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void preencherPublico(T tipo_formulario){
        boolean condicao = true;
        Publico publico = tipo_formulario.getPublico();

        while (condicao){

            try{
                System.out.println("\n-------- Público-Alvo --------");
                System.out.println("Público-Alvo:");
                String frase = scanner.nextLine();
                publico.setPublico_alvo(frase);
                System.out.println("Nº de Pessoas Beneficiadas:");
                int numero_pessoas = scanner.nextInt();
                scanner.nextLine();
                publico.setPessoas_beneficiadas(numero_pessoas);
                condicao = false;
                preencherIndissociabiliadade(tipo_formulario);
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void preencherIndissociabiliadade(T tipo_formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Natureza Acadêmica da Ação - Indissociabiliadade entre extensão, ensino e pesquisa --------");
                String frase = scanner.nextLine();
                tipo_formulario.setIndissociabiliadade(frase);
                condicao = false;
                preencherIndicadoresImpacto(tipo_formulario);
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void preencherIndicadoresImpacto(T tipo_formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Relações com a Sociedade - Indicadores de Impacto --------");
                String frase = scanner.nextLine();
                tipo_formulario.setIndicadores_impacto(frase);
                condicao = false;
                preencherAvaliacaoAcao(tipo_formulario);
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void preencherAvaliacaoAcao(T tipo_formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Avaliação da Ação --------");
                String frase = scanner.nextLine();
                tipo_formulario.setAvaliacao(frase);
                condicao = false;
                preencherCargaHoraria(tipo_formulario);
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void preencherCargaHoraria(T tipo_formulario){
        boolean condicao = true;
        CargaHoraria cargaHoraria = tipo_formulario.getCarga_horaria();

        while (condicao){

            try{
                System.out.println("\n-------- Carga Horária* --------");
                System.out.println("Período de Execução da Ação (dia, mês e ano)");

                System.out.println("Início:");
                String frase = scanner.nextLine();
                cargaHoraria.setInicio(frase);

                System.out.println("Fim:");
                frase = scanner.nextLine();
                cargaHoraria.setFim(frase);

                System.out.println("Carga Horária semanal:");
                frase = scanner.nextLine();
                cargaHoraria.setCh_semanal(frase);

                System.out.println("Carga horária anual:");
                frase = scanner.nextLine();
                cargaHoraria.setCh_anual(frase);

                condicao = false;
                preencherCronogramaExecucao(tipo_formulario);
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void preencherCronogramaExecucao(T tipo_formulario){
        boolean condicao = true;
        int opcao;
        ArrayList<CronogramaExecucao> cronogramas = tipo_formulario.getCronogramas_execucao();

        while (condicao){

            try{
                System.out.println("\n-------- Cronograma de Execução --------");
                System.out.println("0 - Adicionar um cronograma\n1 - Seguir");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 0:
                        addCronogramaExecucao(cronogramas);
                        break;

                    case 1:
                        if(!cronogramas.isEmpty()) {
                            preencherEquipe(tipo_formulario);
                            condicao = false;
                        } else
                            System.out.println("É obrigatório adicionar, pelo menos, um Cronograma de Execução");
                        break;

                    default:
                        System.out.println("Esses campos são obrigatórios! Marque uma das opções disponíveis.");

                }
            } catch (InputMismatchException e){
                System.out.println("Marque um dos índices disponíveis");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void preencherEquipe(T tipo_formulario){
        boolean condicao = true;
        int opcao;
        ArrayList<Membro> equipe = tipo_formulario.getEquipe();

        while (condicao){

            try{
                System.out.println("\n-------- Equipe de Execução --------");
                System.out.println("0 - Adicionar um mebro\n1 - Seguir");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 0:
                        addMebros(equipe);
                        break;

                    case 1:
                        if(!equipe.isEmpty()) {
                            preencherPropostaOrcamentaria(tipo_formulario);
                            condicao = false;
                        } else
                            System.out.println("É obrigatório adicionar, pelo menos, membro");
                        break;

                    default:
                        System.out.println("Esses campos são obrigatórios! Marque uma das opções disponíveis.");

                }
            } catch (InputMismatchException e){
                System.out.println("Marque um dos índices disponíveis");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void preencherPropostaOrcamentaria(T tipo_formulario){
        boolean condicao = true;
        PropostaOrcamentaria proposta_orcamentaria = tipo_formulario.getProposta_orcamentaria();

        while (condicao){

            try{
                System.out.println("\n-------- Proposta Orçamentária (previsão) --------");

                System.out.println("Recursos:");
                String frase = scanner.nextLine();
                proposta_orcamentaria.setRecursos(frase);

                System.out.println("Justificativas:");
                frase = scanner.nextLine();
                proposta_orcamentaria.setJustificativas(frase);

                System.out.println("Custos Previstos (R$):");
                float valor = scanner.nextFloat();
                scanner.nextLine();
                proposta_orcamentaria.setCustos_previstos(valor);

                System.out.println("Origem do Recurso:");
                frase = scanner.nextLine();
                proposta_orcamentaria.setOrigem_recurso(frase);

                System.out.println("Outras Despesas:");
                valor = scanner.nextFloat();
                scanner.nextLine();
                proposta_orcamentaria.setDespesas(valor);

                condicao = false;
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void addFormulario(ArrayList<T> formularios, T formulario){
        if(formulario != null)
            formularios.add(formulario);
        else
            System.out.println("\nNão é possível adicionar esse arquivo, pois não houve êxito na criação.\n");
    }

    public void addReferencia(ArrayList<String> referencias){
        try{
            System.out.println("\nReferência Bibliográficas:");
            String referencia = scanner.nextLine();
            referencias.add(referencia);
        } catch (InputMismatchException e){
            System.out.println("Digite um nome válido para o arquivo");
            scanner.nextLine();
        }
    }

    public void addCronogramaExecucao(ArrayList<CronogramaExecucao> cronogramas){
        try{
            CronogramaExecucao cronograma_execucao = new CronogramaExecucao();

            System.out.println("Atividades Planejadas:");
            String frase = scanner.nextLine();
            cronograma_execucao.setAtividade_planejada(frase);

            System.out.println("Período:");
            frase = scanner.nextLine();
            cronograma_execucao.setPeriodo(frase);

            System.out.println("Local:");
            frase = scanner.nextLine();
            cronograma_execucao.setLocal(frase);

            System.out.println("Observações:");
            frase = scanner.nextLine();
            cronograma_execucao.setObservacao(frase);

            cronogramas.add(cronograma_execucao);
        } catch (InputMismatchException e){
            System.out.println("Digite um nome válido para o arquivo");
            scanner.nextLine();
        }
    }

    public void addMebros(ArrayList<Membro> equipe){
        try{
            Membro membro = new Membro();

            System.out.println("Nome Completo:");
            String frase = scanner.nextLine();
            membro.setNome_completo(frase);

            System.out.println("CPF:");
            frase = scanner.nextLine();
            membro.setCpf(frase);

            System.out.println("Instituição:");
            frase = scanner.nextLine();
            membro.setInstituicao(frase);

            System.out.println("Colegiado/Setor:");
            frase = scanner.nextLine();
            membro.setColegiado_setor(frase);

            System.out.println("Categoria Profissional (docente, técnico, aluno, etc.):");
            frase = scanner.nextLine();
            membro.setCategoria_profissional(frase);

            System.out.println("*Função no Projeto (colaborador, voluntário, etc.):");
            frase = scanner.nextLine();
            membro.setFuncao_projeto(frase);

            equipe.add(membro);
        } catch (InputMismatchException e){
            System.out.println("Digite um nome válido para o arquivo");
            scanner.nextLine();
        }
    }

}
