package br.com.frota.DAO;

nm_prescrito, dt_solicitacao, consulta_medica_id, habilitacao_exame_id, exame_id

public class SolicitacaoExameDAO extends ConexaoDB {
    
    private static final String INSERT_SOLICITACAO_EXAME_SQL = "INSERT INTO solicitacao_exame (nm_prescrito, dt_solicitacao, consulta_medica_id, habilitacao_exame_id, exame_id) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_SOLICITACAO_EXAME_BY_ID = "SELECT nm_prescrito, dt_solicitacao, consulta_medica_id, habilitacao_exame_id, exame_id FROM solicitacao_exame WHERE id = ?";
    private static final String SELECT_ALL_SOLICITACAO_EXAME = "SELECT * FROM solicitacao_exame;";
    private static final String DELETE_SOLICITACAO_EXAME_SQL = "DELETE FROM solicitacao_exame WHERE id = ?;";
    private static final String UPDATE_SOLICITACAO_EXAME_SQL = "UPDATE solicitacao_exame SET nm_prescrito = ?, dt_solicitacao = ?, consulta_medica_id = ?, habilitacao_exame_id = ?, exame_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM solicitacao_exame;";
    
}
