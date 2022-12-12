package br.com.frota.servico;
import java.sql.SQLException;

import br.com.frota.DAO.MedicoHasEspecialidadeDAO;
import br.com.frota.model.MedicoHasEspecialidade;

public class ServicoMedicoHasEspecialidade {
    private MedicoHasEspecialidadeDAO medicoHasEspecialidadeDAO = new MedicoHasEspecialidadeDAO();

	public MedicoHasEspecialidade salvar(MedicoHasEspecialidade medicoHasEspecialidade) {
		return medicoHasEspecialidadeDAO.insert(medicoHasEspecialidade);
	}

	public MedicoHasEspecialidade buscarPorId(Integer id) {
		return medicoHasEspecialidadeDAO.findById(id);
	}

	public void update(MedicoHasEspecialidade medicoHasEspecialidade) throws SQLException {
		medicoHasEspecialidadeDAO.updateMedicoHasEspecialidade(medicoHasEspecialidade);
	}

	public void remover(Integer id) throws SQLException {
		medicoHasEspecialidadeDAO.deleteMedicoHasEspecialidade(id);
	}
}
