package odontosoft.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import odontosoft.model.dao.ConsultaDAO;
import odontosoft.model.dao.FuncionarioDAO;
import odontosoft.model.dao.PacienteDAO;
import odontosoft.model.database.ConexaoBanco;
import odontosoft.model.domain.Consulta;
import odontosoft.model.domain.Funcionario;
import odontosoft.model.domain.Paciente;

public class TelaAdicionarConsultaController implements Initializable {

    @FXML
    private Button btnSalvar,btnCancelar;
    
    @FXML
    private TextField txtFieldHorarioConsulta;
    
    @FXML
    private ComboBox cmbBoxDentista, cmbBoxPaciente;
    private final PacienteDAO pacienteDao = new PacienteDAO(new ConexaoBanco());
    private final FuncionarioDAO funcionarioDao = new FuncionarioDAO(new ConexaoBanco());
    private final ConsultaDAO consultaDao = new ConsultaDAO();
    List <Paciente> listaPacientes = pacienteDao.listar();
    List <Funcionario> listaFuncionarios = funcionarioDao.listarDentista();
           
    @FXML
    private DatePicker datePickerDataConsulta;
    
    
    @Override    
    public void initialize(URL url, ResourceBundle rb) {
        completeComboBox();
    }   
    
    public void completeComboBox () {        
        ObservableList<Paciente> listaPaciente = FXCollections.observableArrayList(listaPacientes);        
        cmbBoxPaciente.setItems(listaPaciente);   
                
        ObservableList <Funcionario> listaDentista = FXCollections.observableArrayList(listaFuncionarios);        
        cmbBoxDentista.setItems(listaDentista);           
    }
    
    public void btnSalvarClicked(){
        //Atributos da classe consulta
        
        try {
        Paciente paciente = listaPacientes.get(cmbBoxPaciente.getSelectionModel().getSelectedIndex());
        Funcionario dentista = listaFuncionarios.get(cmbBoxDentista.getSelectionModel().getSelectedIndex());
                        
        String[] hora = txtFieldHorarioConsulta.getText().split(":");
        LocalDate d = datePickerDataConsulta.getValue();
        
        Calendar c = new GregorianCalendar(d.getYear(), d.getMonthValue()-1, d.getDayOfMonth(),Integer.parseInt(hora[0]), Integer.parseInt(hora[1]));
        //c = new GregorianCalendar
        Consulta consul = new Consulta (0,paciente.getId(), dentista.getId(), c);        
        consultaDao.inserir(consul);
                       
        Stage stage = (Stage)btnSalvar.getScene().getWindow();
        stage.close();
        } catch (Exception excecao) {            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação de erro: "+excecao);
            alert.setHeaderText("Dados errados");
            alert.setContentText("Não use '.' ou '-' ou ','");
            alert.initOwner(btnCancelar.getScene().getWindow());
            
            alert.showAndWait();            
        }
    }
    
     public void btnCancelarClicked(){
        Stage stage = (Stage)btnCancelar.getScene().getWindow();
        stage.close();
       
    }
    
}
