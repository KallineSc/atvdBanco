package br.com.frota.servico;
import java.sql.SQLException;

import br.com.frota.DAO.ComposicaoDAO;
import br.com.frota.model.Composicao;

public class ServicoComposicao {
    private ComposicaoDAO composicaoDAO = new ComposicaoDAO();

	public Composicao salvar(Composicao composicao) {
		return composicaoDAO.insert(composicao);
	}

	public Composicao buscarPorId(Integer id) {
		return composicaoDAO.findById(id);
	}

	public void update(Composicao composicao) throws SQLException {
		composicaoDAO.updateComposicao(composicao);
	}

	public void remover(Integer id) throws SQLException {
		composicaoDAO.deleteComposicao(id);
	}
}
