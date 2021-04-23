package controller;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.UsuarioDAO;
import javax.swing.JOptionPane;
import model.entidades.Cliente;
import model.entidades.Funcionario;
import model.entidades.Usuario;
import model.entidades.UsuarioFuncionario;

public class UsuarioController {

    private String login, senha, confirm;
    boolean editar = false;
    private String antigo;
    public UsuarioController() {
    }

    

    public boolean cadastrar(String login, String senha, String confirm, Cliente c){
        this.login = login;
        this.senha = senha;
        this.confirm = confirm;
        boolean flag = false;
        if(validate()){
           Usuario user = new Usuario(login, senha, c);
           if(new UsuarioDAO(user).cadastrar()) flag = true;
        }else{
            JOptionPane.showMessageDialog(null, "Insira os valores corretamente: Campo login deve ser maior que 3 carac. \nSenha deve ser maior que 5 carac. e coincidir com a confirmação!\n", "Erro de inserção", JOptionPane.ERROR_MESSAGE);
            flag = false;
        }
        return flag;
    }
     public boolean cadastrarADM(String login, String senha, String confirm, Funcionario c){
        this.login = login;
        this.senha = senha;
        this.confirm = confirm;
        boolean flag = false;
        if(validate()){
            UsuarioFuncionario user = new UsuarioFuncionario(login, senha, c);
           if(new UsuarioDAO(user).cadastrarADM()) flag = true;
        }else{
            JOptionPane.showMessageDialog(null, "Insira os valores corretamente: Campo login deve ser maior que 3 carac. \nSenha deve ser maior que 5 carac. e coincidir com a confirmação!\n", "Erro de inserção", JOptionPane.ERROR_MESSAGE);
            flag = false;
        }
        return flag;
    }
    
    public boolean validate(){
        return login.length() > 3 && senha.length() > 5 && senha.equalsIgnoreCase(confirm);
    }

    public boolean validarAdm(String login, String senha) {
      return new UsuarioDAO().validarADM(login, senha);
    }

    public boolean clienteIsRegistered(String cpf) {
        int id = new ClienteDAO().getID(cpf);
        return new UsuarioDAO().clienteIsRegistered(id);
    }

    public Usuario findByCliente(String cpf) {
        int id = new ClienteDAO().getID(cpf);
        return new UsuarioDAO().getByCliente(id);
    }

    public UsuarioFuncionario findByFunc(String cpf) {
        int id = new FuncionarioDAO().getID(cpf);
        return new UsuarioDAO().getByFunc(id);
    }

    public boolean funcIsRegistered(String cpf) {
        int id = new FuncionarioDAO().getID(cpf);
        return new UsuarioDAO().funcISRegistered(id);
    }

    public Usuario puxar(String login) {
        return new UsuarioDAO().puxar(login);
    }

    public UsuarioFuncionario puxarFuncionario(String login) {
        return new UsuarioDAO().puxarFuncionario(login);
    }

    public boolean editar(String login, String senha, String confirm, Cliente c, String antigo) {
        this.antigo = antigo;
        this.login = login;
        this.senha = senha;
        this.confirm = confirm;
        if(validate()) return new UsuarioDAO(new Usuario(login, senha, c)).editar(antigo);
        else{
            JOptionPane.showMessageDialog(null, "Insira os valores corretamente: Campo login deve ser maior que 3 carac. \nSenha deve ser maior que 5 carac. e coincidir com a confirmação!\n", "Erro de inserção", JOptionPane.ERROR_MESSAGE);
            return false;
        }
       
    }
     public boolean editarADM(String login, String senha, String confirm, Funcionario c, String antigo) {
        this.antigo = antigo;
        this.login = login;
        this.senha = senha;
        this.confirm = confirm;
        if(validate()) return new UsuarioDAO(new UsuarioFuncionario(login, senha, c)).editarADM(antigo);
         else{
            JOptionPane.showMessageDialog(null, "Insira os valores corretamente: Campo login deve ser maior que 3 carac. \nSenha deve ser maior que 5 carac. e coincidir com a confirmação!\n", "Erro de inserção", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
