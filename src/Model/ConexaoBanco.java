/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Aluno
 */
import java.sql.*;

public class ConexaoBanco {
    Connection conexao = null; 
    String url = "jdbc:mysql://localhost/odontosoft"; 
    String usuario = "root";
    String senha = "";
    
    public ConexaoBanco(){
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexao com o banco de dados realizada com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro na conexao com o banco: "+e);
        }
    }
    
    public Connection getConexao(){
        return conexao;
    }
}
