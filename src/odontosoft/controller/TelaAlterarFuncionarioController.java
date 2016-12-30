package odontosoft.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import odontosoft.model.dao.FuncionarioDAO;
import odontosoft.model.dao.UsuarioDAO;
import odontosoft.model.database.ConexaoBanco;
import odontosoft.model.domain.Funcionario;
import odontosoft.model.domain.Usuario;

/**
 *
 */
public class TelaAlterarFuncionarioController implements Initializable{
    private Funcionario funcionario;
    
    @FXML
    private Button btnSalvar,btnCancelar;
    
    @FXML
    private TextField txtFieldNomeFuncionario, txtFieldCpfFuncionario, txtFieldRgFuncionario, txtFieldSalarioFuncionario,
            txtFieldTelefoneFuncionario, txtFieldUsuarioFuncionario, txtFieldSenhaFuncionario;
   @FXML
   private CheckBox checkBoxGerente, checkBoxDentista;
   @FXML
   private DatePicker datePickerDataNascFuncionario;
   
   ConexaoBanco conexao = new ConexaoBanco();
   private UsuarioDAO usuarioDao = new UsuarioDAO(conexao.getConexao());
   private Usuario usuario;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
        usuario = usuarioDao.buscaPorIdInt(funcionario.getId());
        txtFieldNomeFuncionario.setText(funcionario.getNome());
        txtFieldCpfFuncionario.setText(funcionario.getCpf());
        txtFieldRgFuncionario.setText(funcionario.getRg());
        txtFieldSalarioFuncionario.setText(String.valueOf(funcionario.getSalario()));
        txtFieldTelefoneFuncionario.setText(funcionario.getTelefone());
        txtFieldUsuarioFuncionario.setText(usuario.getId());
        txtFieldSenhaFuncionario.setText(usuario.getSenha());
        
        datePickerDataNascFuncionario.setValue(funcionario.getDataNascimento().toLocalDate());
        checkBoxGerente.setSelected(funcionario.isGerente());
        checkBoxDentista.setSelected(funcionario.isDentista());
    }
    
    @FXML
    public void btnSalvarClicked(){
        String nome = txtFieldNomeFuncionario.getText();
        String cpf = txtFieldCpfFuncionario.getText();
        String rg = txtFieldRgFuncionario.getText();
        try {
        double salario = Double.parseDouble(txtFieldSalarioFuncionario.getText());
        String telefone = txtFieldTelefoneFuncionario.getText();
        Date data = Date.valueOf(datePickerDataNascFuncionario.getValue());
        usuario.setSenha(txtFieldSenhaFuncionario.getText());
        
        boolean gerente = checkBoxGerente.isSelected();
        boolean dentista = checkBoxDentista.isSelected();
        
        Funcionario f = new Funcionario(0, nome, cpf, rg, telefone, salario, data, gerente, dentista);
        FuncionarioDAO funcionarioDao = new FuncionarioDAO(conexao);
        funcionarioDao.update(funcionario.getId(), f);
        
        usuarioDao.update(usuario.getId(), usuario);
        
        Stage stage = (Stage)btnSalvar.getScene().getWindow();
        stage.close(); 
        } catch(Exception excecao) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação de erro: "+excecao);
            alert.setHeaderText("Dados errados");
            alert.setContentText("Não use '.' ou '-' ou ','");
            alert.initOwner(btnCancelar.getScene().getWindow());
            
            alert.showAndWait();              
        }
        
    }
    
    @FXML
    public void btnCancelarClicked(){
        Stage stage = (Stage)btnCancelar.getScene().getWindow();
        stage.close();
    }
    
}
