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
import odontosoft.model.domain.Procedimento;

/**
 *
 * @author mikolaja
 */
public class ProcedimentoDAO implements InterfaceGenericDAO<Procedimento, Integer>{
    ConexaoBanco conexao = new ConexaoBanco();
    Connection connect = conexao.getConexao();
    PreparedStatement stmt = null;

    public ProcedimentoDAO() {
        
    }
    
    @Override
    public void inserir(Procedimento var) {
        String sql = "INSERT INTO Procedimento(descricao, preco) VALUES (?,?);";
        try{
            stmt = connect.prepareStatement(sql);
            stmt.setString(1, var.getDescricao());
            stmt.setDouble(2, var.getPreco());
            
            stmt.execute();
            stmt.close();
            System.out.println("Dados inseridos no banco de dados!");
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }
    }

    @Override
    public List<Procedimento> listar() {
        ResultSet query;
        List<Procedimento> list = new ArrayList<>();
        String sql = "SELECT * FROM Procedimento";
        try{
            stmt = connect.prepareStatement(sql);
            query = stmt.executeQuery();
            
            while(query.next()){
                list.add(new Procedimento(query.getInt("id"), query.getString("descricao"), query.getDouble("preco")));
                
            }
            query.close();
            stmt.close();
        }catch(SQLException e){
            System.out.println("Error: " +e);
        }
        return list;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Procedimento WHERE id = ?";
        try{
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();
            System.out.println("Dados deletados com sucesso!");
        }catch(SQLException e){
            System.out.println("Error: " +e);
        }
    }

    @Override
    public void update(Integer id, Procedimento newVar) {
        String sql = "UPDATE Procedimento SET descricao = ?, preco = ? WHERE id = ?;";
        try{
            stmt = connect.prepareStatement(sql);
            stmt.setString(1, newVar.getDescricao());
            stmt.setDouble(2, newVar.getPreco());
            stmt.setInt(3, id);
            
            stmt.execute();
            stmt.close();
            System.out.println("Dados atualizados!");
        }catch(SQLException e){
            System.out.println("Error: " +e);
        }
    }

    @Override
    public Procedimento buscaPorId(Integer id) {
        String sql = "SELECT * FROM Procedimento WHERE id = ?";
        Procedimento var = null;
        
        try{
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                var = new Procedimento(rs.getInt("id"), rs.getString("descricao"), rs.getDouble("preco"));
            }
            rs.close();
            stmt.close();
        }catch(SQLException e){
            System.out.println("Error: " +e);
        }
        
        return var;
    }

   
    
}
