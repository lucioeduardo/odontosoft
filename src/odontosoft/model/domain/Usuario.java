package odontosoft.model.domain;

public class Usuario {
    private String id,senha;

    public Usuario(String id, String senha) {
        this.id = id;
        this.senha = senha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}