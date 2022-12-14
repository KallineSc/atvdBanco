package br.com.frota.util;

import br.com.frota.DAO.ValorReferenciaComposicaoExameDAO;
import br.com.frota.model.ValorReferenciaComposicaoExame;
import br.com.frota.servico.ServicoValorReferenciaComposicaoExame;

import br.com.frota.DAO.UnidadeMedidaDAO;
import br.com.frota.model.UnidadeMedida;
import br.com.frota.servico.ServicoUnidadeMedida;

import java.sql.SQLException;
import java.util.List;

public class TesteValorReferenciaComposicaoExame {

    static ValorReferenciaComposicaoExameDAO ValorReferenciaComposicaoExameDAO = new ValorReferenciaComposicaoExameDAO();
    static ServicoValorReferenciaComposicaoExame servicoValorReferenciaComposicaoExame = new ServicoValorReferenciaComposicaoExame();

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

        ValorReferenciaComposicaoExame ValorReferenciaComposicaoExameSalvar = new ValorReferenciaComposicaoExame("10", "20", "30", "40", unidade_medida_id1);
        servicoValorReferenciaComposicaoExame.salvar(ValorReferenciaComposicaoExameSalvar);

        //buscar por ID
        Integer id = ValorReferenciaComposicaoExameSalvar.getId();

        ValorReferenciaComposicaoExame ValorReferenciaComposicaoExameBuscar = servicoValorReferenciaComposicaoExame.buscarPorId(id);
        System.out.println(ValorReferenciaComposicaoExameBuscar);

        //Update
    
        ValorReferenciaComposicaoExameBuscar.setLimitador_maximo("11");
        ValorReferenciaComposicaoExameBuscar.setLimitador_minimo("21");
        ValorReferenciaComposicaoExameBuscar.setValor_maximo("31");
        ValorReferenciaComposicaoExameBuscar.setValor_minimo("41");
        ValorReferenciaComposicaoExameBuscar.setUnidade_medida_id(unidade_medida_id2);
        
        servicoValorReferenciaComposicaoExame.update(ValorReferenciaComposicaoExameBuscar);

        ValorReferenciaComposicaoExame ValorReferenciaComposicaoExameUpdate = servicoValorReferenciaComposicaoExame.buscarPorId(id);
        System.out.println(ValorReferenciaComposicaoExameUpdate);
        
        //Select all
        System.out.println("Todos: \n");
        List<ValorReferenciaComposicaoExame> ValorReferenciaComposicaoExames = ValorReferenciaComposicaoExameDAO.selectAllValorReferenciaComposicaoExames();
        ValorReferenciaComposicaoExames.forEach(System.out::println);

        //Delete
        servicoValorReferenciaComposicaoExame.remover(id);
        
        servicoUnidadeMedida.remover(unidade_medida_id1);
        servicoUnidadeMedida.remover(unidade_medida_id2);
    }
    
}

