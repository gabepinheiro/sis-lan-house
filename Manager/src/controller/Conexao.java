package controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/lanhouse" + "?useLegacyDatetimeCode=false&serverTimezone=America/Sao_Paulo";
    private static final String USER = "root";
    private static final String PASS = "root";
    
    public static Connection getCon(){
        try {
            
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException | SQLException e) {
            
            throw new RuntimeException("Erro de conexão: ", e);
            
        }
    }
    
    public static void closeCon(Connection con){
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão");
            }
        }
    }
    public static void closeCon(Connection con, PreparedStatement pstm){
        if(pstm != null){
            try {
                
                pstm.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão");
            }
        }
        closeCon(con);
        
    }
    public static void closeCon(Connection con, PreparedStatement pstm, ResultSet rs){
        if(rs != null){
            try {
                
                rs.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão");
            }
            
        }
        closeCon(con, pstm);
        
    }
    
}
