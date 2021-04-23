
package model.entidades;

import java.util.ArrayList;
import java.util.Date;

public class Venda {
    private Date data;
    private ArrayList<Servico> servicos;
    private float valorTotal;
    private Cliente cliente;

    public Venda() {
    }

    public Venda(Date data, ArrayList<Servico> servicos, float valorTotal, Cliente cliente) {
        this.data = data;
        this.servicos = servicos;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
