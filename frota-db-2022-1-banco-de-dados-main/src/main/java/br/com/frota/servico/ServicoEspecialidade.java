package br.com.frota.servico;

import java.sql.SQLException;

import br.com.frota.DAO.EspecialidadeDAO;
import br.com.frota.model.Especialidade;

public class ServicoEspecialidade {

    private EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();

	public Especialidade salvar (Especialidade especialidade) {
		return especialidadeDAO.insert(especialidade);
	}

	public Especialidade buscarPorId(Integer id) {
		return especialidadeDAO.findById(id);
	}

	public void update(Especialidade especialidade) throws SQLException {
	    especialidadeDAO.updateEspecialidade(especialidade);
	}

	public void remover(Integer id) throws SQLException {
        especialidadeDAO.deleteEspecialidade(id);
	}

}
