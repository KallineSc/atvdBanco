package br.com.frota.DAO;
dt_consulta, nm_atendimento, medico_id, paciente_id
public class ConsultaMedicaDAO extends ConexaoDB{
    
    private static final String INSERT_CONSULTA_MEDICA_SQL = "INSERT INTO consulta_medica (dt_consulta, nm_atendimento, medico_id, paciente_id) VALUES (?, ?, ?, ?);";
    private static final String SELECT_CONSULTA_MEDICA_BY_ID = "SELECT dt_consulta, nm_atendimento, medico_id, paciente_id FROM consulta_medica WHERE id = ?";
    private static final String SELECT_ALL_consulta_medica = "SELECT * FROM consulta_medica;";
    private static final String DELETE_CONSULTA_MEDICA_SQL = "DELETE FROM consulta_medica WHERE id = ?;";
    private static final String UPDATE_CONSULTA_MEDICA_SQL = "UPDATE consulta_medica SET dt_consulta = ?, nm_atendimento = ?, medico_id = ?, paciente_id = ?WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM consulta_medica;";
    
}
