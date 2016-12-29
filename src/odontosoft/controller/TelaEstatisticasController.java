/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.controller;

import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import odontosoft.model.dao.ConsultaDAO;
import odontosoft.model.dao.Consulta_has_ProcedimentoDAO;

/**
 * FXML Controller class
 *
 * @author eduardo
 */
public class TelaEstatisticasController implements Initializable {

    @FXML
    private LineChart<String,Integer> lineChartConsultasMeses;
    @FXML
    private LineChart<String,Double>lineChartFaturamentoMeses;
    @FXML
    private BarChart<String,Integer> barChartConsultasSemana;
    @FXML
    private CategoryAxis xAxisConsultaMeses,xAxisConsultaSemana,xAxisFaturamentoMeses;
    
    private final ConsultaDAO consultaDao = new ConsultaDAO();
    private final Consulta_has_ProcedimentoDAO consProcDao = new Consulta_has_ProcedimentoDAO();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarGraficoConsultaMeses();
        carregarGraficoConsultaSemana();
        carregarGraficoFaturamentoMes();
    }    
    
    public void carregarGraficoConsultaMeses(){
        String[] meses = DateFormatSymbols.getInstance(new Locale("pt", "BR")).getMonths();
        Integer[] qtdPorMes = consultaDao.numeroDeConsultasPorMeses();
        
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        
        for(int i=0; i<12;i++){
            series.getData().add(new XYChart.Data<>(meses[i],qtdPorMes[i]));
        }
        
        lineChartConsultasMeses.getData().add(series);
    }
    
    public void carregarGraficoConsultaSemana(){
        String[] dias = DateFormatSymbols.getInstance(new Locale("pt", "BR")).getWeekdays();
        Integer[] qtdPorDia = consultaDao.numeroDeConsultasPorDiaDaSemana();
        
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        
        for(int i=0; i<7;i++){
            series.getData().add(new XYChart.Data<>(dias[i],qtdPorDia[i]));
        }
        
        barChartConsultasSemana.getData().add(series);
    }
    
    public void carregarGraficoFaturamentoMes(){
        String[] meses = DateFormatSymbols.getInstance(new Locale("pt", "BR")).getMonths();
        Double[] qtdPorMes = consProcDao.faturamentoPorMes();
        
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        
        for(int i=0; i<12;i++){
            series.getData().add(new XYChart.Data<>(meses[i],qtdPorMes[i]));
        }
        
        lineChartFaturamentoMeses.getData().add(series);
    }
}
