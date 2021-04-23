
package controller;

import dao.FornecedorDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.entidades.Fornecedor;

public class FornecedorController {
    
        private String cnpj, nome, razaoSocial, cep, logradouro, numero, complemento, bairro, cidade, estado, email, telefone, celular;


    public FornecedorController() {
    }

    public FornecedorController(String cnpj, String nome, String razaoSocial, String cep, String logradouro, String numero, String complemento, String bairro, String cidade, String estado, String email, String telefone, String celular) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
    }

     public boolean salvar(){
        boolean flag = false;
        if (validate()){
            Fornecedor c = new Fornecedor(cnpj, nome, razaoSocial, cep, logradouro, numero, complemento, bairro, cidade, estado, email, telefone, celular);
            if( new FornecedorDAO(c).inserir())flag=true;
        }else{
            JOptionPane.showMessageDialog(null, "Digite todos os campos corretamente!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
       return flag;
    }
    
    public boolean editar(){
        boolean flag = false;
        if (validate()){
            Fornecedor c = new Fornecedor(cnpj, nome, razaoSocial, cep, logradouro, numero, complemento, bairro, cidade, estado, email, telefone, celular);
            if(new FornecedorDAO(c).editar())flag=true;
        }else{
            JOptionPane.showMessageDialog(null, "Digite todos os campos corretamente!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
       return flag;
    }
    
    public Fornecedor puxar(String cnpj){
         
        return new FornecedorDAO().findByCnpj(cnpj);
    }
    
    public List<Fornecedor> listar() {
       List<Fornecedor> fornecedores;
       fornecedores = (ArrayList) new FornecedorDAO().listar();
        return fornecedores;
    }

    public List<Fornecedor> filtrar(String filtro) {
       List<Fornecedor> fornecedores;
       fornecedores = (ArrayList) new FornecedorDAO().filtrar(filtro);
        return fornecedores;
    }
     public boolean validate(){
        return  logradouro.length() > 5 && numero.length() > 0 && bairro.length() > 1  && telefone.length() == 14 && celular.length() == 15; 
    }

    public void desativar(String cnpj) {
       new FornecedorDAO().desativar(cnpj);
    }

    public void reativar(String cnpj) {
        new FornecedorDAO().reativar(cnpj);
    }
  
}
