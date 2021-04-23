package dao;

import java.sql.PreparedStatement;
import controller.Conexao;
import java.sql.Connection;
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
import model.entidades.EstoqueEquipamento;

import view.TelaEstoque;

public class EstoqueEquipamentoDAO {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private EstoqueEquipamento ee;

    private SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");

    public EstoqueEquipamentoDAO() {
        con = Conexao.getCon();
    }

    public EstoqueEquipamentoDAO(EstoqueEquipamento ee) {
        con = Conexao.getCon();
        this.ee = ee;
    }

    public boolean salvar() {
        boolean flag = false;
        try {
            pstm = con.prepareStatement("insert into estoqueEquipamento(equipamento, quantidade) values(?,?);");
            pstm.setInt(1, getIdEquipamento(ee.getEquipamento()));
            pstm.setInt(2, ee.getQtd());
            if (pstm.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                flag = true;
            }
            Conexao.closeCon(con, pstm);
        } catch (SQLException ex) {
            if (ex.toString().contains("Duplicate")) {
                String[] op = {"Nao", "Sim"};
                int res = JOptionPane.showOptionDialog(null, "Equipamento já em estoque!\nDeseja ir a tela de estoque?\n\n", "Confrmação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
                if (res == 1) {
                    new TelaEstoque().setVisible(true);
                    flag = true;
                } else {
                    flag = false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "A inserção não foi possível: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        }
        return flag;
    }

    public int getIdEquipamento(Equipamento e) {
        int id = -1;
        con = Conexao.getCon();
        try {
            PreparedStatement pstm2 = con.prepareStatement("select id from equipamento where descricao like ?");
            pstm2.setString(1, e.getDescricao());
            ResultSet rs2 = pstm2.executeQuery();
            if (rs2.next()) {
                id = rs2.getInt("id");
            } else {
                JOptionPane.showMessageDialog(null, "Equipamento não existente!: ", null, JOptionPane.ERROR_MESSAGE);
            }
            Conexao.closeCon(con, pstm2, rs2);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar equipamento: " + ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }

    public List<EstoqueEquipamento> listar() {
        List<EstoqueEquipamento> equips = new ArrayList<EstoqueEquipamento>();
        try {
            pstm = con.prepareStatement("select * from estoqueEquipamento");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Equipamento e = new EquipamentoDAO().findByID(rs.getInt("equipamento"));
                equips.add(new EstoqueEquipamento(e, rs.getInt("quantidade"), data.parse(rs.getString("dataEntrada"))));
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar no banco: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(EstoqueEquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return equips;
    }

    public List<EstoqueEquipamento> filtrar(String filtro) {
        List<EstoqueEquipamento> equips = new ArrayList<EstoqueEquipamento>();
        try {
            pstm = con.prepareStatement("select equipamento, quantidade,dataEntrada, equipamento.descricao from estoqueequipamento "
                    + "inner join equipamento on estoqueequipamento.equipamento = equipamento.id where upper(equipamento.descricao) like ?");
            pstm.setString(1, "%" + filtro + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Equipamento e = new EquipamentoDAO().findByID(rs.getInt("equipamento"));
                equips.add(new EstoqueEquipamento(e, rs.getInt("quantidade"), data.parse(rs.getString("dataEntrada"))));
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar no banco: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(EstoqueEquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return equips;
    }

    public List<EstoqueEquipamento> filtraByData(Date inicio, Date fim) {
        List<EstoqueEquipamento> equips = new ArrayList<EstoqueEquipamento>();
        try {
            pstm = con.prepareStatement("select * from estoqueEquipamento where dataEntrada between date_sub(?, interval 1 day) and date_add(?, interval 1 day)");
            pstm.setString(1, data.format(inicio).replaceAll("-", "/"));
            pstm.setString(2, data.format(fim).replaceAll("-", "/"));
            rs = pstm.executeQuery();
            while (rs.next()) {
                Equipamento e = new EquipamentoDAO().findByID(rs.getInt("equipamento"));
                equips.add(new EstoqueEquipamento(e, rs.getInt("quantidade"), data.parse(rs.getString("dataEntrada"))));
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar no banco: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(EstoqueEquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return equips;
    }

    public boolean excluir(String equip) {
        boolean flag = false;
        Equipamento e = new Equipamento();
        e.setDescricao(equip);
        int id = getIdEquipamento(e);
        con = Conexao.getCon();
        try {
            pstm = con.prepareStatement("delete from estoqueequipamento where equipamento = ?");
            pstm.setInt(1, id);
            if (pstm.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Excluido com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                flag = true;
            }
            Conexao.closeCon(con, pstm);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "A exclusão não foi possível: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }

    public boolean inserir(String equip, int qtd) {
        boolean flag = false;
       Equipamento e = new EquipamentoDAO().findByDesc(equip);
       int id = getIdEquipamento(e);
       con = Conexao.getCon();
        try {
            pstm = con.prepareStatement("update estoqueequipamento set quantidade = quantidade + ? where equipamento = ?");
            pstm.setInt(1, qtd);
            pstm.setInt(2, id);
            if(pstm.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Alterado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                flag = true;
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao editar o estoque: " + ex.getMessage(), "ERRO",JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }
    

}
