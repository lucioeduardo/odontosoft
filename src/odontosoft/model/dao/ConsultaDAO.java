/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.model.dao;

/**
 *
 * @author Aluno
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import odontosoft.model.database.ConexaoBanco;
import odontosoft.model.domain.Consulta;
import odontosoft.model.domain.Funcionario;
import odontosoft.model.domain.Paciente;
import odontosoft.model.domain.Procedimento;

public class ConsultaDAO implements InterfaceGenericDAO<Consulta, Integer>{
    ConexaoBanco conexao;
    Connection connect = conexao.getConexao();
    PreparedStatement stmt = null;
    Paciente paciente;
    Funcionario funcionario;
    ArrayList<Procedimento> procedimentos = new ArrayList<>();

    public ConsultaDAO(ConexaoBanco conexao, Paciente paciente, Funcionario funcionario, ArrayList<Procedimento> procedimentos) {
        this.conexao = conexao;
        this.paciente = paciente;
        this.funcionario = funcionario;
        this.procedimentos = procedimentos;
    }
    
    @Override
    public void inserir(Consulta var) {
        String sql = "INSERT INTO Consulta(idPaciente, idFuncionario, dataConsulta) VALUES (?,?,?);";
        try{
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, paciente.getId());
            stmt.setInt(2, funcionario.getId());
            stmt.setDate(3, var.getData());
            
            stmt.execute();
            stmt.close();
            System.out.println("Dados inseridos no banco de dados!");
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }
    }

    @Override
    public List<Consulta> listar() {
        ResultSet query;
        List<Consulta> list = new ArrayList<>();
        String sql = "SELECT * FROM Consulta";
        try{
            stmt = connect.prepareStatement(sql);
            query = stmt.executeQuery();
            
            while(query.next()){
                list.add(new Consulta(query.getInt("idPaciente"), query.getInt("idFuncionario"), query.getDate("dataConsulta")));
                
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
        String sql = "DELETE FROM Consulta WHERE id = ?";
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
    public void update(Integer id, Consulta newVar) {
        String sql = "UPDATE Consulta SET idPaciente = ?, idFuncionario = ? WHERE id = ?;";
        try{
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, newVar.getPaciente());
            stmt.setInt(2, newVar.getDentista());
            stmt.setInt(3, id);
            
            stmt.execute();
            stmt.close();
            System.out.println("Dados atualizados!");
        }catch(SQLException e){
            System.out.println("Error: " +e);
        }
    }

    @Override
    public Consulta buscaPorId(Integer id) {
        String sql = "SELECT * FROM Consulta WHERE id = ?";
        Consulta var = null;
        
        try{
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                var = new Consulta(rs.getInt("idPaciente"), rs.getInt("idFuncionario"), rs.getDate("dataConsulta"));
            }
            rs.close();
            stmt.close();
        }catch(SQLException e){
            System.out.println("Error: " +e);
        }
        
        return var;
    }
   
    
}
