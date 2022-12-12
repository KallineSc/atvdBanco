package br.com.frota.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.HabilitacaoExame;

public class HabilitacaoExameDAO extends ConexaoDB{
    
    private static final String INSERT_HABILITACAO_EXAME_SQL = "INSERT INTO habilitacao_exame (observacao, custo, laboratorio_id, tipo_exame) VALUES (?, ?, ?, ?);";
    private static final String SELECT_HABILITACAO_EXAME_BY_ID = "SELECT observacao, custo, laboratorio_id, tipo_exame FROM habilitacao_exame WHERE id = ?";
    private static final String SELECT_ALL_HABILITACAO_EXAME = "SELECT * FROM habilitacao_exame;";
    private static final String DELETE_HABILITACAO_EXAME_SQL = "DELETE FROM habilitacao_exame WHERE id = ?;";
    private static final String UPDATE_HABILITACAO_EXAME_SQL = "UPDATE habilitacao_exame SET observacao = ?, custo = ?, laboratorio_id = ?, tipo_exame = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM habilitacao_exame;";
 
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

    public HabilitacaoExame insert(HabilitacaoExame entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_HABILITACAO_EXAME_SQL, 
        		java.sql.Statement.RETURN_GENERATED_KEYS)) {
        	
                    preparedStatement.setString(1, entidade.getObservacao());
                    preparedStatement.setInt(2, entidade.getCusto());
                    preparedStatement.setInt(3, entidade.getLaboratorio_id());
                    preparedStatement.setInt(4, entidade.getTipo_exame());
            
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

    public HabilitacaoExame findById(int id) {
        HabilitacaoExame entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_HABILITACAO_EXAME_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	
                String observacao = rs.getString("observacao");
                int custo = rs.getInt("custo");
                int laboratorio_id = rs.getInt("laboratorio_id");
                int tipo_exame = rs.getInt("tipo_exame");
                
                entidade = new HabilitacaoExame(id, observacao, custo, laboratorio_id, tipo_exame);
                
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<HabilitacaoExame> selectAllHabilitacaoExames() {
        List<HabilitacaoExame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_HABILITACAO_EXAME)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	int id = rs.getInt("id");
            	String observacao = rs.getString("observacao");
                int custo = rs.getInt("custo");
                int laboratorio_id = rs.getInt("laboratorio_id");
                int tipo_exame = rs.getInt("tipo_exame");
                
                entidades.add(new HabilitacaoExame(id, observacao, custo, laboratorio_id, tipo_exame));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteHabilitacaoExame(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_HABILITACAO_EXAME_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateHabilitacaoExame(HabilitacaoExame entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_HABILITACAO_EXAME_SQL)) {

            statement.setString(1, entidade.getObservacao());
            statement.setInt(2, entidade.getCusto());
            statement.setInt(3, entidade.getLaboratorio_id());
            statement.setInt(4, entidade.getTipo_exame());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    
}
