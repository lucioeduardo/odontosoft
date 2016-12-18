/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.model.database;

/**
 *
 * @author Aluno
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void fecharConexao(){
        try {
            this.conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
