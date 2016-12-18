/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import odontosoft.model.database.ConexaoBanco;
import odontosoft.model.domain.Consulta_has_Procedimento;

/**
 *
 * @author mikolaja
 */
public class Consulta_has_ProcedimentoDAO implements InterfaceGenericDAO<Consulta_has_Procedimento, Integer>{
    ConexaoBanco conexao;
    Connection connect = conexao.getConexao();
    PreparedStatement stmt = null;
    Consulta_has_Procedimento chs;
    @Override
    public void inserir(Consulta_has_Procedimento var) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consulta_has_Procedimento> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Integer id, Consulta_has_Procedimento newVar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consulta_has_Procedimento buscaPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
