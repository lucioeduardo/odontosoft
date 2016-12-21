package odontosoft.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import odontosoft.model.dao.PacienteDAO;
import odontosoft.model.database.ConexaoBanco;
import odontosoft.model.domain.Paciente;


public class TelaAlterarPacienteController implements Initializable {

    private Paciente paciente;    
    
    @FXML
    private Button btnSalvar,btnCancelar;
    @FXML
    private TextField txtFieldNomePaciente,txtFieldTelefonePaciente
            ,txtFieldCpfPaciente;
    @FXML
    private DatePicker datePickerDataNascPaciente;
    
    PacienteDAO pacienteDao = new PacienteDAO(new ConexaoBanco());
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        txtFieldNomePaciente.setText(paciente.getNome());
        txtFieldTelefonePaciente.setText(paciente.getTelefone());
        txtFieldCpfPaciente.setText(paciente.getCpf());
        datePickerDataNascPaciente.setValue(paciente.getData().toLocalDate());
        
    }
    
    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }
    public Paciente getPaciente(){
        return paciente;
    }
    
    public void btnSalvarClicked(){
        
        //Atributos da classe cliente
        String nome = txtFieldNomePaciente.getText();
        Date dataNasc = Date.valueOf(datePickerDataNascPaciente.getValue());
        String cpf = txtFieldCpfPaciente.getText();
        String telefone = txtFieldTelefonePaciente.getText();
        
        System.out.println("chegou aqui!");
        
        Paciente p = new Paciente(0, nome, dataNasc, cpf, telefone);
        
        pacienteDao.update(paciente.getId(), p);
        
        System.out.println("chegou aqui!");
        
        Stage stage = (Stage)btnSalvar.getScene().getWindow();
        stage.close();
    }
    
    public void btnCancelarClicked(){
        Stage stage = (Stage)btnCancelar.getScene().getWindow();
        stage.close();
    }
    
}
