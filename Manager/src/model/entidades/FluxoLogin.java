
package model.entidades;

import java.util.Date;

public class FluxoLogin {
    private String user;
    private Date data_hora;
    private TipoAcaoLogin acao;

    public FluxoLogin() {
    }

    public FluxoLogin(String user, Date data_hora, TipoAcaoLogin acao) {
        this.user = user;
        this.data_hora = data_hora;
        this.acao = acao;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

    public TipoAcaoLogin getAcao() {
        return acao;
    }

    public void setAcao(TipoAcaoLogin acao) {
        this.acao = acao;
    }
   
    
   
}
