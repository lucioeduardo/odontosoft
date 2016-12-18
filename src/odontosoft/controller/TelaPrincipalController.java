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
import javafx.scene.control.Label;
import odontosoft.model.dao.FuncionarioDAO;
import odontosoft.model.domain.Funcionario;
import odontosoft.model.domain.Usuario;

/**
 * FXML Controller class
 *
 * @author eduardo
 */
public class TelaPrincipalController implements Initializable {
    @FXML
    private Usuario user;
    @FXML
    private Label lblNome;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
        lblNome.setText(user.getId());
    }
    
    
    
}
