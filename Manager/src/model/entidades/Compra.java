
package model.entidades;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    
    private String data, dataVencimentoBoleto;
    private float valorTotal;
    private List<Fornecedor> fornecedores = new ArrayList<>();
    private StatusCompra status = StatusCompra.PENDENTE;
    
    public Compra() {
    }

    public Compra(String data, String dataVencimentoBoleto, float valorTotal) {
        this.data = data;
        this.dataVencimentoBoleto = dataVencimentoBoleto;
        this.valorTotal = valorTotal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataVencimentoBoleto() {
        return dataVencimentoBoleto;
    }

    public void setDataVencimentoBoleto(String dataVencimentoBoleto) {
        this.dataVencimentoBoleto = dataVencimentoBoleto;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public StatusCompra getStatus() {
        return status;
    }

    public void setStatus(StatusCompra status) {
        this.status = status;
    }
    
    
    
}
