package main.projetoExtensao.controllers;

import main.projetoExtensao.formularios.formularioAvaliacao.models.FormularioAvaliacao;
import main.projetoExtensao.formularios.formularioSubmissao.FormularioSubmissao;
import main.projetoExtensao.formularios.formularioSubmissao.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerInicio {
    private Scanner scanner;
    private FormularioSubmissao formulario_submissao;
    private FormularioAvaliacao formulario_avaliacao;
    private ControllerCriarFormularioSubmissao criar_formulario;
    private ControllerCriarFormularioAvaliacao criar_formulario_avaliacao;
    private ControllerAtualizarFormularioSubmissao atualizar_formulario;
    private ControllerAtualizarFormularioAvaliacao atualizar_formulario_avaliacao;
    private ControllerDeletarFormularioSubmissao deletar_formulario;
    private ControllerDeletarFormularioAvaliacao deletar_formulario_avaliacao;
    private ControllerVerFormularioSubmissao ver_formulario;
    private ControllerVerFormularioAvaliacao ver_formulario_avaliacao;
    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<EmpresaJunior> empresas_juniors = new ArrayList<>();
    private ArrayList<Evento> eventos = new ArrayList<>();
    private ArrayList<LigaAcademica> ligas_cademicas = new ArrayList<>();
    private ArrayList<NucleoTematico> nucleos_tematicos = new ArrayList<>();
    private ArrayList<PrestacaoServico> prestacoes_servicos = new ArrayList<>();
    private ArrayList<Programa> programas = new ArrayList<>();
    private ArrayList<Projeto> projetos = new ArrayList<>();
    private ArrayList<FormularioAvaliacao> formularios_avaliacoes = new ArrayList<>();

    public ControllerInicio(){
        scanner = new Scanner(System.in);
        formulario_submissao = new FormularioSubmissao();
        formulario_avaliacao = new FormularioAvaliacao();
        criar_formulario = new ControllerCriarFormularioSubmissao();
        criar_formulario_avaliacao = new ControllerCriarFormularioAvaliacao();
    }

    public void iniciarMenu(){
        atualizar_formulario = new ControllerAtualizarFormularioSubmissao(cursos,empresas_juniors, eventos, ligas_cademicas, nucleos_tematicos, prestacoes_servicos, programas, projetos);
        deletar_formulario = new ControllerDeletarFormularioSubmissao(cursos, empresas_juniors, eventos, ligas_cademicas, nucleos_tematicos, prestacoes_servicos, programas, projetos);
        ver_formulario = new ControllerVerFormularioSubmissao(cursos, empresas_juniors, eventos, ligas_cademicas, nucleos_tematicos, prestacoes_servicos, programas, projetos);
        ver_formulario_avaliacao = new ControllerVerFormularioAvaliacao(formularios_avaliacoes);
        atualizar_formulario_avaliacao = new ControllerAtualizarFormularioAvaliacao(formularios_avaliacoes);
        deletar_formulario_avaliacao = new ControllerDeletarFormularioAvaliacao(formularios_avaliacoes);
        int input;
        boolean condicao = true;

        while(condicao) {
            System.out.println("\n=================================");
            System.out.println("BEM VINDO À DIRETORIA DE EXTENSÃO");
            System.out.println("=================================\n");
            System.out.println("1 - Formulário de Submissão");
            System.out.println("2 - Formulário de Avaliação");
            System.out.println("0 - Encerrar Processo");

            try {
                input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 1:
                        menuFormularioSubimissao();
                        break;

                    case 2:
                        menuFormularioAvaliacao();
                        break;

                    case 0:
                        condicao = false;
                        break;

                    default:
                        System.out.println("Escolha uma das opções disponíveis");
                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println("Selecione um dos índices disponíveis!");
                scanner.nextLine();
            }
        }

    }

    public void menuFormularioSubimissao(){
        int input;
        boolean condicao = true;

        while(condicao) {
            System.out.println("\n===========================================");
            System.out.println("FORMULÁRIO DE SUBMISSÃO DE AÇÃO DE EXTENSÃO");
            System.out.println("===========================================\n");
            System.out.println("Oque você deseja?");
            System.out.println("1 - Criar um Formulário de Subimissão");
            System.out.println("2 - Ver um Formulário de Subimissão");
            System.out.println("3 - Atualizar um Formulário de Subimissão");
            System.out.println("4 - Deletar um Formulário de Subimissão");
            System.out.println("0 - Voltar");

            try {
                input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 1:
                        System.out.println("Você escolheu criar um Formulário de Subimissão...\n");
                        formulario_submissao = criar_formulario.iniciarFormulario();
                        addArquivo(formulario_submissao);
                        System.out.println("\nDocumento criado com sucesso!\n\n");
                        break;

                    case 2:
                        System.out.println("Você escolheu ver um Formulário de Subimissão...\n");
                        ver_formulario.exibirFormularios();
                        break;

                    case 3:
                        System.out.println("Você escolheu atualizar um Formulário de Subimissão...\n");
                        atualizar_formulario.exibirFormularios();
                        break;

                    case 4:
                        System.out.println("Você escolheu deletar um Formulário de Subimissão...\n");
                        deletar_formulario.exibirFormularios();
                        break;

                    case 0:
                        condicao = false;
                        break;

                    default:
                        System.out.println("Escolha uma das opções disponíveis");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Selecione um dos índices disponíveis!");
                scanner.nextLine();
            }
        }
    }

    public void menuFormularioAvaliacao(){
        int input;
        boolean condicao = true;
        FormularioSubmissao formulario_submissao;

        while(condicao) {
            System.out.println("\n========================================");
            System.out.println("FICHA DE AVALIAÇÃO PARA AÇÃO DE EXTENSÃO");
            System.out.println("========================================\n");
            System.out.println("Oque você deseja?");
            System.out.println("1 - Criar um Formulário");
            System.out.println("2 - Ver um Formulário");
            System.out.println("3 - Atualizar um Formulário");
            System.out.println("4 - Deletar um Formulário");
            System.out.println("0 - Voltar");

            try {
                input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 1:
                        if(!ver_formulario.formularioIsEmpty()) {
                            System.out.println("Você escolheu criar um formulário...\n");
                            formulario_submissao = selecionarAvaliacao();
                            formulario_avaliacao = criar_formulario_avaliacao.criarFormulario(formulario_submissao);
                            formularios_avaliacoes.add(formulario_avaliacao);
                            System.out.println("Documento criado com sucesso!\n\n");
                        } else
                            System.out.println("Nenhum Formulário de Submissão foi criado. É preciso criar um Formulário de Submissão para poder Ver, Deletar ou Atualizar.\n");
                        break;

                    case 2:
                        System.out.println("Você escolheu ver um formulário...\n");
                        ver_formulario_avaliacao.exibirFormularios();
                        break;

                    case 3:
                        System.out.println("Você escolheu atualizar um formulário...\n");
                        atualizar_formulario_avaliacao.exibirFormularios();
                        break;

                    case 4:
                        System.out.println("Você escolheu deletar um formulário...\n");
                        deletar_formulario_avaliacao.exibirFormularios();
                        break;

                    case 0:
                        condicao = false;
                        break;

                    default:
                        System.out.println("Escolha uma das opções disponíveis");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Selecione um dos índices disponíveis!");
                scanner.nextLine();
            }
        }
    }

    public void addArquivo(FormularioSubmissao formulario_submissao){

        if(formulario_submissao instanceof Programa)
            criar_formulario.addFormulario(programas, (Programa) formulario_submissao);

        else if(formulario_submissao instanceof Projeto)
            criar_formulario.addFormulario(projetos, (Projeto) formulario_submissao);

        else if(formulario_submissao instanceof NucleoTematico)
            criar_formulario.addFormulario(nucleos_tematicos, (NucleoTematico) formulario_submissao);

        else if(formulario_submissao instanceof Evento)
            criar_formulario.addFormulario(eventos, (Evento) formulario_submissao);

        else if(formulario_submissao instanceof EmpresaJunior)
            criar_formulario.addFormulario(empresas_juniors, (EmpresaJunior) formulario_submissao);

        else if(formulario_submissao instanceof LigaAcademica)
            criar_formulario.addFormulario(ligas_cademicas, (LigaAcademica) formulario_submissao);

        else if(formulario_submissao instanceof PrestacaoServico)
            criar_formulario.addFormulario(prestacoes_servicos, (PrestacaoServico) formulario_submissao);

        else if(formulario_submissao instanceof Curso)
            criar_formulario.addFormulario(cursos, (Curso) formulario_submissao);
    }

    public FormularioSubmissao selecionarAvaliacao() {

        int opcao = 0;
        boolean condicao = true;
        FormularioSubmissao form = new FormularioSubmissao();

        while (condicao) {
            System.out.println("\nPara ser possível preencher um Formulario de Avaliação é preciso escolher um Formulário de Submissão.\nEntão vamos lá...");
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
                        return escolherFormulario(programas);

                    case 2:
                        return escolherFormulario(projetos);

                    case 3:
                        return escolherFormulario(nucleos_tematicos);

                    case 4:
                        return escolherFormulario(eventos);

                    case 5:
                        return escolherFormulario(empresas_juniors);

                    case 6:
                        return escolherFormulario(ligas_cademicas);

                    case 7:
                        return escolherFormulario(prestacoes_servicos);

                    case 8:
                        return escolherFormulario(cursos);

                    default:
                        System.out.println("Esses campos são obrigatórios! Marque um desses que estão disponíveis.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Esses campos são obrigatórios! Marque um desses que estão disponíveis.");
                scanner.nextLine();
            }
        }
        return form;
    }

    public <T extends FormularioSubmissao> FormularioSubmissao escolherFormulario(ArrayList<T> formularios){
        FormularioSubmissao form = new FormularioSubmissao();
        if(formularios.isEmpty())
            System.out.println("\n Não há formulários dessa modalidade\n");
        else {
            int indice, opcao;
            boolean condicao = true;

            while (condicao) {
                indice = 0;
                System.out.println("------- Lista de Formulários -------");
                for (T formulario : formularios) {
                    System.out.println(indice + " - " + formulario.getNome_arquivo());
                    indice++;
                }
                System.out.print(indice + " - Voltar");


                while (indice < 0 || indice >= formularios.size()) {

                    System.out.print("\nQual desses documentos você deseja avaliar (escolha pelo índice)? ");

                    try {
                        opcao = scanner.nextInt();
                        scanner.nextLine();

                        if (opcao >= 0 && opcao < formularios.size()) {
                            return formularios.get(opcao);
                        } else if (indice == opcao) {
                            indice--;
                            condicao = false;
                        }
                        else
                            System.out.println("Escolha um dos índices disponíveis.");

                    } catch (InputMismatchException e) {
                        System.out.println("Escolha pelo índice.");
                        scanner.nextLine();
                    }

                }
            }
        }
        return form;
    }

    public void serializacao()
            throws IOException, ClassNotFoundException {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("programas.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(programas);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("cursos.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(cursos);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("empresas.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(empresas_juniors);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("eventos.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(eventos);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("ligas.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(ligas_cademicas);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("nucleos.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(nucleos_tematicos);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("prestacoes.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(prestacoes_servicos);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("projetos.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(projetos);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("avaliacao.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(formularios_avaliacoes);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void dessserializacao()
            throws IOException, ClassNotFoundException {

        try {
            FileInputStream fileInputStream = new FileInputStream("programas.txt");

            if (fileInputStream.available() > 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                programas = (ArrayList<Programa>) objectInputStream.readObject();
                objectInputStream.close();
            } else {
                System.out.println("Não foi carregado nenhuma informação do arquivo pois o arquivo está vazio");
            }

            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("cursos.txt");

            if (fileInputStream.available() > 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                cursos = (ArrayList<Curso>) objectInputStream.readObject();
                objectInputStream.close();
            } else {
                System.out.println("Não foi carregado nenhuma informação do arquivo pois o arquivo está vazio");
            }

            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("empresas.txt");

            if (fileInputStream.available() > 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                empresas_juniors = (ArrayList<EmpresaJunior>) objectInputStream.readObject();
                objectInputStream.close();
            } else {
                System.out.println("Não foi carregado nenhuma informação do arquivo pois o arquivo está vazio");
            }

            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("eventos.txt");

            if (fileInputStream.available() > 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                eventos = (ArrayList<Evento>) objectInputStream.readObject();
                objectInputStream.close();
            } else {
                System.out.println("Não foi carregado nenhuma informação do arquivo pois o arquivo está vazio");
            }

            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("ligas.txt");

            if (fileInputStream.available() > 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                ligas_cademicas = (ArrayList<LigaAcademica>) objectInputStream.readObject();
                objectInputStream.close();
            } else {
                System.out.println("Não foi carregado nenhuma informação do arquivo pois o arquivo está vazio");
            }

            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("nucleos.txt");

            if (fileInputStream.available() > 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                nucleos_tematicos = (ArrayList<NucleoTematico>) objectInputStream.readObject();
                objectInputStream.close();
            } else {
                System.out.println("Não foi carregado nenhuma informação do arquivo pois o arquivo está vazio");
            }

            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("prestacoes.txt");

            if (fileInputStream.available() > 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                prestacoes_servicos = (ArrayList<PrestacaoServico>) objectInputStream.readObject();
                objectInputStream.close();
            } else {
                System.out.println("Não foi carregado nenhuma informação do arquivo pois o arquivo está vazio");
            }

            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("projetos.txt");

            if (fileInputStream.available() > 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                projetos = (ArrayList<Projeto>) objectInputStream.readObject();
                objectInputStream.close();
            } else {
                System.out.println("Não foi carregado nenhuma informação do arquivo pois o arquivo está vazio");
            }

            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("avaliacao.txt");

            if (fileInputStream.available() > 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                formularios_avaliacoes = (ArrayList<FormularioAvaliacao>) objectInputStream.readObject();
                objectInputStream.close();
            } else {
                System.out.println("Não foi carregado nenhuma informação do arquivo pois o arquivo está vazio");
            }

            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}

