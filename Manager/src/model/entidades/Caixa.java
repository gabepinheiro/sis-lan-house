package model.entidades;

import controller.CaixaController;
import java.util.Date;

public class Caixa {

    private StatusCaixa status = StatusCaixa.FECHADO;
    private float valor;

    public Caixa(float valor, String status) {
        this.status = StatusCaixa.valueOf(status);
        this.valor = valor;
    }

    public Caixa() {
    }
     
    public StatusCaixa getStatus() {
        return status;
    }

    public void setStatus(StatusCaixa status) {
        this.status = status;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

}
