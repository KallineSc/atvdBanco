package br.com.frota.model;

import java.util.List;
import javax.persistence.*;

public class Especialidade extends GenericModel{
	private String descricao; 
	private String observacao;

	@ManyToMany(mappedBy="especialidade", cascade = CascadeType.ALL)
  	private List<Medico> medico;
		

    public Especialidade(String descricao, String observacao) {
    	this.descricao = descricao;
    	this.observacao = observacao;
    }

    public Especialidade(Integer id, String descricao, String observacao) {
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
        return "Especialidade {\n" +
                "id='" + this.getId() + "\'\n" +
                "descricao='" + descricao + "\'\n" +
                "observacao='" + observacao + "\'\n" +
                '}';
    }

	public List<Medico> getMedico() {
		return medico;
	}

	public void setMedico(List<Medico> medico) {
		this.medico = medico;
	}
}
	