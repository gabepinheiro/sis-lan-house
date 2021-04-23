/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EstoqueEquipamentoDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.entidades.Equipamento;
import model.entidades.EstoqueEquipamento;

/**
 *
 * @author JOSÉLUISFREIREDASILV
 */
public class EstoqueEquipamentoController {
    


    public List<EstoqueEquipamento> listar() {
        return new EstoqueEquipamentoDAO().listar();
    }


    public List<EstoqueEquipamento> filtrar(String filtro) {
       return new EstoqueEquipamentoDAO().filtrar(filtro);
    }

    public List<EstoqueEquipamento> filtraByData(Date inicio, Date fim){
        return new EstoqueEquipamentoDAO().filtraByData(inicio, fim);
    }

  
    public boolean excluir(String equip) {
        return new EstoqueEquipamentoDAO().excluir(equip);
    }

    public boolean inserir(String equip, int qtd) {
        return new EstoqueEquipamentoDAO().inserir(equip, qtd);
    }


}
