package br.com.frota.DAO;

descricao

public class UnidadeMedidaDAO extends ConexaoDB {
    private static final String INSERT_UNIDADE_MEDIDA_SQL = "INSERT INTO unidade_medida (descricao) VALUES (?);";
    private static final String SELECT_UNIDADE_MEDIDA_BY_ID = "SELECT descricao WHERE id = ?";
    private static final String SELECT_ALL_UNIDADE_MEDIDA = "SELECT * FROM unidade_medida;";
    private static final String DELETE_UNIDADE_MEDIDA_SQL = "DELETE FROM unidade_medida WHERE id = ?;";
    private static final String UPDATE_UNIDADE_MEDIDA_SQL = "UPDATE unidade_medida SET descricao = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM unidade_medida;";
    
}
