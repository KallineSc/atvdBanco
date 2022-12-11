package br.com.frota.DAO;
observacao, custo, laboratorio_id, tipo_exame
public class HabilitacaoExameDAO extends ConexaoDB{
    
    private static final String INSERT_HABILITACAO_EXAME_SQL = "INSERT INTO habilitacao_exame (observacao, custo, laboratorio_id, tipo_exame) VALUES (?, ?, ?, ?);";
    private static final String SELECT_HABILITACAO_EXAME_BY_ID = "SELECT observacao, custo, laboratorio_id, tipo_exame FROM habilitacao_exame WHERE id = ?";
    private static final String SELECT_ALL_habilitacao_exame = "SELECT * FROM habilitacao_exame;";
    private static final String DELETE_HABILITACAO_EXAME_SQL = "DELETE FROM habilitacao_exame WHERE id = ?;";
    private static final String UPDATE_HABILITACAO_EXAME_SQL = "UPDATE habilitacao_exame SET observacao = ?, custo = ?, laboratorio_id = ?, tipo_exame = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM habilitacao_exame;";
    
}
