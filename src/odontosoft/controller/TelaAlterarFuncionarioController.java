/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import odontosoft.model.domain.Funcionario;

/**
 *
 * @author mikolaja
 */
public class TelaAlterarFuncionarioController implements Initializable{
    private Funcionario funcionario;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }
    
}
