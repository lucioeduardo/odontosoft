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
import odontosoft.model.dao.UsuarioDAO;

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
    
    ConexaoBanco conexao = new ConexaoBanco();
    Connection connect = conexao.getConexao();
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    public void clickBtnEntrar(){
        String idInformado = txtFieldNomeUsuario.getText();
        String senhaInformada = txtFieldSenha.getText();
        
        Usuario user = new UsuarioDAO(connect).buscaPorId(idInformado);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Conexão");
        
        if(senhaInformada.equals(user.getSenha())){
            alert.setContentText("Conexão realizada com sucesso!");
            alert.showAndWait();
        }else{
            alert.setContentText("Usuario ou senha incorreto(s)!");
            alert.showAndWait();
        }
        
    }
}
