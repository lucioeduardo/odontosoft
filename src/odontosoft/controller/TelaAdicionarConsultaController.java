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
    private final PacienteDAO pa = new PacienteDAO(new ConexaoBanco());
    private final FuncionarioDAO fa = new FuncionarioDAO(new ConexaoBanco());
    private final ConsultaDAO cons = new ConsultaDAO();
    List <Paciente> listaPacientes = pa.listar();
    List <Funcionario> listaFuncionarios = fa.listarDentista();
           
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
        Paciente paciente = listaPacientes.get(cmbBoxPaciente.getSelectionModel().getSelectedIndex());
        Funcionario dentista = listaFuncionarios.get(cmbBoxDentista.getSelectionModel().getSelectedIndex());
                        
        String[] hora = txtFieldHorarioConsulta.getText().split(":");
        LocalDate d = datePickerDataConsulta.getValue();
        
        System.out.println(d.getYear() + "/" + d.getMonthValue() + "/" + d.getDayOfMonth());
        Calendar c = new GregorianCalendar(d.getYear(), d.getMonthValue()-1, d.getDayOfMonth(),Integer.parseInt(hora[0]), Integer.parseInt(hora[1]));
        System.out.println(c.get(Calendar.YEAR) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.YEAR));
        //c = new GregorianCalendar
        Consulta consul = new Consulta (0,paciente.getId(), dentista.getId(), c);        
        cons.inserir(consul);
                       
        Stage stage = (Stage)btnSalvar.getScene().getWindow();
        stage.close();
    }
    
     public void btnCancelarClicked(){
        Stage stage = (Stage)btnCancelar.getScene().getWindow();
        stage.close();
       
    }
    
}
