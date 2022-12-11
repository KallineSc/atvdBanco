package br.com.frota.DAO;

descricao, observacao

public class TipoExameDAO extends ConexaoDB {

    private static final String INSERT_TIPO_EXAME_SQL = "INSERT INTO tipo_exame (descricao, observacao) VALUES (?, ?);";
    private static final String SELECT_TIPO_EXAME_BY_ID = "SELECT descricao, observacao FROM tipo_exame WHERE id = ?";
    private static final String SELECT_ALL_TIPO_EXAME = "SELECT * FROM tipo_exame;";
    private static final String DELETE_TIPO_EXAME_SQL = "DELETE FROM tipo_exame WHERE id = ?;";
    private static final String UPDATE_TIPO_EXAME_SQL = "UPDATE tipo_exame SET descricao = ?, observacao = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM tipo_exame;";
    
}
