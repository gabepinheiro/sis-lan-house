
package dao;

import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.entidades.Cargo;

public class CargoDAO {
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    
    public CargoDAO() {
        con = Conexao.getCon();
    }
    
    public boolean salvar(String cargo){
        boolean flag = false;
        try{
            pstm = con.prepareStatement("insert into cargo(nome) values(?);");
            pstm.setString(1, cargo);
            if(pstm.executeUpdate() > 0)flag = true;
            else flag = false;
            Conexao.closeCon(con, pstm);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao inserir o novo cargo no banco: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }
    public List<Cargo> listar(){
        List<Cargo> cargos = new ArrayList<>();
        try{
            pstm = con.prepareStatement("select * from cargo");
            rs = pstm.executeQuery();
            while(rs.next()){
                cargos.add(new Cargo(rs.getString("nome")));
            }
            Conexao.closeCon(con, pstm, rs);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro puxar os cargos do banco: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return cargos;
    }
    
}
