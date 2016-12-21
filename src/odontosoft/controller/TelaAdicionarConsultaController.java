package odontosoft.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import odontosoft.model.dao.PacienteDAO;
import odontosoft.model.database.ConexaoBanco;
import odontosoft.model.domain.Paciente;

public class TelaAdicionarConsultaController implements Initializable {

    @FXML
    private Button btnSalvar,btnCancelar;
    
    @FXML
    private TextField txtFieldHorarioConsulta;
    
    @FXML
    private ComboBox cmbBoxDentista, cmbBoxPaciente;
    private final PacienteDAO pa = new PacienteDAO(new ConexaoBanco());
    
    @FXML
    private DatePicker datePickerDataConsulta;
    
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        completeComboBox();
    }   
    
    public void completeComboBox () {
        List <Paciente> lista = pa.listar();
        ObservableList<Paciente> listaPaciente = FXCollections.observableArrayList(lista);
        System.out.println(listaPaciente.size() + " x  " + lista.size());
        cmbBoxPaciente.setItems(listaPaciente);
       
        
    }
    
    public void btnSalvarClicked(){
        //Atributos da classe cliente
        
        /* Date dataNasc = Date.valueOf(datePickerDataNascPaciente.getValue());
        String cpf = txtFieldCpfPaciente.getText();
        String telefone = txtFieldTelefonePaciente.getText();
        
        System.out.println("chegou aqui!");
        
        Consulta p = new Paciente(0, , dataNasc, cpf, telefone);
        
        PacienteDAO pacienteDao = new PacienteDAO(new ConexaoBanco());
        pacienteDao.inserir(p);
        
        System.out.println("chegou aqui!");
                */
        
        Stage stage = (Stage)btnSalvar.getScene().getWindow();
        stage.close();
    }
    
     public void btnCancelarClicked(){
        Stage stage = (Stage)btnCancelar.getScene().getWindow();
        stage.close();
       
    }
    
}
