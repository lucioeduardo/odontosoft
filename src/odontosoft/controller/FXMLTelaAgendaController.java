/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import odontosoft.model.dao.ConsultaDAO;
import odontosoft.model.domain.Consulta;
import odontosoft.model.domain.ConsultaAgenda;
import odontosoft.model.domain.Paciente;

/**
 * FXML Controller class
 *
 * @author eduardo
 */
public class FXMLTelaAgendaController implements Initializable {
    
    @FXML
    private TableColumn tableColumnAgendaPaciente, tableColumnAgendaDentista
            ,tableColumnAgendaData,tableColumnAgendaHorario;
    @FXML
    private TableView<ConsultaAgenda> tableViewAgenda;
    @FXML
    private RadioButton radioBtnAgendaSemana,radioBtnAgendaDia;
    
    private ConsultaAgenda consultaSelecionada;
    
    
    ConsultaDAO consultaDao = new ConsultaDAO();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        radioBtnAgendaDia.setSelected(true);
        carregarTableViewAgenda();
        
        tableViewAgenda.getSelectionModel().selectedItemProperty().addListener(
        (observable,odlValue,newValue) -> selecionarItemTableViewAgenda(newValue));
    }    
    
    public void selecionarItemTableViewAgenda(ConsultaAgenda consulta){
        this.consultaSelecionada = consulta;
    }
    
    public void carregarTableViewAgenda(){
        tableColumnAgendaPaciente.setCellValueFactory(new PropertyValueFactory<>("paciente"));
        tableColumnAgendaDentista.setCellValueFactory(new PropertyValueFactory<>("dentista"));
        tableColumnAgendaHorario.setCellValueFactory(new PropertyValueFactory<>("horario"));
        tableColumnAgendaData.setCellValueFactory(new PropertyValueFactory<>("data"));

        if(radioBtnAgendaDia.isSelected())tableViewAgenda.setItems(consultaDao.getAgendaDoDia());
        //else tableViewAgenda.setItems(consultaDao.getAgendaSemana());
    }
    
    @FXML
    public void radioBtnAgendaSemanaClicked(){
        radioBtnAgendaSemana.setSelected(true);
        radioBtnAgendaDia.setSelected(false);
        carregarTableViewAgenda();
    }
    @FXML
    public void radioBtnAgendaDiaClicked(){
        radioBtnAgendaSemana.setSelected(false);
        radioBtnAgendaDia.setSelected(true);
        carregarTableViewAgenda();
    }
    
    
    @FXML
    
    public void btnRemoverConsultaClicked () {
           
    }
    
    public void btnAdiarConsultaClicked () {
        Stage modal = new Stage();
        
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/odontosoft/view/FXMLTelaAdiarConsulta.fxml"));
            Parent parent = fxmlLoader.load();
            TelaAdiarConsultaController controller = fxmlLoader.getController();
            controller.setConculta(consultaSelecionada);
            
            Scene scene = new Scene(parent);
            modal.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("/odontosoft/view/css/bootstrap3.css").toExternalForm());
        } catch (IOException ex) {
            Logger.getLogger(PacientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        modal.setTitle("Adiar Consulta");
        modal.centerOnScreen();
        modal.initOwner(tableViewAgenda.getScene().getWindow());
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
        
        carregarTableViewAgenda();
    }
    
    public void btnAdicioanarConsultaClicked () {
        Stage modal = new Stage();
        
        try {
            System.out.println(getClass().getResource("/odontosoft/view/FXMLTelaAdicionarConsulta.fxml"));
            Parent parent = FXMLLoader.load(getClass().getResource("/odontosoft/view/FXMLTelaAdicionarConsulta.fxml"));
            Scene scene = new Scene(parent);
            modal.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("/odontosoft/view/css/bootstrap3.css").toExternalForm());
        } catch (IOException ex) {
            Logger.getLogger(PacientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        modal.setTitle("Cadastrar Consulta");
        modal.centerOnScreen();
        modal.initOwner(tableViewAgenda.getScene().getWindow());
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
        
        carregarTableViewAgenda();
    }    
}
