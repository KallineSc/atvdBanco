package br.com.frota.util;

import br.com.frota.DAO.LaboratorioDAO;
import br.com.frota.DAO.MedicoDAO;
import br.com.frota.model.Contato;
import br.com.frota.model.Laboratorio;
import br.com.frota.model.Medico;
import br.com.frota.servico.ServicoContato;
import br.com.frota.servico.ServicoLaboratorio;
import br.com.frota.servico.ServicoMedico;

import java.sql.SQLException;
import java.util.List;

public class TesteMedico {
    static MedicoDAO medicoDAO = new MedicoDAO();
    static LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
    static ServicoMedico servicoMedico = new ServicoMedico();
    static ServicoContato servicoContato = new ServicoContato();
    static ServicoLaboratorio servicoLaboratorio = new ServicoLaboratorio();

    public static void main(String[] args) throws SQLException {
    	
////    	salvar contato
//    	Laboratorio laboratorio = new Laboratorio("Lab 2", "222", "002002002", "002", "Lab teste2");
//    	servicoLaboratorio.salvar(laboratorio);
    	
////    	salvar medico
//    	Medico medico = new Medico("123456765432", "Teste Silva");
//    	servicoMedico.salvar(medico);

//	    buscar laboratorio por ID
	    System.out.println(servicoLaboratorio.buscarPorId(1));
    	
////    	Select all laboratorios
//    	System.out.println("Todos os laboratórios: \n");
//    	List<Laboratorio> laboratorios = laboratorioDAO.selectAllLaboratorios();
//    	laboratorios.forEach(System.out::println);

//        //salvar contato
//        Contato contato = new Contato("85988767756", 1);
//        servicoContato.salvar(contato);
//
        //buscar contato por ID
        System.out.println(servicoContato.buscarPorId(3));

////      count
//        System.out.println(medicoDAO.count());
//
////      salvar
//        Medico medico = new Medico("teste", "nome teste");
//        medicoDAO.insertMedico(medico);
//
////      buscar por ID
//    	Medico medico = medicoDAO.selectMedico(3);
//	   	System.out.println(medico);
//
////      Update
//	   	medico.setNome("Nome novo");
//        medico.setCrm("930842093");
//        medicoDAO.updateMedico(medico);
//        
//        medico = medicoDAO.selectMedico(3);
//        System.out.println(medico);
//
////      Select all medicos
//        System.out.println("Todos os médicos: \n");
//        List<Medico> medicos = medicoDAO.selectAllMedicos();
//        medicos.forEach(System.out::println);
//
////      Delete
//        medicoDAO.deleteMedico(2);
//        medicoDAO.selectAllMedicos().forEach(System.out::println);
    	
    	
    }
}
