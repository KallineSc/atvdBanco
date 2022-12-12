package br.com.frota.servico;
import java.sql.SQLException;

import br.com.frota.DAO.HabilitacaoExameDAO;
import br.com.frota.model.HabilitacaoExame;
public class ServicoHabilitacaoExame {
    private HabilitacaoExameDAO habilitacaoExameDAO = new HabilitacaoExameDAO();

	public HabilitacaoExame salvar(HabilitacaoExame habilitacaoExame) {
		return habilitacaoExameDAO.insert(habilitacaoExame);
	}

	public HabilitacaoExame buscarPorId(Integer id) {
		return habilitacaoExameDAO.findById(id);
	}

	public void update(HabilitacaoExame habilitacaoExame) throws SQLException {
		habilitacaoExameDAO.updateHabilitacaoExame(habilitacaoExame);
	}

	public void remover(Integer id) throws SQLException {
		habilitacaoExameDAO.deleteHabilitacaoExame(id);
	}
}
