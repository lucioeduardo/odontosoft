/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import odontosoft.model.dao.ConsultaDAO;
import odontosoft.model.domain.ConsultaAgenda;

/**
 * FXML Controller class
 *
 * @author eduardo
 */
public class TelaAgendaController implements Initializable {
    
    @FXML
    private TableColumn tableColumnAgendaPaciente, tableColumnAgendaDentista
            ,tableColumnAgendaData,tableColumnAgendaHorario;
    @FXML
    private TableView<ConsultaAgenda> tableViewAgenda;
    @FXML
    private RadioButton radioBtnAgendaCompleta,radioBtnAgendaDia;
    
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
        else tableViewAgenda.setItems(consultaDao.getAgendaCompleta());
    }
    
    @FXML
    public void radioBtnAgendaCompletaClicked(){
        radioBtnAgendaCompleta.setSelected(true);
        radioBtnAgendaDia.setSelected(false);
        carregarTableViewAgenda();
    }
    @FXML
    public void radioBtnAgendaDiaClicked(){
        radioBtnAgendaCompleta.setSelected(false);
        radioBtnAgendaDia.setSelected(true);
        carregarTableViewAgenda();
    }
    
    
    @FXML
    
    public void btnRemoverConsultaClicked () {
        if(consultaSelecionada == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Consulta não selecionada");
            alert.setHeaderText("Selecione uma consulta na tabela!");
            alert.initOwner(radioBtnAgendaDia.getScene().getWindow());
            alert.showAndWait();
            
            return;
        }
        
        
        if(consultaSelecionada != null){
            consultaDao.delete(consultaSelecionada.getIdConsulta());
            carregarTableViewAgenda();
        }   
    }
    
    public void btnAdiarConsultaClicked () {
        if(consultaSelecionada == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Consulta não selecionada");
            alert.setHeaderText("Selecione uma consulta na tabela!");
            alert.initOwner(radioBtnAgendaDia.getScene().getWindow());
            alert.showAndWait();
            
            return;
        }
        
        
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
    
    public void btnAdicionarConsultaClicked () {
        Stage modal = new Stage();
        
        try {
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

    @FXML
    public void btnProcedimentosClicked(){
        if(consultaSelecionada == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Consulta não selecionada");
            alert.setHeaderText("Selecione uma consulta!");
            alert.initOwner(radioBtnAgendaDia.getScene().getWindow());
            alert.showAndWait();
            
            return;
        }
        
        Stage modal = new Stage();
        
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/odontosoft/view/FXMLTelaConsultaProcedimentos.fxml"));
            Parent parent = fxmlLoader.load();
            TelaConsultaProcedimentosController controller = fxmlLoader.getController();
            controller.setConsulta(consultaSelecionada);
            
            Scene scene = new Scene(parent);
            modal.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("/odontosoft/view/css/bootstrap3.css").toExternalForm());
        } catch (IOException ex) {
            Logger.getLogger(PacientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        modal.setTitle("Procedimentos da consulta");
        modal.centerOnScreen();
        modal.initOwner(tableViewAgenda.getScene().getWindow());
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();        
    }
}
