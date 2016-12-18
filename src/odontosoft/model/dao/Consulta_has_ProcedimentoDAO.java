/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import odontosoft.model.database.ConexaoBanco;
import odontosoft.model.domain.Consulta_has_Procedimento;

/**
 *
 * @author mikolaja
 */
public class Consulta_has_ProcedimentoDAO implements InterfaceGenericDAO<Consulta_has_Procedimento, String>{
    ConexaoBanco conexao;
    Connection connect = conexao.getConexao();
    PreparedStatement stmt = null;
    
    @Override
    public void inserir(Consulta_has_Procedimento var) {
        String sql = "INSERT INTO Consulta_has_Procedimento(idConsulta, idProcedimento) VALUES (?,?);";
        try{
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, var.getIdConsulta());
            stmt.setInt(2, var.getIdProcedimento());
            
            stmt.execute();
            stmt.close();
            System.out.println("Dados inseridos no banco de dados!");
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }
    }

    @Override
    public List<Consulta_has_Procedimento> listar() {
        ResultSet query;
        List<Consulta_has_Procedimento> list = new ArrayList<>();
        String sql = "SELECT * FROM Procedimento";
        try{
            stmt = connect.prepareStatement(sql);
            query = stmt.executeQuery();
            
            while(query.next()){
                list.add(new Consulta_has_Procedimento(query.getInt("idConsulta"), query.getInt("idProcedimento")));
                
            }
            query.close();
            stmt.close();
        }catch(SQLException e){
            System.out.println("Error: " +e);
        }
        return list;
    }

    @Override
    public void delete(String idString) {
        String sql = "DELETE FROM Consulta_has_Procedimento WHERE idConsulta = ? AND idProcedimento = ?";
        String id[] = new String[2];
        id = idString.split("|");
        try{
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(id[0]));
            stmt.setInt(2, Integer.parseInt(id[1]));
            
            stmt.execute();
            stmt.close();
            System.out.println("Dados deletados com sucesso!");
        }catch(SQLException e){
            System.out.println("Error: " +e);
        }
    }

    @Override
    public void update(String idString, Consulta_has_Procedimento newVar) {
        String sql = "UPDATE Consulta_has_Procedimento SET idConsulta = ?, idProcedimento = ? WHERE idConsulta = ? "
                + "AND idProceidmento = ?;";
        String id[] = new String[2];
        id = idString.split("|");
        try{
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, newVar.getIdConsulta());
            stmt.setInt(2, newVar.getIdProcedimento());
            stmt.setInt(3, Integer.parseInt(id[0]));
            stmt.setInt(4, Integer.parseInt(id[1]));
            
            stmt.execute();
            stmt.close();
            System.out.println("Dados atualizados!");
        }catch(SQLException e){
            System.out.println("Error: " +e);
        }
    }

    @Override
    public Consulta_has_Procedimento buscaPorId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
