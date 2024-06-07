package main.projetoExtensao.controllers;

import main.projetoExtensao.formularios.formularioAvaliacao.models.FormularioAvaliacao;
import main.projetoExtensao.formularios.formularioSubmissao.FormularioSubmissao;
import main.projetoExtensao.formularios.formularioSubmissao.enuns.EnumModalidade;
import main.projetoExtensao.formularios.formularioSubmissao.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
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
        criar_formulario_avaliacao = new ControllerCriarFormularioAvaliacao();
    }

    public void iniciarMenu(){
        criar_formulario = new ControllerCriarFormularioSubmissao(cursos, empresas_juniors, eventos, ligas_cademicas, nucleos_tematicos, prestacoes_servicos, programas, projetos);
        atualizar_formulario = new ControllerAtualizarFormularioSubmissao(cursos,empresas_juniors, eventos, ligas_cademicas, nucleos_tematicos, prestacoes_servicos, programas, projetos);
        deletar_formulario = new ControllerDeletarFormularioSubmissao(cursos, empresas_juniors, eventos, ligas_cademicas, nucleos_tematicos, prestacoes_servicos, programas, projetos, formularios_avaliacoes);
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
                        criar_formulario.iniciarFormulario();
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
                            selecionarAvaliacao();
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
                        String nome_arquivo_avaliado = deletar_formulario_avaliacao.exibirFormularios();
                        if(!Objects.equals(nome_arquivo_avaliado, "")) {
                            ControllerConexao.removerAvaliacao(cursos, empresas_juniors, eventos, ligas_cademicas, nucleos_tematicos, prestacoes_servicos, programas, projetos, nome_arquivo_avaliado);
                            System.out.println("\nDocumento deletado com sucesso!");
                        }
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

    public void selecionarAvaliacao() {

        int opcao;
        boolean condicao = true;

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
                        escolherFormulario(programas);
                        break;

                    case 2:
                        escolherFormulario(projetos);
                        break;

                    case 3:
                        escolherFormulario(nucleos_tematicos);
                    break;

                    case 4:
                        escolherFormulario(eventos);
                    break;

                    case 5:
                        escolherFormulario(empresas_juniors);
                    break;

                    case 6:
                        escolherFormulario(ligas_cademicas);
                    break;

                    case 7:
                        escolherFormulario(prestacoes_servicos);
                    break;

                    case 8:
                        escolherFormulario(cursos);
                    break;

                    default:
                        System.out.println("Esses campos são obrigatórios! Marque um desses que estão disponíveis.");
                        break;
                }
                if (opcao >= 1 && opcao <= 8) {
                    formularios_avaliacoes.add(formulario_avaliacao);
                    System.out.println("Documento criado com sucesso!\n\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Esses campos são obrigatórios! Marque um desses que estão disponíveis.");
                scanner.nextLine();
            }
        }
    }

    public <T extends FormularioSubmissao> void escolherFormulario(ArrayList<T> formularios){
        if(formularios.isEmpty())
            System.out.println("\n Não há formulários dessa modalidade\n");
        else {
            int indice, opcao;
            boolean condicao = true;

            while (condicao) {
                indice = 0;
                System.out.println("------- Lista de Formulários -------");
                for (T formulario : formularios) {
                    System.out.println(indice + " - " + formulario.getNome_arquivo() +" (" + formulario.getAvaliador() + ")");
                    indice++;
                }
                System.out.print(indice + " - Voltar");

                System.out.print("\nQual desses documentos você deseja avaliar (escolha pelo índice)? ");

                try {
                    opcao = scanner.nextInt();
                    scanner.nextLine();


                    if (opcao >= 0 && opcao < formularios.size()) {

                        formulario_submissao = formularios.get(opcao);
                        if (Objects.equals(formulario_submissao.getAvaliador(), "Formulário ainda não avaliado")) {
                            String nome_arquivo = addNomeAvaliacao();
                            formulario_avaliacao = criar_formulario_avaliacao.criarFormulario(formulario_submissao);
                            formulario_avaliacao.setNome_arquivo(nome_arquivo);
                            formulario_submissao.setAvaliador(formulario_avaliacao.getNome_arquivo());
                            condicao = false;
                        }
                        else
                            System.out.println("\nNão é posível avaliar um formulário já avaliado.");
                    } else if (indice == opcao) {
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

    public String addNomeAvaliacao(){
        try {
            boolean condicao = true;
            while(condicao) {
                System.out.println("\nQual nome você deseja dar ao documento? ");
                String nome_arquivo = scanner.nextLine();
                if (!ControllerConexao.existeFormularioAvaliacao(formularios_avaliacoes, nome_arquivo))
                    return nome_arquivo;
                System.out.println("\nJá existe um formulário de submissão com esse nome.");
            }
        }catch (InputMismatchException e){
            System.out.println("Erro ao inserir os dados");
            scanner.nextLine();
        }

        return "";
    }

    public void serializacao()
            throws IOException, ClassNotFoundException {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/serializados/programas.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(programas);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/serializados/cursos.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(cursos);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/serializados/empresas.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(empresas_juniors);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/serializados/eventos.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(eventos);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/serializados/ligas.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(ligas_cademicas);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/serializados/nucleos.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(nucleos_tematicos);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/serializados/prestacoes.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(prestacoes_servicos);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/serializados/projetos.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(projetos);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/serializados/avaliacao.txt");
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
            FileInputStream fileInputStream = new FileInputStream("src/main/serializados/programas.txt");

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
            FileInputStream fileInputStream = new FileInputStream("src/main/serializados/cursos.txt");

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
            FileInputStream fileInputStream = new FileInputStream("src/main/serializados/empresas.txt");

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
            FileInputStream fileInputStream = new FileInputStream("src/main/serializados/eventos.txt");

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
            FileInputStream fileInputStream = new FileInputStream("src/main/serializados/ligas.txt");

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
            FileInputStream fileInputStream = new FileInputStream("src/main/serializados/nucleos.txt");

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
            FileInputStream fileInputStream = new FileInputStream("src/main/serializados/prestacoes.txt");

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
            FileInputStream fileInputStream = new FileInputStream("src/main/serializados/projetos.txt");

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
            FileInputStream fileInputStream = new FileInputStream("src/main/serializados/avaliacao.txt");

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

