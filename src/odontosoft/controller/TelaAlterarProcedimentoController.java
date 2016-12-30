package odontosoft.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import odontosoft.model.dao.ProcedimentoDAO;
import odontosoft.model.domain.Procedimento;

/**
 * FXML Controller class
 *
 */
public class TelaAlterarProcedimentoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextArea txtAreaDescricao;
    @FXML
    private TextField txtFieldPreco;
    
    private final ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
    private Procedimento procedimento;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setProcedimento(Procedimento p){
        this.procedimento = p;
        
        txtAreaDescricao.setText(procedimento.getDescricao());
        txtFieldPreco.setText(procedimento.getPreco() + "");
    }
    
    @FXML
    public void btnCancelarClicked(){
        Stage stage = (Stage) txtFieldPreco.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void btnSalvarClicked(){
        String descricao = txtAreaDescricao.getText();
        try {
        Double preco = Double.parseDouble(txtFieldPreco.getText());
        
        procedimento.setDescricao(descricao);
        procedimento.setPreco(preco);
        
        procedimentoDAO.update(procedimento.getId(), procedimento);
        
        Stage stage = (Stage) txtFieldPreco.getScene().getWindow();
        stage.close();
        } catch (Exception excecao) {           
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação de erro: "+excecao);
            alert.setHeaderText("Dados errados");
            alert.setContentText("Não use '.' ou '-' ou ','");
            alert.initOwner(txtFieldPreco.getScene().getWindow());
            
            alert.showAndWait();              
        }
        }
    }

