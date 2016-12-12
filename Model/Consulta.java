/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionario;

import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class Consulta {
    private Funcionario dentista;
    private Cliente paciente;
    private ArrayList<String> procedimentos;
    private double preco;

    public Consulta(Funcionario dentista, Cliente paciente, ArrayList<String> procedimentos, double preco) {
        this.dentista = dentista;
        this.paciente = paciente;
        this.procedimentos = procedimentos;
        this.preco = preco;
    }

    public Funcionario getDentista() {
        return dentista;
    }

    public void setDentista(Funcionario dentista) {
        this.dentista = dentista;
    }

    public Cliente getPaciente() {
        return paciente;
    }

    public void setPaciente(Cliente paciente) {
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
    
    
}
