package main.projetoExtensao.formularios.formularioSubmissao;

import main.projetoExtensao.formularios.Formularios;
import main.projetoExtensao.formularios.formularioSubmissao.enuns.EnumAreaExtensao;
import main.projetoExtensao.formularios.formularioSubmissao.enuns.EnumLInhaExtensao;
import main.projetoExtensao.formularios.formularioSubmissao.enuns.EnumModalidade;
import main.projetoExtensao.formularios.formularioSubmissao.models.*;

import java.util.ArrayList;

public class FormularioSubmissao extends Formularios {
    protected String nome_arquivo;
    protected EnumModalidade modalidade;
    protected EnumAreaExtensao area_extensao;
    protected EnumLInhaExtensao linha_extensao;
    protected String titulo_proposta;
    final protected Coordenador coordenador;
    protected String colegiado_campus;
    protected String apresentacao_acao;
    protected String justificativa;
    protected String objetivos;
    protected String metas;
    protected String resultados_esperados;
    protected String metodologia;
    final protected ArrayList<String> referencias;
    final protected Publico publico;
    protected String indissociabiliadade;
    protected String indicadores_impacto;
    protected String avaliacao;
    final protected CargaHoraria carga_horaria;
    final protected ArrayList<CronogramaExecucao> cronogramas_execucao;
    final protected ArrayList<Membro> equipe;
    final protected PropostaOrcamentaria proposta_orcamentaria;
    private static final long serialVersionUID = 1138922830810543596L;

    public FormularioSubmissao(){
        modalidade = EnumModalidade.VAZIO;
        area_extensao = EnumAreaExtensao.VAZIO;
        linha_extensao = EnumLInhaExtensao.VAZIO;
        coordenador = new Coordenador();
        referencias = new ArrayList<>();
        publico = new Publico();
        carga_horaria = new CargaHoraria();
        cronogramas_execucao = new ArrayList<>();
        equipe = new ArrayList<>();
        proposta_orcamentaria = new PropostaOrcamentaria();
    }

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public EnumModalidade getModalidade(){
        return modalidade;
    }

    public EnumAreaExtensao getArea_extensao(){
        return area_extensao;
    }

    public EnumLInhaExtensao getLinha_extensao(){
        return linha_extensao;
    }

    public String getNome_arquivo() {
        return nome_arquivo;
    }

    public String getTitulo_proposta() {
        return titulo_proposta;
    }

    public String getApresentacao_acao() {
        return apresentacao_acao;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public String getMetas() {
        return metas;
    }

    public String getResultados_esperados() {
        return resultados_esperados;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public ArrayList<String> getReferencias() {
        return referencias;
    }

    public Publico getPublico() {
        return publico;
    }

    public ArrayList<CronogramaExecucao> getCronogramas_execucao() {
        return cronogramas_execucao;
    }

    public ArrayList<Membro> getEquipe() {
        return equipe;
    }

    public CargaHoraria getCarga_horaria() {
        return carga_horaria;
    }

    public PropostaOrcamentaria getProposta_orcamentaria() {
        return proposta_orcamentaria;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public String getIndicadores_impacto() {
        return indicadores_impacto;
    }

    public String getIndissociabiliadade() {
        return indissociabiliadade;
    }

    public String getColegiado_campus() {
        return colegiado_campus;
    }

    public void setApresentacao_acao(String apresentacao_acao) {
        this.apresentacao_acao = apresentacao_acao;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public void setMetas(String metas) {
        this.metas = metas;
    }

    public void setResultados_esperados(String resultados_esperados) {
        this.resultados_esperados = resultados_esperados;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public void setNome_arquivo(String nome_arquivo) {
        this.nome_arquivo = nome_arquivo;
    }

    public void setTitulo_proposta(String titulo_proposta) {
        this.titulo_proposta = titulo_proposta;
    }

    public void setModalidade(EnumModalidade modalidade){
        this.modalidade = modalidade;
    }

    public void setArea_extensao(EnumAreaExtensao area_extensao){
        this.area_extensao = area_extensao;
    }

    public void setLinha_extensao(EnumLInhaExtensao linha_extensao){
        this.linha_extensao = linha_extensao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setIndicadores_impacto(String indicadores_impacto) {
        this.indicadores_impacto = indicadores_impacto;
    }

    public void setIndissociabiliadade(String indissociabiliadade) {
        this.indissociabiliadade = indissociabiliadade;
    }

    public void setColegiado_campus(String colegiado_campus) {
        this.colegiado_campus = colegiado_campus;
    }

}