
package model.entidades;


public class Computador extends Equipamento{
    
    private String ip, nome;
    private StatusComputador status;
    private int tempoUsado;
    private String garantia;

    public Computador() {
    }

    public Computador(String ip, String nome, Equipamento equip) {
        this.ip = ip;
        this.nome = nome;
        this.status = StatusComputador.LIVRE;
        this.tempoUsado = 0;
        this.garantia = equip.getGarantia() + " Meses";
    }
    
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusComputador getStatus() {
        return status;
    }

    public void setStatus(StatusComputador status) {
        this.status = status;
    }

    public int getTempoUsado() {
        return tempoUsado;
    }

    public void setTempoUsado(int tempoUsado) {
        this.tempoUsado = tempoUsado;
    }
    
    
}
