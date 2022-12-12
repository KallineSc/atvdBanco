package br.com.frota.servico;

import java.sql.SQLException;

import br.com.frota.DAO.ConsultaMedicaDAO;
import br.com.frota.model.ConsultaMedica;

public class ServicoConsultaMedica {
    private ConsultaMedicaDAO consultaMedicaDAO = new ConsultaMedicaDAO();

	public ConsultaMedica salvar(ConsultaMedica consultaMedica) {
		return consultaMedicaDAO.insert(consultaMedica);
	}

	public ConsultaMedica buscarPorId(Integer id) {
		return consultaMedicaDAO.findById(id);
	}

	public void update(ConsultaMedica consultaMedica) throws SQLException {
		consultaMedicaDAO.updateConsultaMedica(consultaMedica);
	}

	public void remover(Integer id) throws SQLException {
		consultaMedicaDAO.deleteConsultaMedica(id);
	}
}
