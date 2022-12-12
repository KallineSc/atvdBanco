package br.com.frota.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.UnidadeMedida;

public class UnidadeMedidaDAO extends ConexaoDB {
    private static final String INSERT_UNIDADE_MEDIDA_SQL = "INSERT INTO unidade_medida (descricao) VALUES (?);";
    private static final String SELECT_UNIDADE_MEDIDA_BY_ID = "SELECT descricao WHERE id = ?";
    private static final String SELECT_ALL_UNIDADE_MEDIDA = "SELECT * FROM unidade_medida;";
    private static final String DELETE_UNIDADE_MEDIDA_SQL = "DELETE FROM unidade_medida WHERE id = ?;";
    private static final String UPDATE_UNIDADE_MEDIDA_SQL = "UPDATE unidade_medida SET descricao = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM unidade_medida;";
    
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

    public UnidadeMedida insert(UnidadeMedida entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_UNIDADE_MEDIDA_SQL, 
        		java.sql.Statement.RETURN_GENERATED_KEYS)) {
        	
            preparedStatement.setString(1, entidade.getDescricao());
            
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

    public UnidadeMedida findById(int id) {
        UnidadeMedida entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_UNIDADE_MEDIDA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	
                String descricao = rs.getString("descricao");
                
                entidade = new UnidadeMedida(id, descricao);
                
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<UnidadeMedida> selectAllUnidadeMedidas() {
        List<UnidadeMedida> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_UNIDADE_MEDIDA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	int id = rs.getInt("id");
            	String descricao = rs.getString("descricao");
                
                entidades.add(new UnidadeMedida(id, descricao));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteUnidadeMedida(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_UNIDADE_MEDIDA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateUnidadeMedida(UnidadeMedida entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_UNIDADE_MEDIDA_SQL)) {

            statement.setString(1, entidade.getDescricao());
            statement.setInt(2, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
