package service;

import java.io.Serializable;
import model.entidades.Estacao;
import model.entidades.Usuario;

public class ConnectionService implements Serializable {

    private Estacao estacao;
    private Usuario usr;
    private Action action;
    private String msg;

    public enum Action {
        CONFIG, LOGIN, LOGOUT, BLOCK, UNBLOCK, ERROR;
    }

    public Estacao getEstacao() {
        return estacao;
    }

    public void setEstacao(Estacao estacao) {
        this.estacao = estacao;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Usuario getUsr() {
        return usr;
    }

    public void setUsr(Usuario usr) {
        this.usr = usr;
    }

}
