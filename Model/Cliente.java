import java.util.*;


publiv class    Cliente {
    private String nome,cpf,telefone;
    private int idade;
    private Endereco end;
    
    public Cliente () {
        
    }
    
    public Cliente (String nome, int idade, String cpf, Endereco end, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.rg = rg;
        this.end = end;
        this.telefone = telefone;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getIdade() {
        return idade;
    }
    
    public void setIdade(String idade) {
        this.idade = idade;
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