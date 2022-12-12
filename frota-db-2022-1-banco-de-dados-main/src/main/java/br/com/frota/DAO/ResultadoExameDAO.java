package br.com.frota.DAO;

import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.ResultadoExame;

public class ResultadoExameDAO extends ConexaoDB{

    private static final String INSERT_RESULTADO_EXAME_SQL = "INSERT INTO resultado_exame (dt_exame, valor, composicao_id, laudo_id) VALUES (?, ?, ?, ?);";
    private static final String SELECT_RESULTADO_EXAME_BY_ID = "SELECT dt_exame, valor, composicao_id, laudo_id FROM resultado_exame WHERE id = ?";
    private static final String SELECT_ALL_RESULTADO_EXAME = "SELECT * FROM resultado_exame;";
    private static final String DELETE_RESULTADO_EXAME_SQL = "DELETE FROM resultado_exame WHERE id = ?;";
    private static final String UPDATE_RESULTADO_EXAME_SQL = "UPDATE resultado_exame SET dt_exame = ?, valor = ?, composicao_id = ?, laudo_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM resultado_exame;";
    
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

    public ResultadoExame insert(ResultadoExame entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_RESULTADO_EXAME_SQL, 
        		java.sql.Statement.RETURN_GENERATED_KEYS)) {
        	
            preparedStatement.setString(1, entidade.getValor());
            preparedStatement.setInt(2, entidade.getComposicao_id());
            preparedStatement.setTimestamp(3, entidade.getDt_exame());
            preparedStatement.setInt(4, entidade.getLaudo_id());
            
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

    public ResultadoExame findById(int id) {
        ResultadoExame entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_RESULTADO_EXAME_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Timestamp dt_exame = rs.getTimestamp("dt_exame");
                String valor = rs.getString("valor");
                Integer composicao_id = rs.getInt("composicao_id");
                Integer laudo_id = rs.getInt("laudo_id");
                
                entidade = new ResultadoExame(id, dt_exame, valor, composicao_id, laudo_id);
                
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ResultadoExame> selectAllResultadoExames() {
        List<ResultadoExame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_RESULTADO_EXAME)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	int id = rs.getInt("id");
            	Timestamp dt_exame = rs.getTimestamp("dt_exame");
                String valor = rs.getString("valor");
                Integer composicao_id = rs.getInt("composicao_id");
                Integer laudo_id = rs.getInt("laudo_id");
                
                entidades.add(new ResultadoExame(id, dt_exame, valor, composicao_id, laudo_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteResultadoExame(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_RESULTADO_EXAME_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateResultadoExame(ResultadoExame entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_RESULTADO_EXAME_SQL)) {

            statement.setString(1, entidade.getValor());
            statement.setInt(2, entidade.getComposicao_id());
            statement.setTimestamp(3, entidade.getDt_exame());
            statement.setInt(4, entidade.getLaudo_id());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
