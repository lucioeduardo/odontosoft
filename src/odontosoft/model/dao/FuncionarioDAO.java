package odontosoft.model.dao;

import odontosoft.model.domain.Funcionario;
import java.sql.*;
import java.util.*;
import odontosoft.model.database.ConexaoBanco;

public class FuncionarioDAO implements InterfaceGenericDAO<Funcionario, Integer>{
    ConexaoBanco conexao;
    Connection connect;
    PreparedStatement stmt = null;

    public FuncionarioDAO(ConexaoBanco conexao) {
        this.conexao = conexao;
        connect = this.conexao.getConexao();
    }
   
    
    
    
    @Override
    public void inserir(Funcionario var) {
        String sql = "INSERT INTO Funcionario (nome, cpf, telefone, dataNascimento, rg, salario, isGerente, isDentista) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            stmt = connect.prepareStatement(sql);
            stmt.setString(1, var.getNome());
            stmt.setString(2, var.getCpf());
            stmt.setString(3, var.getTelefone());
            stmt.setDate(4, var.getDataNascimento());
            stmt.setString(5, var.getRg());
            stmt.setDouble(6, var.getSalario());
            stmt.setBoolean(7, var.isGerente());
            stmt.setBoolean(8, var.isDentista());
            
            stmt.execute();
            stmt.close();
            
            System.out.println("Dados inseridos");
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }
    }

    @Override
    public List<Funcionario> listar() {
        ResultSet query;
        List<Funcionario> list = new ArrayList<>();
        String sql = "SELECT * FROM Funcionario";
       
        try{
            stmt = connect.prepareStatement(sql);
            query = stmt.executeQuery();
            
            while(query.next()){
                //id, nome, cpf, rg, telefone, salario, dataNascimento, Gerente
                list.add(new Funcionario(query.getInt("id"), query.getString("nome"), query.getString("cpf"), query.getString("rg"), query.getString("telefone"),
                query.getDouble("salario"), query.getDate("dataNascimento"), query.getBoolean("isGerente"), query.getBoolean("isDentista")));            
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
        String sql = "DELETE FROM Funcionario WHERE id = ?";
        
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
    public void update(Integer id, Funcionario newVar) {
        // nome, cpf, rg, telefone, salario, dataNascimento, isGerente
        String sql = "UPDATE Funcionario SET nome = ?, cpf = ?, "
                + "rg = ?, telefone = ?, salario = ?, dataNascimento = ?, isGerente = ?, isDentista where id = ?;";
        try{
            stmt = connect.prepareStatement(sql);
            stmt.setString(1, newVar.getNome());
            stmt.setString(2, newVar.getCpf());
            stmt.setString(3, newVar.getRg());
            stmt.setString(4, newVar.getTelefone());
            stmt.setDouble(5, newVar.getSalario());
            stmt.setDate(6, newVar.getDataNascimento());
            stmt.setBoolean(7, newVar.isGerente());
            stmt.setBoolean(8, newVar.isDentista());
                        
            stmt.setInt(9, id);
            
            stmt.execute();
            stmt.close();
            System.out.println("Dados atualizados!");
        }catch(SQLException e){
            System.out.println("Error: " +e);
        }
    }

    @Override
    public Funcionario buscaPorId(Integer id) {
        String sql = "SELECT * FROM Funcionario WHERE id = ?";
        Funcionario funcionario = null;
        
        try{
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                // id, nome, cpf, rg, telefone, salario, dataNascimento, Gerente
                funcionario = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), 
                        rs.getString("rg"), rs.getString("telefone"), rs.getDouble("salario"), rs.getDate("dataNascimento"), rs.getBoolean("isGerente"), rs.getBoolean("isDentista"));
            }
            rs.close();
            stmt.close();
        }catch(SQLException e){
            System.out.println("Error: " +e);
        }
        
        return funcionario;
    }
    
}
