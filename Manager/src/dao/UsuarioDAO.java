package dao;

import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.entidades.Cliente;
import model.entidades.Funcionario;
import model.entidades.Usuario;
import model.entidades.UsuarioFuncionario;

public class UsuarioDAO {

    UsuarioFuncionario userF;
    Usuario user;
    private final Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    public UsuarioDAO(Usuario user) {
        this.user = user;
        this.con = Conexao.getCon();
    }

    public UsuarioDAO(UsuarioFuncionario user) {
        this.userF = user;
        this.con = Conexao.getCon();
    }

    public UsuarioDAO() {
        this.con = Conexao.getCon();
    }

    public boolean cadastrar() {
        int cliente = new ClienteDAO().getID(user.getC().getCpf());
        boolean flag = false;
        try {
            pstm = con.prepareStatement("insert into usuario(login, senha, cliente) values(?,?,?);");
            pstm.setString(1, user.getLogin());
            pstm.setString(2, user.getSenha());
            pstm.setInt(3, cliente);
            int res = pstm.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com sucesso");
                flag = true;
            } else {
                throw new SQLException();
            }
            Conexao.closeCon(con, pstm);
        } catch (SQLException e) {
            if (e.toString().contains("Duplicate")) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir! Login já cadastrado!", null, JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro na inserção: \n" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        return flag;
    }

    public boolean cadastrarADM() {
        int func = new FuncionarioDAO().getID(userF.getF().getCpf());
        boolean flag = false;
        try {
            pstm = con.prepareStatement("insert into usuarioFuncionario(login, senha, funcionario) values(?,?,?);");
            pstm.setString(1, userF.getLogin());
            pstm.setString(2, userF.getSenha());
            pstm.setInt(3, func);
            int res = pstm.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com sucesso");
                flag = true;
            } else {
                throw new SQLException();
            }
            Conexao.closeCon(con, pstm);
        } catch (SQLException e) {
            if (e.toString().contains("Duplicate")) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir! Login já cadastrado!", null, JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro na inserção: \n" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        return flag;
    }

