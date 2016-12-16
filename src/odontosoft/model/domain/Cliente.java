/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.model.domain;

import java.util.*;


public class Cliente {
    private String nome,cpf,telefone;
    private int idade;
    private Endereco end;
    
    public Cliente () {
        
    }
    
    public Cliente (String nome, int idade, String cpf, Endereco end, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.end = end;
        this.telefone = telefone;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    public Endereco getEnd() {
        return end;
    }
    
    public void setEnd(Endereco end) {
        this.end = end;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
