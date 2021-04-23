/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;


public class BancoDeHoras {
    
    private int usuarioID;
    private int hora;
    private int minuto;
    private int segundo;

    public BancoDeHoras(int usuarioID, int hora, int minuto, int segundo) {
        this.usuarioID = usuarioID;
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public BancoDeHoras() {
    }
      

    /**
     * @return the usuarioID
     */
    public int getUsuarioID() {
        return usuarioID;
    }

    /**
     * @param usuarioID the usuarioID to set
     */
    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    /**
     * @return the hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * @return the minuto
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * @param minuto the minuto to set
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    /**
     * @return the segundo
     */
    public int getSegundo() {
        return segundo;
    }

    /**
     * @param segundo the segundo to set
     */
    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }
    
    public int getTempo(){
        return this.hora + this.minuto + this.segundo;
    }
    
}
