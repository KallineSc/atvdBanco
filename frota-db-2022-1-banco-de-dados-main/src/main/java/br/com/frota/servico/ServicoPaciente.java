package br.com.frota.servico;
import java.sql.SQLException;

import br.com.frota.DAO.PacienteDAO;
import br.com.frota.model.Paciente;

public class ServicoPaciente {
    private PacienteDAO pacienteDAO = new PacienteDAO();

	public Paciente salvar(Paciente paciente) {
		return pacienteDAO.insert(paciente);
	}

	public Paciente buscarPorId(Integer id) {
		return pacienteDAO.findById(id);
	}

	public void update(Paciente paciente) throws SQLException {
		pacienteDAO.updatePaciente(paciente);
	}

	public void remover(Integer id) throws SQLException {
		pacienteDAO.deletePaciente(id);
	}
}
