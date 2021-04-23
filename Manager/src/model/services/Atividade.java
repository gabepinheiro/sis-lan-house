
package model.services;

import java.util.ArrayList;
import java.util.List;
import model.entidades.Cliente;
import model.entidades.Funcionario;
import model.entidades.Servico;

public class Atividade {
    private String data, hora;
    private float valor;
    private StatusAtividade status;
    private Cliente cliente;
    private Funcionario funcionario;
    private List<Servico> servicos = new ArrayList<>();

    public Atividade() {
    }

    public Atividade(String data, String hora, StatusAtividade status, Cliente cliente, Funcionario funcionario, List<Servico> servicos) {
        this.data = data;
        this.hora = hora;
        this.status = status;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.servicos = servicos;
        for(Servico s : servicos) valor += s.getValor();
    }

//getset
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public StatusAtividade getStatus() {
        return status;
    }

    public void setStatus(StatusAtividade status) {
        this.status = status;
    }
    
    
}
