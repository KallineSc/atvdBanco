package br.com.frota.DAO; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.Exame;

public class ExameDAO extends ConexaoDB{
    private static final String INSERT_EXAME_SQL = "INSERT INTO exame (descricao, metodo, tipo_exame, meterial_exame_id) VALUES (?, ?, ?, ?);";
    private static final String SELECT_EXAME_BY_ID = "SELECT descricao, metodo, tipo_exame, meterial_exame_id FROM exame WHERE id = ?";
    private static final String SELECT_ALL_EXAME = "SELECT * FROM exame;";
    private static final String DELETE_EXAME_SQL = "DELETE FROM exame WHERE id = ?;";
    private static final String UPDATE_EXAME_SQL = "UPDATE exame SET descricao = ?, metodo = ?, tipo_exame = ?, meterial_exame_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM exame;";
    
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

    public Exame insert(Exame entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_EXAME_SQL, 
        		java.sql.Statement.RETURN_GENERATED_KEYS)) {
        	
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setString(2, entidade.getMetodo());
            preparedStatement.setInt(3, entidade.getMeterial_exame_id());
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

    public Exame findById(int id) {
        Exame entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_EXAME_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                String descricao = rs.getString("descricao");
                String metodo = rs.getString("metodo");
                Integer tipo_exame = rs.getInt("tipo_exame");
                Integer meterial_exame_id = rs.getInt("meterial_exame_id");

                entidade = new Exame(id, descricao, metodo, tipo_exame, meterial_exame_id);
                
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Exame> selectAllExames() {
        List<Exame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_EXAME)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                String metodo = rs.getString("metodo");
                Integer tipo_exame = rs.getInt("tipo_exame");
                Integer meterial_exame_id = rs.getInt("meterial_exame_id");
                
                entidades.add(new Exame(id, descricao, metodo, tipo_exame, meterial_exame_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteExame(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_EXAME_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateExame(Exame entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_EXAME_SQL)) {
            
            statement.setString(1, entidade.getDescricao());
            statement.setString(2, entidade.getMetodo());
            statement.setInt(3, entidade.getMeterial_exame_id());
            statement.setInt(4, entidade.getTipo_exame());
            statement.setInt(5, entidade.getId());
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
