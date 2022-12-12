package br.com.frota.servico;
import java.sql.SQLException;

import br.com.frota.DAO.ResponsavelTecnicoHasLaboratorioDAO;
import br.com.frota.model.ResponsavelTecnicoHasLaboratorio;

public class ServicoResponsavelTecnicoHasLaboratorio {
    private ResponsavelTecnicoHasLaboratorioDAO responsavelTecnicoHasLaboratorioDAO = new ResponsavelTecnicoHasLaboratorioDAO();

	public ResponsavelTecnicoHasLaboratorio salvar(ResponsavelTecnicoHasLaboratorio responsavelTecnicoHasLaboratorio) {
		return responsavelTecnicoHasLaboratorioDAO.insert(responsavelTecnicoHasLaboratorio);
	}

	public ResponsavelTecnicoHasLaboratorio buscarPorId(Integer id) {
		return responsavelTecnicoHasLaboratorioDAO.findById(id);
	}

	public void update(ResponsavelTecnicoHasLaboratorio responsavelTecnicoHasLaboratorio) throws SQLException {
		responsavelTecnicoHasLaboratorioDAO.updateResponsavelTecnicoHasLaboratorio(responsavelTecnicoHasLaboratorio);
	}

	public void remover(Integer id) throws SQLException {
		responsavelTecnicoHasLaboratorioDAO.deleteResponsavelTecnicoHasLaboratorio(id);
	}
}
