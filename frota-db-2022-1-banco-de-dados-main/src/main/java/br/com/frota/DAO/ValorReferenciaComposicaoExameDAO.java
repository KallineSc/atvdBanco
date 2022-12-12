package br.com.frota.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.ValorReferenciaComposicaoExame;

public class ValorReferenciaComposicaoExameDAO extends ConexaoDB {

    private static final String INSERT_VALOR_REFERENCIA_COMPOSICAO_EXAME_SQL = "INSERT INTO (valor_minimo, valor_maximo, limitador_minimo, limitador_maximo, unidade_medida_id) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_VALOR_REFERENCIA_COMPOSICAO_EXAME_BY_ID = "SELECT valor_minimo, valor_maximo, limitador_minimo, limitador_maximo, unidade_medida_id WHERE id = ?";
    private static final String SELECT_ALL_VALOR_REFERENCIA_COMPOSICAO_EXAME = "SELECT * FROM valor_referencia_composicao_exame;";
    private static final String DELETE_VALOR_REFERENCIA_COMPOSICAO_EXAME_SQL = "DELETE FROM valor_referencia_composicao_exame WHERE id = ?;";
    private static final String UPDATE_VALOR_REFERENCIA_COMPOSICAO_EXAME_SQL = "UPDATE valor_referencia_composicao_exame SET valor_minimo = ?, valor_maximo = ?, limitador_minimo = ?, limitador_maximo = ?, unidade_medida_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM valor_referencia_composicao_exame;";
    
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

    public ValorReferenciaComposicaoExame insert(ValorReferenciaComposicaoExame entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_VALOR_REFERENCIA_COMPOSICAO_EXAME_SQL, 
        		java.sql.Statement.RETURN_GENERATED_KEYS)) {
        	
            preparedStatement.setString(1, entidade.getLimitador_maximo());
            preparedStatement.setString(2, entidade.getLimitador_minimo());
            preparedStatement.setString(3, entidade.getValor_maximo());
            preparedStatement.setString(4, entidade.getValor_minimo());
            preparedStatement.setInt(5, entidade.getUnidade_medida_id());
            
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

    public ValorReferenciaComposicaoExame findById(int id) {
        ValorReferenciaComposicaoExame entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_VALOR_REFERENCIA_COMPOSICAO_EXAME_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String valor_minimo = rs.getString("valor_minimo");
                String valor_maximo = rs.getString("valor_maximo");
                String limitador_minimo = rs.getString("limitador_minimo");
                String limitador_maximo = rs.getString("limitador_maximo");
                Integer unidade_medida_id = rs.getInt("unidade_medida_id");
                
                entidade = new ValorReferenciaComposicaoExame(id, valor_minimo, valor_maximo, limitador_minimo, limitador_maximo, unidade_medida_id);
                
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ValorReferenciaComposicaoExame> selectAllValorReferenciaComposicaoExames() {
        List<ValorReferenciaComposicaoExame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_VALOR_REFERENCIA_COMPOSICAO_EXAME)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	int id = rs.getInt("id");
            	String valor_minimo = rs.getString("valor_minimo");
                String valor_maximo = rs.getString("valor_maximo");
                String limitador_minimo = rs.getString("limitador_minimo");
                String limitador_maximo = rs.getString("limitador_maximo");
                Integer unidade_medida_id = rs.getInt("unidade_medida_id");
                
                entidades.add(new ValorReferenciaComposicaoExame(id, valor_minimo, valor_maximo, limitador_minimo, limitador_maximo, unidade_medida_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteValorReferenciaComposicaoExame(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_VALOR_REFERENCIA_COMPOSICAO_EXAME_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateValorReferenciaComposicaoExame(ValorReferenciaComposicaoExame entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_VALOR_REFERENCIA_COMPOSICAO_EXAME_SQL)) {

            statement.setString(1, entidade.getLimitador_maximo());
            statement.setString(2, entidade.getLimitador_minimo());
            statement.setString(3, entidade.getValor_maximo());
            statement.setString(4, entidade.getValor_minimo());
            statement.setInt(5, entidade.getUnidade_medida_id());

            statement.setInt(6, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
