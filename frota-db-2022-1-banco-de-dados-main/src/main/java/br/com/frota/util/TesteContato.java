package br.com.frota.util;

import br.com.frota.DAO.ContatoDAO;
import br.com.frota.model.Contato;
import br.com.frota.servico.ServicoContato;

import br.com.frota.DAO.LaboratorioDAO;
import br.com.frota.model.Laboratorio;
import br.com.frota.servico.ServicoLaboratorio;

import java.sql.SQLException;
import java.util.List;

public class TesteContato {

    static ContatoDAO ContatoDAO = new ContatoDAO();
    static ServicoContato servicoContato = new ServicoContato();

    static LaboratorioDAO LaboratorioDAO = new LaboratorioDAO();
    static ServicoLaboratorio servicoLaboratorio = new ServicoLaboratorio();

    public static void main(String[] args) throws SQLException {
        //salvar
        Laboratorio LaboratorioSalvar = new Laboratorio("Laboratório 1","123","1234", "12345", "LAB 1");
        servicoLaboratorio.salvar(LaboratorioSalvar);

        Integer laboratorio_id = LaboratorioSalvar.getId();

        Contato ContatoSalvar = new Contato("85999", laboratorio_id);
        servicoContato.salvar(ContatoSalvar);

        //buscar por ID
        Integer id = ContatoSalvar.getId();

        Contato ContatoBuscar = servicoContato.buscarPorId(id);
        System.out.println(ContatoBuscar);

        //Update
    
        ContatoBuscar.setTelefone("77897");

        servicoContato.update(ContatoBuscar);

        Contato ContatoUpdate = servicoContato.buscarPorId(id);
        System.out.println(ContatoUpdate);
        
        //Select all
        System.out.println("Todos: \n");
        List<Contato> Contatos = ContatoDAO.selectAllContatos();
        Contatos.forEach(System.out::println);

        //Delete
        servicoContato.remover(id);

        servicoLaboratorio.remover(laboratorio_id);
    }
    
}
