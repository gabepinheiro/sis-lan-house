package dao;

import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.entidades.FluxoLogin;

public class FluxoLoginDAO {

    private FluxoLogin f;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    public FluxoLoginDAO() {
        con = Conexao.getCon();
    }

    public FluxoLoginDAO(FluxoLogin f) {
        this.f = f;
        con = Conexao.getCon();
    }

    public void logarADM(int usuario) {
        try {
            pstm = con.prepareStatement("insert into loginFuncionario(usuario) values(?)");
            pstm.setInt(1, usuario);
            pstm.executeUpdate();
            Conexao.closeCon(con, pstm);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de registro do login " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void deslogarADM(int usuario) {
        try {
            pstm = con.prepareStatement("insert into logoutFuncionario(usuario) values(?)");
            pstm.setInt(1, usuario);
            pstm.executeUpdate();
            Conexao.closeCon(con, pstm);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de regitro do login " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void logar(int id) {
        try {
            pstm = con.prepareStatement("insert into logout(usuario) values(?)");
            pstm.setInt(1, id);
            pstm.executeUpdate();
            Conexao.closeCon(con, pstm);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de registro do login " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deslogar(int usuario) {
        try {
            pstm = con.prepareStatement("insert into login(usuario) values(?)");
            pstm.setInt(1, usuario);
            pstm.executeUpdate();
            Conexao.closeCon(con, pstm);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de regitro do login " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
