package br.com.frota.DAO;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.SolicitacaoExame;

public class SolicitacaoExameDAO extends ConexaoDB {
    
    private static final String INSERT_SOLICITACAO_EXAME_SQL = "INSERT INTO solicitacao_exame (nm_prescrito, dt_solicitacao, consulta_medica_id, habilitacao_exame_id, exame_id) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_SOLICITACAO_EXAME_BY_ID = "SELECT nm_prescrito, dt_solicitacao, consulta_medica_id, habilitacao_exame_id, exame_id FROM solicitacao_exame WHERE id = ?";
    private static final String SELECT_ALL_SOLICITACAO_EXAME = "SELECT * FROM solicitacao_exame;";
    private static final String DELETE_SOLICITACAO_EXAME_SQL = "DELETE FROM solicitacao_exame WHERE id = ?;";
    private static final String UPDATE_SOLICITACAO_EXAME_SQL = "UPDATE solicitacao_exame SET nm_prescrito = ?, dt_solicitacao = ?, consulta_medica_id = ?, habilitacao_exame_id = ?, exame_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM solicitacao_exame;";
    
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

    public SolicitacaoExame insert(SolicitacaoExame entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_SOLICITACAO_EXAME_SQL, 
        		java.sql.Statement.RETURN_GENERATED_KEYS)) {
        	
            preparedStatement.setString(1, entidade.getNm_prescrito());
            preparedStatement.setInt(2, entidade.getConsulta_medica_id());
            preparedStatement.setTimestamp(3, entidade.getDt_solicitacao());
            preparedStatement.setInt(4, entidade.getExame_id());
            preparedStatement.setInt(5, entidade.getHabilitacao_exame_id());
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

    public SolicitacaoExame findById(int id) {
        SolicitacaoExame entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_SOLICITACAO_EXAME_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nm_prescrito = rs.getString("nm_prescrito");
                Timestamp dt_solicitacao = rs.getTimestamp("dt_solicitacao");
                Integer consulta_medica_id = rs.getInt("consulta_medica_id");
                Integer habilitacao_exame_id = rs.getInt("habilitacao_exame_id");
                Integer exame_id = rs.getInt("exame_id");
                
                entidade = new SolicitacaoExame(id, nm_prescrito, dt_solicitacao, consulta_medica_id, habilitacao_exame_id, exame_id);
                
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<SolicitacaoExame> selectAllSolicitacaoExames() {
        List<SolicitacaoExame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_SOLICITACAO_EXAME)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	int id = rs.getInt("id");
                
            	String nm_prescrito = rs.getString("nm_prescrito");
                Timestamp dt_solicitacao = rs.getTimestamp("dt_solicitacao");
                Integer consulta_medica_id = rs.getInt("consulta_medica_id");
                Integer habilitacao_exame_id = rs.getInt("habilitacao_exame_id");
                Integer exame_id = rs.getInt("exame_id");
                
                entidades.add(new SolicitacaoExame(id, nm_prescrito, dt_solicitacao, consulta_medica_id, habilitacao_exame_id, exame_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteSolicitacaoExame(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_SOLICITACAO_EXAME_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateSolicitacaoExame(SolicitacaoExame entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_SOLICITACAO_EXAME_SQL)) {

            
            statement.setString(1, entidade.getNm_prescrito());
            statement.setInt(2, entidade.getConsulta_medica_id());
            statement.setTimestamp(3, entidade.getDt_solicitacao());
            statement.setInt(4, entidade.getExame_id());
            statement.setInt(5, entidade.getHabilitacao_exame_id());
            statement.setInt(6, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
