package br.com.frota.servico;

import java.sql.SQLException;

import br.com.frota.DAO.ComposicaoExameDAO;
import br.com.frota.model.ComposicaoExame;

public class ServicoComposicaoExame {
    private ComposicaoExameDAO composicaoExameDAO = new ComposicaoExameDAO();

	public ComposicaoExame salvar(ComposicaoExame composicaoExame) {
		return composicaoExameDAO.insert(composicaoExame);
	}

	public ComposicaoExame buscarPorId(Integer id) {
		return composicaoExameDAO.findById(id);
	}

	public void update(ComposicaoExame composicaoExame) throws SQLException {
		composicaoExameDAO.updateComposicaoExame(composicaoExame);
	}

	public void remover(Integer id) throws SQLException {
		composicaoExameDAO.deleteComposicaoExame(id);
	}
    
}
