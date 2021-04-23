package view;

import controller.ClienteController;
import controller.UsuarioController;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.entidades.Cliente;
import model.entidades.Usuario;

/**
 *
 * @author JOSÉLUISFREIREDASILV
 */
public class TelaClientes extends javax.swing.JFrame {

    public TelaClientes() {
        initComponents();
        listar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblFechar1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DefaultTableModel tableModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        tabela = new javax.swing.JTable();
        tabela.setDefaultRenderer(Object.class, new CellRenderer());
        txtFiltro = new javax.swing.JTextField();
        btnRelatorio = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        chkDesativados = new javax.swing.JCheckBox();
        btnDesativar = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Clientes");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(79, 158, 195), new java.awt.Color(46, 52, 59)));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(230, 227, 231));
        jPanel3.setPreferredSize(new java.awt.Dimension(706, 706));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Clientes cadastrados");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(805, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(296, 296, 296))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1100, 50));

        lblFechar1.setBackground(new java.awt.Color(255, 255, 255));
        lblFechar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/fechar.png"))); // NOI18N
        lblFechar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFechar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFechar1MouseClicked(evt);
            }
        });
        jPanel1.add(lblFechar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, 50, 40));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        tabela.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        tabela.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabela.setFillsViewportHeight(true);
        tabela.setGridColor(new java.awt.Color(255, 255, 255));
        tabela.setRowHeight(20);
        tabela.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tabela.setShowVerticalLines(false);
        tabela.setModel(tableModel);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 1000, 390));

        txtFiltro.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        txtFiltro.setForeground(new java.awt.Color(51, 51, 51));
        txtFiltro.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        txtFiltro.setSelectionColor(new java.awt.Color(153, 153, 153));
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroKeyTyped(evt);
            }
        });
        jPanel1.add(txtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 240, 40));

        btnRelatorio.setBackground(new java.awt.Color(255, 255, 255));
        btnRelatorio.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnRelatorio.setForeground(new java.awt.Color(51, 51, 51));
        btnRelatorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-filter-30.png"))); // NOI18N
        btnRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRelatorioMouseClicked(evt);
            }
        });
        jPanel1.add(btnRelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 30, 40));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Nome, CPF ou telefone ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 180, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Selecione um dado para mais opções");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 300, -1));

        btnAlterar.setBackground(new java.awt.Color(255, 255, 255));
        btnAlterar.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-edit-file-30.png"))); // NOI18N
        btnAlterar.setText("Editar");
        btnAlterar.setBorder(null);
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.setEnabled(false);
        btnAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterar.setIconTextGap(0);
        btnAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 330, 70, 60));

        btnAdicionar.setBackground(new java.awt.Color(255, 255, 255));
        btnAdicionar.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-add-file-30.png"))); // NOI18N
        btnAdicionar.setText("Novo");
        btnAdicionar.setBorder(null);
        btnAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdicionar.setIconTextGap(0);
        btnAdicionar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 240, 70, 60));

        chkDesativados.setBackground(new java.awt.Color(255, 255, 255));
        chkDesativados.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        chkDesativados.setForeground(new java.awt.Color(51, 51, 51));
        chkDesativados.setText("Clientes desativados");
        chkDesativados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDesativadosActionPerformed(evt);
            }
        });
        jPanel1.add(chkDesativados, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 180, -1, -1));

        btnDesativar.setBackground(new java.awt.Color(255, 255, 255));
        btnDesativar.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnDesativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/desabilitar.png"))); // NOI18N
        btnDesativar.setText("Desativar");
        btnDesativar.setBorder(null);
        btnDesativar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesativar.setEnabled(false);
        btnDesativar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDesativar.setIconTextGap(0);
        btnDesativar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDesativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesativarActionPerformed(evt);
            }
        });
        jPanel1.add(btnDesativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 510, 70, 60));

        btnUser.setBackground(new java.awt.Color(255, 255, 255));
        btnUser.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/pass.png"))); // NOI18N
        btnUser.setText("Login");
        btnUser.setBorder(null);
        btnUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUser.setEnabled(false);
        btnUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUser.setIconTextGap(0);
        btnUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        jPanel1.add(btnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 420, 70, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1191, 645));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblFechar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFechar1MouseClicked
        this.dispose();
    }//GEN-LAST:event_lblFechar1MouseClicked

    private void btnRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRelatorioMouseClicked

    }//GEN-LAST:event_btnRelatorioMouseClicked

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        new CadastroClientes().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (tabela.getSelectedRow() != -1) {
            btnAlterar.setEnabled(true);
            btnDesativar.setEnabled(true);
            btnUser.setEnabled(true);
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        String cpf = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 0));
        new CadastroClientes(cpf).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void txtFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyTyped


    }//GEN-LAST:event_txtFiltroKeyTyped

    private void chkDesativadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDesativadosActionPerformed
        btnDesativar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnUser.setEnabled(false);
        if (chkDesativados.isSelected()) {
            listarDesativados();
            btnDesativar.setText("Reativar");
            btnDesativar.setIcon(new ImageIcon(getClass().getResource("/view/img/retornar.png")));
        } else {
            listar();
            btnDesativar.setText("Desativar");
            btnDesativar.setIcon(new ImageIcon(getClass().getResource("/view/img/bloquear.png")));
        }
    }//GEN-LAST:event_chkDesativadosActionPerformed

    private void btnDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesativarActionPerformed
        String cpf = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 0));
        String btns[] = {"Sim", "Cancelar"};
        if (btnDesativar.getText().equals("Reativar")) {
            int res = JOptionPane.showOptionDialog(null, "Deseja reabilitar o registro", "Confrmação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, btns, btns[0]);
            if (res == 0) {
                new ClienteController().reativar(cpf);
                listarDesativados();
            }
        } else {
            int res = JOptionPane.showOptionDialog(null, "Deseja desativar o registro", "Confrmação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, btns, btns[0]);
            if (res == 0) {
                new ClienteController().desativar(cpf);
                listar();
            }
        }

        btnDesativar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnUser.setEnabled(false);
    }//GEN-LAST:event_btnDesativarActionPerformed

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        if (chkDesativados.isSelected()) {
            filtrarDesativados();
        } else {
            filtrar();
        }
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        if (new UsuarioController().clienteIsRegistered(String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 0)))) {
            Usuario user = new UsuarioController().findByCliente(String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 0)));
            String op[] = {"OK", "Editar"};
            StringBuilder b = new StringBuilder(user.getSenha());
            b.replace(0, 5, "*****");
            if (JOptionPane.showOptionDialog(null, "DADOS DE USUÁRIO: \n\nLogin: " + user.getLogin() + "\nSenha: " + b + "\n\n", "Dados cadastrados", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, op, 0) == 1) {
                new CadastroUsuario(String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 0)), true, user.getLogin()).setVisible(true);
            }
        } else {
            if (JOptionPane.showConfirmDialog(null, "Cliente não possui usuário cadastrado.\n\nDeseja atribuir um usuário ao cliente?", "Confirmação", JOptionPane.YES_NO_OPTION) == 0) {
                new CadastroUsuario(String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 0)), true).setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnUserActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnDesativar;
    private javax.swing.JLabel btnRelatorio;
    private javax.swing.JButton btnUser;
    private javax.swing.JCheckBox chkDesativados;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFechar1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables

    public void filtrar() {
        List<Cliente> clientes;
        clientes = new ClienteController().filtrar(txtFiltro.getText().toUpperCase());
        ((DefaultTableModel) tabela.getModel()).setRowCount(0);
        ((DefaultTableModel) tabela.getModel()).setColumnCount(6);
        String[] header = {"CPF", "Nome", "Email", "Gênero", "Telefone", "Celular"};
        ((DefaultTableModel) tabela.getModel()).setColumnIdentifiers(header);
        tabela.getColumnModel().getColumn(0).setMinWidth(130);
        tabela.getColumnModel().getColumn(1).setMinWidth(210);
        tabela.getColumnModel().getColumn(2).setMinWidth(210);
        tabela.getColumnModel().getColumn(3).setMinWidth(95);
        tabela.getColumnModel().getColumn(4).setMinWidth(180);
        tabela.getColumnModel().getColumn(5).setMinWidth(180);
        for (Cliente c : clientes) {
            String[] dados = new String[6];
            if (!c.isDesativado()) {
                dados[0] = c.getCpf();
                dados[1] = c.getNome() + " " + c.getSobrenome();
                dados[2] = c.getEmail();
                dados[3] = c.getGenero();
                dados[4] = c.getTelefone().replace("(", "").replace(")", "");
                dados[5] = c.getCelular().replace("(", "").replace(")", "");
                ((DefaultTableModel) tabela.getModel()).addRow(dados);
            }
        }
    }

    public void filtrarDesativados() {
        List<Cliente> clientes;
        clientes = new ClienteController().filtrar(txtFiltro.getText().toUpperCase());
        ((DefaultTableModel) tabela.getModel()).setRowCount(0);
        ((DefaultTableModel) tabela.getModel()).setColumnCount(6);
        String[] header = {"CPF", "Nome", "Email", "Gênero", "Telefone", "Celular"};
        ((DefaultTableModel) tabela.getModel()).setColumnIdentifiers(header);
        tabela.getColumnModel().getColumn(0).setMinWidth(130);
        tabela.getColumnModel().getColumn(1).setMinWidth(210);
        tabela.getColumnModel().getColumn(2).setMinWidth(210);
        tabela.getColumnModel().getColumn(3).setMinWidth(95);
        tabela.getColumnModel().getColumn(4).setMinWidth(180);
        tabela.getColumnModel().getColumn(5).setMinWidth(180);
        for (Cliente c : clientes) {
            String[] dados = new String[6];
            if (c.isDesativado()) {
                dados[0] = c.getCpf();
                dados[1] = c.getNome() + " " + c.getSobrenome();
                dados[2] = c.getEmail();
                dados[3] = c.getGenero();
                dados[4] = c.getTelefone().replace("(", "").replace(")", "");
                dados[5] = c.getCelular().replace("(", "").replace(")", "");
                ((DefaultTableModel) tabela.getModel()).addRow(dados);
            }
        }
    }

    public void listar() {
        List<Cliente> clientes;
        clientes = new ClienteController().listar();
        ((DefaultTableModel) tabela.getModel()).setRowCount(0);
        ((DefaultTableModel) tabela.getModel()).setColumnCount(6);
        String[] header = {"CPF", "Nome", "Email", "Gênero", "Telefone", "Celular"};
        ((DefaultTableModel) tabela.getModel()).setColumnIdentifiers(header);
        tabela.getColumnModel().getColumn(0).setMinWidth(130);
        tabela.getColumnModel().getColumn(1).setMinWidth(210);
        tabela.getColumnModel().getColumn(2).setMinWidth(210);
        tabela.getColumnModel().getColumn(3).setMinWidth(95);
        tabela.getColumnModel().getColumn(4).setMinWidth(180);
        tabela.getColumnModel().getColumn(5).setMinWidth(180);
        for (Cliente c : clientes) {
            String[] dados = new String[6];
            if (!c.isDesativado()) {
                dados[0] = c.getCpf();
                dados[1] = c.getNome() + " " + c.getSobrenome();
                dados[2] = c.getEmail();
                dados[3] = c.getGenero();
                dados[4] = c.getTelefone().replace("(", "").replace(")", "");
                dados[5] = c.getCelular().replace("(", "").replace(")", "");
                ((DefaultTableModel) tabela.getModel()).addRow(dados);
            }
        }
    }

    public void listarDesativados() {
        List<Cliente> clientes;
        clientes = new ClienteController().listar();
        ((DefaultTableModel) tabela.getModel()).setRowCount(0);
        ((DefaultTableModel) tabela.getModel()).setColumnCount(6);
        String[] header = {"CPF", "Nome", "Email", "Gênero", "Telefone", "Celular"};
        ((DefaultTableModel) tabela.getModel()).setColumnIdentifiers(header);
        tabela.getColumnModel().getColumn(0).setMinWidth(130);
        tabela.getColumnModel().getColumn(1).setMinWidth(210);
        tabela.getColumnModel().getColumn(2).setMinWidth(210);
        tabela.getColumnModel().getColumn(3).setMinWidth(95);
        tabela.getColumnModel().getColumn(4).setMinWidth(180);
        tabela.getColumnModel().getColumn(5).setMinWidth(180);
        for (Cliente c : clientes) {
            String[] dados = new String[6];
            if (c.isDesativado()) {
                dados[0] = c.getCpf();
                dados[1] = c.getNome() + " " + c.getSobrenome();
                dados[2] = c.getEmail();
                dados[3] = c.getGenero();
                dados[4] = c.getTelefone().replace("(", "").replace(")", "");
                dados[5] = c.getCelular().replace("(", "").replace(")", "");
                ((DefaultTableModel) tabela.getModel()).addRow(dados);
            }
        }
    }
}
