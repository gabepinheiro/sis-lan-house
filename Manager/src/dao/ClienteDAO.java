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

public class ClienteDAO {

    private Cliente cliente;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    public ClienteDAO(Cliente cliente) {
        this.cliente = cliente;
        con = Conexao.getCon();
    }

    public ClienteDAO() {
        con = Conexao.getCon();
    }

    public List<Cliente> filtrar(String filtro) {
        List<Cliente> clientes = new ArrayList<>();
        try {
            pstm = con.prepareStatement("select * from cliente where cpf like ? or upper(nome) like ? or telefone like ? or celular like ?");
            pstm.setObject(1, "%" + filtro + "%");
            pstm.setObject(2, "%" + filtro + "%");
            pstm.setObject(3, "%" + filtro + "%");
            pstm.setObject(4, "%" + filtro + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                clientes.add(new Cliente(rs.getString("cpf"), rs.getString("nome"), rs.getString("sobrenome"), rs.getString("genero").charAt(0), rs.getString("email"), rs.getString("telefone"), rs.getString("celular"), rs.getBoolean("desativado")));
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar!\n" + ex, null, JOptionPane.ERROR_MESSAGE);

        }
        return clientes;
    }

    public Cliente findByCpf(String cpf) {

        Cliente c = new Cliente();
        try {
            pstm = con.prepareStatement("select * from cliente where cpf like ?");
            pstm.setString(1, cpf);
            rs = pstm.executeQuery();
            while (rs.next()) {
                c.setCpf(cpf);
                c.setNome(rs.getString("nome"));
                c.setSobrenome(rs.getString("sobrenome"));
                c.setEmail(rs.getString("email"));
                c.setGenero(rs.getString("genero").charAt(0));
                c.setTelefone(rs.getString("telefone"));
                c.setCelular(rs.getString("celular"));
                c.setDesativado(rs.getBoolean("desativado"));
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            System.out.println("Erro na busca de dados: " + ex.getMessage());
        }
        return c;
    }

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();

        try {
            pstm = con.prepareStatement("select * from cliente");
            rs = pstm.executeQuery();
            while (rs.next()) {
                clientes.add(new Cliente(rs.getString("cpf"), rs.getString("nome"), rs.getString("sobrenome"), rs.getString("genero").charAt(0), rs.getString("email"), rs.getString("telefone"), rs.getString("celular"), rs.getBoolean("desativado")));
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            System.out.println("Erro na busca de dados: " + ex.getMessage());
        }
        return clientes;
    }

    public boolean inserir() {

        boolean flag = false;
        try {
            pstm = con.prepareStatement("insert into cliente(cpf, nome, sobrenome, genero, email, telefone, celular) values(?,?,?,?,?,?,?)");
            pstm.setString(1, cliente.getCpf());
            pstm.setString(2, cliente.getNome());
            pstm.setString(3, cliente.getSobrenome());
            pstm.setString(4, cliente.getGenero().charAt(0) + "");
            pstm.setString(5, cliente.getEmail());
            pstm.setString(6, cliente.getTelefone());
            pstm.setString(7, cliente.getCelular());
            if (pstm.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
                flag = true;
            }
            Conexao.closeCon(con, pstm);
        } catch (SQLException ex) {
            if (ex.toString().contains("Integrity")) {
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
            pstm = con.prepareStatement("update cliente set nome = ?, sobrenome = ?, genero = ?, email = ?, telefone = ?, celular = ? where cpf = ?");
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getSobrenome());
            pstm.setString(3, cliente.getGenero().charAt(0) + "");
            pstm.setString(4, cliente.getEmail());
            pstm.setString(5, cliente.getTelefone());
            pstm.setString(6, cliente.getCelular());
            pstm.setString(7, cliente.getCpf());

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

    public void desativar(String cpf) {

        try {
            pstm = con.prepareStatement("update cliente set desativado = true where cpf like ?");
            pstm.setString(1, cpf);
            if (pstm.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cliente desativado");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não está ativo!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            Conexao.closeCon(con, pstm);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao desativar o registro: \n\n" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void reativar(String cpf) {

        try {
            pstm = con.prepareStatement("update cliente set desativado = false where cpf like ?");
            pstm.setString(1, cpf);
            if (pstm.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cliente reabilitado");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente já está ativo!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            Conexao.closeCon(con, pstm);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao reativar o registro: \n\n" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int getID(String cpf) {
        int id = 0;
        try {
            pstm = con.prepareStatement("select id from cliente where cpf like ?");
            pstm.setString(1, cpf);
            rs = pstm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o cliente: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }

    public List<Cliente> filtrarByNome(String filtro) {
        List<Cliente> clientes = new ArrayList<>();
        try {
            pstm = con.prepareStatement("select * from cliente where upper(nome) like ? ");
            pstm.setObject(1, "%" + filtro + "%");

            rs = pstm.executeQuery();
            while (rs.next()) {
                clientes.add(new Cliente(rs.getString("cpf"), rs.getString("nome"), rs.getString("sobrenome"), rs.getString("genero").charAt(0), rs.getString("email"), rs.getString("telefone"), rs.getString("celular"), rs.getBoolean("desativado")));
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar!\n" + ex, null, JOptionPane.ERROR_MESSAGE);

        }
        return clientes;
    }

}
