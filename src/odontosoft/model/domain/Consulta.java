/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.model.domain;

import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class Consulta {
    private Funcionario dentista;
    private Paciente paciente;
    private ArrayList<String> procedimentos;
    private double preco;
    private String data;

    public Consulta(Funcionario dentista, Paciente paciente, ArrayList<String> procedimentos, double preco, String data) {
        this.dentista = dentista;
        this.paciente = paciente;
        this.procedimentos = procedimentos;
        this.preco = preco;
        this.data = data;
    }


    public Funcionario getDentista() {
        return dentista;
    }

    public void setDentista(Funcionario dentista) {
        this.dentista = dentista;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ArrayList<String> getProcedimentos() {
        return procedimentos;
    }

    public void setProcedimentos(ArrayList<String> procedimentos) {
        this.procedimentos = procedimentos;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
}
