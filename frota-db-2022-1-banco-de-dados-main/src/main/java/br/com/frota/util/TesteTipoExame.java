package br.com.frota.util;

import br.com.frota.DAO.TipoExameDAO;
import br.com.frota.model.TipoExame;
import br.com.frota.servico.ServicoTipoExame;

import java.sql.SQLException;
import java.util.List;

public class TesteTipoExame {

    static TipoExameDAO TipoExameDAO = new TipoExameDAO();
    static ServicoTipoExame servicoTipoExame = new ServicoTipoExame();
    public static void main(String[] args) throws SQLException {
        //salvar 
        TipoExame TipoExameSalvar = new TipoExame("descrição 1", "obs 1");
        servicoTipoExame.salvar(TipoExameSalvar);

        //buscar por ID
        Integer id = TipoExameSalvar.getId();

        TipoExame TipoExameBuscar = servicoTipoExame.buscarPorId(id);
        System.out.println(TipoExameBuscar);

        //Update
    
        TipoExameBuscar.setDescricao("descrição 2");
        TipoExameBuscar.setObservacao("obs 2");
        servicoTipoExame.update(TipoExameBuscar);

        TipoExame TipoExameUpdate = servicoTipoExame.buscarPorId(id);
        System.out.println(TipoExameUpdate);
        
        //Select all
        System.out.println("Todos: \n");
        List<TipoExame> TipoExames = TipoExameDAO.selectAllTipoExames();
        TipoExames.forEach(System.out::println);

        //Delete
        servicoTipoExame.remover(id);
    }
    
}
