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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.entidades.Cliente;
import model.entidades.Fornecedor;

public class FornecedorDAO {
    
    private Fornecedor fornecedor;
    private Connection con;

    public FornecedorDAO(Fornecedor c) {
        this.fornecedor = c;
        con = Conexao.getCon();
    }

    public FornecedorDAO() {
        con = Conexao.getCon();
    }
    
    public List<Fornecedor> filtrar(String filtro){
        List<Fornecedor> fornecedores = new ArrayList<>();
        ResultSet rs;
        con = Conexao.getCon();
        try{
            PreparedStatement pstm = con.prepareStatement("select * from fornecedor where cnpj like ? or upper(nome) like ? or upper(razaoSocial) like ? or telefone like ? or celular like ?");
            pstm.setObject(1, "%" + filtro + "%");
            pstm.setObject(2, "%" + filtro + "%");
            pstm.setObject(3, "%" + filtro + "%");
            pstm.setObject(4, "%" + filtro + "%");
            pstm.setObject(5, "%" + filtro + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                fornecedores.add(new Fornecedor(rs.getString("cnpj"), rs.getString("nome"), rs.getString("razaoSocial"), rs.getString("email")
                        , rs.getString("cep"), rs.getString("logradouro"), rs.getString("numero"), rs.getString("complemento"), 
                        rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("telefone"), rs.getString("celular"), rs.getBoolean("desativado")));
            }
            Conexao.closeCon(con, pstm, rs);
        }catch(SQLException ex){
                            JOptionPane.showMessageDialog(null, "Erro ao buscar!\n" + ex, null, JOptionPane.ERROR_MESSAGE);

        }
        return fornecedores;
    }
    
    public List<Fornecedor> listar(){
        List<Fornecedor> fornecedores = new ArrayList<>();
        con = Conexao.getCon();
        PreparedStatement pstm;
        ResultSet rs;
        try {
            pstm = con.prepareStatement("select * from fornecedor");
            rs = pstm.executeQuery();
            while (rs.next()) {
               fornecedores.add(new Fornecedor(rs.getString("cnpj"),rs.getString("nome"), rs.getString("razaoSocial"), rs.getString("cep"), rs.getString("logradouro"), rs.getString("numero"), rs.getString("Complemento"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("email"), rs.getString("telefone"),rs.getString("celular"), rs.getBoolean("desativado")));
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            System.out.println("Erro na busca de dados: " + ex.getMessage());
        }
        return fornecedores;
    }

    public boolean inserir() {
       PreparedStatement pstm;
        boolean flag = false;
        try {
            pstm = con.prepareStatement("insert into fornecedor(cnpj, nome, razaoSocial, email, cep, logradouro, numero, complemento, bairro"
                    + ", cidade, estado, telefone, celular) values(?,?,?,?,?,?,?,?,?,?,?,?,?);");
            pstm.setString(1, fornecedor.getCnpj());
            pstm.setString(2, fornecedor.getNome());
            pstm.setString(3, fornecedor.getRazaoSocial());
            pstm.setString(4, fornecedor.getEmail());
            pstm.setString(5, fornecedor.getCep());
            pstm.setString(6, fornecedor.getLogradouro());
            pstm.setString(7, fornecedor.getNumero());
            pstm.setString(8, fornecedor.getComplemento());
            pstm.setString(9, fornecedor.getBairro());
            pstm.setString(10, fornecedor.getCidade());
            pstm.setString(11, fornecedor.getEstado());
            pstm.setString(12, fornecedor.getTelefone());
            pstm.setString(13, fornecedor.getCelular());
            if (pstm.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
                flag = true;
            }
            Conexao.closeCon(con, pstm);
        } catch (SQLException ex) {
            if (ex.toString().contains("Duplicate")) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir! CNPJ já cadastrado!", null, JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao inserir!\n" + ex, null, JOptionPane.ERROR_MESSAGE);
            }
        }
        return flag;
    }

    public boolean editar() {
        PreparedStatement pstm;
        boolean flag = false;
        try {
            pstm = con.prepareStatement("update fornecedor set nome = ?, razaoSocial = ?, email = ?, cep = ?, logradouro = ?,"
                    + " numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, telefone = ?, celular = ? where cnpj = ?");
            pstm.setString(1, fornecedor.getNome());
            pstm.setString(2, fornecedor.getRazaoSocial());
            pstm.setString(3, fornecedor.getEmail());
            pstm.setString(4, fornecedor.getCep());
            pstm.setString(5, fornecedor.getLogradouro());
            pstm.setString(6, fornecedor.getNumero());
            pstm.setString(7, fornecedor.getComplemento());
            pstm.setString(8, fornecedor.getBairro());
            pstm.setString(9, fornecedor.getCidade());
            pstm.setString(10, fornecedor.getEstado());
            pstm.setString(11, fornecedor.getTelefone());
            pstm.setString(12, fornecedor.getCelular());
            pstm.setString(13, fornecedor.getCnpj());

            if (pstm.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
                flag = true;
            }
            Conexao.closeCon(con, pstm);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção!\n" + ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }

    public Fornecedor findByCnpj(String cnpj) {
        PreparedStatement pstm;
        ResultSet rs;
        Fornecedor c  = null;
        try{
            pstm = con.prepareStatement("select * from fornecedor where cnpj like ?");
            pstm.setString(1, cnpj);
            rs = pstm.executeQuery();
            while(rs.next()){
                c = new Fornecedor(rs.getString("cnpj"),rs.getString("nome"), rs.getString("razaoSocial"), rs.getString("cep"), rs.getString("logradouro"), rs.getString("numero"), rs.getString("Complemento"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("email"), rs.getString("telefone"),rs.getString("celular"), rs.getBoolean("desativado"));
            }
            Conexao.closeCon(con, pstm, rs);
            return c;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao buscar o fornecedor: \n\n" + e, "ERRO",JOptionPane.ERROR_MESSAGE  );
            return c;
        }
    }

    public void desativar(String cnpj) {
        PreparedStatement pstm;
        try{
            pstm = con.prepareStatement("update fornecedor set desativado = true where cnpj like ?");
            pstm.setString(1, cnpj);
            if(pstm.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Fornecedor desativado");
            }else{
                JOptionPane.showMessageDialog(null, "Fornecedor não está ativo!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            Conexao.closeCon(con, pstm);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao desativar o registro: \n\n" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void reativar(String cnpj) {
       PreparedStatement pstm;
        try{
            pstm = con.prepareStatement("update fornecedor set desativado = false where cnpj like ?");
            pstm.setString(1, cnpj);
            if(pstm.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Fornecedor reabilitado");
            }else{
                JOptionPane.showMessageDialog(null, "Fornecedor já está ativo!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            Conexao.closeCon(con, pstm);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao reativar o registro: \n\n" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
}
