
package controller;

import dao.TipoEquipamentoDAO;
import java.util.List;
import model.entidades.TipoEquipamento;

public class TipoEquipamentoController {
    private String tipo;
    
    public TipoEquipamentoController() {
    }

    public TipoEquipamentoController(String tipo) {
        this.tipo = tipo;
    }
    
     public List<TipoEquipamento> listar(){
         return new TipoEquipamentoDAO().listar();
     }

    public boolean salvar(String tipo) {
        return new TipoEquipamentoDAO().salvar(tipo);
    }
    
}