    public boolean editar(String login) {
        int res;
        boolean flag = false;
        try {
            pstm = con.prepareStatement("update usuario set login = ?, senha = ? where login like ?;");
            pstm.setString(1, user.getLogin());
            pstm.setString(2, user.getSenha());
            pstm.setString(3, login);
            res = pstm.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com sucesso");
                flag = true;
            }
            Conexao.closeCon(con, pstm);
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro na edição: \n" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }

    public boolean editarADM(String login) {
        int res;
        boolean flag = false;
        try {
            pstm = con.prepareStatement("update usuarioFuncionario set login = ?, senha = ? where login like ?;");
            pstm.setString(1, userF.getLogin());
            pstm.setString(2, userF.getSenha());
            pstm.setString(3, login);
            res = pstm.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com sucesso");
                flag = true;
            } else {
                throw new SQLException();
            }
            Conexao.closeCon(con, pstm);
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro na edição: \n" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }

    public boolean validarADM(String login, String senha) {

        boolean flag = false;
        try {
            pstm = con.prepareStatement("select * from usuarioFuncionario where login=? and senha=?");
            pstm.setString(1, login);
            pstm.setString(2, senha);
            rs = pstm.executeQuery();
            if (rs.next()) {
                flag = true;
                new FluxoLoginDAO().logarADM(rs.getInt("id"));
            } else {
                JOptionPane.showMessageDialog(null, "ERRO: login ou senha inválidos!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO: banco não pôde ser acessado: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            flag = false;
        }
        return flag;
    }

    public boolean validar(String login, String senha) {

        boolean flag = false;
        try {
            pstm = con.prepareStatement("select * from usuario where login=? and senha=?");
            pstm.setString(1, login);
            pstm.setString(2, senha);
            rs = pstm.executeQuery();
            if (rs.next()) {
                flag = true;
                new FluxoLoginDAO().logar(rs.getInt("id"));
            } else {
                JOptionPane.showMessageDialog(null, "ERRO: login ou senha inválidos!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO: banco não pôde ser acessado: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            flag = false;
        }
        return flag;
    }

    //TODO
    /*public List<Usuario> listar() {
         List<Usuario> usuarios = new ArrayList<>();
        try {
            pstm = con.prepareStatement("select * from usuario");
            rs = pstm.executeQuery();
            while (rs.next()){
                usuarios.add(new Usuario(rs.getString("login"), rs.getString("senha"), rs.get(""),NivelAcesso.COMUM))
            }
        } catch (SQLException) {

        }
    }*/
    public int getUserId(String login) {
        int id = 0;
        try {
            pstm = con.prepareStatement("select id from usuario where login like ?");
            pstm.setString(1, login);
            rs = pstm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o login: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }

    public int getUserFuncionarioId(String login) {
        int id = 0;
        try {
            pstm = con.prepareStatement("select id from usuarioFuncionario where login like ?");
            pstm.setString(1, login);
            rs = pstm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o login: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }

    public boolean clienteIsRegistered(int id) {
        boolean flag = false;
        try {
            pstm = con.prepareStatement("select * from usuario where cliente=?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                flag = true;
            } else {
                flag = false;
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o login: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }

        return flag;
    }

    public Usuario getByCliente(int id) {
        Usuario user = null;
        try {
            pstm = con.prepareStatement("select login, senha, Cliente.cpf from usuario inner join cliente on usuario.cliente = ?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                Cliente c = new Cliente();
                c.setCpf(rs.getString("Cliente.cpf"));
                user = new Usuario(rs.getString("login"), rs.getString("senha"), c);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o login: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }

    public UsuarioFuncionario getByFunc(int id) {
        UsuarioFuncionario func = null;
        try {
            pstm = con.prepareStatement("select login, senha, Funcionario.cpf from usuarioFuncionario inner join funcionario on usuarioFuncionario.funcionario = ?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                Funcionario c = new Funcionario();
                c.setNome(rs.getString("Funcionario.cpf"));
                func = new UsuarioFuncionario(rs.getString("login"), rs.getString("senha"), c);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o login: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return func;
    }

    public boolean funcISRegistered(int id) {
        boolean flag = false;
        try {
            pstm = con.prepareStatement("select * from usuarioFuncionario where funcionario=?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                flag = true;
            } else {
                flag = false;
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o login: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }

        return flag;
    }

    public Usuario puxar(String login) {
        Usuario user = null;
        try {
            pstm = con.prepareStatement("select login, senha, Cliente.cpf from usuario inner join cliente on usuario.cliente = cliente.id where login like?");
            pstm.setString(1, login);
            rs = pstm.executeQuery();
            if (rs.next()) {
                Cliente c = new Cliente();
                c.setCpf(rs.getString("Cliente.cpf"));
                user = new Usuario(rs.getString("login"), rs.getString("senha"), c);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o login: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }

    public UsuarioFuncionario puxarFuncionario(String login) {
        UsuarioFuncionario user = null;
        try {
            pstm = con.prepareStatement("select login, senha, funcionario.cpf from usuarioFuncionario inner join funcionario on usuarioFuncionario.funcionario = funcionario.id where login like?");
            pstm.setString(1, login);
            rs = pstm.executeQuery();
            if (rs.next()) {
                Funcionario c = new Funcionario();
                c.setCpf(rs.getString("funcionario.cpf"));
                user = new UsuarioFuncionario(rs.getString("login"), rs.getString("senha"), c);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o login: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }
    
    public String findByLogin(String login) {
        String user = null ;
        try {
            pstm = con.prepareStatement("select login from usuario where login like ?");
            pstm.setString(1, login);
            rs = pstm.executeQuery();
            while(rs.next()){
                user = rs.getString("login");
            }
            Conexao.closeCon(con, pstm, rs);
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Não foi possível buscar o login", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }

}
