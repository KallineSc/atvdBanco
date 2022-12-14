package br.com.frota.util;

import br.com.frota.DAO.HabilitacaoExameDAO;
import br.com.frota.model.HabilitacaoExame;
import br.com.frota.servico.ServicoHabilitacaoExame;

import br.com.frota.DAO.LaboratorioDAO;
import br.com.frota.model.Laboratorio;
import br.com.frota.servico.ServicoLaboratorio;

import br.com.frota.DAO.TipoExameDAO;
import br.com.frota.model.TipoExame;
import br.com.frota.servico.ServicoTipoExame;

import java.sql.SQLException;
import java.util.List;

public class TesteHabilitacaoExame {
    static HabilitacaoExameDAO HabilitacaoExameDAO = new HabilitacaoExameDAO();
    static ServicoHabilitacaoExame servicoHabilitacaoExame = new ServicoHabilitacaoExame();

    static LaboratorioDAO LaboratorioDAO = new LaboratorioDAO();
    static ServicoLaboratorio servicoLaboratorio = new ServicoLaboratorio();

    static TipoExameDAO TipoExameDAO = new TipoExameDAO();
    static ServicoTipoExame servicoTipoExame = new ServicoTipoExame();

    public static void main(String[] args) throws SQLException {
        //salvar  
        Laboratorio LaboratorioSalvar = new Laboratorio("Laboratório 1","123","1234", "12345", "LAB 1");
        servicoLaboratorio.salvar(LaboratorioSalvar);

        TipoExame TipoExameSalvar = new TipoExame("descrição 1", "obs 1");
        servicoTipoExame.salvar(TipoExameSalvar);

        Integer laboratorio_id = LaboratorioSalvar.getId();
        Integer tipo_exame_id = TipoExameSalvar.getId();

        HabilitacaoExame HabilitacaoExameSalvar = new HabilitacaoExame("observacao 1", 200, laboratorio_id, tipo_exame_id);
        servicoHabilitacaoExame.salvar(HabilitacaoExameSalvar);

        //buscar por ID
        Integer id = HabilitacaoExameSalvar.getId();

        HabilitacaoExame HabilitacaoExameBuscar = servicoHabilitacaoExame.buscarPorId(id);
        System.out.println(HabilitacaoExameBuscar);

        //Update
    
        HabilitacaoExameBuscar.setObservacao("obs 2");
        servicoHabilitacaoExame.update(HabilitacaoExameBuscar);

        HabilitacaoExame HabilitacaoExameUpdate = servicoHabilitacaoExame.buscarPorId(id);
        System.out.println(HabilitacaoExameUpdate);
        
        //Select all
        System.out.println("Todos: \n");
        List<HabilitacaoExame> HabilitacaoExames = HabilitacaoExameDAO.selectAllHabilitacaoExames();
        HabilitacaoExames.forEach(System.out::println);

        //Delete
        servicoHabilitacaoExame.remover(id);

        servicoLaboratorio.remover(laboratorio_id);
        servicoTipoExame.remover(tipo_exame_id);
        
    }

    
}