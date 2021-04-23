/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CaixaController;
import dao.EstacaoDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.entidades.Estacao;
import service.ConnectionManager;

/**
 *
 * @author JOSÉLUISFREIREDASILV
 */
public class TelaPrincipal extends javax.swing.JFrame implements Observer {

    private String usuario;
    private NumberFormat f = NumberFormat.getCurrencyInstance();

    
    
    public TelaPrincipal() {
        initComponents();
        lblCaixa.setText(f.format(new CaixaController().getValorCaixa()));
        lblCaixa.setVisible(false);
        lblCaixa2.setVisible(true);
        carregarPanelsEstacoes();
    }

    public void TelaPrincipalUser(String user) {
        initComponents();
        usuario = user;
        lblUser.setText("Olá, " + usuario);
        lblCaixa.setVisible(true);
        lblCaixa2.setVisible(false);
        lblCaixa.setText(f.format(new CaixaController().getValorCaixa()));
        carregarPanelsEstacoes();
    }

    public void TelaPrincipalLoginB(String login, boolean b) {
        initComponents();
        lblCaixa.setText(f.format(new CaixaController().getValorCaixa()));
        lblCaixa.setVisible(false);
        lblCaixa2.setVisible(true);
        usuario = login;
        lblUser.setText("Olá, " + usuario);
        carregarPanelsEstacoes();
    }
    
     public static TelaPrincipal instance = null;

