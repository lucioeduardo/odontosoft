/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import odontosoft.model.dao.FuncionarioDAO;
import odontosoft.model.database.ConexaoBanco;
import odontosoft.model.domain.Funcionario;

/**
 *
 * @author mikolaja
 */
public class TelaAlterarFuncionarioController implements Initializable{
    private Funcionario funcionario;
    
    @FXML
    private Button btnSalvar,btnCancelar;
    
    @FXML
    private TextField txtFieldNomeFuncionario, txtFieldCpfFuncionario, txtFieldRgFuncionario, txtFieldSalarioFuncionario,
            txtFieldTelefoneFuncionario;
   @FXML
   private CheckBox checkBoxGerente, checkBoxDentista;
   @FXML
   private DatePicker datePickerDataNascFuncionario;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
        txtFieldNomeFuncionario.setText(funcionario.getNome());
        txtFieldCpfFuncionario.setText(funcionario.getCpf());
        txtFieldRgFuncionario.setText(funcionario.getRg());
        txtFieldSalarioFuncionario.setText(String.valueOf(funcionario.getSalario()));
        txtFieldTelefoneFuncionario.setText(funcionario.getTelefone());
        
        datePickerDataNascFuncionario.setValue(funcionario.getDataNascimento().toLocalDate());
        checkBoxGerente.setSelected(funcionario.isGerente());
        checkBoxDentista.setSelected(funcionario.isDentista());
    }
    
    @FXML
    public void btnSalvarClicked(){
        String nome = txtFieldNomeFuncionario.getText();
        String cpf = txtFieldCpfFuncionario.getText();
        String rg = txtFieldRgFuncionario.getText();
        double salario = Double.parseDouble(txtFieldSalarioFuncionario.getText());
        String telefone = txtFieldTelefoneFuncionario.getText();
        Date data = Date.valueOf(datePickerDataNascFuncionario.getValue());
        
        boolean gerente = checkBoxGerente.isSelected();
        boolean dentista = checkBoxDentista.isSelected();
        
        Funcionario f = new Funcionario(0, nome, cpf, rg, telefone, salario, data, gerente, dentista);
        ConexaoBanco conexao = new ConexaoBanco();
        FuncionarioDAO funcionarioDao = new FuncionarioDAO(conexao);
        
        funcionarioDao.update(funcionario.getId(), f);
        
        Stage stage = (Stage)btnSalvar.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void btnCancelarClicked(){
        Stage stage = (Stage)btnCancelar.getScene().getWindow();
        stage.close();
    }
    
}
