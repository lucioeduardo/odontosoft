/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import odontosoft.model.dao.PacienteDAO;
import odontosoft.model.database.ConexaoBanco;
import odontosoft.model.domain.Paciente;

/**
 * FXML Controller class
 *
 * @author eduardo
 */
public class TelaAdicionarPacienteController implements Initializable {

    @FXML
    private Button btnSalvar,btnCancelar;
    @FXML
    private TextField txtFieldNomePaciente,txtFieldTelefonePaciente
            ,txtFieldCpfPaciente;
    @FXML
    private DatePicker datePickerDataNascPaciente;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void btnSalvarClicked(){
        //Atributos da classe cliente
        String nome = txtFieldNomePaciente.getText();
        Date dataNasc = Date.valueOf(datePickerDataNascPaciente.getValue());
        String cpf = txtFieldCpfPaciente.getText();
        String telefone = txtFieldTelefonePaciente.getText();
        
        System.out.println("chegou aqui!");
        
        Paciente p = new Paciente(0, nome, dataNasc, cpf, telefone);
        
        PacienteDAO pacienteDao = new PacienteDAO(new ConexaoBanco());
        pacienteDao.inserir(p);
        
        System.out.println("chegou aqui!");
        
        Stage stage = (Stage)btnSalvar.getScene().getWindow();
        stage.close();
    }
    
    public void btnCancelarClicked(){
        Stage stage = (Stage)btnCancelar.getScene().getWindow();
        stage.close();
    }
    
}
