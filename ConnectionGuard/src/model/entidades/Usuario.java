package model.entidades;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String login, senha;

    private Cliente c;

    public Usuario() {
    }

    public Usuario(String login, String senha, Cliente c) {
        this.login = login;
        this.senha = senha;
        this.c = c;
    }
  

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

   

    
    
    
}
