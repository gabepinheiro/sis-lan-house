package model.entidades;

import java.util.Date;

public class EquipamentoEmManutencao {

    private Equipamento equipamento;
    private Date dataEntrada;
    private int qtd;
    private String defeito;

    public EquipamentoEmManutencao() {
    }

    public EquipamentoEmManutencao(Equipamento equipamento, Date dataEntrada, int qtd, String defeito) {
        this.equipamento = equipamento;
        this.dataEntrada = dataEntrada;
        this.qtd = qtd;
        this.defeito = defeito;
    }

    public EquipamentoEmManutencao(Equipamento ee, int qtd, String defeito) {
        this.equipamento = ee;
        this.qtd = qtd;
        this.defeito = defeito;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

}
