
package model.entidades;

import java.util.Date;


public class Equipamento {
    private String descricao;
    private Fornecedor fornecedor;
    private int garantia;
    private float valor;
    private Date dataFabricacao;
    private TipoEquipamento tipo;

    public Equipamento() {
    }

    public Equipamento(String descricao, int garantia, Date dataFabricacao, Fornecedor fornecedor, float valor, TipoEquipamento tipo) {
        this.descricao = descricao;
        this.garantia = garantia;
        this.dataFabricacao = dataFabricacao;
        this.fornecedor = fornecedor;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public TipoEquipamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEquipamento tipo) {
        this.tipo = tipo;
    }

   
}
