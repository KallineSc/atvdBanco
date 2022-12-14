package br.com.frota.util;

import br.com.frota.DAO.MaterialExameDAO;
import br.com.frota.model.MaterialExame;
import br.com.frota.servico.ServicoMaterialExame;

import java.sql.SQLException;
import java.util.List;

public class TesteMaterialExame {
    static MaterialExameDAO MaterialExameDAO = new MaterialExameDAO();
    static ServicoMaterialExame servicoMaterialExame = new ServicoMaterialExame();

    public static void main(String[] args) throws SQLException {
        //salvar 
        MaterialExame MaterialExameSalvar = new MaterialExame("material 1", "obs 1");
        servicoMaterialExame.salvar(MaterialExameSalvar);

        //buscar por ID
        Integer id = MaterialExameSalvar.getId();

        MaterialExame MaterialExameBuscar = servicoMaterialExame.buscarPorId(id);
        System.out.println(MaterialExameBuscar);

        //Update
    
        MaterialExameBuscar.setMaterial("material 2");
        MaterialExameBuscar.setObservacao("obs 2");
        servicoMaterialExame.update(MaterialExameBuscar);

        MaterialExame MaterialExameUpdate = servicoMaterialExame.buscarPorId(id);
        System.out.println(MaterialExameUpdate);
        
        //Select all
        System.out.println("Todos: \n");
        List<MaterialExame> MaterialExames = MaterialExameDAO.selectAllMaterialExames();
        MaterialExames.forEach(System.out::println);

        //Delete
        servicoMaterialExame.remover(id);
        
    }

    
}