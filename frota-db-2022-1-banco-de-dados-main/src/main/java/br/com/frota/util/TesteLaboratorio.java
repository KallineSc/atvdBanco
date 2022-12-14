package br.com.frota.util;

import br.com.frota.DAO.LaboratorioDAO;
import br.com.frota.model.Laboratorio;
import br.com.frota.servico.ServicoLaboratorio;

import java.sql.SQLException;
import java.util.List;

public class TesteLaboratorio {

    static LaboratorioDAO LaboratorioDAO = new LaboratorioDAO();
    static ServicoLaboratorio servicoLaboratorio = new ServicoLaboratorio();
    public static void main(String[] args) throws SQLException {
        //salvar 

        Laboratorio LaboratorioSalvar = new Laboratorio("Laboratório 1","123","1234", "12345", "LAB 1");
        servicoLaboratorio.salvar(LaboratorioSalvar);

        //buscar por ID
        Integer id = LaboratorioSalvar.getId();

        Laboratorio LaboratorioBuscar = servicoLaboratorio.buscarPorId(id);
        System.out.println(LaboratorioBuscar);

        //Update
    
        LaboratorioBuscar.setDescricao("Laboratório 2");

        servicoLaboratorio.update(LaboratorioBuscar);

        Laboratorio LaboratorioUpdate = servicoLaboratorio.buscarPorId(id);
        System.out.println(LaboratorioUpdate);
        
        //Select all
        System.out.println("Todos: \n");
        List<Laboratorio> Laboratorios = LaboratorioDAO.selectAllLaboratorios();
        Laboratorios.forEach(System.out::println);

        //Delete
        servicoLaboratorio.remover(id);
    }
    
}
