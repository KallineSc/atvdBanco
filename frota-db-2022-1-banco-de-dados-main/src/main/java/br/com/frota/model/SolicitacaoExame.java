package br.com.frota.model;

import java.security.Timestamp;

public class SolicitacaoExame extends GenericModel{
    private String nm_prescrito;
    private Timestamp dt_solicitacao;
    private Integer consulta_medica_id;
    private Integer habilitacao_exame_id; 
    private Integer exame_id;
    
    public SolicitacaoExame(String nm_prescrito, Timestamp dt_solicitacao, Integer consulta_medica_id,
            Integer habilitacao_exame_id, Integer exame_id) {
        this.nm_prescrito = nm_prescrito;
        this.dt_solicitacao = dt_solicitacao;
        this.consulta_medica_id = consulta_medica_id;
        this.habilitacao_exame_id = habilitacao_exame_id;
        this.exame_id = exame_id;
    }
    public SolicitacaoExame(Integer id, String nm_prescrito, Timestamp dt_solicitacao, Integer consulta_medica_id,
            Integer habilitacao_exame_id, Integer exame_id) {
        this.nm_prescrito = nm_prescrito;
        this.dt_solicitacao = dt_solicitacao;
        this.consulta_medica_id = consulta_medica_id;
        this.habilitacao_exame_id = habilitacao_exame_id;
        this.exame_id = exame_id;
        super.setId(id);
    }
    public String getNm_prescrito() {
        return nm_prescrito;
    }
    public void setNm_prescrito(String nm_prescrito) {
        this.nm_prescrito = nm_prescrito;
    }
    public Timestamp getDt_solicitacao() {
        return dt_solicitacao;
    }
    public void setDt_solicitacao(Timestamp dt_solicitacao) {
        this.dt_solicitacao = dt_solicitacao;
    }
    public Integer getConsulta_medica_id() {
        return consulta_medica_id;
    }
    public void setConsulta_medica_id(Integer consulta_medica_id) {
        this.consulta_medica_id = consulta_medica_id;
    }
    public Integer getHabilitacao_exame_id() {
        return habilitacao_exame_id;
    }
    public void setHabilitacao_exame_id(Integer habilitacao_exame_id) {
        this.habilitacao_exame_id = habilitacao_exame_id;
    }
    public Integer getExame_id() {
        return exame_id;
    }
    public void setExame_id(Integer exame_id) {
        this.exame_id = exame_id;
    }

    
}