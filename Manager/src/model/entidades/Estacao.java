package model.entidades;

import java.io.Serializable;

public class Estacao implements Serializable {

    private String ip;
    private Status status;
    private String descricao;
    private int Hour;
    private int Minute;
    private int second;

    public enum Status {
        LIVRE, OCUPADO, MANUTENCAO;

    }

    public Estacao() {
    }

    public Estacao(int hora, int minuto, int segundo) {
        this.Hour = hora;
        this.Minute = minuto;
        this.second = segundo;
    }

    public Estacao(String ip) {
        this.ip = ip;

    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the Hour
     */
    public int getHour() {
        return Hour;
    }

    /**
     * @param Hour the Hour to set
     */
    public void setHour(int Hour) {
        this.Hour = Hour;
    }

    /**
     * @return the Minute
     */
    public int getMinute() {
        return Minute;
    }

    /**
     * @param Minute the Minute to set
     */
    public void setMinute(int Minute) {
        this.Minute = Minute;
    }

    /**
     * @return the second
     */
    public int getSecond() {
        return second;
    }

    /**
     * @param second the second to set
     */
    public void setSecond(int second) {
        this.second = second;
    }

}
