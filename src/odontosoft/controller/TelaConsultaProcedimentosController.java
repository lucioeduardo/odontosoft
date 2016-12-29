/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import odontosoft.model.dao.Consulta_has_ProcedimentoDAO;
import odontosoft.model.dao.ProcedimentoDAO;
import odontosoft.model.domain.ConsultaAgenda;
import odontosoft.model.domain.ConsultaProcedimento;
import odontosoft.model.domain.Consulta_has_Procedimento;
import odontosoft.model.domain.Procedimento;

/**
 * FXML Controller class
 *
 * @author eduardo
 */
public class TelaConsultaProcedimentosController implements Initializable {

    @FXML
    private TableView<ConsultaProcedimento> tableViewProcedimentos;
    @FXML
    private TableColumn tableColumnDescricao,tableColumnQuantidade,tableColumnPreco;
    @FXML
    private Label lblPrecoTotal;
    @FXML
    private ComboBox<Procedimento> cmbBoxProcedimento;
    @FXML
    private TextField txtFieldQuantidade;
    @FXML
    private Button btnAdicionar;
    

   
    
    private final ProcedimentoDAO procedimentoDao = new ProcedimentoDAO();
    private final Consulta_has_ProcedimentoDAO consultaProcDao = new Consulta_has_ProcedimentoDAO();
    private ConsultaAgenda consulta;
    private ConsultaProcedimento consProcSelecionado;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        completeComboBox();
        
        tableViewProcedimentos.getSelectionModel().selectedItemProperty().addListener(
        (observable,odlValue,newValue) -> selecionarItemTableViewProcedimentos(newValue));
        
    }
    
    public void selecionarItemTableViewProcedimentos(ConsultaProcedimento procedimento){
        this.consProcSelecionado = procedimento;
    }

    public void btnAdicionarClicked(){
        Procedimento procedimentoSelecionado = cmbBoxProcedimento.getSelectionModel().getSelectedItem();
        int qtd = Integer.parseInt(txtFieldQuantidade.getText());
        
        Consulta_has_Procedimento consultaProc = new Consulta_has_Procedimento(this.consulta.getIdConsulta(), procedimentoSelecionado.getId(), qtd);
        
        consultaProcDao.inserir(consultaProc);
        carregarTableView();
        carregaPrecoTotal();
    }
    
    public void carregarTableView(){
        tableColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricaoProcedimento"));
        tableColumnPreco.setCellValueFactory(new PropertyValueFactory<>("precoProcedimento"));
        tableColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        
        tableViewProcedimentos.setItems(consultaProcDao.buscarProcedimentosPorConsulta(this.consulta.getIdConsulta()));
    }
    
    public void completeComboBox () {        
        ObservableList<Procedimento> listaProcedimentos = FXCollections.observableArrayList(procedimentoDao.listar());        
        cmbBoxProcedimento.setItems(listaProcedimentos);             
    }
    
    public ConsultaAgenda getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaAgenda consulta) {
        this.consulta = consulta;
        carregarTableView();
        carregaPrecoTotal();
    }
    
    public void carregaPrecoTotal(){
        double preco = consultaProcDao.calcularPrecoTotalConsulta(this.consulta.getIdConsulta());
        
        String precoFormatado = String.format("R$ %,.2f", preco);
        lblPrecoTotal.setText(precoFormatado);
    }
    
    public void btnRemoverClicked(){
        consultaProcDao.delete(consulta.getIdConsulta()+" "+consProcSelecionado.getIdProcedimento());
        carregarTableView();
        carregaPrecoTotal();
    }
    
    public void btnSalvarClicked(){
        Stage stage = (Stage) tableViewProcedimentos.getScene().getWindow();
        stage.close();
    }
    
}
