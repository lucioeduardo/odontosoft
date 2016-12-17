/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import odontosoft.model.database.ConexaoBanco;

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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    @FXML
    public void clickBtnEntrar(){
        String sql = "select id, senha from Usuario where id = ?;";
        
    }
}
