
package controller;

import java.util.Date;
import java.util.List;
import model.entidades.Equipamento;
import model.entidades.EquipamentoEmManutencao;
import model.entidades.EstoqueEquipamento;

public class ManutencaoController {

    public ManutencaoController() {
    }

    public List<EquipamentoEmManutencao> listar() {
     return new EquipamentoManutencaoDAO().listar();
    }

    public boolean cadastrar(Equipamento ee, int qtd, String defeito) {
       return new EquipamentoManutencaoDAO(new EquipamentoEmManutencao(ee, qtd, defeito)).salvar();
    }

    public List<EquipamentoEmManutencao> listar(String filtro) {
        return new EquipamentoManutencaoDAO().filtrar(filtro);
    }

    public List<EquipamentoEmManutencao> filtraByData(Date inicio, Date fim) {
       return new EquipamentoManutencaoDAO().filtraByData(inicio, fim);
    }

    
}
