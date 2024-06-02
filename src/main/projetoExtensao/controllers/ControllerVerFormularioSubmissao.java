package main.projetoExtensao.controllers;

import main.projetoExtensao.formularios.formularioSubmissao.FormularioSubmissao;
import main.projetoExtensao.formularios.formularioSubmissao.enuns.*;
import main.projetoExtensao.formularios.formularioSubmissao.models.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerVerFormularioSubmissao {
    protected Scanner scanner;
    protected boolean condicao;
    protected ArrayList<Curso> cursos;
    protected ArrayList<EmpresaJunior> empresas_juniors;
    protected ArrayList<Evento> eventos;
    protected ArrayList<LigaAcademica> ligas_cademicas;
    protected ArrayList<NucleoTematico> nucleos_tematicos;
    protected ArrayList<PrestacaoServico> prestacoes_servicos;
    protected ArrayList<Programa> programas;
    protected ArrayList<Projeto> projetos;

    public ControllerVerFormularioSubmissao(
            ArrayList<Curso> cursos,
            ArrayList<EmpresaJunior> empresas_juniors,
            ArrayList<Evento> eventos,
            ArrayList<LigaAcademica> ligas_cademicas,
            ArrayList<NucleoTematico> nucleos_tematicos,
            ArrayList<PrestacaoServico> prestacoes_servicos,
            ArrayList<Programa> programas,
            ArrayList<Projeto> projetos){

        scanner = new Scanner(System.in);
        this.cursos = cursos;
        this.empresas_juniors = empresas_juniors;
        this.eventos = eventos;
        this.ligas_cademicas = ligas_cademicas;
        this.nucleos_tematicos = nucleos_tematicos;
        this.prestacoes_servicos = prestacoes_servicos;
        this.programas = programas;
        this.projetos = projetos;
    }

    public void exibirFormularios(){
        if(formularioIsEmpty())
            System.out.println("Nenhum Formulário de Submissão foi criado. É preciso criar um Formulário de Submissão para poder Ver, Deletar ou Atualizar.\n");
        else {
            int opcao;
            condicao = true;

            while (condicao) {
                System.out.println("\n========= Exibir Formulários =========");
                System.out.println("1 - Formulários de Programa\n2 - Formulários de Projeto\n3 - Formulários de Núcleo Temático\n4 - Formulários de Evento\n" +
                                    "5 - Formulários de Empresa Junior\n6 - Formulários de Liga Acadêmica\n7 - Formulários de Prestação de Serviço\n8 - Curso\n" +
                                    "0 - Voltar para o Menu");
                try {
                    opcao = scanner.nextInt();

                    switch (opcao) {

                        case 0:
                            condicao = false;
                            System.out.println("Voltando para o menu...\n");
                            break;

                        case 1:
                            printNomesFormularios(programas);
                            break;

                        case 2:
                            printNomesFormularios(projetos);
                            break;

                        case 3:
                            printNomesFormularios(nucleos_tematicos);
                            break;

                        case 4:
                            printNomesFormularios(eventos);
                            break;

                        case 5:
                            printNomesFormularios(empresas_juniors);
                            break;

                        case 6:
                            printNomesFormularios(ligas_cademicas);
                            break;

                        case 7:
                            printNomesFormularios(prestacoes_servicos);
                            break;

                        case 8:
                            printNomesFormularios(cursos);
                            break;

                        default:
                            System.out.println("Esses campos são obrigatórios! Marque um desses que estão disponíveis.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Esses campos são obrigatórios! Marque um desses que estão disponíveis.");
                    scanner.nextLine();
                }
            }
        }
    }

    public boolean formularioIsEmpty(){
        return cursos.isEmpty() && empresas_juniors.isEmpty() &&
                eventos.isEmpty() && ligas_cademicas.isEmpty() &&
                nucleos_tematicos.isEmpty() && prestacoes_servicos.isEmpty() &&
                programas.isEmpty() && projetos.isEmpty();
    }

    public <T extends FormularioSubmissao> void printNomesFormularios(ArrayList<T> formularios){

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

            indice = -1;

            while (indice < 0 || indice >= formularios.size()) {

                System.out.print("Qual desses documentos você deseja ver (escolha pelo índice)? ");

                try{
                    indice = scanner.nextInt();
                    scanner.nextLine();

                    if (indice >= 0 && indice < formularios.size()) {
                        T formulario = formularios.get(indice);

                        if(formulario instanceof Evento)
                            printDadosFormularioEvento((Evento) formulario);
                        else if(formulario instanceof Curso)
                            printDadosFormularioCurso((Curso) formulario);
                        else
                            printDadosFormulario(formulario);

                    } else
                        System.out.println("Escolha um dos índices disponíveis.");

                } catch (InputMismatchException e){
                    System.out.println("Escolha pelo índice.");
                    scanner.nextLine();
                }

            }
        }

    }

    public <T extends FormularioSubmissao> void printDadosFormulario(T formulario) {

        DecimalFormat decimal = new DecimalFormat("0.00");
        Coordenador coordenador = formulario.getCoordenador();
        EnumModalidade modalidade = formulario.getModalidade();
        EnumAreaExtensao area_extensao = formulario.getArea_extensao();
        EnumLInhaExtensao lInha_extensao = formulario.getLinha_extensao();
        ArrayList<String> referencias = formulario.getReferencias();
        Publico publico = formulario.getPublico();
        CargaHoraria carga_horaria = formulario.getCarga_horaria();
        ArrayList<CronogramaExecucao> cronogramas = formulario.getCronogramas_execucao();
        ArrayList<Membro> equipe = formulario.getEquipe();
        PropostaOrcamentaria proposta_orcamentaria = formulario.getProposta_orcamentaria();
        int count = 1;

        System.out.println("\n\n\n---------------------------- " + formulario.getNome_arquivo() + " ----------------------------");
        System.out.println("\n 1 - Modalidade da Proposta de Extensão: " + modalidade.getTexto());
        System.out.println("\n 2 - Área de Extensão Vinculada: " + area_extensao.getTexto());
        System.out.println("\n 3 - Linha de Extensão: " + lInha_extensao.getTexto());
        System.out.println("\n 4 - Título da Ação Proposta: " + formulario.getTitulo_proposta());
        System.out.println("\n 5 - Coordenador(a):");
        System.out.println("Nome completo: " + coordenador.getNome());
        System.out.println("CPF: " + coordenador.getCpf());
        System.out.println("Email: " + coordenador.getEmail());
        System.out.println("Telefone: " + coordenador.getTelefone());
        System.out.println("Titulação: " + coordenador.getTitulacao());
        System.out.println("Área de Formação: " + coordenador.getArea_formacao());
        System.out.println("\n6 - Colegiado/Setor Proponente e campus: " + formulario.getColegiado_campus());
        System.out.println("\n7 - Apresentação da Ação de Extensão: " + formulario.getApresentacao_acao());
        System.out.println("\n8 - Justificativa: " + formulario.getJustificativa());
        System.out.println("\n9 - Objetivos: " + formulario.getObjetivos());
        System.out.println("\n10 - Metas: " + formulario.getMetas());
        System.out.println("\n11 - Resultados Esperados: " + formulario.getResultados_esperados());
        System.out.println("\n12 - Metodologia: " + formulario.getMetodologia());
        System.out.println("\n13 - Referências Bibliográficas:");
        for(String referencia : referencias)
            System.out.println(referencia);
        System.out.println("\n14 - Público-Alvo: " + publico.getPublico_alvo());
        System.out.println("Nº de Pessoas Beneficiadas: " + publico.getPessoas_beneficiadas());
        System.out.println("\n15 - Natureza Acadêmica da Ação - Indissociabiliadade entre extensão, ensino e pesquisa: " + formulario.getIndissociabiliadade());
        System.out.println("\n16 - Relações com a Sociedade - Indicadores de Impacto: " + formulario.getIndicadores_impacto());
        System.out.println("\n17 - Avaliação da Ação: " + formulario.getAvaliacao());
        System.out.println("\n18 - Carga Horária*:");
        System.out.println("Período de Execução da Ação (dia, mês e ano)");
        System.out.println("Início: " + carga_horaria.getInicio());
        System.out.println("Fim: " + carga_horaria.getFim());
        System.out.println("Carga Horária semanal: " + carga_horaria.getCh_semanal());
        System.out.println("Carga horária anual: " + carga_horaria.getCh_anual());
        System.out.println("\n19 - Cronograma de Execução:");
        for(CronogramaExecucao cronograma : cronogramas){
            System.out.println(count + "º");
            System.out.println("Atividades Planejadas: " + cronograma.getAtividade_planejada());
            System.out.println("Período: " + cronograma.getPeriodo());
            System.out.println("Local: " + cronograma.getLocal());
            System.out.println("Observações: " + cronograma.getObservacao());
            count++;
        }
        count = 1;
        System.out.println("\n20 - Equipe de Execução:");
        for(Membro membro : equipe){
            System.out.println(count + "º");
            System.out.println("Nome Completo: " + membro.getNome_completo());
            System.out.println("CPF: " + membro.getCpf());
            System.out.println("Instituição: " + membro.getInstituicao());
            System.out.println("Colegiado/Setor: " + membro.getColegiado_setor());
            System.out.println("Categoria Profissional (docente, técnico, aluno, etc.): " + membro.getCategoria_profissional());
            System.out.println("*Função no Projeto (colaborador, voluntário, etc.): " + membro.getFuncao_projeto());
            count++;
        }
        System.out.println("\n21 - Proposta Orçamentária (previsão):");
        System.out.println("Recursos: " + proposta_orcamentaria.getRecursos());
        System.out.println("Justificativas: " + proposta_orcamentaria.getJustificativas());
        System.out.println("Custos Previstos (R$): " + decimal.format(proposta_orcamentaria.getCustos_previstos()));
        System.out.println("Origem do Recurso: " + proposta_orcamentaria.getOrigem_recurso());
        System.out.println("Outras Despesas: " + decimal.format(proposta_orcamentaria.getDespesas()));
        double total = proposta_orcamentaria.getDespesas() + proposta_orcamentaria.getCustos_previstos();
        System.out.println("Total R$: " + decimal.format(total));

    }

    public void printDadosFormularioEvento(Evento formulario) {

        Coordenador coordenador = formulario.getCoordenador();
        EnumModalidade modalidade = formulario.getModalidade();
        EnumAreaExtensao area_extensao = formulario.getArea_extensao();
        EnumLInhaExtensao lInha_extensao = formulario.getLinha_extensao();
        EnumEvento evento = formulario.getTipo_evento();
        ArrayList<String> referencias = formulario.getReferencias();
        Publico publico = formulario.getPublico();
        CargaHoraria carga_horaria = formulario.getCarga_horaria();
        ArrayList<CronogramaExecucao> cronogramas = formulario.getCronogramas_execucao();
        ArrayList<Membro> equipe = formulario.getEquipe();
        PropostaOrcamentaria proposta_orcamentaria = formulario.getProposta_orcamentaria();
        int count = 1;
        DecimalFormat decimal = new DecimalFormat("0.00");

        System.out.println("\n-------------- " + formulario.getNome_arquivo() + " --------------");
        System.out.println("\n1 - Modalidade da Proposta de Extensão -> " + modalidade.getTexto());
        System.out.println("\n2 - *Eventos -> " + evento.getTexto());
        System.out.println("\n3 - Área de Extensão Vinculada -> " + area_extensao.getTexto());
        System.out.println("\n4 - Linha de Extensão -> " + lInha_extensao.getTexto());
        System.out.println("\n5 - Título da Ação Proposta: " + formulario.getTitulo_proposta());
        System.out.println("\n6 - Coordenador(a):");
        System.out.println("Nome completo: " + coordenador.getNome());
        System.out.println("CPF: " + coordenador.getCpf());
        System.out.println("Email: " + coordenador.getEmail());
        System.out.println("Telefone: " + coordenador.getTelefone());
        System.out.println("Titulação: " + coordenador.getTitulacao());
        System.out.println("Área de Formação: " + coordenador.getArea_formacao());
        System.out.println("\n7 - Colegiado/Setor Proponente e campus: " + formulario.getColegiado_campus());
        System.out.println("\n8 - Apresentação da Ação de Extensão: " + formulario.getApresentacao_acao());
        System.out.println("\n9 - Justificativa: " + formulario.getJustificativa());
        System.out.println("\n10 - Objetivos: " + formulario.getObjetivos());
        System.out.println("\n11 - Metas: " + formulario.getMetas());
        System.out.println("\n12 - Resultados Esperados: " + formulario.getResultados_esperados());
        System.out.println("\n13 - Metodologia: " + formulario.getMetodologia());
        System.out.println("\n14 - Referências Bibliográficas:");
        for(String referencia : referencias)
            System.out.println(referencia);
        System.out.println("\n15 - Público-Alvo: " + publico.getPublico_alvo());
        System.out.println("Nº de Pessoas Beneficiadas: " + publico.getPessoas_beneficiadas());
        System.out.println("\n16 - Natureza Acadêmica da Ação - Indissociabiliadade entre extensão, ensino e pesquisa: " + formulario.getIndissociabiliadade());
        System.out.println("\n17 - Relações com a Sociedade - Indicadores de Impacto: " + formulario.getIndicadores_impacto());
        System.out.println("\n18 - Avaliação da Ação: " + formulario.getAvaliacao());
        System.out.println("\n19 - Carga Horária*:");
        System.out.println("Período de Execução da Ação (dia, mês e ano)");
        System.out.println("Início: " + carga_horaria.getInicio());
        System.out.println("Fim: " + carga_horaria.getFim());
        System.out.println("Carga Horária semanal: " + carga_horaria.getCh_semanal());
        System.out.println("Carga horária anual: " + carga_horaria.getCh_anual());
        System.out.println("\n20 - Cronograma de Execução:");
        for(CronogramaExecucao cronograma : cronogramas){
            System.out.println(count + "º");
            System.out.println("Atividades Planejadas: " + cronograma.getAtividade_planejada());
            System.out.println("Período: " + cronograma.getPeriodo());
            System.out.println("Local: " + cronograma.getLocal());
            System.out.println("Observações: " + cronograma.getObservacao());
            count++;
        }
        count = 1;
        System.out.println("\n21 - Equipe de Execução:");
        for(Membro membro : equipe){
            System.out.println(count + "º");
            System.out.println("Nome Completo: " + membro.getNome_completo());
            System.out.println("CPF: " + membro.getCpf());
            System.out.println("Instituição: " + membro.getInstituicao());
            System.out.println("Colegiado/Setor: " + membro.getColegiado_setor());
            System.out.println("Categoria Profissional (docente, técnico, aluno, etc.): " + membro.getCategoria_profissional());
            System.out.println("*Função no Projeto (colaborador, voluntário, etc.): " + membro.getFuncao_projeto());
            count++;
        }
        System.out.println("\n22 - Proposta Orçamentária (previsão):");
        System.out.println("Recursos: " + proposta_orcamentaria.getRecursos());
        System.out.println("Justificativas: " + proposta_orcamentaria.getJustificativas());
        System.out.println("Custos Previstos (R$): " + decimal.format(proposta_orcamentaria.getCustos_previstos()));
        System.out.println("Origem do Recurso: " + proposta_orcamentaria.getOrigem_recurso());
        System.out.println("Outras Despesas: " + decimal.format(proposta_orcamentaria.getDespesas()));
        double total = proposta_orcamentaria.getDespesas() + proposta_orcamentaria.getCustos_previstos();
        System.out.println("Total R$: " + decimal.format(total));


    }

    public void printDadosFormularioCurso(Curso formulario) {

        Coordenador coordenador = formulario.getCoordenador();
        EnumModalidade modalidade = formulario.getModalidade();
        EnumAreaExtensao area_extensao = formulario.getArea_extensao();
        EnumLInhaExtensao lInha_extensao = formulario.getLinha_extensao();
        EnumCursos curso = formulario.getTipo_curso();
        ArrayList<String> referencias = formulario.getReferencias();
        Publico publico = formulario.getPublico();
        CargaHoraria carga_horaria = formulario.getCarga_horaria();
        ArrayList<CronogramaExecucao> cronogramas = formulario.getCronogramas_execucao();
        ArrayList<Membro> equipe = formulario.getEquipe();
        PropostaOrcamentaria proposta_orcamentaria = formulario.getProposta_orcamentaria();
        int count = 1;
        DecimalFormat decimal = new DecimalFormat("0.00");

        System.out.println("\n-------------- " + formulario.getNome_arquivo() + " --------------");
        System.out.println("\n1 - Modalidade da Proposta de Extensão -> " + modalidade.getTexto());
        System.out.println("\n2 - *Cursos -> " + curso.getTexto());
        System.out.println("\n3 - Área de Extensão Vinculada -> " + area_extensao.getTexto());
        System.out.println("\n4 - Linha de Extensão -> " + lInha_extensao.getTexto());
        System.out.println("\n5 - Título da Ação Proposta: " + formulario.getTitulo_proposta());
        System.out.println("\n6 - Coordenador(a):");
        System.out.println("Nome completo: " + coordenador.getNome());
        System.out.println("CPF: " + coordenador.getCpf());
        System.out.println("Email: " + coordenador.getEmail());
        System.out.println("Telefone: " + coordenador.getTelefone());
        System.out.println("Titulação: " + coordenador.getTitulacao());
        System.out.println("Área de Formação: " + coordenador.getArea_formacao());
        System.out.println("\n7 - Colegiado/Setor Proponente e campus: " + formulario.getColegiado_campus());
        System.out.println("\n8 - Apresentação da Ação de Extensão: " + formulario.getApresentacao_acao());
        System.out.println("\n9 - Justificativa: " + formulario.getJustificativa());
        System.out.println("\n10 - Objetivos: " + formulario.getObjetivos());
        System.out.println("\n11 - Metas: " + formulario.getMetas());
        System.out.println("\n12 - Resultados Esperados: " + formulario.getResultados_esperados());
        System.out.println("\n13 - Metodologia: " + formulario.getMetodologia());
        System.out.println("\n14 - Referências Bibliográficas:");
        for(String referencia : referencias)
            System.out.println(referencia);
        System.out.println("\n15 - Público-Alvo: " + publico.getPublico_alvo());
        System.out.println("Nº de Pessoas Beneficiadas: " + publico.getPessoas_beneficiadas());
        System.out.println("\n16 - Natureza Acadêmica da Ação - Indissociabiliadade entre extensão, ensino e pesquisa: " + formulario.getIndissociabiliadade());
        System.out.println("\n17 - Relações com a Sociedade - Indicadores de Impacto: " + formulario.getIndicadores_impacto());
        System.out.println("\n18 - Avaliação da Ação: " + formulario.getAvaliacao());
        System.out.println("\n19 - Carga Horária*:");
        System.out.println("Período de Execução da Ação (dia, mês e ano)");
        System.out.println("Início: " + carga_horaria.getInicio());
        System.out.println("Fim: " + carga_horaria.getFim());
        System.out.println("Carga Horária semanal: " + carga_horaria.getCh_semanal());
        System.out.println("Carga horária anual: " + carga_horaria.getCh_anual());
        System.out.println("\n20 - Cronograma de Execução:");
        for(CronogramaExecucao cronograma : cronogramas){
            System.out.println(count + "º");
            System.out.println("Atividades Planejadas: " + cronograma.getAtividade_planejada());
            System.out.println("Período: " + cronograma.getPeriodo());
            System.out.println("Local: " + cronograma.getLocal());
            System.out.println("Observações: " + cronograma.getObservacao());
            count++;
        }
        count = 1;
        System.out.println("\n21 - Equipe de Execução:");
        for(Membro membro : equipe){
            System.out.println(count + "º");
            System.out.println("Nome Completo: " + membro.getNome_completo());
            System.out.println("CPF: " + membro.getCpf());
            System.out.println("Instituição: " + membro.getInstituicao());
            System.out.println("Colegiado/Setor: " + membro.getColegiado_setor());
            System.out.println("Categoria Profissional (docente, técnico, aluno, etc.): " + membro.getCategoria_profissional());
            System.out.println("*Função no Projeto (colaborador, voluntário, etc.): " + membro.getFuncao_projeto());
            count++;
        }
        System.out.println("\n22 - Proposta Orçamentária (previsão):");
        System.out.println("Recursos: " + proposta_orcamentaria.getRecursos());
        System.out.println("Justificativas: " + proposta_orcamentaria.getJustificativas());
        System.out.println("Custos Previstos (R$): " + decimal.format(proposta_orcamentaria.getCustos_previstos()));
        System.out.println("Origem do Recurso: " + proposta_orcamentaria.getOrigem_recurso());
        System.out.println("Outras Despesas: " + decimal.format(proposta_orcamentaria.getDespesas()));
        double total = proposta_orcamentaria.getDespesas() + proposta_orcamentaria.getCustos_previstos();
        System.out.println("Total R$: " + decimal.format(total));

    }

}
