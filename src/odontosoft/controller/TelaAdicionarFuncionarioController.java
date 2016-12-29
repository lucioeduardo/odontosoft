package odontosoft.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import odontosoft.model.dao.FuncionarioDAO;
import odontosoft.model.dao.UsuarioDAO;
import odontosoft.model.database.ConexaoBanco;
import odontosoft.model.domain.Funcionario;
import odontosoft.model.domain.Usuario;

public class TelaAdicionarFuncionarioController implements Initializable{
    
    @FXML
    private Button btnSalvar,btnCancelar;
    @FXML
    private TextField txtFieldNomeFuncionario,txtFieldTelefoneFuncionario
            ,txtFieldCpfFuncionario, txtFieldRgFuncionario, txtFieldSalarioFuncionario, txtFieldUsuarioFuncionario,
            txtFieldSenhaFuncionario;
    
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
        try {
            double salario = Double.parseDouble(txtFieldSalarioFuncionario.getText());
                     
        boolean gerente = checkBoxGerente.isSelected();
        boolean dentista = checkBoxDentista.isSelected();
        
        ConexaoBanco conexao = new ConexaoBanco();       
        Funcionario f  = new Funcionario(0, nome, cpf, rg, telefone, salario, dataNasc, gerente, dentista);                        
        FuncionarioDAO FuncionarioDao = new FuncionarioDAO(conexao);        
        FuncionarioDao.inserir(f);
                    
        Usuario u = new Usuario(txtFieldUsuarioFuncionario.getText(), txtFieldSenhaFuncionario.getText(), FuncionarioDao.getId());        
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao.getConexao());        
        usuarioDao.inserir(u);
            
            Stage stage = (Stage)btnSalvar.getScene().getWindow();
            stage.close();
        } catch (Exception excecao) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Informação de erro: "+excecao);
            alert.setHeaderText("Dados errados");
            alert.setContentText("Não use '.' ou '-' ou ','");
            
            alert.showAndWait();
        }
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
