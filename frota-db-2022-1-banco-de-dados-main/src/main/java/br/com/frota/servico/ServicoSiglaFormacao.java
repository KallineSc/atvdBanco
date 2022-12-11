package br.com.frota.servico;

import java.sql.SQLException;

import br.com.frota.DAO.SiglaFormacaoDAO;
import br.com.frota.model.SiglaFormacao;

public class ServicoSiglaFormacao {

    private SiglaFormacaoDAO siglaFormacaoDAO = new SiglaFormacaoDAO();

	public SiglaFormacao salvar (SiglaFormacao siglaFormacao) {
		return siglaFormacaoDAO.insert(siglaFormacao);
	}

	public SiglaFormacao buscarPorId(Integer id) {
		return siglaFormacaoDAO.findById(id);
	}

	public void update(SiglaFormacao siglaFormacao) throws SQLException {
	    siglaFormacaoDAO.updateSiglaFormacao(siglaFormacao);
	}

	public void remover(Integer id) throws SQLException {
        siglaFormacaoDAO.deleteSiglaFormacao(id);
	}

}
