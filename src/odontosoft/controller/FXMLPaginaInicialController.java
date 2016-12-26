/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import odontosoft.model.dao.ConsultaDAO;
import odontosoft.model.domain.Consulta;
import odontosoft.model.domain.ConsultaAgenda;

/**
 * FXML Controller class
 *
 * @author eduardo
 */
public class FXMLPaginaInicialController implements Initializable {

    
    @FXML
    private TableColumn tableColumnDentista,tableColumnHorario;
    @FXML
    private TableView<ConsultaAgenda> tableViewConsultasHoje;
    @FXML
    private Label lblTempoRestante;
    
    private final ConsultaDAO consultaDao = new ConsultaDAO();
    private Consulta proximaConsulta;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarTableViewAgenda();
        
        Timer timer = new Timer();
        
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {                
                Platform.runLater(() -> lblTempoRestante.setText(getTempoRestante()));
                
            }
        }, 0, 1000*60);
    }    
    
    public void carregarTableViewAgenda(){
        tableColumnDentista.setCellValueFactory(new PropertyValueFactory<>("dentista"));
        tableColumnHorario.setCellValueFactory(new PropertyValueFactory<>("horario"));

        tableViewConsultasHoje.setItems(consultaDao.getAgendaDoDia());
    }
    
    public String getTempoRestante(){
        Consulta consulta = consultaDao.getProximaConsulta();
        this.proximaConsulta = consulta;
        if(consulta == null)
            return "Não há consultas marcadas!";
        
        long timeMillis = (consulta.getData().getTimeInMillis() - Calendar.getInstance().getTimeInMillis());
        int horas = (int) (timeMillis/(1000*60*60));
        timeMillis -= horas*1000*60*60;
        int minutos = (int) (timeMillis/(1000*60));
       
        
        String retorno = horas + ":";
        if(minutos < 10)
            retorno += "0";
        retorno += minutos;
        
        return retorno;
    }
    
    
    public void btnVisualizarConsultaClicked(){
        Stage modal = new Stage();
        
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/odontosoft/view/FXMLTelaAdiarConsulta.fxml"));
            Parent parent = fxmlLoader.load();
            TelaAdiarConsultaController controller = fxmlLoader.getController();
            controller.setConculta(tableViewConsultasHoje.getItems().get(0));
            
            Scene scene = new Scene(parent);
            modal.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("/odontosoft/view/css/bootstrap3.css").toExternalForm());
        } catch (IOException ex) {
            Logger.getLogger(PacientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        modal.setTitle("Adiar Consulta");
        modal.centerOnScreen();
        modal.initOwner(tableViewConsultasHoje.getScene().getWindow());
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
        
        carregarTableViewAgenda();
    }
}
