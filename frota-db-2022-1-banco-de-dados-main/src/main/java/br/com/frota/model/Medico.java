package br.com.frota.model;

import java.util.List;
import javax.persistence.*;

public class Medico extends GenericModel{
    private String crm;
	private String nome;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="medico_has_especialidade",
                joinColumns={@JoinColumn(name="medico_id")},
                inverseJoinColumns={@JoinColumn(name="especialidade_id")})
    private List<Especialidade> especialidade;    

    public Medico(String crm, String nome) {
    	this.crm = crm;
        this.nome = nome;
    }

    public Medico(Integer id, String crm, String nome) {
        this.crm = crm;
        this.nome = nome;
        super.setId(id);
    }


    public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
    public String toString() {
        return "Medico {\n" +
                "id='" + this.getId() + "\'\n" +
                "crm='" + crm + "\'\n" +
                "nome='" + nome + "\'\n" +
                '}';
    }

    public List<Especialidade> getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(List<Especialidade> especialidade) {
        this.especialidade = especialidade;
    }
}
