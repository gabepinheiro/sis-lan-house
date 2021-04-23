
package controller;

import dao.CaixaDAO;

import model.entidades.Caixa;


public class CaixaController {

    public CaixaController() {
    }
    public boolean abrirCaixa(float valor, String user) {
       Caixa c = new Caixa();
       return new CaixaDAO(c).abrirCaixa(valor, user);
    }

    public boolean fecharCaixa(String motivo, float retirada, String user) {
        Caixa c = new Caixa();
       return new CaixaDAO(c).fecharCaixa(motivo, retirada, user);
    }
    
    public boolean isAberto(){
        return new CaixaDAO().isAberto();
    }
    
    public float getValorCaixa(){
        return new CaixaDAO().getValorCaixa();
    }
    
    
    
}
