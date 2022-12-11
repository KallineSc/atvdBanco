package br.com.frota.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.Endereco;
    
public class EnderecoDAO extends ConexaoDB {

    private static final String INSERT_ENDERECO_SQL = "INSERT INTO endereco (rua, numero, complemento, bairro, cep, cidade, laboratorio_id) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ENDERECO_BY_ID = "SELECT rua, numero, complemento, bairro, cep, cidade, laboratorio_id FROM endereco WHERE id = ?";
    private static final String SELECT_ALL_ENDERECO = "SELECT * FROM endereco;";
    private static final String DELETE_ENDERECO_SQL = "DELETE FROM endereco WHERE id = ?;";
//	private static final String BUSCAR_POR_DESCRICAO_MARCA_SQL = "DELETE FROM marca WHERE descricao = ?;";
    private static final String UPDATE_ENDERECO_SQL = "UPDATE endereco SET rua = ?, numero = ?, complemento = ?, bairro = ?, cep = ?, cidade = ?, laboratorio_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM endereco;";

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

    public Endereco insert(Endereco entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_ENDERECO_SQL, 
                java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, entidade.getRua());
            preparedStatement.setString(2, entidade.getNumero());
            preparedStatement.setString(3, entidade.getComplemento());
            preparedStatement.setString(4, entidade.getBairro());
            preparedStatement.setString(5, entidade.getCep());
            preparedStatement.setString(6, entidade.getCidade());
            preparedStatement.setInt(7, entidade.getLaboratorio_id());
            
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

    public Endereco findById(int id) {
        Endereco entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ENDERECO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                
                String descricao = rs.getString("descricao");
                String cnes = rs.getString("cnes");
                String cnpj = rs.getString("cnpj");
                String crbm = rs.getString("crbm");
                String nome_fantasia = rs.getString("nome_fantasia");
                
                entidade = new ENDERECO(id, descricao, cnes, cnpj, crbm, nome_fantasia);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ENDERECO> selectAllENDERECOs() {
        List<ENDERECO> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_ENDERECO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                String cnes = rs.getString("cnes");
                String cnpj = rs.getString("cnpj");
                String crbm = rs.getString("crbm");
                String nome_fantasia = rs.getString("nome_fantasia");
                
                entidades.add(new ENDERECO(id, descricao, cnes, cnpj, crbm, nome_fantasia));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteENDERECO(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_ENDERECO_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateENDERECO(ENDERECO entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_ENDERECO_SQL)) {

            statement.setString(1, entidade.getCnes());
            statement.setString(2, entidade.getCnpj());
            statement.setString(3, entidade.getCrbm());
            statement.setString(4, entidade.getDescricao());
            statement.setString(5, entidade.getNome_fantasia());
            statement.setInt(6, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
