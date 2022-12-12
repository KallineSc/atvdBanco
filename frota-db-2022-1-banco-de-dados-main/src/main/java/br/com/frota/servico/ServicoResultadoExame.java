package br.com.frota.servico;
import java.sql.SQLException;

import br.com.frota.DAO.ResultadoExameDAO;
import br.com.frota.model.ResultadoExame;

public class ServicoResultadoExame {
    private ResultadoExameDAO resultadoExameDAO = new ResultadoExameDAO();

	public ResultadoExame salvar(ResultadoExame resultadoExame) {
		return resultadoExameDAO.insert(resultadoExame);
	}

	public ResultadoExame buscarPorId(Integer id) {
		return resultadoExameDAO.findById(id);
	}

	public void update(ResultadoExame resultadoExame) throws SQLException {
		resultadoExameDAO.updateResultadoExame(resultadoExame);
	}

	public void remover(Integer id) throws SQLException {
		resultadoExameDAO.deleteResultadoExame(id);
	}
}
