package br.com.frota.util;

import br.com.frota.DAO.ComposicaoExameDAO;
import br.com.frota.model.ComposicaoExame;
import br.com.frota.servico.ServicoComposicaoExame;

import br.com.frota.DAO.UnidadeMedidaDAO;
import br.com.frota.model.UnidadeMedida;
import br.com.frota.servico.ServicoUnidadeMedida;

import java.sql.SQLException;
import java.util.List;

public class TesteComposicaoExame {

    static ComposicaoExameDAO ComposicaoExameDAO = new ComposicaoExameDAO();
    static ServicoComposicaoExame servicoComposicaoExame = new ServicoComposicaoExame();

    static UnidadeMedidaDAO UnidadeMedidaDAO = new UnidadeMedidaDAO();
    static ServicoUnidadeMedida servicoUnidadeMedida = new ServicoUnidadeMedida();
    
    public static void main(String[] args) throws SQLException {
        //salvar 

        UnidadeMedida UnidadeMedida1 = new UnidadeMedida("descrição 1");
        servicoUnidadeMedida.salvar(UnidadeMedida1);
        UnidadeMedida UnidadeMedida2 = new UnidadeMedida("descrição 2");
        servicoUnidadeMedida.salvar(UnidadeMedida2);

        Integer unidade_medida_id1 = UnidadeMedida1.getId();
        Integer unidade_medida_id2 = UnidadeMedida2.getId();

        ComposicaoExame ComposicaoExameSalvar = new ComposicaoExame("descrição 1",unidade_medida_id1);
        servicoComposicaoExame.salvar(ComposicaoExameSalvar);

        //buscar por ID
        Integer id = ComposicaoExameSalvar.getId();

        ComposicaoExame ComposicaoExameBuscar = servicoComposicaoExame.buscarPorId(id);
        System.out.println(ComposicaoExameBuscar);

        //Update
    
        ComposicaoExameBuscar.setDescricao("descrição 2");
        ComposicaoExameBuscar.setUnidade_medida_id(unidade_medida_id2);

        servicoComposicaoExame.update(ComposicaoExameBuscar);

        ComposicaoExame ComposicaoExameUpdate = servicoComposicaoExame.buscarPorId(id);
        System.out.println(ComposicaoExameUpdate);
        
        //Select all
        System.out.println("Todos: \n");
        List<ComposicaoExame> ComposicaoExames = ComposicaoExameDAO.selectAllComposicaoExames();
        ComposicaoExames.forEach(System.out::println);

        //Delete
        servicoComposicaoExame.remover(id);
        
        servicoUnidadeMedida.remover(unidade_medida_id1);
        servicoUnidadeMedida.remover(unidade_medida_id2);
    }
    
}
