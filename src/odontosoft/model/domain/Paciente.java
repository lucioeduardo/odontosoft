package odontosoft.model.domain;

public class Paciente {
    private String nome,cpf,telefone, data, foto;
    private int id;
    
    public Paciente () {
        
    }
    
    public Paciente (int id, String nome, String data, String cpf, String telefone, String foto) {
        this.nome = nome;
        this.id = id;
        this.data = data;
        this.cpf = cpf;
        this.telefone = telefone;
        this.foto = foto;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
    
}
