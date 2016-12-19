/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.model.domain;

import java.sql.Date;

/**
 *
 * @author Aluno
 */
public class Funcionario {
    private String nome,cpf,rg,telefone;
    private Date dataNascimento;
    private boolean Gerente;
    private int id;
    private double salario;

    public Funcionario(int id, String nome, String cpf, String rg, String telefone, double salario, Date dataNascimento, boolean Gerente) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.id = id;
        this.salario = salario;
        this.dataNascimento = dataNascimento;
        this.Gerente = Gerente;
    }

    public boolean isGerente() {
        return Gerente;
    }

    public void setIsGerente(boolean isGerente) {
        this.Gerente = isGerente;
    }
        
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }            
}
