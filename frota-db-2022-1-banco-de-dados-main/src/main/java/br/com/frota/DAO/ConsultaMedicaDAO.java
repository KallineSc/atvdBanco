package br.com.frota.DAO;

import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.ConsultaMedica;

public class ConsultaMedicaDAO extends ConexaoDB{
    
    private static final String INSERT_CONSULTA_MEDICA_SQL = "INSERT INTO consulta_medica (dt_consulta, nm_atendimento, medico_id, paciente_id) VALUES (?, ?, ?, ?);";
    private static final String SELECT_CONSULTA_MEDICA_BY_ID = "SELECT dt_consulta, nm_atendimento, medico_id, paciente_id FROM consulta_medica WHERE id = ?";
    private static final String SELECT_ALL_CONSULTA_MEDICA = "SELECT * FROM consulta_medica;";
    private static final String DELETE_CONSULTA_MEDICA_SQL = "DELETE FROM consulta_medica WHERE id = ?;";
    private static final String UPDATE_CONSULTA_MEDICA_SQL = "UPDATE consulta_medica SET dt_consulta = ?, nm_atendimento = ?, medico_id = ?, paciente_id = ?WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM consulta_medica;";
    
    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public ConsultaMedica insert(ConsultaMedica entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_CONSULTA_MEDICA_SQL, 
        		java.sql.Statement.RETURN_GENERATED_KEYS)) {
        	
            preparedStatement.setString(1, entidade.getNm_atendimento());
            preparedStatement.setInt(2, entidade.getMedico_id());
            preparedStatement.setTimestamp(3, entidade.getDt_consulta());
            preparedStatement.setInt(4, entidade.getPaciente_id());
            preparedStatement.executeUpdate();
            
            ResultSet result = preparedStatement.getGeneratedKeys();
			if (result.next()) {
				entidade.setId(result.getInt(1));
			}
            
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
		return entidade;
    }

    public ConsultaMedica findById(int id) {
        ConsultaMedica entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_CONSULTA_MEDICA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Timestamp dt_consulta = rs.getTimestamp("dt_consulta");
                String nm_atendimento = rs.getString("nm_atendimento");
                int medico_id = rs.getInt("medico_id");
                int paciente_id = rs.getInt("paciente_id");

                entidade = new ConsultaMedica(id, dt_consulta, nm_atendimento, medico_id, paciente_id);
                
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ConsultaMedica> selectAllConsultaMedicas() {
        List<ConsultaMedica> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_CONSULTA_MEDICA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                Timestamp dt_consulta = rs.getTimestamp("dt_consulta");
                String nm_atendimento = rs.getString("nm_atendimento");
                int medico_id = rs.getInt("medico_id");
                int paciente_id = rs.getInt("paciente_id");
                
                entidades.add(new ConsultaMedica(id, dt_consulta, nm_atendimento, medico_id, paciente_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteConsultaMedica(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_CONSULTA_MEDICA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateConsultaMedica(ConsultaMedica entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_CONSULTA_MEDICA_SQL)) {
            
            statement.setString(1, entidade.getNm_atendimento());
            statement.setInt(2, entidade.getMedico_id());
            statement.setTimestamp(3, entidade.getDt_consulta());
            statement.setInt(4, entidade.getPaciente_id());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
