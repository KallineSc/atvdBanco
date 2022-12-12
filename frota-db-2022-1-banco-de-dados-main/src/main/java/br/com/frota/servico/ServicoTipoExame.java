package br.com.frota.servico;
import java.sql.SQLException;

import br.com.frota.DAO.TipoExameDAO;
import br.com.frota.model.TipoExame;

public class ServicoTipoExame {
    private TipoExameDAO tipoExameDAO = new TipoExameDAO();

	public TipoExame salvar(TipoExame tipoExame) {
		return tipoExameDAO.insert(tipoExame);
	}

	public TipoExame buscarPorId(Integer id) {
		return tipoExameDAO.findById(id);
	}

	public void update(TipoExame tipoExame) throws SQLException {
		tipoExameDAO.updateTipoExame(tipoExame);
	}

	public void remover(Integer id) throws SQLException {
		tipoExameDAO.deleteTipoExame(id);
	}
}
