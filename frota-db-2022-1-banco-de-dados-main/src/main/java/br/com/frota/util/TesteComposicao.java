package br.com.frota.util;

import br.com.frota.DAO.ComposicaoDAO;
import br.com.frota.model.Composicao;
import br.com.frota.servico.ServicoComposicao;

import br.com.frota.DAO.ExameDAO;
import br.com.frota.model.Exame;
import br.com.frota.servico.ServicoExame;

import br.com.frota.DAO.ComposicaoExameDAO;
import br.com.frota.model.ComposicaoExame;
import br.com.frota.servico.ServicoComposicaoExame;

import br.com.frota.DAO.ValorReferenciaComposicaoExameDAO;
import br.com.frota.model.ValorReferenciaComposicaoExame;
import br.com.frota.servico.ServicoValorReferenciaComposicaoExame;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteComposicao {
    static ComposicaoDAO ComposicaoDAO = new ComposicaoDAO();
    static ServicoComposicao servicoComposicao = new ServicoComposicao();

    static ExameDAO ExameDAO = new ExameDAO();
    static ServicoExame servicoExame = new ServicoExame();

    static ComposicaoExameDAO ComposicaoExameDAO = new ComposicaoExameDAO();
    static ServicoComposicaoExame servicoComposicaoExame = new ServicoComposicaoExame();

    static ValorReferenciaComposicaoExameDAO ValorReferenciaComposicaoExameDAO = new ValorReferenciaComposicaoExameDAO();
    static ServicoValorReferenciaComposicaoExame servicoValorReferenciaComposicaoExame = new ServicoValorReferenciaComposicaoExame();

    
    public static void main(String[] args) throws SQLException {


        //salvar Composicao
            Composicao ComposicaoSalvar = new Composicao(1, 1, 1);
            servicoComposicao.salvar(ComposicaoSalvar);
            System.out.println(ComposicaoSalvar);
    
        //buscar por ID
            Composicao ComposicaoBuscar = servicoComposicao.buscarPorId(1);
            System.out.println(ComposicaoBuscar);
        
        //Update
            Composicao ComposicaoUpdate = servicoComposicao.buscarPorId(1);
            ComposicaoUpdate.setExame_id(1);
            ComposicaoUpdate.setComposicao_exame_id(1);
            ComposicaoUpdate.setValor_referencia_composicao_exame_id(2);
            servicoComposicao.update(ComposicaoUpdate);
            System.out.println(ComposicaoUpdate);
            
        //Select all Composicaos
           System.out.println("Todos as Composições: \n");
           List<Composicao> Composicaos = ComposicaoDAO.selectAllComposicaos();
           Composicaos.forEach(System.out::println);
    
        //Delete
            servicoComposicao.remover(1);
    	
    }
}