package br.com.frota.DAO; 
descricao, metodo, tipo_exame, meterial_exame_id
public class ExameDAO extends ConexaoDB{
    private static final String INSERT_EXAME_SQL = "INSERT INTO exame (descricao, metodo, tipo_exame, meterial_exame_id) VALUES (?, ?, ?, ?);";
    private static final String SELECT_EXAME_BY_ID = "SELECT descricao, metodo, tipo_exame, meterial_exame_id FROM exame WHERE id = ?";
    private static final String SELECT_ALL_EXAME = "SELECT * FROM exame;";
    private static final String DELETE_EXAME_SQL = "DELETE FROM exame WHERE id = ?;";
//	private static final String BUSCAR_POR_DESCRICAO_MARCA_SQL = "DELETE FROM marca WHERE descricao = ?;";
    private static final String UPDATE_EXAME_SQL = "UPDATE exame SET descricao = ?, metodo = ?, tipo_exame = ?, meterial_exame_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM exame;";
    
}
