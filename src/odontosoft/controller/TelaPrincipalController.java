/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.controller;

import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private Label lblNome,lblHorario;
    @FXML
    private ImageView imgViewSair;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        Timer timer = new Timer();
        
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                
                System.out.println("Executou!");
                
                Platform.runLater(() -> lblHorario.setText(getHora()));
                
            }
        }, 0, 1000);
        
        
    }   

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
        
        //Funcionario f = new FuncionarioDAO().buscaPorId(user.getIdFuncionario());
        
        lblNome.setText(user.getId());
    }
    
    @FXML
    public void imgViewSairMouseEntered(){
        Image image = new Image(getClass().getResourceAsStream("/odontosoft/view/img/iconSairHover.png"));
        imgViewSair.setImage(image);
    }
    
    @FXML
    public void imgViewSairMouseExited(){
        Image image = new Image(getClass().getResourceAsStream("/odontosoft/view/img/iconSairPadrao.png"));
        imgViewSair.setImage(image);
    }
    
    @FXML
    public void imgViewSairMouseClicked(){
        System.exit(0);
    }
    
    
    public String getHora(){
        Calendar cal = new GregorianCalendar();
        
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        
        return hora + ":" + min + ":" + sec;
    }
    
}