    public static TelaPrincipal getInstance() { // singleton  
        if (instance == null) {
            instance = new TelaPrincipal();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btnEquip = new javax.swing.JLabel();
        btnClientes = new javax.swing.JLabel();
        btnFuncionarios = new javax.swing.JLabel();
        btnCompras = new javax.swing.JLabel();
        btnContas = new javax.swing.JLabel();
        btnFornecedores = new javax.swing.JLabel();
        panelEstacoes = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblCaixa = new javax.swing.JLabel();
        lblCaixa2 = new javax.swing.JLabel();
        lblCaixa2.setVisible(false);
        lblSair = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnIncluirTempo = new javax.swing.JButton();
        btnDesbloquearEstacao = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(79, 158, 195), new java.awt.Color(46, 52, 59)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(java.awt.SystemColor.controlLtHighlight);
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel3.setPreferredSize(new java.awt.Dimension(706, 706));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(230, 227, 231));
        jPanel7.setPreferredSize(new java.awt.Dimension(706, 706));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        jLabel14.setText("Menu de opções");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap())
        );

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 50));

        btnEquip.setBackground(new java.awt.Color(255, 255, 255));
        btnEquip.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        btnEquip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/equipamentos.png"))); // NOI18N
        btnEquip.setText("Equipamentos");
        btnEquip.setAlignmentX(2.5F);
        btnEquip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEquip.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEquip.setIconTextGap(10);
        btnEquip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEquipMouseClicked(evt);
            }
        });
        jPanel3.add(btnEquip, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 182, 40));

        btnClientes.setBackground(new java.awt.Color(255, 255, 255));
        btnClientes.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/clientes.png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setAlignmentX(2.5F);
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnClientes.setIconTextGap(10);
        btnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClientesMouseClicked(evt);
            }
        });
        jPanel3.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 182, 40));

        btnFuncionarios.setBackground(new java.awt.Color(255, 255, 255));
        btnFuncionarios.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        btnFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/funcionarios.png"))); // NOI18N
        btnFuncionarios.setText("Funcionários");
        btnFuncionarios.setAlignmentX(2.5F);
        btnFuncionarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFuncionarios.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnFuncionarios.setIconTextGap(10);
        btnFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFuncionariosMouseClicked(evt);
            }
        });
        jPanel3.add(btnFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 182, 40));

        btnCompras.setBackground(new java.awt.Color(255, 255, 255));
        btnCompras.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        btnCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/compras.png"))); // NOI18N
        btnCompras.setText("Compras");
        btnCompras.setAlignmentX(2.5F);
        btnCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCompras.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCompras.setIconTextGap(10);
        btnCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnComprasMouseClicked(evt);
            }
        });
        jPanel3.add(btnCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 182, 40));

        btnContas.setBackground(new java.awt.Color(255, 255, 255));
        btnContas.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        btnContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/contas.png"))); // NOI18N
        btnContas.setText("Contas");
        btnContas.setAlignmentX(2.5F);
        btnContas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnContas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnContas.setIconTextGap(10);
        btnContas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnContasMouseClicked(evt);
            }
        });
        jPanel3.add(btnContas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 182, 40));

        btnFornecedores.setBackground(new java.awt.Color(255, 255, 255));
        btnFornecedores.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        btnFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/usuarios.png"))); // NOI18N
        btnFornecedores.setText("Fornecedores");
        btnFornecedores.setAlignmentX(2.5F);
        btnFornecedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFornecedores.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnFornecedores.setIconTextGap(10);
        btnFornecedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFornecedoresMouseClicked(evt);
            }
        });
        jPanel3.add(btnFornecedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 182, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 220, 620));

        panelEstacoes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        panelEstacoes.setPreferredSize(new java.awt.Dimension(706, 706));
        jPanel1.add(panelEstacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 900, 540));

        jPanel9.setBackground(new java.awt.Color(247, 246, 246));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        jPanel9.setPreferredSize(new java.awt.Dimension(706, 706));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUser.setBackground(new java.awt.Color(255, 255, 255));
        lblUser.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        lblUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/user.png"))); // NOI18N
        lblUser.setText("Olá, ");
        lblUser.setAlignmentX(2.5F);
        lblUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblUser.setIconTextGap(10);
        lblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblUserMouseEntered(evt);
            }
        });
        jPanel9.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        lblCaixa.setBackground(new java.awt.Color(255, 255, 255));
        lblCaixa.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        lblCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/caixa.png"))); // NOI18N
        lblCaixa.setText("R$ 00,00");
        lblCaixa.setToolTipText("Caixa");
        lblCaixa.setAlignmentX(2.5F);
        lblCaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaixa.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblCaixa.setIconTextGap(10);
        lblCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaixaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCaixaMouseEntered(evt);
            }
        });
        jPanel9.add(lblCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 10, -1, -1));

        lblCaixa2.setBackground(new java.awt.Color(255, 255, 255));
        lblCaixa2.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        lblCaixa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/caixa.png"))); // NOI18N
        lblCaixa2.setText("Abrir Caixa");
        lblCaixa2.setToolTipText("Caixa");
        lblCaixa2.setAlignmentX(2.5F);
        lblCaixa2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaixa2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblCaixa2.setIconTextGap(10);
        lblCaixa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaixa2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCaixa2MouseEntered(evt);
            }
        });
        jPanel9.add(lblCaixa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        lblSair.setBackground(new java.awt.Color(255, 255, 255));
        lblSair.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        lblSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/sair.png"))); // NOI18N
        lblSair.setText("Sair");
        lblSair.setAlignmentX(2.5F);
        lblSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSair.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblSair.setIconTextGap(5);
        lblSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSairMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSairMouseEntered(evt);
            }
        });
        jPanel9.add(lblSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(1041, 10, -1, -1));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1130, 50));

        jPanel8.setBackground(new java.awt.Color(230, 227, 231));
        jPanel8.setPreferredSize(new java.awt.Dimension(706, 706));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        jLabel15.setText("Estações de Uso");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 380, 50));

        btnIncluirTempo.setBackground(new java.awt.Color(255, 255, 255));
        btnIncluirTempo.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnIncluirTempo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-relógio-24.png"))); // NOI18N
        btnIncluirTempo.setText("<html>Incluir Tempo <br>Estacão de Uso</html>");
        btnIncluirTempo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        btnIncluirTempo.setIconTextGap(10);
        btnIncluirTempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirTempoActionPerformed(evt);
            }
        });
        jPanel1.add(btnIncluirTempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, 170, 40));

        btnDesbloquearEstacao.setBackground(new java.awt.Color(255, 255, 255));
        btnDesbloquearEstacao.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnDesbloquearEstacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/liberar.png"))); // NOI18N
        btnDesbloquearEstacao.setText("<html>\n\tDesbloquear </br>\n\tEstação de Uso.\n</html>");
        btnDesbloquearEstacao.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        btnDesbloquearEstacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesbloquearEstacaoActionPerformed(evt);
            }
        });
        jPanel1.add(btnDesbloquearEstacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 90, 170, 40));

        jMenu2.setText("Sobre");

        jMenuItem1.setText("Informações Técnicas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1154, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(1154, 707));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSairMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblSairMouseEntered

    private void lblSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSairMouseClicked
        
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblSairMouseClicked

    private void lblUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblUserMouseEntered

    private void lblCaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaixaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCaixaMouseEntered

    private void btnClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseClicked
        new TelaClientes().setVisible(true);
    }//GEN-LAST:event_btnClientesMouseClicked

    private void btnFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFuncionariosMouseClicked
        new TelaFuncionarios().setVisible(true);
    }//GEN-LAST:event_btnFuncionariosMouseClicked

    private void lblCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaixaMouseClicked
        new FechamentoCaixa(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblCaixaMouseClicked

    private void lblCaixa2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaixa2MouseClicked
        new AberturaCaixa(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblCaixa2MouseClicked

    private void lblCaixa2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaixa2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCaixa2MouseEntered

    private void btnEquipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEquipMouseClicked
       new TelaEquipamentos().setVisible(true);
    }//GEN-LAST:event_btnEquipMouseClicked

    private void btnComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprasMouseClicked
        new TelaVendas().setVisible(true);
    }//GEN-LAST:event_btnComprasMouseClicked

    private void btnContasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContasMouseClicked
        new TelaContasAPagar().setVisible(true);
    }//GEN-LAST:event_btnContasMouseClicked

    private void btnFornecedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFornecedoresMouseClicked
        new TelaFornecedores().setVisible(true);
    }//GEN-LAST:event_btnFornecedoresMouseClicked

    private void btnIncluirTempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirTempoActionPerformed
        // TODO add your handling code here:
        new IncluirTempoEstacao().setVisible(true);
    }//GEN-LAST:event_btnIncluirTempoActionPerformed

    private void btnDesbloquearEstacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesbloquearEstacaoActionPerformed
        // TODO add your handling code here:
            new DesbloquearEstacao().setVisible(true);
    }//GEN-LAST:event_btnDesbloquearEstacaoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new Sobre().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClientes;
    private javax.swing.JLabel btnCompras;
    private javax.swing.JLabel btnContas;
    private javax.swing.JButton btnDesbloquearEstacao;
    private javax.swing.JLabel btnEquip;
    private javax.swing.JLabel btnFornecedores;
    private javax.swing.JLabel btnFuncionarios;
    private javax.swing.JButton btnIncluirTempo;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblCaixa;
    private javax.swing.JLabel lblCaixa2;
    private javax.swing.JLabel lblSair;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel panelEstacoes;
    // End of variables declaration//GEN-END:variables

    
     public  void carregarPanelsEstacoes() {

        EstacaoDAO estDAO = new EstacaoDAO();

        estDAO.connectar();

        ArrayList<Estacao> estacaoList;

        if ((estacaoList = estDAO.selectAll()).isEmpty()) {

            JLabel label = new JLabel();

            label.setText("<html>Nenhuma Estação de Uso ainda foi mapeada no Sistema Central.<br/>"
                    + " Realiza a comunicação e configuração da aplicação nas máquinas clientes.</html>");

            label.setForeground(Color.ORANGE.darker());
            this.panelEstacoes.add(label);

        } else {
            for (Estacao est : estacaoList) {

                JPanel panelEstacao = new JPanel();

                panelEstacao.setLayout(new BoxLayout(panelEstacao, BoxLayout.Y_AXIS));
                panelEstacao.setPreferredSize(new Dimension(140, 140));

                JLabel labelimage = new JLabel();

                JLabel em_manutencao = new JLabel();

                if (est.getStatus().equals(Estacao.Status.MANUTENCAO)) {
                    labelimage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("view/img/computer_emmanutencao.png")));
                    em_manutencao.setText("Em manutenção");

                } else if (est.getStatus().equals(Estacao.Status.LIVRE)) {

                    labelimage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("view/img/computer_livre.png")));

                } else if (est.getStatus().equals(Estacao.Status.OCUPADO)) {
                    labelimage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("view/img/computer_emuso.png")));

                }
                panelEstacao.add(labelimage);
                panelEstacao.add(new JLabel(est.getDescricao()));

                this.panelEstacoes.add(panelEstacao);

            }
        }

    }

    public void atualizarPanelEstacao(ArrayList<Estacao> estacaolist) {

        this.panelEstacoes.removeAll();
        for (Estacao est : estacaolist) {

            JPanel panelEstacao = new JPanel();
            panelEstacao.setLayout(new BoxLayout(panelEstacao, BoxLayout.Y_AXIS));
            panelEstacao.setPreferredSize(new Dimension(140, 140));

            JLabel labelimage = new JLabel();

            JLabel em_manutencao = new JLabel();

            if (est.getStatus().equals(Estacao.Status.MANUTENCAO)) {
                labelimage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("view/img/computer_emmanutencao.png")));
                em_manutencao.setText("Em manutenção");

            } else if (est.getStatus().equals(Estacao.Status.LIVRE)) {

                labelimage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("view/img/computer_livre.png")));

            } else if (est.getStatus().equals(Estacao.Status.OCUPADO)) {
                labelimage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("view/img/computer_emuso.png")));

            }

            panelEstacao.add(labelimage);
            panelEstacao.add(new JLabel(est.getDescricao()));

            this.panelEstacoes.add(panelEstacao);
            this.panelEstacoes.revalidate();
            this.panelEstacoes.repaint();

        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
        ArrayList<Estacao> estacaolist = ((ConnectionManager) o).getEstacoes();

        atualizarPanelEstacao(estacaolist);
    }
}
