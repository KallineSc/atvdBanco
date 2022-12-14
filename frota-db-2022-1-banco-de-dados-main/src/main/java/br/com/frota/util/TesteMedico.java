package br.com.frota.util;

import br.com.frota.DAO.EspecialidadeDAO;
import br.com.frota.model.Especialidade;
import br.com.frota.servico.ServicoEspecialidade;

import br.com.frota.DAO.MedicoDAO;
import br.com.frota.model.Medico;
import br.com.frota.servico.ServicoMedico;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteMedico {
    static MedicoDAO medicoDAO = new MedicoDAO();
    static ServicoMedico servicoMedico = new ServicoMedico();
    
    static EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
    static ServicoEspecialidade servicoEspecialidade = new ServicoEspecialidade();
    
    public static void main(String[] args) throws SQLException {


        //salvar medico
            Especialidade especialidade1 = new Especialidade("descricao teste 1", "obs 1");
            Especialidade especialidade2 = new Especialidade("descricao teste 2", "obs 2");
            
            servicoEspecialidade.salvar(especialidade1);
            servicoEspecialidade.salvar(especialidade2);

            List<Especialidade> especialidade = new ArrayList<>(); 

            especialidade.add(especialidade1);
            especialidade.add(especialidade2);

            Medico medicoSalvar = new Medico("999888", "Maria");
            medicoSalvar.setEspecialidade(especialidade);

            servicoMedico.salvar(medicoSalvar);
            System.out.println(medicoSalvar);
    
        // //buscar laboratorio por ID
        //     Medico medicoBuscar = servicoMedico.buscarPorId(1);
        //     System.out.println(medicoBuscar);
        
        // //Update
        //     Medico medicoUpdate = servicoMedico.buscarPorId(1);
        //     medicoUpdate.setCrm("33333");
        //     medicoUpdate.setNome("Joana");
        //     servicoMedico.update(medicoUpdate);
        //     System.out.println(medicoUpdate);
            
        // //Select all medicos
        //    System.out.println("Todos os médicos: \n");
        //    List<Medico> medicos = medicoDAO.selectAllMedicos();
        //    medicos.forEach(System.out::println);
    
        // //Delete
        //     servicoMedico.remover(1);
    	
    }
}