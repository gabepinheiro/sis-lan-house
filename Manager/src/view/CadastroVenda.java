/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ClienteDAO;
import dao.ServicoDAO;
import java.awt.Font;
import static java.awt.Frame.NORMAL;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.entidades.Cliente;
import model.entidades.Servico;

/**
 *
 * @author JOSÃ‰LUISFREIREDASILV
 */
public class CadastroVenda extends javax.swing.JFrame {

    /**
     * Creates new form CadastroVenda
     */
    public CadastroVenda() {
        initComponents();
        listClientes.setVisible(true);
        remover.setEnabled(false);
        pintatabela();
        preenchelist();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblFechar1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
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
        remover = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DefaultTableModel tableModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        tabela1 = new javax.swing.JTable();
        tabela.setDefaultRenderer(Object.class, new CellRenderer());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        jLabel2.setText("Nova Venda");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(705, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(296, 296, 296))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1000, 50));

        lblFechar1.setBackground(new java.awt.Color(255, 255, 255));
        lblFechar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/fechar.png"))); // NOI18N
        lblFechar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFechar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFechar1MouseClicked(evt);
            }
        });
        jPanel1.add(lblFechar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 50, 40));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Adicione os serviÃ§os na comanda");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 300, -1));

        btnLimpar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpar.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/limpar.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 630, 170, 40));

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.setIconTextGap(10);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 630, 170, 40));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("(*) Campos obrigatÃ³rios.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 250, -1));

        lblValor.setBackground(new java.awt.Color(255, 255, 255));
        lblValor.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        lblValor.setForeground(new java.awt.Color(51, 51, 51));
        lblValor.setText("Valor Total:");
        jPanel1.add(lblValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 470, 120, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 440, 230));

        remover.setBackground(new java.awt.Color(255, 255, 255));
        remover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-delete-bin-30.png"))); // NOI18N
        remover.setToolTipText("Adicionar na comanda");
        remover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        remover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removerMouseClicked(evt);
            }
        });
        jPanel1.add(remover, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 30, 40));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);

        tabela1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        tabela1.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
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
        tabela1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabela1.setFillsViewportHeight(true);
        tabela1.setGridColor(new java.awt.Color(255, 255, 255));
        tabela1.setRowHeight(20);
        tabela1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tabela1.setShowVerticalLines(false);
        tabela.setModel(tableModel);
        tabela1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 440, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1083, 694));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblFechar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFechar1MouseClicked
        new TelaFuncionarios().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblFechar1MouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (tabela.getSelectedRow() != -1) {
            remover.setEnabled(true);
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void removerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerMouseClicked

    }//GEN-LAST:event_removerMouseClicked

    private void tabela1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabela1MouseClicked

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
            java.util.logging.Logger.getLogger(CadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechar1;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel remover;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabela1;
    // End of variables declaration//GEN-END:variables

    private void limpar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void preenchelist() {
        listServico.removeAll();
        List<Servico> servicos = new ServicoDAO().listar();
        for (Servico s : servicos) {
            listServico.add(s.getServico());
        }
        listClientes.removeAll();
        List<Cliente> clientes = new ClienteDAO().listar();
        for (Cliente s : clientes) {
            if (!s.isDesativado()) {
                listClientes.add(s.getNome());
            }
        }

    }

    private void filtrarServico() {
        listServico.removeAll();
        List<Servico> servicos = new ServicoDAO().filtrarByNome(txtServico.getText().toUpperCase());
        for (Servico s : servicos) {

            listServico.add(s.getServico());

        }
    }

    private void filtrarCliente() {
        List<Cliente> clientes = new ClienteDAO().filtrarByNome(txtCliente.getText().toUpperCase());
        for (Cliente s : clientes) {

            listClientes.add(s.getNome());

        }
    }

    private void pintatabela() {
        ((DefaultTableModel) tabela.getModel()).setRowCount(0);
        ((DefaultTableModel) tabela.getModel()).setColumnCount(3);
        String[] header = {"ServiÃ§o", "Quantidade", "Subtotal"};
        ((DefaultTableModel) tabela.getModel()).setColumnIdentifiers(header);
        tabela.getTableHeader().setFont(new Font("Nirmala ui", NORMAL, 14));
        tabela.getColumnModel().getColumn(0).setMinWidth(210);
        tabela.getColumnModel().getColumn(1).setMinWidth(120);
        tabela.getColumnModel().getColumn(2).setMinWidth(160);
    }

}
