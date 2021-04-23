package dao;

import java.sql.PreparedStatement;
import controller.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.entidades.Equipamento;
import model.entidades.Fornecedor;
import model.entidades.TipoEquipamento;

public class EquipamentoDAO {

    private Equipamento e;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    private SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat dataBrasil = new SimpleDateFormat("dd/MM/yyyy");

    public EquipamentoDAO() {
        con = Conexao.getCon();
    }

    public EquipamentoDAO(Equipamento e) {
        this.e = e;
        con = Conexao.getCon();
    }

    public boolean salvar() {
        boolean flag = false;
        try {
            pstm = con.prepareStatement("insert into equipamento(descricao, valor, fornecedor, dataFabricacao, garantia, tipo) values(?,?,?,?,?,?)");
            pstm.setString(1, e.getDescricao());
            pstm.setFloat(2, e.getValor());
            pstm.setInt(3, getFKFornecedor(e.getFornecedor().getNome()));
            pstm.setString(4, data.format(e.getDataFabricacao()).replaceAll("-", "/"));
            pstm.setInt(5, e.getGarantia());
            pstm.setInt(6, getFKTipo(e.getTipo().getTipo()));
            if (pstm.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                flag = true;
            }
            Conexao.closeCon(con, pstm);
        } catch (SQLException ex) {
            if (ex.toString().contains("Duplicate")) {
                JOptionPane.showMessageDialog(null, "Não foi possível inserir no banco: \nProduto com descrição idêntica já cadastrado", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível inserir no banco: \n" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        return flag;
    }

    public boolean editar(String descricao) {
        boolean flag = false;
        try {
            pstm = con.prepareStatement("update equipamento set descricao = ?, valor = ?, fornecedor = ?, dataFabricacao = ?, garantia = ?, tipo = ? where descricao like ? ");
            pstm.setString(1, e.getDescricao());
            pstm.setFloat(2, e.getValor());
            pstm.setInt(3, getFKFornecedor(e.getFornecedor().getNome()));
            pstm.setString(4, data.format(e.getDataFabricacao()).replaceAll("-", "/"));
            pstm.setInt(5, e.getGarantia());
            pstm.setInt(6, getFKTipo(e.getTipo().getTipo()));
            pstm.setString(7, descricao);

            if (pstm.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                flag = true;
            }
            Conexao.closeCon(con, pstm);
        } catch (SQLException ex) {
            if (ex.toString().contains("Duplicate")) {
                JOptionPane.showMessageDialog(null, "Não foi possível inserir no banco: \nProduto com descrição idêntica já cadastrado", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível inserir no banco: \n" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        return flag;
    }

    public List<Equipamento> listar() {
        List<Equipamento> equipamentos = new ArrayList<>();
        try {
            pstm = con.prepareStatement("SELECT descricao, valor, garantia, dataFabricacao, fornecedor.nome, tipoEquipamento.tipo FROM equipamento\n"
                    + "INNER JOIN fornecedor ON equipamento.fornecedor = fornecedor.id "
                    + "INNER JOIN tipoEquipamento ON equipamento.tipo = tipoEquipamento.id");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setNome(rs.getString("fornecedor.nome"));

                equipamentos.add(new Equipamento(rs.getString("descricao"), rs.getInt("garantia"), data.parse(rs.getString("dataFabricacao")), f, rs.getFloat("valor"), new TipoEquipamento(rs.getString("tipoEquipamento.tipo"))));
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar os dados no banco: \n" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return equipamentos;
    }

    public List<Equipamento> filtrar(String filtro) {
        List<Equipamento> equipamentos = new ArrayList<>();
        try {
            pstm = con.prepareStatement("SELECT descricao, valor, garantia, dataFabricacao, fornecedor.nome, tipoEquipamento.tipo FROM equipamento\n"
                    + "INNER JOIN fornecedor ON equipamento.fornecedor = fornecedor.id \n"
                    + "INNER JOIN tipoEquipamento ON equipamento.tipo = tipoEquipamento.id where upper(descricao) like ? or "
                    + " upper(fornecedor.nome) like ? ;");
            pstm.setString(1, "%" + filtro + "%");
            pstm.setString(2, "%" + filtro + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setNome(rs.getString("fornecedor.nome"));

                equipamentos.add(new Equipamento(rs.getString("descricao"), rs.getInt("garantia"), data.parse(rs.getString("dataFabricacao")), f, rs.getFloat("valor"), new TipoEquipamento(rs.getString("tipoEquipamento.tipo"))));
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar os dados no banco: \n" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return equipamentos;
    }

    private int getFKFornecedor(String fornecedor) {
        int id = 0;
        Connection con = Conexao.getCon();
        ResultSet rs;
        try {
            PreparedStatement pstm2 = con.prepareStatement("select id from fornecedor where nome like ?");
            pstm2.setString(1, fornecedor);
            rs = pstm2.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            Conexao.closeCon(con, pstm2, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível puxar do banco: \n" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }

    private int getFKTipo(String tipo) {
        int id = 0;
        Connection con = Conexao.getCon();
        ResultSet rs;
        try {
            PreparedStatement pstm3 = con.prepareStatement("select id from tipoEquipamento where tipo like ?");
            pstm3.setString(1, tipo);
            rs = pstm3.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            Conexao.closeCon(con, pstm3, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível puxar do banco: \n" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }

    public Equipamento findByDesc(String desc) {
        Equipamento e = null;
        try {
            pstm = con.prepareStatement("SELECT descricao, valor, garantia, dataFabricacao, fornecedor.nome, tipoEquipamento.tipo FROM equipamento\n"
                    + "INNER JOIN fornecedor ON equipamento.fornecedor = fornecedor.id \n"
                    + "INNER JOIN tipoEquipamento ON equipamento.tipo = tipoEquipamento.id where descricao like ?");
            pstm.setString(1, desc);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setNome(rs.getString("fornecedor.nome"));
                e = new Equipamento(rs.getString("descricao"), rs.getInt("garantia"), data.parse(rs.getString("dataFabricacao")), f, rs.getFloat("valor"), new TipoEquipamento(rs.getString("tipoEquipamento.tipo")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    public List<Equipamento> filtraByNome(String filtro) {

        List<Equipamento> equipamentos = new ArrayList<>();
        try {
            pstm = con.prepareStatement("SELECT descricao, valor, garantia, dataFabricacao, fornecedor.nome, tipoEquipamento.tipo FROM equipamento\n"
                    + "INNER JOIN fornecedor ON equipamento.fornecedor = fornecedor.id \n"
                    + "INNER JOIN tipoEquipamento ON equipamento.tipo = tipoEquipamento.id where upper(descricao) like ? ;");
            pstm.setString(1, "%" + filtro.toUpperCase() + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setNome(rs.getString("fornecedor.nome"));

                equipamentos.add(new Equipamento(rs.getString("descricao"), rs.getInt("garantia"), data.parse(rs.getString("dataFabricacao")), f, rs.getFloat("valor"), new TipoEquipamento(rs.getString("tipoEquipamento.tipo"))));
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar os dados no banco: \n" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return equipamentos;
    }

    public boolean getByDescricao(String nome) {
        boolean flag = false;
        try {
            pstm = con.prepareStatement("select * from equipamento where descricao like ?");
            pstm.setString(1, nome);
            rs = pstm.executeQuery();
            if (rs.next()) {
                flag = true;
            } else {
                JOptionPane.showMessageDialog(null, "Insira um equipamento existente! \n", "ERRO", JOptionPane.ERROR_MESSAGE);
                flag = false;
            }
            Conexao.closeCon(con, pstm, rs);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no banco ao bucar o equipamento! \n", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }

    public Equipamento findByID(int id) {
        Equipamento e = null;
        try {
            pstm = con.prepareStatement("SELECT descricao, valor, garantia, dataFabricacao, fornecedor.nome, tipoEquipamento.tipo FROM equipamento\n"
                    + "INNER JOIN fornecedor ON equipamento.fornecedor = fornecedor.id \n"
                    + "INNER JOIN tipoEquipamento ON equipamento.tipo = tipoEquipamento.id where equipamento.id = ?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setNome(rs.getString("fornecedor.nome"));

                e = new Equipamento(rs.getString("descricao"), rs.getInt("garantia"), data.parse(rs.getString("dataFabricacao")), f, rs.getFloat("valor"), new TipoEquipamento(rs.getString("tipoEquipamento.tipo")));
            }
            Conexao.closeCon(con, pstm, rs);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no banco ao bucar o equipamento! \n" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

}
