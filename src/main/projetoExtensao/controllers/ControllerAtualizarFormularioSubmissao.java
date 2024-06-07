package main.projetoExtensao.controllers;

import main.projetoExtensao.formularios.formularioSubmissao.FormularioSubmissao;
import main.projetoExtensao.formularios.formularioSubmissao.enuns.*;
import main.projetoExtensao.formularios.formularioSubmissao.models.*;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class ControllerAtualizarFormularioSubmissao extends ControllerVerFormularioSubmissao {
    private boolean condicao = true;
    int indice;

    public ControllerAtualizarFormularioSubmissao(
                ArrayList<Curso> cursos,
                ArrayList<EmpresaJunior> empresas_juniors,
                ArrayList<Evento> eventos,
                ArrayList<LigaAcademica> ligas_cademicas,
                ArrayList<NucleoTematico> nucleos_tematicos,
                ArrayList<PrestacaoServico> prestacoes_servicos,
                ArrayList<Programa> programas,
                ArrayList<Projeto> projetos) {

        super(cursos, empresas_juniors, eventos, ligas_cademicas, nucleos_tematicos, prestacoes_servicos, programas, projetos);
    }

    public <T extends FormularioSubmissao> void printNomesFormularios(ArrayList<T> formularios){

        if(formularios.isEmpty())
            System.out.println("\n Não há formulários dessa modalidade\n");
        else {
            indice = 0;

            System.out.println("------- Lista de Formulários -------");
            for (T formulario : formularios) {
                System.out.println(indice + " - " + formulario.getNome_arquivo());
                indice++;
            }
            System.out.print("\n");

            indice = -1;

            while (indice < 0 || indice >= formularios.size()) {

                System.out.print("Qual desses documentos você deseja ver (escolha pelo índice)? ");

                try{
                    indice = scanner.nextInt();
                    scanner.nextLine();

                    condicao = true;

                    if (indice >= 0 && indice < formularios.size()) {
                        T formulario = formularios.get(indice);

                        while (condicao) {

                            if (formulario instanceof Evento)
                                escolherAlterarEvento((Evento) formulario);
                            else if (formulario instanceof Curso)
                                escolherAlterarCurso((Curso) formulario);
                            else
                                escolherAlterar(formulario);

                            System.out.println("Documento Atualizado com sucesso!\n\n");
                        }
                    } else
                        System.out.println("Escolha um dos índices disponíveis.");

                } catch (InputMismatchException e){
                    System.out.println("Escolha pelo índice.");
                    scanner.nextLine();
                }

            }
        }

    }

    public <T extends FormularioSubmissao> void escolherAlterar(T formulario){
        printDadosFormulario(formulario);
        System.out.println("\n22 - Modificar o nome do arquivo");
        System.out.println("\n0 - Voltar\n");
        System.out.println("Qual desses campos você deseja alterar (escolha pelo índice)? ");
        try{
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){

                case 1:
                    System.out.println("Não é possível alterar a Modalidade da Proposta de Extensão :(\n");
                    break;

                case 2:
                    modificiarAreaExtensao(formulario);
                    break;

                case 3:
                    modificiarLinhaExtensao(formulario);
                    break;

                case 4:
                    modificarTitulo(formulario);
                    break;

                case 5:
                    modificarCoordenador(formulario);
                    break;

                case 6:
                    modificarColegiadoCampus(formulario);
                    break;

                case 7:
                    modificarApresentacaoAcao(formulario);
                    break;

                case 8:
                    modificarJustificativa(formulario);
                    break;

                case 9:
                    modificarObjetivos(formulario);
                    break;

                case 10:
                    modificarMetas(formulario);
                    break;

                case 11:
                    modificarResultadosEsperados(formulario);
                    break;

                case 12:
                    modificarMetodologia(formulario);
                    break;

                case 13:
                    modificarReferencias(formulario);
                    break;

                case 14:
                    modificarPublico(formulario);
                    break;

                case 15:
                    modificarIndissociabiliadade(formulario);
                    break;

                case 16:
                    modificarIndicadoresImpacto(formulario);
                    break;

                case 17:
                    modificarAvaliacaoAcao(formulario);
                    break;

                case 18:
                    modificarCargaHoraria(formulario);
                    break;

                case 19:
                    modificarCronogramaExecucao(formulario);
                    break;

                case 20:
                    modificarEquipe(formulario);
                    break;

                case 21:
                    modificarPropostaOrcamentaria(formulario);
                    break;

                case 22:
                    modificiarNomeArquivo(formulario);
                    break;

                case 0:
                    condicao = false;
                    break;

                default:
                    System.out.println("Escolha um dos índices disponíveis.");
                    break;

            }

        } catch (InputMismatchException e){
            System.out.println("Escolha pelo índice.");
            scanner.nextLine();
        }
    }

    public void escolherAlterarEvento(Evento formulario){
        printDadosFormularioEvento(formulario);
        System.out.println("23 - Modificar o nome do arquivo");
        System.out.println("0 - Voltar\n");
        System.out.println("Qual desses campos você deseja alterar (escolha pelo índice)? ");
        try{
            int opcao = scanner.nextInt();
            scanner.nextLine();


            switch (opcao){

                case 1:
                    System.out.println("Não é possível alterar a Modalidade da Proposta de Extensão :(\n");
                    break;

                case 2:
                    modificarEvento(formulario);
                    break;

                case 3:
                    modificiarAreaExtensao(formulario);
                    break;

                case 4:
                    modificiarLinhaExtensao(formulario);
                    break;

                case 5:
                    modificarTitulo(formulario);
                    break;

                case 6:
                    modificarCoordenador(formulario);
                    break;

                case 7:
                    modificarColegiadoCampus(formulario);
                    break;

                case 8:
                    modificarApresentacaoAcao(formulario);
                    break;

                case 9:
                    modificarJustificativa(formulario);
                    break;

                case 10:
                    modificarObjetivos(formulario);
                    break;

                case 11:
                    modificarMetas(formulario);
                    break;

                case 12:
                    modificarResultadosEsperados(formulario);
                    break;

                case 13:
                    modificarMetodologia(formulario);
                    break;

                case 14:
                    modificarReferencias(formulario);
                    break;

                case 15:
                    modificarPublico(formulario);
                    break;

                case 16:
                    modificarIndissociabiliadade(formulario);
                    break;

                case 17:
                    modificarIndicadoresImpacto(formulario);
                    break;

                case 18:
                    modificarAvaliacaoAcao(formulario);
                    break;

                case 19:
                    modificarCargaHoraria(formulario);
                    break;

                case 20:
                    modificarCronogramaExecucao(formulario);
                    break;

                case 21:
                    modificarEquipe(formulario);
                    break;

                case 22:
                    modificarPropostaOrcamentaria(formulario);
                    break;

                case 23:
                    modificiarNomeArquivo(formulario);
                    break;

                case 0:
                    condicao = false;
                    break;

                default:
                    System.out.println("Escolha um dos índices disponíveis.");
                    break;

            }

        } catch (InputMismatchException e){
            System.out.println("Escolha pelo índice.");
            scanner.nextLine();
        }
    }

    public void escolherAlterarCurso(Curso formulario){
        printDadosFormularioCurso(formulario);
        System.out.println("23 - Modificar o nome do arquivo");
        System.out.println("0 - Voltar\n");
        System.out.println("Qual desses campos você deseja alterar (escolha pelo índice)? ");
        try{
            int opcao = scanner.nextInt();
            scanner.nextLine();


            switch (opcao){

                case 1:
                    System.out.println("Não é possível alterar a Modalidade da Proposta de Extensão :(\n");
                    break;

                case 2:
                    modificarCurso(formulario);
                    break;

                case 3:
                    modificiarAreaExtensao(formulario);
                    break;

                case 4:
                    modificiarLinhaExtensao(formulario);
                    break;

                case 5:
                    modificarTitulo(formulario);
                    break;

                case 6:
                    modificarCoordenador(formulario);
                    break;

                case 7:
                    modificarColegiadoCampus(formulario);
                    break;

                case 8:
                    modificarApresentacaoAcao(formulario);
                    break;

                case 9:
                    modificarJustificativa(formulario);
                    break;

                case 10:
                    modificarObjetivos(formulario);
                    break;

                case 11:
                    modificarMetas(formulario);
                    break;

                case 12:
                    modificarResultadosEsperados(formulario);
                    break;

                case 13:
                    modificarMetodologia(formulario);
                    break;

                case 14:
                    modificarReferencias(formulario);
                    break;

                case 15:
                    modificarPublico(formulario);
                    break;

                case 16:
                    modificarIndissociabiliadade(formulario);
                    break;

                case 17:
                    modificarIndicadoresImpacto(formulario);
                    break;

                case 18:
                    modificarAvaliacaoAcao(formulario);
                    break;

                case 19:
                    modificarCargaHoraria(formulario);
                    break;

                case 20:
                    modificarCronogramaExecucao(formulario);
                    break;

                case 21:
                    modificarEquipe(formulario);
                    break;

                case 22:
                    modificarPropostaOrcamentaria(formulario);
                    break;

                case 23:
                    modificiarNomeArquivo(formulario);
                    break;

                case 0:
                    condicao = false;
                    break;

                default:
                    System.out.println("Escolha um dos índices disponíveis.");
                    break;

            }

        } catch (InputMismatchException e){
            System.out.println("Escolha pelo índice.");
            scanner.nextLine();
        }
    }

    public void modificarEvento(Evento formulario){
        int opcao = 0;


        while (opcao < 1 || opcao > 14) {
            System.out.println("\n-------- *Eventos --------");
            System.out.println("1 - Congresso\n2 - Conferência\n3 - Seminário\n4 - Fórum\n" +
                    "5 - Simpósio\n6 - Oficina\n7 - Palestra\n8 - Mesa redonda\n" +
                    "9 - Encontro\n10 - Workshop\n11 - Feira\n12 - Semana\n" +
                    "13 - Exposição\n14 - Festival\n");
            System.out.println("Para qual você deseja modificar?");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        formulario.setTipo_evento(EnumEvento.CONGRESSO);
                        break;

                    case 2:
                        formulario.setTipo_evento(EnumEvento.CONFERENCIA);
                        break;

                    case 3:
                        formulario.setTipo_evento(EnumEvento.SEMINARIO);
                        break;

                    case 4:
                        formulario.setTipo_evento(EnumEvento.FORUM);
                        break;

                    case 5:
                        formulario.setTipo_evento(EnumEvento.SIMPOSIO);
                        break;

                    case 6:
                        formulario.setTipo_evento(EnumEvento.OFICINA);
                        break;

                    case 7:
                        formulario.setTipo_evento(EnumEvento.PALESTRA);
                        break;

                    case 8:
                        formulario.setTipo_evento(EnumEvento.MESA_REDONDA);
                        break;

                    case 9:
                        formulario.setTipo_evento(EnumEvento.ENCONTRO);
                        break;

                    case 10:
                        formulario.setTipo_evento(EnumEvento.WORKSHOP);
                        break;

                    case 11:
                        formulario.setTipo_evento(EnumEvento.FEIRA);
                        break;

                    case 12:
                        formulario.setTipo_evento(EnumEvento.SEMANA);
                        break;

                    case 13:
                        formulario.setTipo_evento(EnumEvento.EXPOSICAO);
                        break;

                    case 14:
                        formulario.setTipo_evento(EnumEvento.FESTIVAL);
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

    public void modificarCurso(Curso formulario){
        int opcao = 0;

        while (opcao < 1 || opcao > 4) {
            System.out.println("\n-------- *Cursos --------");
            System.out.println("1 - Inicialiazação\n2 - Atualização\n3 - Formação\n4 - Qualificação/Aperfeiçoamento\n");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        formulario.setTipo_curso(EnumCursos.INICIALIZACAO);
                        break;

                    case 2:
                        formulario.setTipo_curso(EnumCursos.ATUALIZACAO);
                        break;

                    case 3:
                        formulario.setTipo_curso(EnumCursos.FORMACAO);
                        break;

                    case 4:
                        formulario.setTipo_curso(EnumCursos.QUALIFICACAO_APERFEICOAMENTO);
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

    public <T extends FormularioSubmissao> void modificiarNomeArquivo(T formulario){
        try {
            String novo_nome;
            System.out.print("Novo Nome do arquivo? ");
            novo_nome = scanner.nextLine();
            formulario.setNome_arquivo(novo_nome);

        }   catch (InputMismatchException e){
            System.out.println("Digite um nome válido para o arquivo");
            scanner.nextLine();
        }
    }

    public <T extends FormularioSubmissao> void modificiarAreaExtensao(T formulario){
        int opcao = 0;

        while (opcao < 1 || opcao > 4) {
            System.out.println("\n-------- Área de Extensão Vinculada --------");
            System.out.println("1 - Ciências da Terra\n2 - Ciências Humanas e Ciências Sociais Aplicadas\n3 - Ciências da Vida\n4 - Engenharias e Ciências Exatas\n");
            System.out.println("Para qual você deseja modificar?");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        formulario.setArea_extensao(EnumAreaExtensao.CIENCIAS_TERRA);
                        break;

                    case 2:
                        formulario.setArea_extensao(EnumAreaExtensao.CIENCIAS_HUMANAS_SOCIAIS);
                        break;

                    case 3:
                        formulario.setArea_extensao(EnumAreaExtensao.CIENCIAS_VIDA);
                        break;

                    case 4:
                        formulario.setArea_extensao(EnumAreaExtensao.ENGENHARIAS_CIENCIAS_EXATAS);
                        break;

                    default:
                        System.out.println("Escolha uma das opções disponíveis.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Escolha pelo número vinculado");
                scanner.nextLine();
            }
        }
    }

    public <T extends FormularioSubmissao> void modificiarLinhaExtensao(T formulario){
        int opcao = 0;

        while (opcao < 1 || opcao > 8) {
            System.out.println("\n-------- Linha de Extensão --------");
            System.out.println("1 - Cultura\n2 - Comunicação\n3 - Educação\n4 - Direitos Humanos e Justiça\n" +
                    "5 - Saúde\n6 - Meio Ambiente\n7 - Trabalho\n8 - Tecnologia e Produção\n");
            System.out.println("Para qual você deseja modificar?");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        formulario.setLinha_extensao(EnumLInhaExtensao.CULTURA);
                        break;

                    case 2:
                        formulario.setLinha_extensao(EnumLInhaExtensao.COMUNICACAO);
                        break;

                    case 3:
                        formulario.setLinha_extensao(EnumLInhaExtensao.EDUCACAO);
                        break;

                    case 4:
                        formulario.setLinha_extensao(EnumLInhaExtensao.DIREITOS_HUMANOS_JUSTICA);
                        break;

                    case 5:
                        formulario.setLinha_extensao(EnumLInhaExtensao.SAUDE);
                        break;

                    case 6:
                        formulario.setLinha_extensao(EnumLInhaExtensao.MEIO_AMBIENTE);
                        break;

                    case 7:
                        formulario.setLinha_extensao(EnumLInhaExtensao.TRABALHO);
                        break;

                    case 8:
                        formulario.setLinha_extensao(EnumLInhaExtensao.TECNOLOGIA_PRODUCAO);
                        break;

                    default:
                        System.out.println("Escolha uma das opções disponíveis.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Escolha pelo número vinculado");
                scanner.nextLine();
            }
        }
    }

    public <T extends FormularioSubmissao> void modificarTitulo(T formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Título da Ação Proposta (Novo) --------");
                String titulo_proposta = scanner.nextLine();
                formulario.setTitulo_proposta(titulo_proposta);
                condicao = false;
            } catch (InputMismatchException e){
                System.out.println("Digite um nome válido para o arquivo");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void modificarCoordenador(T formulario){
        boolean condicao = true;

        while (condicao) {
            try {
                Coordenador coordenador = formulario.getCoordenador();
                String texto;
                System.out.println("\n-------- Coordenador (Novo) --------");

                System.out.println("Coordenador(a) (nome completo):");
                texto = scanner.nextLine();
                coordenador.setNome(texto);

                System.out.println("CPF:");
                texto = scanner.nextLine();
                coordenador.setCpf(texto);

                System.out.println("Email:");
                texto = scanner.nextLine();
                coordenador.setEmail(texto);

                System.out.println("Telefone:");
                texto = scanner.nextLine();
                coordenador.setTelefone(texto);

                System.out.println("Titulação:");
                texto = scanner.nextLine();
                coordenador.setTitulacao(texto);

                System.out.println("Área de Formação:");
                texto = scanner.nextLine();
                coordenador.setArea_formacao(texto);

                condicao = false;
            } catch (InputMismatchException e) {
                System.out.println("Digite uma String válida");
                scanner.nextLine();
            }
        }

    }

    public <T extends FormularioSubmissao> void modificarColegiadoCampus(T tipo_formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Colegiado/Setor Proponente e campus (Novo) --------");
                String titulo_proposta = scanner.nextLine();
                tipo_formulario.setColegiado_campus(titulo_proposta);
                condicao = false;
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void modificarApresentacaoAcao(T formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Apresentação da Ação de Extensão (Novo) --------");
                String titulo_proposta = scanner.nextLine();
                formulario.setTitulo_proposta(titulo_proposta);
                condicao = false;
            } catch (InputMismatchException e){
                System.out.println("Digite um nome válido para o arquivo");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void modificarJustificativa(T formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Justificativa (Novo) --------");
                String titulo_proposta = scanner.nextLine();
                formulario.setTitulo_proposta(titulo_proposta);
                condicao = false;
            } catch (InputMismatchException e){
                System.out.println("Digite um nome válido para o arquivo");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void modificarObjetivos(T formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Objetivos (Novo) --------");
                String titulo_proposta = scanner.nextLine();
                formulario.setTitulo_proposta(titulo_proposta);
                condicao = false;
            } catch (InputMismatchException e){
                System.out.println("Digite um nome válido para o arquivo");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void modificarMetas(T formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Metas (Novo) --------");
                String titulo_proposta = scanner.nextLine();
                formulario.setTitulo_proposta(titulo_proposta);
                condicao = false;
            } catch (InputMismatchException e){
                System.out.println("Digite um nome válido para o arquivo");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void modificarResultadosEsperados(T formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Resultados Esperados (Novo) --------");
                String titulo_proposta = scanner.nextLine();
                formulario.setTitulo_proposta(titulo_proposta);
                condicao = false;
            } catch (InputMismatchException e){
                System.out.println("Digite um nome válido para o arquivo");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void modificarMetodologia(T formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Metodologia (Novo) --------");
                String titulo_proposta = scanner.nextLine();
                formulario.setTitulo_proposta(titulo_proposta);
                condicao = false;
            } catch (InputMismatchException e){
                System.out.println("Digite um nome válido para o arquivo");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void modificarReferencias(T formulario){
        boolean condicao = true;
        int opcao;
        ArrayList<String> referencias = formulario.getReferencias();

        while (condicao){

            try{
                System.out.println("\n-------- Referências Bibliográficas (Novo) --------");
                System.out.println("1 - Adicionar Referência Bibliográfica\n2 - Deletar uma Referência Bibliográfica\n0 - Voltar");
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        ControllerCriarFormularioSubmissao.addReferencia(referencias);
                        break;

                    case 2:
                        if(referencias.size() != 1)
                            deleteReferencia(referencias);
                        else
                            System.out.println("Não será possível remover a referência, pois é preciso ter pelo menos uma");
                        break;

                    case 0:
                        condicao = false;
                        break;

                    default:
                        System.out.println("Esses campos são obrigatórios! Marque uma das opções disponíveis.");

                }
            } catch (InputMismatchException e){
                System.out.println("Digite um nome válido para o arquivo");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void modificarPublico(T formulario){
        boolean condicao = true;
        Publico publico = formulario.getPublico();

        while (condicao){

            try{
                System.out.println("\n-------- Público-Alvo (Novo) --------");
                System.out.println("Público-Alvo:");
                String frase = scanner.nextLine();
                publico.setPublico_alvo(frase);
                System.out.println("Novo Nº de Pessoas Beneficiadas:");
                int numero_pessoas = scanner.nextInt();
                publico.setPessoas_beneficiadas(numero_pessoas);
                condicao = false;
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void modificarIndissociabiliadade(T formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Natureza Acadêmica da Ação - Indissociabiliadade entre extensão, ensino e pesquisa (Novo) --------");
                String frase = scanner.nextLine();
                formulario.setIndissociabiliadade(frase);
                condicao = false;
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void modificarIndicadoresImpacto(T formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Relações com a Sociedade - Indicadores de Impacto (Novo) --------");
                String frase = scanner.nextLine();
                formulario.setIndicadores_impacto(frase);
                condicao = false;
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void modificarAvaliacaoAcao(T formulario){
        boolean condicao = true;

        while (condicao){

            try{
                System.out.println("\n-------- Avaliação da Ação (Novo) --------");
                String frase = scanner.nextLine();
                formulario.setAvaliacao(frase);
                condicao = false;
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void modificarCargaHoraria(T formulario){
        boolean condicao = true;
        CargaHoraria cargaHoraria = formulario.getCarga_horaria();

        while (condicao){

            try{
                System.out.println("\n-------- Carga Horária* (Novo) --------");
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
            } catch (InputMismatchException e){
                System.out.println("Erro ao inserir os dados");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void modificarCronogramaExecucao(T formulario){
        boolean condicao = true;
        int opcao;
        ArrayList<CronogramaExecucao> cronogramas = formulario.getCronogramas_execucao();

        while (condicao){

            try{
                System.out.println("\n-------- Cronograma de Execução (Novo) --------");
                System.out.println("1 - Adicionar uma Atividade Planejada\n2 - Deletar um Cronograma de Execução\n0 - Voltar");
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        ControllerCriarFormularioSubmissao.addCronogramaExecucao(cronogramas);
                        break;

                    case 2:
                        if(cronogramas.size() != 1)
                            deleteCronograma(cronogramas);
                        else
                            System.out.println("Não será possível remover a Atividade Planejada, pois é preciso ter pelo menos uma");
                        break;

                    case 0:
                        condicao = false;
                        break;

                    default:
                        System.out.println("Esses campos são obrigatórios! Marque uma das opções disponíveis.");

                }
            } catch (InputMismatchException e){
                System.out.println("Digite um nome válido para o arquivo");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void modificarEquipe(T formulario){
        boolean condicao = true;
        int opcao;
        ArrayList<Membro> equipe = formulario.getEquipe();

        while (condicao){

            try{
                System.out.println("\n-------- Equipe de Execução (Novo) --------");
                System.out.println("1 - Adicionar um Membro na Equipe\n2 - Deletar um membro da equipe\n0 - Voltar");
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        ControllerCriarFormularioSubmissao.addMebros(equipe);
                        break;

                    case 2:
                        if(equipe.size() != 1)
                            deleteMembro(equipe);
                        else
                            System.out.println("Não será possível remover o Membro, pois é preciso ter pelo menos uma");
                        break;

                    case 0:
                        condicao = false;
                        break;

                    default:
                        System.out.println("Esses campos são obrigatórios! Marque uma das opções disponíveis.");

                }
            } catch (InputMismatchException e){
                System.out.println("Digite um nome válido para o arquivo");
                scanner.nextLine();
            }

        }
    }

    public <T extends FormularioSubmissao> void modificarPropostaOrcamentaria(T formulario){
        boolean condicao = true;
        PropostaOrcamentaria proposta_orcamentaria = formulario.getProposta_orcamentaria();

        while (condicao){

            try{
                System.out.println("\n-------- Nova Proposta Orçamentária (previsão) --------");

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

    public void deleteReferencia(ArrayList<String> referencias){
        int count = 0;
        for(String referencia : referencias) {
            System.out.println(count + " - " + referencia);
            count++;
        }
        try{
            System.out.println("\nQual Referência você deseja deletar?");
            int opcao = scanner.nextInt();
            if(opcao >= 0 && opcao <= count)
                referencias.remove(opcao);
            else
                System.out.println("Escolha um dos índices disponíveis.");
        } catch (InputMismatchException e){
            System.out.println("Escolha pelo índice.");
            scanner.nextLine();
        }

    }

    public void deleteCronograma(ArrayList<CronogramaExecucao> cronogramas){
        int count = 0;
        for(CronogramaExecucao cronograma : cronogramas) {
            System.out.println(count + " - " + cronograma.getAtividade_planejada());
            count++;
        }
        try{
            System.out.println("\nQual Atividade Planejada você deseja deletar?");
            int opcao = scanner.nextInt();
            if(opcao >= 0 && opcao <= count)
                cronogramas.remove(opcao);
            else
                System.out.println("Escolha um dos índices disponíveis.");
        } catch (InputMismatchException e){
            System.out.println("Escolha pelo índice.");
            scanner.nextLine();
        }
    }

    public void deleteMembro(ArrayList<Membro> equipe){
        int count = 0;
        for(Membro membro : equipe) {
            System.out.println(count + " - " + membro.getNome_completo());
            count++;
        }
        try{
            System.out.println("\nQual Membro você deseja deletar?");
            int opcao = scanner.nextInt();
            if(opcao >= 0 && opcao <= count)
                equipe.remove(opcao);
            else
                System.out.println("Escolha um dos índices disponíveis.");
        } catch (InputMismatchException e){
            System.out.println("Escolha pelo índice.");
            scanner.nextLine();
        }
    }

}
