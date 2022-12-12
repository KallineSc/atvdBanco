package br.com.frota.servico;
import java.sql.SQLException;

import br.com.frota.DAO.ExameDAO;
import br.com.frota.model.Exame;

public class ServicoExame {
    private ExameDAO exameDAO = new ExameDAO();

	public Exame salvar(Exame exame) {
		return exameDAO.insert(exame);
	}

	public Exame buscarPorId(Integer id) {
		return exameDAO.findById(id);
	}

	public void update(Exame exame) throws SQLException {
		exameDAO.updateExame(exame);
	}

	public void remover(Integer id) throws SQLException {
		exameDAO.deleteExame(id);
	}
}
