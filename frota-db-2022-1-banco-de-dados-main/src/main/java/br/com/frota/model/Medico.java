package br.com.frota.model;

public class Medico extends GenericModel{
    private String crm;
	private String nome;
		

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
                "id=e'" + this.getId() + "\'\n" +
                "crm='" + crm + "\'\n" +
                "nome='" + nome + "\'\n" +
                '}';
    }
}
