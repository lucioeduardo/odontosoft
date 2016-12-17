/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.sql.Connection;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import odontosoft.model.database.ConexaoBanco;
import odontosoft.model.domain.Usuario;

/**
 * FXML Controller class
 *
 * @author eduardo
 */
public class TelaLoginController implements Initializable {
    
    @FXML
    TextField txtFieldNomeUsuario,txtFieldSenha;
    @FXML
    Button btnEntrar;
    ConexaoBanco conexao;
    Connection connect = conexao.getConexao();
    PreparedStatement stmt = null;
    Usuario usuario;
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    public void clickBtnEntrar(){
        usuario = new Usuario(txtFieldNomeUsuario.getText(), txtFieldSenha.getText());
        String sql = "select id, senha from Usuario where id = ?;";
        try{
            stmt = connect.prepareStatement(sql);
            stmt.setString(1, usuario.getId());
            ResultSet executeQuery = stmt.executeQuery(sql);
            
            while(executeQuery.next()){
                if(usuario.getId().equals(executeQuery.getString("id")) && 
                        usuario.getSenha().equals(executeQuery.getString("senha"))){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Conexão");
                    alert.setContentText("Conexão realizada com sucesso!");
                    alert.showAndWait();
                }
            }
            
        }catch(SQLException e){
            System.out.println("Error: " + e);
        }
        
    }
}
