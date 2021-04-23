
package dao;

import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.entidades.TipoEquipamento;

public class TipoEquipamentoDAO {
    
    private final Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    
    public TipoEquipamentoDAO() {
        con = Conexao.getCon();
    }
     public List<TipoEquipamento> listar(){
       List<TipoEquipamento> tipos = new ArrayList<>();
         try {
            pstm = con.prepareStatement("select * from tipoEquipamento");
            rs = pstm.executeQuery();
            while(rs.next()){
                tipos.add(new TipoEquipamento(rs.getString("tipo")));
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao puxar os dados do banco: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
         return tipos;
     }

    public boolean salvar(String tipo) {
        boolean flag = false;
        try {
             pstm = con.prepareStatement("insert into tipoEquipamento(tipo) values(?)");
            pstm.setString(1, tipo);
            if(pstm.executeUpdate() > 0) flag = true;
        } catch (SQLException ex) {
            if(ex.toString().contains("Duplicate"))  JOptionPane.showMessageDialog(null, "Erro ao inserir os dados no banco: \nTIpo já cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
            else JOptionPane.showMessageDialog(null, "Erro ao inserir os dados no banco: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }
}
