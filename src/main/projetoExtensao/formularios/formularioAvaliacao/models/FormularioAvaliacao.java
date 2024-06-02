package main.projetoExtensao.formularios.formularioAvaliacao.models;

import main.projetoExtensao.formularios.Formularios;
import main.projetoExtensao.formularios.formularioSubmissao.enuns.EnumModalidade;


public class FormularioAvaliacao extends Formularios {
    private String nome_arquivo;
    private String avaliador;
    private String colegiado;
    private EnumModalidade modalidade;
    final private IdentificacaoProposta proposta;
    final private CheckBoxOpcao titulo;
    private String consideracoes_objetivos;
    final private CheckBoxAtende[] natureza_academica;
    final private CheckBoxAtende[] relacoes_sociedade;
    final private CheckBoxConsistente fundamentacao_teorica;
    final private CheckBoxConsistente merito_proposta;
    final private CheckBoxConsistente estrutura_projeto;
    final private CheckBoxConsistente iteracao_conhecimento;
    final private CheckBoxConsistente publico_alvo;
    final private CheckBoxOpcao cronograma;
    final private CheckBoxConsistente recursos;
    final private CheckBoxConsistente resultados_esperados;
    final private CheckBoxOpcao avaliacao;
    final private CheckBoxOpcao extensao;
    final private CheckBoxParecer parecer;
    private String local_data;

    public FormularioAvaliacao(){
        natureza_academica = new CheckBoxAtende[4];
        for (int i = 0; i < 4; i++) {
            natureza_academica[i] = new CheckBoxAtende();
        }
        relacoes_sociedade = new CheckBoxAtende[3];
        for (int i = 0; i < 3; i++) {
            relacoes_sociedade[i] = new CheckBoxAtende();
        }
        proposta = new IdentificacaoProposta();
        fundamentacao_teorica = new CheckBoxConsistente();
        merito_proposta = new CheckBoxConsistente();
        estrutura_projeto = new CheckBoxConsistente();
        iteracao_conhecimento = new CheckBoxConsistente();
        publico_alvo = new CheckBoxConsistente();
        cronograma = new CheckBoxOpcao();
        recursos = new CheckBoxConsistente();
        resultados_esperados = new CheckBoxConsistente();
        avaliacao = new CheckBoxOpcao();
        extensao = new CheckBoxOpcao();
        parecer = new CheckBoxParecer();
        titulo = new CheckBoxOpcao();
    }

    public CheckBoxAtende[] getNatureza_academica() {
        return natureza_academica;
    }

    public CheckBoxAtende[] getRelacoes_sociedade() {
        return relacoes_sociedade;
    }

    public CheckBoxConsistente getEstrutura_projeto() {
        return estrutura_projeto;
    }

    public CheckBoxConsistente getFundamentacao_teorica() {
        return fundamentacao_teorica;
    }

    public CheckBoxConsistente getIteracao_conhecimento() {
        return iteracao_conhecimento;
    }

    public CheckBoxConsistente getMerito_proposta() {
        return merito_proposta;
    }

    public CheckBoxConsistente getPublico_alvo() {
        return publico_alvo;
    }

    public CheckBoxConsistente getRecursos() {
        return recursos;
    }

    public CheckBoxConsistente getResultados_esperados() {
        return resultados_esperados;
    }

    public CheckBoxOpcao getAvaliacao() {
        return avaliacao;
    }

    public CheckBoxOpcao getCronograma() {
        return cronograma;
    }

    public CheckBoxOpcao getExtensao() {
        return extensao;
    }

    public CheckBoxOpcao getTitulo() {
        return titulo;
    }

    public CheckBoxParecer getParecer() {
        return parecer;
    }

    public EnumModalidade getModalidade() {
        return modalidade;
    }

    public IdentificacaoProposta getProposta() {
        return proposta;
    }

    public String getConsideracoes_objetivos() {
        return consideracoes_objetivos;
    }

    public String getLocal_data() {
        return local_data;
    }

    public String getAvaliador() {
        return avaliador;
    }

    public String getColegiado() {
        return colegiado;
    }

    public String getNome_arquivo() {
        return nome_arquivo;
    }

    public void setConsideracoes_objetivos(String consideracoes_objetivos) {
        this.consideracoes_objetivos = consideracoes_objetivos;
    }

    public void setLocal_data(String local_data) {
        this.local_data = local_data;
    }

    public void setModalidade(EnumModalidade modalidade) {
        this.modalidade = modalidade;
    }

    public void setAvaliador(String avaliador) {
        this.avaliador = avaliador;
    }

    public void setColegiado(String colegiado) {
        this.colegiado = colegiado;
    }

    public void setNome_arquivo(String nome_arquivo) {
        this.nome_arquivo = nome_arquivo;
    }

}
