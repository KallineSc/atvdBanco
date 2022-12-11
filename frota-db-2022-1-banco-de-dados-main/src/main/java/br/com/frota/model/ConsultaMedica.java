package br.com.frota.model;

import java.security.Timestamp;

public class ConsultaMedica extends GenericModel {
    private Timestamp dt_consulta;
    private String nm_atendimento; 
    private Integer medico_id;
    private Integer paciente_id;

    public ConsultaMedica(Timestamp dt_consulta, String nm_atendimento, Integer medico_id, Integer paciente_id) {
        this.dt_consulta = dt_consulta;
        this.nm_atendimento = nm_atendimento;
        this.medico_id = medico_id;
        this.paciente_id = paciente_id;
    }

    public ConsultaMedica(Integer id, Timestamp dt_consulta, String nm_atendimento, Integer medico_id, Integer paciente_id) {
        this.dt_consulta = dt_consulta;
        this.nm_atendimento = nm_atendimento;
        this.medico_id = medico_id;
        this.paciente_id = paciente_id;
        super.setId(id);
    }
    public Timestamp getDt_consulta() {
        return dt_consulta;
    }
    public void setDt_consulta(Timestamp dt_consulta) {
        this.dt_consulta = dt_consulta;
    }
    public String getNm_atendimento() {
        return nm_atendimento;
    }
    public void setNm_atendimento(String nm_atendimento) {
        this.nm_atendimento = nm_atendimento;
    }
    public Integer getMedico_id() {
        return medico_id;
    }
    public void setMedico_id(Integer medico_id) {
        this.medico_id = medico_id;
    }
    public Integer getPaciente_id() {
        return paciente_id;
    }
    public void setPaciente_id(Integer paciente_id) {
        this.paciente_id = paciente_id;
    } 

    
}
