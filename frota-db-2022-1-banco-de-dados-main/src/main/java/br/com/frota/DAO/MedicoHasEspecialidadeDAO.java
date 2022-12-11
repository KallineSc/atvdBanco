package br.com.frota.DAO;
medico_id, especialidade_id
public class MedicoHasEspecialidadeDAO extends ConexaoDB{

    private static final String INSERT_MEDICO_HAS_ESPECIALIDADE_SQL = "INSERT INTO medico_has_especialidade (rua, numero, complemento, bairro, cep, cidade, laboratorio_id) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_MEDICO_HAS_ESPECIALIDADE_BY_ID = "SELECT rua, numero, complemento, bairro, cep, cidade, laboratorio_id FROM medico_has_especialidade WHERE id = ?";
    private static final String SELECT_ALL_MEDICO_HAS_ESPECIALIDADE = "SELECT * FROM medico_has_especialidade;";
    private static final String DELETE_MEDICO_HAS_ESPECIALIDADE_SQL = "DELETE FROM medico_has_especialidade WHERE id = ?;";
    private static final String UPDATE_MEDICO_HAS_ESPECIALIDADE_SQL = "UPDATE medico_has_especialidade SET rua = ?, numero = ?, complemento = ?, bairro = ?, cep = ?, cidade = ?, laboratorio_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM medico_has_especialidade;";
    
}
