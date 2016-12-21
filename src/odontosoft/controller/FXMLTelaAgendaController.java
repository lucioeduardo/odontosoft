/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
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
    
    ConsultaDAO consultaDao = new ConsultaDAO();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarTableViewAgenda();
    }    
    
    public void carregarTableViewAgenda(){
        
        
        tableColumnAgendaPaciente.setCellValueFactory(new PropertyValueFactory<>("nomePaciente"));
        tableColumnAgendaDentista.setCellValueFactory(new PropertyValueFactory<>("nomeDentista"));
        tableColumnAgendaHorario.setCellValueFactory(new PropertyValueFactory<>("horario"));
        tableColumnAgendaData.setCellValueFactory(new PropertyValueFactory<>("data"));

        tableViewAgenda.setItems(consultaDao.getAgendaDoDia());
    }
    
}
