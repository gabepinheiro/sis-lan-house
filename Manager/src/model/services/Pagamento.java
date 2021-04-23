
package model.services;

import dao.PagamentoDAO;
import model.entidades.Caixa;

public class Pagamento {
    private float total, valorPago, troco, lucro;
    private Atividade atividade;
    private Caixa caixa;

    public Pagamento() {
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    public float getTroco() {
        return troco;
    }

    public void setTroco(float troco) {
        this.troco = troco;
    }

    public float getLucro() {
        return lucro;
    }

    public void setLucro(float lucro) {
        this.lucro = lucro;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Pagamento(float valorPago, Atividade atividade, Caixa caixa) {
        this.atividade = atividade;
        this.total = atividade.getValor();
        this.valorPago = valorPago;
        this.troco = valorPago - total;
        this.caixa = caixa;
        PagamentoDAO pay = new PagamentoDAO(caixa, valorPago, valorPago, troco);
    }

}
