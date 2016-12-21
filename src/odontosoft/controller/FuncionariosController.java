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
import odontosoft.model.dao.FuncionarioDAO;
import odontosoft.model.database.ConexaoBanco;
import odontosoft.model.domain.Funcionario;

public class FuncionariosController implements Initializable {
    
    @FXML
    private TableColumn tableColumnFuncionarioNome,tableColumnFuncionarioTelefone,tableColumnFuncionarioCpf,tableColumnFuncionarioDataNascimento;
    @FXML
    private TableView<Funcionario> tableViewFuncionarios;
    @FXML
    private Button btnAdicionarFuncionario,btnAlterarFuncionario,btnRemoverFuncionario;
    
    
    private ConexaoBanco conexao = new ConexaoBanco();
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conexao);
    private Funcionario funcionarioSelecionado = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarTableViewFuncionarios();
        
        tableViewFuncionarios.getSelectionModel().selectedItemProperty().addListener(
        (observable,odlValue,newValue) -> selecionarItemTableViewFuncionarios(newValue));
    }    
    
    public void carregarTableViewFuncionarios(){
        tableColumnFuncionarioNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnFuncionarioTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tableColumnFuncionarioCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tableColumnFuncionarioDataNascimento.setCellValueFactory(new PropertyValueFactory("data"));
        
        List<Funcionario> listFuncionarios = funcionarioDAO.listar();
        ObservableList<Funcionario> observableListFuncionarios = FXCollections.observableArrayList(listFuncionarios);
        tableViewFuncionarios.setItems(observableListFuncionarios);
    }
    
    public void selecionarItemTableViewFuncionarios(Funcionario funcionario){
        this.funcionarioSelecionado=funcionario;
    }
    
    @FXML
    public void btnRemoverFuncionarioClicked(){
        if(funcionarioSelecionado!=null){
            funcionarioDAO.delete(funcionarioSelecionado.getId());
            carregarTableViewFuncionarios();
        }
    }
    
    @FXML
    public void btnAdicionarFuncionarioClicked(){
        Stage modal = new Stage();
        
        try {
            System.out.println(getClass().getResource("/odontosoft/view/FXMLTelaAdicionarFuncionario.fxml"));
            Parent parent = FXMLLoader.load(getClass().getResource("/odontosoft/view/FXMLTelaAdicionarFuncionario.fxml"));
            Scene scene = new Scene(parent);
            modal.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("/odontosoft/view/css/bootstrap3.css").toExternalForm());
        } catch (IOException ex) {
            Logger.getLogger(FuncionariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        modal.setTitle("Cadastrar Funcionario");
        modal.centerOnScreen();
        modal.initOwner(btnAdicionarFuncionario.getScene().getWindow());
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
        
        carregarTableViewFuncionarios();
    }
    @FXML
    public void btnAlterarFuncionarioClicked(){
        Stage modal = new Stage();
        
        try {
            System.out.println(getClass().getResource("/odontosoft/view/FXMLTelaAlterarFuncionario.fxml"));
            FXMLLoader fxmlloader = FXMLLoader.load(getClass().getResource("/odontosoft/view/FXMLTelaAlterarFuncionario.fxml"));
            Parent parent = fxmlloader.load();
            //TelaAlterarFuncionarioController controller = fxmlloader.getController();
            //controller.setFuncionario(funcionarioSelecionado);
            
            Scene scene = new Scene(parent);
            modal.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("/odontosoft/view/css/bootstrap3.css").toExternalForm());
        } catch (IOException ex) {
            Logger.getLogger(FuncionariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        modal.setTitle("Alterar Funcionario");
        modal.centerOnScreen();
        modal.initOwner(btnAlterarFuncionario.getScene().getWindow());
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
        
        carregarTableViewFuncionarios();
    }
    
}
