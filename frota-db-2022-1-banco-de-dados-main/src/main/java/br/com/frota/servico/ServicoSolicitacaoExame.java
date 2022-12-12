package br.com.frota.servico;
import java.sql.SQLException;

import br.com.frota.DAO.SolicitacaoExameDAO;
import br.com.frota.model.SolicitacaoExame;

public class ServicoSolicitacaoExame {
    private SolicitacaoExameDAO solicitacaoExameDAO = new SolicitacaoExameDAO();

	public SolicitacaoExame salvar(SolicitacaoExame solicitacaoExame) {
		return solicitacaoExameDAO.insert(solicitacaoExame);
	}

	public SolicitacaoExame buscarPorId(Integer id) {
		return solicitacaoExameDAO.findById(id);
	}

	public void update(SolicitacaoExame solicitacaoExame) throws SQLException {
		solicitacaoExameDAO.updateSolicitacaoExame(solicitacaoExame);
	}

	public void remover(Integer id) throws SQLException {
		solicitacaoExameDAO.deleteSolicitacaoExame(id);
	}
}
