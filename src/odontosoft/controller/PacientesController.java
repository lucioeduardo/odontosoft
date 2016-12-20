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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
    @FXML
    private Label lblNomePaciente,lblTelefonePaciente,lblCpfPaciente,lblDataNascimentoPaciente;
    @FXML
    private Button btnAdicionarPaciente,btnAlterarPaciente,btnRemoverPaciente;
    
    
    private final ConexaoBanco conexao = new ConexaoBanco();
    private PacienteDAO pacienteDAO = new PacienteDAO(conexao);
    private Paciente pacienteSelecionado = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarTableViewPacientes();
        
        tableViewPacientes.getSelectionModel().selectedItemProperty().addListener(
        (observable,odlValue,newValue) -> selecionarItemTableViewPacientes(newValue));
    }    
    
    public void carregarTableViewPacientes(){
        tableColumnPacienteNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnPacienteTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        
        List<Paciente> listPacientes = pacienteDAO.listar();
        ObservableList<Paciente> observableListPacientes = FXCollections.observableArrayList(listPacientes);
        tableViewPacientes.setItems(observableListPacientes);
    }
    
    public void selecionarItemTableViewPacientes(Paciente paciente){
        this.pacienteSelecionado=paciente;
        
        lblNomePaciente.setText(paciente.getNome());
        lblDataNascimentoPaciente.setText(paciente.getData().toString());
        lblCpfPaciente.setText(paciente.getCpf());
        lblTelefonePaciente.setText(paciente.getTelefone());
    }
    
    @FXML
    public void btnRemoverPacienteClicked(){
        if(pacienteSelecionado!=null){
            pacienteDAO.delete(pacienteSelecionado.getId());
            carregarTableViewPacientes();
        }
    }
    
    @FXML
    public void btnAdicionarPacienteClicked(){
        Stage modal = new Stage();
        
        try {
            System.out.println(getClass().getResource("/odontosoft/view/FXMLTelaAdicionarPaciente.fxml"));
            Parent parent = FXMLLoader.load(getClass().getResource("/odontosoft/view/FXMLTelaAdicionarPaciente.fxml"));
            Scene scene = new Scene(parent);
            modal.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("/odontosoft/view/css/bootstrap3.css").toExternalForm());
        } catch (IOException ex) {
            Logger.getLogger(PacientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        modal.setTitle("Cadastrar Paciente");
        modal.centerOnScreen();
        modal.initOwner(lblNomePaciente.getScene().getWindow());
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
        
        carregarTableViewPacientes();
    }
    @FXML
    public void btnAlterarPacienteClicked(){
        Stage modal = new Stage();
        
        try {
            System.out.println(getClass().getResource("/odontosoft/view/FXMLTelaAdicionarPaciente.fxml"));
            Parent parent = FXMLLoader.load(getClass().getResource("/odontosoft/view/FXMLTelaAlterarPaciente.fxml"));
            Scene scene = new Scene(parent);
            modal.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("/odontosoft/view/css/bootstrap3.css").toExternalForm());
        } catch (IOException ex) {
            Logger.getLogger(PacientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        modal.setTitle("Cadastrar Paciente");
        modal.centerOnScreen();
        modal.initOwner(lblNomePaciente.getScene().getWindow());
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
        
        carregarTableViewPacientes();
    }
    
    
    
}
