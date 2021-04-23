
package model.entidades;


public class UsuarioFuncionario {
     private String login, senha;
    private Funcionario f;

    public UsuarioFuncionario() {
    }

    public UsuarioFuncionario(String login, String senha, Funcionario f) {
        this.login = login;
        this.senha = senha;
        this.f = f;
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

    public Funcionario getF() {
        return f;
    }

    public void setF(Funcionario f) {
        this.f = f;
    }

    
}
