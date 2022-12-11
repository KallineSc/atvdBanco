package br.com.frota.model;

public class Laudo extends GenericModel{
    private String assinatura_digital;
    private String dt_resultado;
    private String codigo;
    private Integer solicitacao_exame_id;
    
    public Laudo(String assinatura_digital, String dt_resultado, String codigo, Integer solicitacao_exame_id) {
        this.assinatura_digital = assinatura_digital;
        this.dt_resultado = dt_resultado;
        this.codigo = codigo;
        this.solicitacao_exame_id = solicitacao_exame_id;
    }
    public Laudo(Integer id, String assinatura_digital, String dt_resultado, String codigo, Integer solicitacao_exame_id) {
        this.assinatura_digital = assinatura_digital;
        this.dt_resultado = dt_resultado;
        this.codigo = codigo;
        this.solicitacao_exame_id = solicitacao_exame_id;
        super.setId(id);
    }
    public String getAssinatura_digital() {
        return assinatura_digital;
    }
    public void setAssinatura_digital(String assinatura_digital) {
        this.assinatura_digital = assinatura_digital;
    }
    public String getDt_resultado() {
        return dt_resultado;
    }
    public void setDt_resultado(String dt_resultado) {
        this.dt_resultado = dt_resultado;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public Integer getSolicitacao_exame_id() {
        return solicitacao_exame_id;
    }
    public void setSolicitacao_exame_id(Integer solicitacao_exame_id) {
        this.solicitacao_exame_id = solicitacao_exame_id;
    }
    
}
