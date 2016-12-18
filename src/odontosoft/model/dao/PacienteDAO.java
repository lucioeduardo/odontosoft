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
import odontosoft.model.domain.Paciente;

/**
 *
 * @author Aluno
 */
public class PacienteDAO implements InterfaceGenericDAO<Paciente,Integer>{
    ConexaoBanco conexao;
    Connection connect = conexao.getConexao();
    PreparedStatement stmt = null;
    Paciente paciente;

    public PacienteDAO(ConexaoBanco conexao, Paciente paciente) {
        this.conexao = conexao;
        this.paciente = paciente;
    }
    
    
    
    @Override
    public void inserir(Paciente var) {
        String sql = "INSERT INTO Paciente(nome, dataNascimento, cpf, telefone, foto) VALUES"
                + "(?,?,?,?,?);";
        try{
            stmt = connect.prepareStatement(sql);
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getData());
            stmt.setString(3, paciente.getCpf());
            stmt.setString(4, paciente.getTelefone());
            stmt.setString(5, paciente.getFoto());
            
            stmt.execute();
            stmt.close();
            System.out.println("Dados inseridos no banco de dados!");
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }
    }

    @Override
    public List<Paciente> listar() {
        ResultSet query;
        List<Paciente> list = new ArrayList<>();
        String sql = "SELECT * FROM Paciente";
        try{
            stmt = connect.prepareStatement(sql);
            query = stmt.executeQuery();
            
            while(query.next()){
                //id, nome, dataNascimento, CPF, Telefone, Caminho da Foto
                list.add(new Paciente(query.getInt(1), query.getString(2), query.getString(3),
                        query.getString(4), query.getString(5), query.getString(6)));
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
        String sql = "DELETE FROM Paciente WHERE id = ?";
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
    public void update(Integer id, Paciente newVar) {
        String sql = "UPDATE Usuario SET nome = ?, dataNascimento = ?, "
                + "cpf = ?, telefone = ?, foto = ? where id = ?;";
        try{
            stmt = connect.prepareStatement(sql);
            stmt.setString(1, newVar.getNome());
            stmt.setString(2, newVar.getData());
            stmt.setString(3, newVar.getCpf());
            stmt.setString(4, newVar.getTelefone());
            stmt.setString(5, newVar.getFoto());
            stmt.setInt(6, id);
            
            stmt.execute();
            stmt.close();
            System.out.println("Dados atualizados!");
        }catch(SQLException e){
            System.out.println("Error: " +e);
        }
    }

    @Override
    public Paciente buscaPorId(Integer id) {
        String sql = "SELECT * FROM Paciente WHERE id = ?";
        Paciente paciente = null;
        
        try{
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                paciente = new Paciente(rs.getInt("id"), rs.getString("nome"), rs.getString("data"), 
                        rs.getString("cpf"), rs.getString("telefone"), rs.getString("foto"));
            }
            rs.close();
            stmt.close();
        }catch(SQLException e){
            System.out.println("Error: " +e);
        }
        
        return paciente;
    }
    
}
