
package model.entidades;

public class Servico {
    private String servico;
    private float valor;
    
    public Servico() {
    }
    
    public Servico(String servico, float valor) {
        this.servico = servico;
        this.valor = valor;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
}
