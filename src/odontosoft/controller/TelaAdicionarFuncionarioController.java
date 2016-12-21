package odontosoft.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import odontosoft.model.dao.FuncionarioDAO;
import odontosoft.model.database.ConexaoBanco;
import odontosoft.model.domain.Funcionario;

public class TelaAdicionarFuncionarioController implements Initializable{
    
    @FXML
    private Button btnSalvar,btnCancelar;
    @FXML
    private TextField txtFieldNomeFuncionario,txtFieldTelefoneFuncionario
            ,txtFieldCpfFuncionario, txtFieldRgFuncionario, txtFieldSalarioFuncionario;
    
    @FXML
    private CheckBox checkBoxGerente, checkBoxDentista;            
    @FXML
    private DatePicker datePickerDataNascFuncionario;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void btnSalvarClicked(){
        String nome = txtFieldNomeFuncionario.getText();
        Date dataNasc = Date.valueOf(datePickerDataNascFuncionario.getValue());
        String cpf = txtFieldCpfFuncionario.getText();
        String telefone = txtFieldTelefoneFuncionario.getText();
        String rg = txtFieldRgFuncionario.getText();
        double salario = Double.parseDouble(txtFieldSalarioFuncionario.getText());
        boolean gerente = checkBoxGerente.isSelected();
        boolean dentista = checkBoxDentista.isSelected();
        
        Funcionario f = new Funcionario(0, nome, cpf, rg, telefone, salario, dataNasc, gerente, dentista);
        
        FuncionarioDAO FuncionarioDao = new FuncionarioDAO(new ConexaoBanco());
        FuncionarioDao.inserir(f);
        
        Stage stage = (Stage)btnSalvar.getScene().getWindow();
        stage.close();
    }   
    
    public void btnCancelarClicked(){
        Stage stage = (Stage)btnCancelar.getScene().getWindow();
        stage.close();
    }
    
    public void checkBoxGerenteClicked(){
        
    }
    
    public void checkBoxDentistaClicked(){
        
    }
    
}
