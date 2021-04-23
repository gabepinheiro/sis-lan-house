package dao;

import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.entidades.Cargo;
import model.entidades.Funcionario;

public class FuncionarioDAO {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private Funcionario funcionario;

    private SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat dataBrasil = new SimpleDateFormat("dd/MM/yyyy");

    public FuncionarioDAO() {
        con = Conexao.getCon();
       
    }

    public FuncionarioDAO(Funcionario f) {
        con = Conexao.getCon();
        this.funcionario = f;
    }

    public boolean inserir() {
        boolean flag = false;
        try {
            PreparedStatement pstmCargo = con.prepareStatement("select id from cargo where nome like ?");
            pstmCargo.setString(1, funcionario.getCargo().getCargo());
            rs = pstmCargo.executeQuery();
            int cargo = 0;
            while (rs.next()) {
                cargo = rs.getInt("id");
            }
            pstm = con.prepareStatement("insert into funcionario(cpf, nome, sobrenome, email, dataAdmissao, salario, cep, logradouro, numero, complemento, bairro"
                    + ", cidade, estado, cargo, telefone, celular) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            pstm.setString(1, funcionario.getCpf());
            pstm.setString(2, funcionario.getNome());
            pstm.setString(3, funcionario.getSobrenome());
            pstm.setString(4, funcionario.getEmail());
            pstm.setString(5, data.format(funcionario.getDataAdmissao()).replaceAll("-", "/"));
            pstm.setFloat(6, funcionario.getSalario());
            pstm.setString(7, funcionario.getCep());
            pstm.setString(8, funcionario.getLogradouro());
            pstm.setString(9, funcionario.getNumero());
            pstm.setString(10, funcionario.getComplemento());
            pstm.setString(11, funcionario.getBairro());
            pstm.setString(12, funcionario.getCidade());
            pstm.setString(13, funcionario.getEstado());
            pstm.setInt(14, cargo);
            pstm.setString(15, funcionario.getTelefone());
            pstm.setString(16, funcionario.getCelular());
            if (pstm.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
                flag = true;
            }
            Conexao.closeCon(con, pstm);
        } catch (SQLException ex) {
            if (ex.toString().contains("Duplicate")) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir! CPF já cadastrado!", null, JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao inserir!\n" + ex, null, JOptionPane.ERROR_MESSAGE);
            }
        }
        return flag;
    }

    public boolean editar() {
        boolean flag = false;

        try {
            PreparedStatement pstmCargo = con.prepareStatement("select id from cargo where nome like ?");
            pstmCargo.setString(1, funcionario.getCargo().getCargo());
            pstm = con.prepareStatement("update funcionario set nome = ?, sobrenome = ?, email = ?, dataAdmissao = ?, salario = ?, cep = ?, logradouro = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?"
                    + ", estado = ?, cargo = ?, telefone = ?, celular = ? where cpf like ?");
            rs = pstmCargo.executeQuery();
            int cargo = 0;
            while (rs.next()) {
                cargo = rs.getInt("id");
            }
            
            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getSobrenome());
            pstm.setString(3, funcionario.getEmail());
            pstm.setString(4, data.format(funcionario.getDataAdmissao()).replaceAll("-", "/"));
            pstm.setFloat(5, funcionario.getSalario());
            pstm.setString(6, funcionario.getCep());
            pstm.setString(7, funcionario.getLogradouro());
            pstm.setString(8, funcionario.getNumero());
            pstm.setString(9, funcionario.getComplemento());
            pstm.setString(10, funcionario.getBairro());
            pstm.setString(11, funcionario.getCidade());
            pstm.setString(12, funcionario.getEstado());
            pstm.setInt(13, cargo);
            pstm.setString(14, funcionario.getTelefone());
            pstm.setString(15, funcionario.getCelular());
            pstm.setString(16, funcionario.getCpf());
            
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

    public List<Funcionario> listar() {
        List<Funcionario> funcionarios = new ArrayList<>();
        PreparedStatement pstmCargo;
        ResultSet rsCargo;
        try {
            pstm = con.prepareStatement("select * from funcionario");
            pstmCargo = con.prepareStatement("select nome from cargo where id = ?");
            rs = pstm.executeQuery();
            while (rs.next()) {
                pstmCargo.setInt(1, rs.getInt("cargo"));
                String cargo = null;
                rsCargo = pstmCargo.executeQuery();
                while (rsCargo.next()) {
                    funcionarios.add(new Funcionario(rs.getString("cpf"), rs.getString("nome"), rs.getString("sobrenome"), rs.getString("email"), rs.getString("cep"), rs.getString("logradouro"), rs.getString("numero"), rs.getString("cidade"), rs.getString("complemento"), rs.getString("bairro"), rs.getString("estado"), rs.getString("telefone"), rs.getString("celular"), data.parse(rs.getString("dataAdmissao")), new Cargo(rsCargo.getString("nome")), rs.getFloat("salario"), rs.getBoolean("desativado")));
                }
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            System.out.println("Erro na busca de dados: " + ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }

    public List<Funcionario> filtrar(String filtro) {
        List<Funcionario> funcionarios = new ArrayList<>();
        PreparedStatement pstmCargo;
        ResultSet rsCargo;
        try {
            pstm = con.prepareStatement("select * from funcionario where cpf like ? or upper(nome) like ? or upper(sobrenome) like ? or upper(email) like ? or telefone like ?  or celular like ?");
            pstm.setString(1, "%" + filtro + "%");
            pstm.setString(2, "%" + filtro + "%");
            pstm.setString(3, "%" + filtro + "%");
            pstm.setString(4, "%" + filtro + "%");
            pstm.setString(5, "%" + filtro + "%");
            pstm.setString(6, "%" + filtro + "%");
            pstmCargo = con.prepareStatement("select nome from cargo where id = ?");
            rs = pstm.executeQuery();
            while (rs.next()) {
                pstmCargo.setInt(1, rs.getInt("cargo"));
                String cargo = null;
                rsCargo = pstmCargo.executeQuery();
                while (rsCargo.next()) {
                    funcionarios.add(new Funcionario(rs.getString("cpf"), rs.getString("nome"), rs.getString("sobrenome"), rs.getString("email"), rs.getString("cep"), rs.getString("logradouro"), rs.getString("numero"), rs.getString("cidade"), rs.getString("complemento"), rs.getString("bairro"), rs.getString("estado"), rs.getString("telefone"), rs.getString("celular"), data.parse(rs.getString("dataAdmissao")), new Cargo(rsCargo.getString("nome")), rs.getFloat("salario"), rs.getBoolean("desativado")));
                }
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            System.out.println("Erro na busca de dados: " + ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }

    public List<Funcionario> filtrarByCargo(String cargo) {
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            pstm = con.prepareStatement("select cpf, nome, sobrenome, email, dataAdmissao, cep, logradouro, numero, complemento, bairro, cidade, estado, telefone, celular, salario, desativado,  Cargo.nome from funcionario inner join cargo on funcionario.cargo = cargo.id where cargo.nome like ? ");
            pstm.setString(1, cargo);
            while(rs.next()){
                    funcionarios.add(new Funcionario(rs.getString("cpf"), rs.getString("nome"), rs.getString("sobrenome"), rs.getString("email"), rs.getString("cep"), rs.getString("logradouro"), rs.getString("numero"), rs.getString("cidade"), rs.getString("complemento"), rs.getString("bairro"), rs.getString("estado"), rs.getString("telefone"), rs.getString("celular"), data.parse(rs.getString("dataAdmissao")), new Cargo(rs.getString("cargo.nome")), rs.getFloat("salario"), rs.getBoolean("desativado")));
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            System.out.println("Erro na busca de dados: " + ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }
      public void desativar(String cpf) {
        try{
            pstm = con.prepareStatement("update funcionario set desativado = true where cpf like ?");
            pstm.setString(1, cpf);
            if(pstm.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Funcionario desativado");
            }else{
                JOptionPane.showMessageDialog(null, "Funcionario não está ativo!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            Conexao.closeCon(con, pstm);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao desativar o registro: \n\n" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void reativar(String cpf) {
        try{
            pstm = con.prepareStatement("update funcionario set desativado = false where cpf like ?");
            pstm.setString(1, cpf);
            if(pstm.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Funcionario reabilitado");
            }else{
                JOptionPane.showMessageDialog(null, "Funcionario já está ativo!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            Conexao.closeCon(con, pstm);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao ativar o registro: \n\n" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Funcionario findByCpf(String cpf) {
        Funcionario f = null;
        PreparedStatement pstmCargo;
        ResultSet rsCargo;
        try {
            pstm = con.prepareStatement("select * from funcionario where cpf = ?");
            pstm.setString(1, cpf);
            pstmCargo = con.prepareStatement("select nome from cargo where id = ?");
            rs = pstm.executeQuery();
            while (rs.next()) {
                pstmCargo.setInt(1, rs.getInt("cargo"));
                String cargo = null;
                rsCargo = pstmCargo.executeQuery();
                while (rsCargo.next()) {
                    f = new Funcionario(rs.getString("cpf"), rs.getString("nome"), rs.getString("sobrenome"), rs.getString("email"), rs.getString("cep"), rs.getString("logradouro"), rs.getString("numero"), rs.getString("cidade"), rs.getString("complemento"), rs.getString("bairro"), rs.getString("estado"), rs.getString("telefone"), rs.getString("celular"), data.parse(rs.getString("dataAdmissao")), new Cargo(rsCargo.getString("nome")), rs.getFloat("salario"), rs.getBoolean("desativado"));
                }
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            System.out.println("Erro na busca de dados: " + ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }

    public int getID(String cpf) {
        int id = 0;
        try {
            pstm = con.prepareStatement("select id from funcionario where cpf like ?");
            pstm.setString(1, cpf);
            rs = pstm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o funcionario: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }


    

}
