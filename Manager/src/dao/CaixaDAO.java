package dao;


import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.entidades.Caixa;

public class CaixaDAO {

    private Caixa caixa;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    public CaixaDAO() {
        this.con = Conexao.getCon();
    }

    public CaixaDAO(Caixa caixa, Connection con, PreparedStatement pstm, ResultSet rs) {
        this.caixa = caixa;
        this.con = Conexao.getCon();

    }

    public CaixaDAO(Caixa c) {
        this.caixa = c;
        this.con = Conexao.getCon();
    }

    public boolean abrirCaixa(float valorAtribuido, String user) {
        boolean flag = false;
        try{
            pstm = con.prepareStatement("insert into aberturaCaixa(valorAtribuido, usuario) values(?, ?)");
            pstm.setFloat(1, valorAtribuido);
            pstm.setString(2, user);
            if(pstm.executeUpdate() > 0){
                   JOptionPane.showMessageDialog(null, "Caixa aberto!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                    flag = true;
            }
            Conexao.closeCon(con, pstm);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível abrir o caixa: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            flag = false;
        }
        return flag;
    }

    public boolean fecharCaixa(String motivo, float retirada, String user) {
            boolean flag = false;
        try{
            pstm = con.prepareStatement("insert into fechamentoCaixa(valorRetirado, motivoFechamento, usuario) values(?, ?, ? )");
            pstm.setFloat(1, retirada);
            pstm.setString(2, motivo);
            pstm.setString(3, user);
            if(pstm.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Caixa fechado!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                    flag = true;
            }
            Conexao.closeCon(con, pstm);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível fechar o caixa: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            flag = false;
        }
        return flag;
    }
    
   public boolean isAberto(){
       boolean flag = false; 
       try {
            pstm = con.prepareStatement("select status from caixa");
            rs = pstm.executeQuery();
            while(rs.next()){
                if(rs.getString("status").equals("ABERTO")) flag = true;
                else flag = false;
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Não foi possível abrir o caixa: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
       return flag;
   }

    public float getValorCaixa() {
        float valor = 0;
        try {
            pstm = con.prepareStatement("select valor from caixa");
            rs = pstm.executeQuery();
            while(rs.next()){
                valor = rs.getFloat("valor");
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Não foi possível resgatar o valor: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return valor;
    }

}
