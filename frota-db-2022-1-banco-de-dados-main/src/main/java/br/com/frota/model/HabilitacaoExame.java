package br.com.frota.model;

public class HabilitacaoExame extends GenericModel{
    private String observacao;
    private Integer custo;
    private Integer laboratorio_id; 
    private Integer tipo_exame;
    
    public HabilitacaoExame(String observacao, Integer custo, Integer laboratorio_id, Integer tipo_exame) {
        this.observacao = observacao;
        this.custo = custo;
        this.laboratorio_id = laboratorio_id;
        this.tipo_exame = tipo_exame;
    }
    public HabilitacaoExame(Integer id, String observacao, Integer custo, Integer laboratorio_id, Integer tipo_exame) {
        this.observacao = observacao;
        this.custo = custo;
        this.laboratorio_id = laboratorio_id;
        this.tipo_exame = tipo_exame;
        super.setId(id);
    }

    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public Integer getCusto() {
        return custo;
    }
    public void setCusto(Integer custo) {
        this.custo = custo;
    }
    public Integer getLaboratorio_id() {
        return laboratorio_id;
    }
    public void setLaboratorio_id(Integer laboratorio_id) {
        this.laboratorio_id = laboratorio_id;
    }
    public Integer getTipo_exame() {
        return tipo_exame;
    }
    public void setTipo_exame(Integer tipo_exame) {
        this.tipo_exame = tipo_exame;
    }

    @Override
    public String toString() {
        return "Habilitação Exame {\n" +
                "id='" + this.getId() + "\'\n" +
                "observacao='" + observacao + "\'\n" +
                "custo='" + custo + "\'\n" +
                "laboratorio_id='" + laboratorio_id + "\'\n" +
                "tipo_exame='" + tipo_exame + "\'\n" +
                '}';
    }

    
}
