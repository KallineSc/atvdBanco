package br.com.frota.model;

public class SiglaFormacao extends GenericModel{
	private String sigla;
		

    public SiglaFormacao(String sigla) {
    	this.sigla = sigla;
    }

    public SiglaFormacao(Integer id, String sigla) {
        this.sigla = sigla;
        super.setId(id);
    }


	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
    public String toString() {
        return "Sigla Formação {\n" +
                "id='" + this.getId() + "\'\n" +
                "sigla='" + sigla + "\'\n" +
                '}';
    }
}
