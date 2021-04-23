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
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.entidades.Estacao;

/**
 *
 * @author logon
 */
public class EstacaoDAO {
    
     private Connection con;

    public EstacaoDAO() {
        this.con = new Conexao().getCon();
    }
    
    public boolean connectar(){
        return (this.con = new Conexao().getCon()) != null;
    }
    
    public boolean insert(Estacao estacao){
        PreparedStatement pstm;
        int res;
        boolean flag = false;
        try {
            pstm = con.prepareStatement("insert into estacao(ip, descricao) values(?,?);");
            pstm.setString(1, estacao.getIp());
            pstm.setString(2, estacao.getDescricao());
//            pstm.setBoolean(3, estacao.getStatus().equals(Estacao.Status.MANUTENCAO));
            res = pstm.executeUpdate();
            if (res > 0) {
                flag = true;
            } else {
                throw new SQLException();
            }
            Conexao.closeCon(con, pstm);
        } catch (SQLException e) {
            if(e.toString().indexOf("duplicate") != -1) JOptionPane.showMessageDialog(null, "Este login já esta sendo usado!\nTente novamente.", null, JOptionPane.ERROR_MESSAGE);
            else JOptionPane.showMessageDialog(null, "Erro na inserção: \n" + e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }
    
    
      public ArrayList<Estacao> selectAll() {
        ArrayList<Estacao> estacoes = new ArrayList<>();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * from estacao order by id");
            rs = stmt.executeQuery();

            while (rs.next()){

                Estacao estacao = new Estacao();
                
                estacao.setIp(rs.getString("ip"));
                estacao.setDescricao(rs.getString("descricao"));
                if (rs.getBoolean("manutencao")) {
                    estacao.setStatus(Estacao.Status.MANUTENCAO);                    
                } else {
                    estacao.setStatus(Estacao.Status.LIVRE);
                }

                estacoes.add(estacao);
            }
             con.close();
            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer o SELECT no banco: " + ex);
        } finally {
                          
        }
        return estacoes;
    }
}
