 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
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
    BorderPane borderPane;
    @FXML
    TextField txtFieldNomeUsuario,txtFieldSenha;
    @FXML
    Button btnEntrar;
    @FXML
    Label lblErroLogin;
    
    ConexaoBanco conexao = new ConexaoBanco();
    Connection connect = conexao.getConexao();
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    public void clickBtnEntrar(ActionEvent event){
        lblErroLogin.setOpacity(0);
        
        Stage stage = (Stage)borderPane.getScene().getWindow();
        
        String idInformado = txtFieldNomeUsuario.getText();
        String senhaInformada = txtFieldSenha.getText();
        
        Usuario user = new UsuarioDAO(connect).buscaPorId(idInformado);
       
        
        if(senhaInformada.equals(user.getSenha())){
            try {         
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/odontosoft/view/FXMLTelaPrincipal.fxml"));
                Parent root = fxmlLoader.load();
                TelaPrincipalController controller = fxmlLoader.getController();
                controller.setUser(user);                
                
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setFullScreen(true);
                scene.getStylesheets().add(getClass().getResource("/odontosoft/view/css/bootstrap3.css").toExternalForm());
                scene.getStylesheets().add(getClass().getResource("/odontosoft/view/css/TelaPrincipal.css").toExternalForm());
                
                
                
                //borderPane.setCenter(FXMLLoader.load(getClass().getResource("/odontosoft/view/FXMLTelaPrincipal.fxml")));
            } catch (IOException ex) {
                System.out.println("Erro no border!");
                Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            lblErroLogin.setOpacity(1);
        }
    }
    
    public void telaLoginKeyPressed(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER){
            clickBtnEntrar(null);
        }
    }
    
    
    
}
