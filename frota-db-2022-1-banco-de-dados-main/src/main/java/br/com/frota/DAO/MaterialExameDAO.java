package br.com.frota.DAO;
material, observacao
public class MaterialExameDAO extends ConexaoDB{

    private static final String INSERT_MATERIAL_EXAME_SQL = "INSERT INTO material_exame (material, observacao) VALUES (?, ?);";
    private static final String SELECT_MATERIAL_EXAME_BY_ID = "SELECT material, observacao FROM material_exame WHERE id = ?";
    private static final String SELECT_ALL_material_exame = "SELECT * FROM material_exame;";
    private static final String DELETE_MATERIAL_EXAME_SQL = "DELETE FROM material_exame WHERE id = ?;";
    private static final String UPDATE_MATERIAL_EXAME_SQL = "UPDATE material_exame SET material = ?, observacao = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM material_exame;";
    
}
