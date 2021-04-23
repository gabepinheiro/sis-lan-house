/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EquipamentoController;
import controller.EstoqueEquipamentoController;
import dao.EquipamentoDAO;
import java.awt.event.KeyEvent;
import java.util.List;
import model.entidades.Equipamento;
import model.entidades.EstoqueEquipamento;

public class CadastroEstoqueEquipamento extends javax.swing.JFrame {

    boolean editar = false;
    private String desc;

    public CadastroEstoqueEquipamento() {
        initComponents();
        listEquip.setVisible(false);
        preenchelist();
    }

    CadastroEstoqueEquipamento(String equip) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lblFechar1 = new javax.swing.JLabel();
        addEquipamento = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JSpinner();
        txtNome = new javax.swing.JTextField();
        listEquip = new java.awt.List();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estoque de equipamento (Cadastro)");
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
        jLabel2.setText("Cadastro no estoque");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 650, 50));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("(*) Campos obrigatórios.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 250, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Equipamento: *");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 120, -1));

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/salvar.png"))); // NOI18N
        btnSalvar.setText("Cadastrar");
        btnSalvar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.setIconTextGap(10);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 170, 40));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Digite os dados para inserção no estoque");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 340, -1));

        lblFechar1.setBackground(new java.awt.Color(255, 255, 255));
        lblFechar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/fechar.png"))); // NOI18N
        lblFechar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFechar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFechar1MouseClicked(evt);
            }
        });
        jPanel1.add(lblFechar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 50, 40));

        addEquipamento.setBackground(new java.awt.Color(255, 255, 255));
        addEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/adicionar.png"))); // NOI18N
        addEquipamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addEquipamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addEquipamentoMouseClicked(evt);
            }
        });
        jPanel1.add(addEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 30, 40));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Quantidade: *");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 100, 20));

        txtQtd.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        txtQtd.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        txtQtd.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        txtQtd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQtdKeyTyped(evt);
            }
        });
        jPanel1.add(txtQtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 50, 40));

        txtNome.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        txtNome.setForeground(new java.awt.Color(51, 51, 51));
        txtNome.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        txtNome.setSelectionColor(new java.awt.Color(153, 153, 153));
        txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomeFocusLost(evt);
            }
        });
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeKeyTyped(evt);
            }
        });
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 210, 40));

        listEquip.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listEquip.setEnabled(false);
        listEquip.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        listEquip.setForeground(new java.awt.Color(51, 51, 51));
        listEquip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listEquipMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listEquipMousePressed(evt);
            }
        });
        listEquip.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listEquipItemStateChanged(evt);
            }
        });
        listEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listEquipActionPerformed(evt);
            }
        });
        jPanel1.add(listEquip, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 210, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(731, 490));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblFechar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFechar1MouseClicked
        this.dispose();
    }//GEN-LAST:event_lblFechar1MouseClicked

    private void addEquipamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEquipamentoMouseClicked
        new CadastroEquipamentos().setVisible(true);
    }//GEN-LAST:event_addEquipamentoMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (new EquipamentoController().inserirEstoque(txtNome.getText(), Integer.parseInt(txtQtd.getValue() + ""))) {
            new TelaEstoque().setVisible(true);
        }


    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        preenchelist();
    }//GEN-LAST:event_txtNomeActionPerformed

    private void listEquipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listEquipMouseClicked

    }//GEN-LAST:event_listEquipMouseClicked

    private void txtNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusLost
        listEquip.setVisible(false);
        preenchelist();
    }//GEN-LAST:event_txtNomeFocusLost

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        if (txtNome.getText().length() == 0) {
            preenchelist();
        }

    }//GEN-LAST:event_txtNomeKeyTyped

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.listEquip.setVisible(false);
        } else if (evt.getKeyCode() != 40 && evt.getKeyCode() != 38) {
            filtrar();
        } else {
            if (evt.getKeyCode() == 40) {
                listEquip.select(listEquip.getSelectedIndex() + 1);
                if (listEquip.getSelectedIndex() > -1) {
                    txtNome.setText(listEquip.getSelectedItem());
                }
            }
            if (evt.getKeyCode() == 38) {
                listEquip.select(listEquip.getSelectedIndex() - 1);
                if (listEquip.getSelectedIndex() > -1) {
                    txtNome.setText(listEquip.getSelectedItem());
                }
            }
        }

    }//GEN-LAST:event_txtNomeKeyPressed

    private void listEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listEquipActionPerformed


    }//GEN-LAST:event_listEquipActionPerformed

    private void listEquipItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listEquipItemStateChanged


    }//GEN-LAST:event_listEquipItemStateChanged

    private void txtNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusGained
        txtNome.setText("");
        preenchelist();
        listEquip.setVisible(true);
    }//GEN-LAST:event_txtNomeFocusGained

    private void listEquipMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listEquipMousePressed

    }//GEN-LAST:event_listEquipMousePressed

    private void txtQtdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtdKeyTyped
        String carac = "0123456789";
        if (!carac.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQtdKeyTyped

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
            java.util.logging.Logger.getLogger(CadastroEstoqueEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroEstoqueEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroEstoqueEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroEstoqueEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroEstoqueEquipamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addEquipamento;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblFechar1;
    private java.awt.List listEquip;
    private javax.swing.JTextField txtNome;
    private javax.swing.JSpinner txtQtd;
    // End of variables declaration//GEN-END:variables

    private void preenchelist() {
        listEquip.removeAll();
        List<Equipamento> equipamentos = new EquipamentoDAO().listar();
        for (Equipamento e : equipamentos) {
            listEquip.add(e.getDescricao());
        }
    }

    private void filtrar() {
        listEquip.setVisible(true);
        listEquip.removeAll();
        List<Equipamento> equipamentos = new EquipamentoDAO().filtraByNome(txtNome.getText());
        for (Equipamento e : equipamentos) {
            listEquip.add(e.getDescricao());
        }
    }

}
