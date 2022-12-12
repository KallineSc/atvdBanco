package br.com.frota.servico;
import java.sql.SQLException;

import br.com.frota.DAO.UnidadeMedidaDAO;
import br.com.frota.model.UnidadeMedida;

public class ServicoUnidadeMedida {
    private UnidadeMedidaDAO unidadeMedidaDAO = new UnidadeMedidaDAO();

	public UnidadeMedida salvar(UnidadeMedida unidadeMedida) {
		return unidadeMedidaDAO.insert(unidadeMedida);
	}

	public UnidadeMedida buscarPorId(Integer id) {
		return unidadeMedidaDAO.findById(id);
	}

	public void update(UnidadeMedida unidadeMedida) throws SQLException {
		unidadeMedidaDAO.updateUnidadeMedida(unidadeMedida);
	}

	public void remover(Integer id) throws SQLException {
		unidadeMedidaDAO.deleteUnidadeMedida(id);
	}
}
