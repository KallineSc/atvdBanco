package br.com.frota.model;

import java.sql.Timestamp;

public class Paciente extends GenericModel{

    private String nome;
    private Timestamp dt_nascimento;
    
    public Paciente(String nome, Timestamp dt_nascimento) {
        this.nome = nome;
        this.dt_nascimento = dt_nascimento;
    }

    public Paciente(Integer id, String nome, Timestamp dt_nascimento) {
        this.nome = nome;
        this.dt_nascimento = dt_nascimento;
        super.setId(id);
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Timestamp getDt_nascimento() {
        return dt_nascimento;
    }
    public void setDt_nascimento(Timestamp dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }
    @Override
    public String toString() {
        return "Paciente {\n" +
                "id='" + this.getId() + "\'\n" +
                "nome='" + nome + "\'\n" +
                "dt_nascimento='" + dt_nascimento + "\'\n" +
                '}';
    }

    
}
