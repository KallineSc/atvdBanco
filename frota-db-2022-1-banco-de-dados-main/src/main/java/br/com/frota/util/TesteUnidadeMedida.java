package br.com.frota.util;

import br.com.frota.DAO.UnidadeMedidaDAO;
import br.com.frota.model.UnidadeMedida;
import br.com.frota.servico.ServicoUnidadeMedida;

import java.sql.SQLException;
import java.util.List;

public class TesteUnidadeMedida {

    static UnidadeMedidaDAO UnidadeMedidaDAO = new UnidadeMedidaDAO();
    static ServicoUnidadeMedida servicoUnidadeMedida = new ServicoUnidadeMedida();
    public static void main(String[] args) throws SQLException {
        //salvar 
        UnidadeMedida UnidadeMedidaSalvar = new UnidadeMedida("descrição 1");
        servicoUnidadeMedida.salvar(UnidadeMedidaSalvar);

        //buscar por ID
        Integer id = UnidadeMedidaSalvar.getId();

        UnidadeMedida UnidadeMedidaBuscar = servicoUnidadeMedida.buscarPorId(id);
        System.out.println(UnidadeMedidaBuscar);

        //Update
    
        UnidadeMedidaBuscar.setDescricao("descrição 2");
        servicoUnidadeMedida.update(UnidadeMedidaBuscar);

        UnidadeMedida UnidadeMedidaUpdate = servicoUnidadeMedida.buscarPorId(id);
        System.out.println(UnidadeMedidaUpdate);
        
        //Select all
        System.out.println("Todos: \n");
        List<UnidadeMedida> UnidadeMedidas = UnidadeMedidaDAO.selectAllUnidadeMedidas();
        UnidadeMedidas.forEach(System.out::println);

        //Delete
        servicoUnidadeMedida.remover(id);
    }
    
}
