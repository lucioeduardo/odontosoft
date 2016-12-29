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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import odontosoft.model.domain.Funcionario;
import odontosoft.model.dao.FuncionarioDAO;
import odontosoft.model.database.ConexaoBanco;


public class FuncionariosController implements Initializable{
    @FXML
    private TableColumn tableColumnFuncionarioNome,tableColumnFuncionarioTelefone,tableColumnFuncionarioCpf,tableColumnFuncionarioDataNascimento,
            tableColumnFuncionarioRg, tableColumnFuncionarioSalario, tableColumnFuncionarioGerente, tableColumnFuncionarioDentista;
    @FXML
    private TableView<Funcionario> tableViewFuncionarios;
    @FXML
    private Button btnAdicionarFuncionario,btnAlterarFuncionario,btnRemoverFuncionario;
    
    private Funcionario funcionarioSelecionado;
    
    private ConexaoBanco conexao = new ConexaoBanco();
    private FuncionarioDAO funcionarioDao = new FuncionarioDAO(conexao);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarTableViewFuncionarios();
        tableViewFuncionarios.getSelectionModel().selectedItemProperty().addListener(
                (observable,oldValue,newValue) -> selecionarItemTableViewFuncionarios(newValue));
    }
    
    public void carregarTableViewFuncionarios(){
        tableColumnFuncionarioNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnFuncionarioTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tableColumnFuncionarioCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tableColumnFuncionarioRg.setCellValueFactory(new PropertyValueFactory<>("rg"));
        tableColumnFuncionarioDataNascimento.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
        tableColumnFuncionarioSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        tableColumnFuncionarioGerente.setCellValueFactory(new PropertyValueFactory<>("Gerente"));
        tableColumnFuncionarioDentista.setCellValueFactory(new PropertyValueFactory<>("Dentista"));
        
        List<Funcionario> listFuncionarios = funcionarioDao.listar();
        ObservableList<Funcionario> observableFuncionarios = FXCollections.observableList(listFuncionarios);
        tableViewFuncionarios.setItems(observableFuncionarios);
        
    }
    
    public void selecionarItemTableViewFuncionarios(Funcionario newValue){
        funcionarioSelecionado = newValue;
    }
    
    @FXML
    public void btnAdicionarFuncionarioClicked(){
        Stage modal = new Stage();
        try{
            Parent parent = FXMLLoader.load(getClass().getResource("/odontosoft/view/FXMLTelaAdicionarFuncionario.fxml"));
            Scene scene = new Scene(parent);
            modal.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("/odontosoft/view/css/bootstrap3.css").toExternalForm());
            
        }catch (IOException ex){
            Logger.getLogger(FuncionariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        modal.setTitle("Cadastrar Funcionário");
        modal.centerOnScreen();
        modal.initOwner(btnAdicionarFuncionario.getScene().getWindow());
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
        
        carregarTableViewFuncionarios();
        
    }
    @FXML
    public void btnAlterarFuncionarioClicked(){
        if(funcionarioSelecionado == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Funcionário não selecionado");
            alert.setHeaderText("Selecione um funcionário na tabela!");
            //  alert.setContentText("Você precisa selecionar uma consulta!");
            alert.showAndWait();
            
            return;
        }
        
        Stage modal = new Stage();
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/odontosoft/view/FXMLTelaAlterarFuncionario.fxml"));
            Parent parent = fxmlLoader.load();
            TelaAlterarFuncionarioController controller = fxmlLoader.getController();
            controller.setFuncionario(funcionarioSelecionado);
            
            Scene scene = new Scene(parent);
            modal.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("/odontosoft/view/css/bootstrap3.css").toExternalForm());
            
        }catch (IOException ex){
            Logger.getLogger(FuncionariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        modal.setTitle("Alterar Funcionário");
        modal.centerOnScreen();
        modal.initOwner(btnAlterarFuncionario.getScene().getWindow());
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
        
        carregarTableViewFuncionarios();
    }
    @FXML
    public void btnRemoverFuncionarioClicked(){
        if(funcionarioSelecionado == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Funcionário não selecionado");
            alert.setHeaderText("Selecione um funcionário na tabela!");
            //  alert.setContentText("Você precisa selecionar uma consulta!");
            alert.showAndWait();
            
            return;
        }
        
        
        if (funcionarioSelecionado!=null) {
            funcionarioDao.delete(funcionarioSelecionado.getId());
            carregarTableViewFuncionarios();
        }
    }
    
}
