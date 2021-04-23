/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.entidades.Venda;

/**
 *
 * @author JOSÉLUISFREIREDASILV
 */
public class VendaDAO {
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private Venda venda;

    public VendaDAO() {
        con = Conexao.getCon();
    }

    public VendaDAO(Venda venda) {
        this.venda = venda;
            con = Conexao.getCon();
    }
    
   
}
