
package model.services;

import model.entidades.Computador;
import model.entidades.Usuario;

public class Aluguel {
    private Computador computador;
    private int tempo;
    private Usuario user;
    
    public Aluguel() {
    }

    public Aluguel(Computador computador, int tempo, Usuario user) {
        this.computador = computador;
        this.tempo = tempo;
        this.user = user;
    }

    public Computador getComputador() {
        return computador;
    }

    public void setComputador(Computador computador) {
        this.computador = computador;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
  
}
