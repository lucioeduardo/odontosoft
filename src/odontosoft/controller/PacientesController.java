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
    private TableColumn tableColumnPacienteNome,tableColumnPacienteTelefone,tableColumnPacienteCpf,tableColumnPacienteDataNascimento;
    @FXML
    private TableView<Paciente> tableViewPacientes;
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
        tableColumnPacienteCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tableColumnPacienteDataNascimento.setCellValueFactory(new PropertyValueFactory("data"));
        
        List<Paciente> listPacientes = pacienteDAO.listar();
        ObservableList<Paciente> observableListPacientes = FXCollections.observableArrayList(listPacientes);
        tableViewPacientes.setItems(observableListPacientes);
    }
    
    public void selecionarItemTableViewPacientes(Paciente paciente){
        this.pacienteSelecionado=paciente;
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
        modal.initOwner(btnAdicionarPaciente.getScene().getWindow());
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
        
        carregarTableViewPacientes();
    }
    @FXML
    public void btnAlterarPacienteClicked(){
        Stage modal = new Stage();
        
        try {
            System.out.println(getClass().getResource("/odontosoft/view/FXMLTelaAlterarPaciente.fxml"));
            FXMLLoader fxmlloader = FXMLLoader.load(getClass().getResource("/odontosoft/view/FXMLTelaAlterarPaciente.fxml"));
            Parent parent = fxmlloader.load();
            TelaAlterarPacienteController controller = fxmlloader.getController();
            controller.setPaciente(pacienteSelecionado);
            
            Scene scene = new Scene(parent);
            modal.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("/odontosoft/view/css/bootstrap3.css").toExternalForm());
        } catch (IOException ex) {
            Logger.getLogger(PacientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        modal.setTitle("Alterar Paciente");
        modal.centerOnScreen();
        modal.initOwner(btnAlterarPaciente.getScene().getWindow());
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
        
        carregarTableViewPacientes();
    }
    
}
