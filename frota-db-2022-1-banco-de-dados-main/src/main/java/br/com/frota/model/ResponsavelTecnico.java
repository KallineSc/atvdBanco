package br.com.frota.model;

public class ResponsavelTecnico extends GenericModel{
    private String nome;
    private String conselho;
    private String formacao;
    private String sigla_formacao;
    private Integer sigla_formacao_id;
    
    public ResponsavelTecnico(String nome, String conselho, String formacao, String sigla_formacao,
            Integer sigla_formacao_id) {
        this.nome = nome;
        this.conselho = conselho;
        this.formacao = formacao;
        this.sigla_formacao = sigla_formacao;
        this.sigla_formacao_id = sigla_formacao_id;
    }
    public ResponsavelTecnico(Integer id, String nome, String conselho, String formacao, String sigla_formacao,
            Integer sigla_formacao_id) {
        this.nome = nome;
        this.conselho = conselho;
        this.formacao = formacao;
        this.sigla_formacao = sigla_formacao;
        this.sigla_formacao_id = sigla_formacao_id;
        super.setId(id);
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getConselho() {
        return conselho;
    }
    public void setConselho(String conselho) {
        this.conselho = conselho;
    }
    public String getFormacao() {
        return formacao;
    }
    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
    public String getSigla_formacao() {
        return sigla_formacao;
    }
    public void setSigla_formacao(String sigla_formacao) {
        this.sigla_formacao = sigla_formacao;
    }
    public Integer getSigla_formacao_id() {
        return sigla_formacao_id;
    }
    public void setSigla_formacao_id(Integer sigla_formacao_id) {
        this.sigla_formacao_id = sigla_formacao_id;
    }

    
}
