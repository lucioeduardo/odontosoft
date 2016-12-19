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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import odontosoft.model.dao.PacienteDAO;
import odontosoft.model.database.ConexaoBanco;
import odontosoft.model.domain.Paciente;

/**
 * FXML Controller class
 *
 * @author eduardo
 */
public class PacientesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableColumn tableColumnPacienteNome,tableColumnPacienteTelefone;
    @FXML
    private TableView<Paciente> tableViewPacientes;
    
    private final ConexaoBanco conexao = new ConexaoBanco();
    private PacienteDAO pacienteDAO = new PacienteDAO(conexao);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarTableViewPacientes();
    }    
    
    public void carregarTableViewPacientes(){
        
        
        tableColumnPacienteNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnPacienteTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        
        List<Paciente> listPacientes = pacienteDAO.listar();
        ObservableList<Paciente> observableListPacientes = FXCollections.observableArrayList(listPacientes);
        tableViewPacientes.setItems(observableListPacientes);
    }
}
