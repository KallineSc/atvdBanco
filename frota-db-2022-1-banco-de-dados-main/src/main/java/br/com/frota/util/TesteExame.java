package br.com.frota.util;

import br.com.frota.DAO.ExameDAO;
import br.com.frota.model.Exame;
import br.com.frota.servico.ServicoExame;

import br.com.frota.DAO.TipoExameDAO;
import br.com.frota.model.TipoExame;
import br.com.frota.servico.ServicoTipoExame;

import br.com.frota.DAO.MaterialExameDAO;
import br.com.frota.model.MaterialExame;
import br.com.frota.servico.ServicoMaterialExame;

import java.sql.SQLException;
import java.util.List;

public class TesteExame {

    static ExameDAO ExameDAO = new ExameDAO();
    static ServicoExame servicoExame = new ServicoExame();

    static TipoExameDAO TipoExameDAO = new TipoExameDAO();
    static ServicoTipoExame servicoTipoExame = new ServicoTipoExame();
    
    static MaterialExameDAO MaterialExameDAO = new MaterialExameDAO();
    static ServicoMaterialExame servicoMaterialExame = new ServicoMaterialExame();
    public static void main(String[] args) throws SQLException {
        //salvar 
        MaterialExame material1 = new MaterialExame("material 1", "obs 1");
        servicoMaterialExame.salvar(material1);
        MaterialExame material2 = new MaterialExame("material 2", "obs 2");
        servicoMaterialExame.salvar(material2);

        TipoExame tipoExame1 = new TipoExame("descrição 1", "obs 1");
        servicoTipoExame.salvar(tipoExame1);
        TipoExame tipoExame2 = new TipoExame("descrição 2", "obs 2");
        servicoTipoExame.salvar(tipoExame2);

        Integer tipo_exame_id1 = material1.getId();
        Integer material_exame_id1 = tipoExame1.getId();

        Integer tipo_exame_id2 = material2.getId();
        Integer material_exame_id2 = tipoExame2.getId();

        Exame ExameSalvar = new Exame("descrição 1", "metodo 1", tipo_exame_id1, material_exame_id1);
        servicoExame.salvar(ExameSalvar);

        //buscar por ID
        Integer id = ExameSalvar.getId();

        Exame ExameBuscar = servicoExame.buscarPorId(id);
        System.out.println(ExameBuscar);

        //Update
    
        ExameBuscar.setDescricao("descrição 2");
        ExameBuscar.setMetodo("metodo 2");
        ExameBuscar.setMeterial_exame_id(material_exame_id2);
        ExameBuscar.setTipo_exame(tipo_exame_id2);

        servicoExame.update(ExameBuscar);

        Exame ExameUpdate = servicoExame.buscarPorId(id);
        System.out.println(ExameUpdate);
        
        //Select all
        System.out.println("Todos: \n");
        List<Exame> Exames = ExameDAO.selectAllExames();
        Exames.forEach(System.out::println);

        //Delete
        servicoExame.remover(id);

        //Deletar 
        servicoMaterialExame.remover(tipo_exame_id1);
        servicoMaterialExame.remover(tipo_exame_id2);
        
        servicoTipoExame.remover(material_exame_id1);
        servicoTipoExame.remover(material_exame_id2);
    }
    
}
