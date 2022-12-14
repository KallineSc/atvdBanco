package br.com.frota.model;

public class Exame extends GenericModel{
    private String descricao;
    private String metodo;
    private Integer tipo_exame;
    private Integer meterial_exame_id;
    
    public Exame(String descricao, String metodo, Integer tipo_exame, Integer meterial_exame_id) {
        this.descricao = descricao;
        this.metodo = metodo;
        this.tipo_exame = tipo_exame;
        this.meterial_exame_id = meterial_exame_id;
    }
    public Exame(Integer id, String descricao, String metodo, Integer tipo_exame, Integer meterial_exame_id) {
        this.descricao = descricao;
        this.metodo = metodo;
        this.tipo_exame = tipo_exame;
        this.meterial_exame_id = meterial_exame_id;
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getMetodo() {
        return metodo;
    }
    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
    public Integer getTipo_exame() {
        return tipo_exame;
    }
    public void setTipo_exame(Integer tipo_exame) {
        this.tipo_exame = tipo_exame;
    }
    public Integer getMeterial_exame_id() {
        return meterial_exame_id;
    }
    public void setMeterial_exame_id(Integer meterial_exame_id) {
        this.meterial_exame_id = meterial_exame_id;
    }

    @Override
    public String toString() {
        return "Exame {\n" +
                "id='" + this.getId() + "\'\n" +
                "descricao='" + descricao + "\'\n" +
                "metodo='" + metodo + "\'\n" +
                "tipo_exame='" + tipo_exame + "\'\n" +
                "meterial_exame_id='" + meterial_exame_id + "\'\n" +
                '}';
    }
}
