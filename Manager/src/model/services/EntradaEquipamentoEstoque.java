
package model.services;


import model.entidades.Equipamento;

public class EntradaEquipamentoEstoque {
    private Equipamento equipamento;
    private int quantidade;
    private String dataEntrada;

    public EntradaEquipamentoEstoque() {
    }

    public EntradaEquipamentoEstoque(Equipamento equipamento, int quantidade) {
        this.equipamento = equipamento;
        this.quantidade = quantidade;
        
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    
    
}
