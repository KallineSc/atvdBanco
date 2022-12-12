package br.com.frota.servico;
import java.sql.SQLException;

import br.com.frota.DAO.MaterialExameDAO;
import br.com.frota.model.MaterialExame;

public class ServicoMaterialExame {
    private MaterialExameDAO materialExameDAO = new MaterialExameDAO();

	public MaterialExame salvar(MaterialExame materialExame) {
		return materialExameDAO.insert(materialExame);
	}

	public MaterialExame buscarPorId(Integer id) {
		return materialExameDAO.findById(id);
	}

	public void update(MaterialExame materialExame) throws SQLException {
		materialExameDAO.updateMaterialExame(materialExame);
	}

	public void remover(Integer id) throws SQLException {
		materialExameDAO.deleteMaterialExame(id);
	}
}
