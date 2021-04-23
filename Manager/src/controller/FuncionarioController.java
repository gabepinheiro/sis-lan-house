package controller;

import dao.FuncionarioDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.entidades.Cargo;
import model.entidades.Funcionario;

public class FuncionarioController {
    
    private String cpf, nome, sobrenome, email, telefone, celular, cargo, cep, logradouro, numero, complemento, bairro, cidade, estado;
    private float salario;
    private Date dataAdmissao;
    
    public FuncionarioController() {
    }
    
    public FuncionarioController(String cpf, String nome, String sobrenome, Date dataAdmissao, String email, String telefone, String celular, String cargo, String cep, String logradouro, String numero, String complemento, String bairro, String cidade, String estado, float salario) {
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.dataAdmissao = dataAdmissao;
        this.telefone = telefone;
        this.celular = celular;
        this.cargo = cargo;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.salario = salario;
    }
    
    public boolean salvar() {
        boolean flag = false;
        Funcionario c = new Funcionario(cpf, nome, sobrenome, email, cep, logradouro, numero, cidade, complemento, bairro, estado, telefone, celular, dataAdmissao, new Cargo(cargo), salario);
        if (new FuncionarioDAO(c).inserir()) {
            flag = true;
        }        
        
        return flag;
    }
    
    public boolean editar() {
        boolean flag = false;
        if (validate()) {
            Funcionario c = new Funcionario(cpf, nome, sobrenome, email, cep, logradouro, numero, cidade, complemento, bairro, estado, telefone, celular, dataAdmissao, new Cargo(cargo), salario);
            if (new FuncionarioDAO(c).editar()) {
                flag = true;
            }
        }
        return flag;
    }
    
    public boolean validate() {
        return logradouro.length() > 5 && numero.length() > 0 && bairro.length() > 1 && telefone.length() == 14 && celular.length() == 15;        
    }
    
    public List<Funcionario> listar() {
        List<Funcionario> funcionarios;
        funcionarios = (ArrayList) new FuncionarioDAO().listar();
        return funcionarios;
    }

    public List<Funcionario> filtrar(String filtro) {
        List<Funcionario> funcionarios;
        funcionarios = (ArrayList) new FuncionarioDAO().filtrar(filtro);
        return funcionarios;
    }
    public void desativar(String cnpj) {
       new FuncionarioDAO().desativar(cnpj);
    }

    public void reativar(String cnpj) {
        new FuncionarioDAO().reativar(cnpj);
    }
    public Funcionario puxar(String cpf){
        return new FuncionarioDAO().findByCpf(cpf);
    }

}
