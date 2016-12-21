package odontosoft.model.domain;

import java.sql.Date;

public class Paciente {
    private String nome,cpf,telefone;
    private Date data;
    private int id;
    
    public Paciente () {
        
    }
    
    public Paciente (int id, String nome, Date data, String cpf, String telefone) {
        this.nome = nome;
        this.id = id;
        this.data = data;
        this.cpf = cpf;
        this.telefone = telefone;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }  

    @Override
    public String toString() {
        return nome;
    }

 
}
