
package controller;

import dao.ClienteDAO;
import dao.FornecedorDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.entidades.Cliente;

public class ClienteController {
    
    private String cpf, nome, sobrenome, email, telefone, celular;
    private char genero;

    public ClienteController() {
    }

    public ClienteController(String cpf, String nome, String sobrenome, String email, String telefone, String celular, char genero) {
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.genero = genero;
    }
    public boolean salvar(){
        boolean flag = false;
        if (validate()){
            Cliente c = new Cliente(cpf, nome, sobrenome, genero, email, telefone, celular);
            if( new ClienteDAO(c).inserir())flag=true;
        }else{
            JOptionPane.showMessageDialog(null, "Digite todos os campos corretamente!\nVerifique se o email tem '@'");
        }
       return flag;
    }
    
    public boolean editar(){
        boolean flag = false;
        if (validate()){
            Cliente c = new Cliente(cpf, nome, sobrenome, genero, email, telefone, celular);
            if( new ClienteDAO(c).editar())flag=true;
        }else{
            JOptionPane.showMessageDialog(null, "Digite todos os campos corretamente!\nVerifique se o email tem '@'");
        }
       return flag;
    }
    
    public Cliente puxar(String cpf){
         Cliente c = new ClienteDAO().findByCpf(cpf);
        this.cpf = cpf;
        this.nome = c.getNome();
        this.sobrenome = c.getSobrenome();
        this.email = c.getEmail();
        this.telefone = c.getTelefone();
        this.celular = c.getCelular();
        this.genero = c.getGenero().charAt(0) ;
        return new Cliente(cpf, nome, sobrenome, genero, email, telefone, celular);
    }
    
    public List<Cliente> listar() {
       List<Cliente> clientes;
       clientes = (ArrayList) new ClienteDAO().listar();
        return clientes;
    }
    
    public boolean validate(){
        return nome.length() > 1 && sobrenome.length() > 2 && email.length() > 10 && email.contains("@") && telefone.length() == 14 && celular.length() == 15;
    }

    public List<Cliente> filtrar(String filtro) {
       List<Cliente> clientes;
       clientes = (ArrayList) new ClienteDAO().filtrar(filtro);
        return clientes;
    }

    public void desativar(String cpf) {
       new ClienteDAO().desativar(cpf);
    }

    public void reativar(String cpf) {
      new ClienteDAO().reativar(cpf);
    }
    
}
