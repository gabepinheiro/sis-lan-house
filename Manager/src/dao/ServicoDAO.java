package dao;


import java.util.List;

import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import model.entidades.Servico;

public class ServicoDAO {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private Servico servico;

    public ServicoDAO() {
        con = Conexao.getCon();
    }

    public ServicoDAO(Servico servico) {
        con = Conexao.getCon();
        this.servico = servico;
    }

    public List<Servico> listar() {
        List<Servico> servicos = new ArrayList<>();
        try {
            pstm = con.prepareStatement("select * from servico");
            rs = pstm.executeQuery();
            while (rs.next()) {
                servicos.add(new Servico(rs.getString("descricao"), rs.getFloat("valor")));
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar no banco: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return servicos;
    }

    public List<Servico> filtrarByNome(String filtro) {
        List<Servico> servicos = new ArrayList<>();
        try {
            pstm = con.prepareStatement("select * from servico where upper(descricao) like ?");
            pstm.setString(1, "%" +filtro + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                servicos.add(new Servico(rs.getString("descricao"), rs.getFloat("valor")));
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar no banco: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return servicos;
    }

}
