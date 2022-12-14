// package br.com.frota.util;

// import br.com.frota.DAO.PacienteDAO;
// import br.com.frota.model.Paciente;
// import br.com.frota.servico.ServicoPaciente;

// import java.security.Timestamp;
// import java.sql.SQLException;
// import java.util.List;

// import java.sql.Timestamp;

// public class TestePaciente {

//     static PacienteDAO PacienteDAO = new PacienteDAO();
//     static ServicoPaciente servicoPaciente = new ServicoPaciente();
//     public static void main(String[] args) throws SQLException {
//         //salvar 

//         Paciente PacienteSalvar = new Paciente("Joana");
//         servicoPaciente.salvar(PacienteSalvar);

//         //buscar por ID
//         Integer id = PacienteSalvar.getId();

//         Paciente PacienteBuscar = servicoPaciente.buscarPorId(id);
//         System.out.println(PacienteBuscar);

//         //Update
    
//         PacienteBuscar.setDescricao("descrição 2");
//         PacienteBuscar.setMetodo("metodo 2");
//         PacienteBuscar.setMeterial_Paciente_id(material_Paciente_id2);
//         PacienteBuscar.setTipo_Paciente(tipo_Paciente_id2);

//         servicoPaciente.update(PacienteBuscar);

//         Paciente PacienteUpdate = servicoPaciente.buscarPorId(id);
//         System.out.println(PacienteUpdate);
        
//         //Select all
//         System.out.println("Todos: \n");
//         List<Paciente> Pacientes = PacienteDAO.selectAllPacientes();
//         Pacientes.forEach(System.out::println);

//         //Delete
//         servicoPaciente.remover(id);

//         //Deletar 
//         servicoMaterialPaciente.remover(tipo_Paciente_id1);
//         servicoMaterialPaciente.remover(tipo_Paciente_id2);
        
//         servicoTipoPaciente.remover(material_Paciente_id1);
//         servicoTipoPaciente.remover(material_Paciente_id2);
//     }
    
// }
