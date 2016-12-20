/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.controller;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;
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
            ,txtFieldCpfPaciente,txtFieldFotoPaciente;
    @FXML
    private DatePicker datePickerDataNascPaciente;
    @FXML
    private ImageView imgViewFileChooserFotoPaciente;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void imgViewFileChooserMouseEntered(){
        Image image = new Image(getClass().getResourceAsStream("/odontosoft/view/img/fileChooserHovered.png"));
        imgViewFileChooserFotoPaciente.setImage(image);
    }
    
    public void imgViewFileChooserMouseExited(){
        Image image = new Image(getClass().getResourceAsStream("/odontosoft/view/img/fileChooserPadrao.png"));
        imgViewFileChooserFotoPaciente.setImage(image);
    }
    
    public void imgViewFileChooserMouseClicked(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );
        Window mainStage = imgViewFileChooserFotoPaciente.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(mainStage);
        txtFieldFotoPaciente.setText(selectedFile.getAbsolutePath());
    }
    
    
    public void btnSalvarClicked(){
        //Atributos da classe cliente
        String nome = txtFieldNomePaciente.getText();
        Date dataNasc = Date.valueOf(datePickerDataNascPaciente.getValue());
        String cpf = txtFieldCpfPaciente.getText();
        String telefone = txtFieldTelefonePaciente.getText();
        String foto = txtFieldFotoPaciente.getText();
        
        System.out.println("chegou aqui!");
        
        Paciente p = new Paciente(0, nome, dataNasc, cpf, telefone, foto);
        
        PacienteDAO pacienteDao = new PacienteDAO(new ConexaoBanco());
        pacienteDao.inserir(p);
        
        System.out.println("chegou aqui!");
        
        Stage stage = (Stage)btnSalvar.getScene().getWindow();
        stage.close();
    }
}
