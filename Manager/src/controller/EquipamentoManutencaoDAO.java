/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EquipamentoDAO;
import dao.EstoqueEquipamentoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.entidades.Equipamento;
import model.entidades.EquipamentoEmManutencao;

/**
 *
 * @author JOSÉLUISFREIREDASILV
 */
public class EquipamentoManutencaoDAO {

    private EquipamentoEmManutencao e;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    private SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");

    public EquipamentoManutencaoDAO(EquipamentoEmManutencao equipamentoEmManutencao) {
        this.e = equipamentoEmManutencao;
        con = Conexao.getCon();
    }

    public EquipamentoManutencaoDAO() {
        con = Conexao.getCon();
    }

    boolean salvar() {
        boolean flag = false;
        try {
            pstm = con.prepareStatement("insert into equipamentomanutencao(equipamento, quantidade, defeito) values(?,?,?)");
            int id = new EstoqueEquipamentoDAO().getIdEquipamento(e.getEquipamento());
            pstm.setInt(1, id);
            pstm.setInt(2, e.getQtd());
            pstm.setString(3, e.getDefeito());
            if (pstm.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                flag = true;
            }
            Conexao.closeCon(con, pstm);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível a inserção: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }

    public List<EquipamentoEmManutencao> listar() {
        List<EquipamentoEmManutencao> e = new ArrayList<>();
        try {
            pstm = con.prepareStatement("select equipamento, quantidade, defeito, dataEntrada from equipamentomanutencao "
                    + "inner join equipamento on equipamentomanutencao.equipamento = equipamento.id");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Equipamento equip = new EquipamentoDAO().findByID(rs.getInt("equipamento"));
                e.add(new EquipamentoEmManutencao(equip, data.parse(rs.getString("dataEntrada")), rs.getInt("quantidade"), rs.getString("defeito")));
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(EquipamentoManutencaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    public List<EquipamentoEmManutencao> filtrar(String filtro) {
        List<EquipamentoEmManutencao> e = new ArrayList<>();
        try {
            pstm = con.prepareStatement("select equipamento, equipamento.descricao, quantidade, defeito, dataEntrada from equipamentomanutencao "
                    + "inner join equipamento on equipamentomanutencao.equipamento = equipamento.id where upper(equipamento.descricao) like ? or upper(defeito) like ?"
            );
            pstm.setString(1, "%" + filtro + "%");
            pstm.setString(2, "%" + filtro + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Equipamento equip = new EquipamentoDAO().findByID(rs.getInt("equipamento"));
                e.add(new EquipamentoEmManutencao(equip, data.parse(rs.getString("dataEntrada")), rs.getInt("quantidade"), rs.getString("defeito")));
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(EquipamentoManutencaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    List<EquipamentoEmManutencao> filtraByData(Date inicio, Date fim) {
        List<EquipamentoEmManutencao> equips = new ArrayList<EquipamentoEmManutencao>();
        try {
            pstm = con.prepareStatement("select equipamento, quantidade, defeito, dataEntrada from equipamentomanutencao "
                    + "inner join equipamento on equipamentomanutencao.equipamento = equipamento.id where dataEntrada between date_sub(?, interval 1 day) and date_add(?, interval 1 day)");
            pstm.setString(1, data.format(inicio).replaceAll("-", "/"));
            pstm.setString(2, data.format(fim).replaceAll("-", "/"));
            rs = pstm.executeQuery();
            while (rs.next()) {
                Equipamento equip = new EquipamentoDAO().findByID(rs.getInt("equipamento"));
                equips.add(new EquipamentoEmManutencao(equip, data.parse(rs.getString("dataEntrada")), rs.getInt("quantidade"), rs.getString("defeito")));
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar no banco: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(EstoqueEquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return equips;
    }

 

}
