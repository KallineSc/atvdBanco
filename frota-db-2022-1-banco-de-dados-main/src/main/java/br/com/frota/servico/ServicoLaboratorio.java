package br.com.frota.servico;

import java.sql.SQLException;

import br.com.frota.DAO.LaboratorioDAO;
import br.com.frota.model.Laboratorio;

public class ServicoLaboratorio {
	
	private LaboratorioDAO laboratorioDAO = new LaboratorioDAO();

	public Laboratorio salvar(Laboratorio laboratorio) {
		return laboratorioDAO.insert(laboratorio);
	}

	public Laboratorio buscarPorId(Integer id) {
		return laboratorioDAO.findById(id);
	}

	public void update(Laboratorio laboratorio) throws SQLException {
		laboratorioDAO.updateLaboratorio(laboratorio);
	}

	public void remover(Integer id) throws SQLException {
		laboratorioDAO.deleteLaboratorio(id);
	}

}
