package br.com.frota.model;

public class TipoExame extends GenericModel{
    private String descricao;
    private String observacao;

    public TipoExame(String descricao, String observacao) {
        this.descricao = descricao;
        this.observacao = observacao;
    }

    public TipoExame(Integer id, String descricao, String observacao) {
        this.descricao = descricao;
        this.observacao = observacao;
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    @Override
    public String toString() {
        return "Tipo Exame {\n" +
                "id='" + this.getId() + "\'\n" +
                "descricao='" + descricao + "\'\n" +
                "observacao='" + observacao + "\'\n" +
                '}';
    }

}
