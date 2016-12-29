/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import odontosoft.model.dao.ProcedimentoDAO;
import odontosoft.model.domain.Procedimento;

/**
 * FXML Controller class
 *
 * @author eduardo
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
        Double preco = Double.parseDouble(txtFieldPreco.getText());
        
        procedimento.setDescricao(descricao);
        procedimento.setPreco(preco);
        
        procedimentoDAO.update(procedimento.getId(), procedimento);
        
        Stage stage = (Stage) txtFieldPreco.getScene().getWindow();
        stage.close();
    }
}
