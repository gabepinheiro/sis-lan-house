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
import javax.swing.JOptionPane;
import model.entidades.BancoDeHoras;

/**
 *
 * @author gabriel
 */
public class BancoDeHorasDAO {
       private Connection con;

    public BancoDeHorasDAO() {
        this.con = new Conexao().getCon();
    }
    
    public boolean connectar(){
        return (this.con = new Conexao().getCon()) != null;
    }
    
    public BancoDeHoras selectByUser(int idUser) {
        
        BancoDeHoras bancohoras = null;
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = con.prepareStatement("SELECT * from bancodehoras WHERE usuarioId = ?");
            pstmt.setInt(1, idUser);
             
            rs = pstmt.executeQuery();

            while (rs.next()){

                bancohoras = new BancoDeHoras();
                
                bancohoras.setUsuarioID(idUser);
                bancohoras.setHora(rs.getInt("hora"));
                bancohoras.setMinuto(rs.getInt("minuto"));
                bancohoras.setSegundo(rs.getInt("segundo"));
                
            }
             con.close();
             pstmt.close();
                rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer o SELECT no banco: " + ex);
        } finally {
                          
        }
        return bancohoras;
    }
}
