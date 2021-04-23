
package model.entidades;

import java.util.Date;

public class EstoqueEquipamento {
    private Equipamento equipamento;
    private int qtd;
    private Date dataEntrada;

    public EstoqueEquipamento() {
    }

    public EstoqueEquipamento(Equipamento equipamento, int qtd, Date data) {
        this.equipamento = equipamento;
        this.qtd = qtd;
        this.dataEntrada = data;
    }

    public EstoqueEquipamento(Equipamento e, int qtd) {
       this.equipamento = e;
        this.qtd = qtd;
    }

   

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }


    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    
    
}
