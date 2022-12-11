package br.com.frota.DAO;
dt_exame, valor, composicao_id, laudo_id
public class ResultadoExameDAO extends ConexaoDB{

    private static final String INSERT_RESULTADO_EXAME_SQL = "INSERT INTO resultado_exame (dt_exame, valor, composicao_id, laudo_id) VALUES (?, ?, ?, ?);";
    private static final String SELECT_RESULTADO_EXAME_BY_ID = "SELECT dt_exame, valor, composicao_id, laudo_id FROM resultado_exame WHERE id = ?";
    private static final String SELECT_ALL_RESULTADO_EXAME = "SELECT * FROM resultado_exame;";
    private static final String DELETE_RESULTADO_EXAME_SQL = "DELETE FROM resultado_exame WHERE id = ?;";
    private static final String UPDATE_RESULTADO_EXAME_SQL = "UPDATE resultado_exame SET dt_exame = ?, valor = ?, composicao_id = ?, laudo_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM resultado_exame;";
    
}
