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
    Consulta consulta;
    ArrayList<Procedimento> procedimentos = new ArrayList<>();

    public ConsultaDAO(ConexaoBanco conexao, Paciente paciente, Funcionario funcionario, Consulta consulta, ArrayList<Procedimento> procedimentos) {
        this.conexao = conexao;
        this.paciente = paciente;
        this.funcionario = funcionario;
        this.consulta = consulta;
        this.procedimentos = procedimentos;
    }

   public double totalProcedimentos(){
       double total = 0;
       for(int i = 0; i < procedimentos.size(); i++){
           total += procedimentos.get(i).getPreco();
       }
       return total;
   }
   
   public String descricaoProcedimentos(){
       String descricao = null;
       for(int i = 0; i < procedimentos.size(); i++){
           descricao += procedimentos.get(i).getDescricao() + " | ";
       }
       return descricao;
   }
    
    @Override
    public void inserir(Consulta var) {
        String sql = "INSERT INTO Consulta(idPaciente, idFuncionario, dataConsulta) VALUES (?,?,?);";
        try{
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, paciente.getId());
            stmt.setInt(2, funcionario.getId());
            stmt.setString(3, consulta.getData());
            
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
                list.add(new Consulta(funcionario, paciente, procedimentos, totalProcedimentos(), descricaoProcedimentos()));
                
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Integer id, Consulta newVar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consulta buscaPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
